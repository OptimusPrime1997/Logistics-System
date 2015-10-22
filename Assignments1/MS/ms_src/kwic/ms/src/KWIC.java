// -*- Java -*-
/*
 * <copyright>
 * 
 *  Copyright (c) 2002
 *  Institute for Information Processing and Computer Supported New Media (IICM),
 *  Graz University of Technology, Austria.
 * 
 * </copyright>
 * 
 * <file>
 * 
 *  Name:    KWIC.java
 * 
 *  Purpose: Demo system for practice in Software Architecture
 * 
 *  Created: 11 Sep 2002 
 * 
 *  $Id$
 * 
 *  Description:
 *    The basic KWIC system is defined as follows. The KWIC system accepts an ordered 
 *  set of lines, each line is an ordered set of words, and each word is an ordered set
 *  of characters. Any line may be "circularly shifted" by repeadetly removing the first
 *  word and appending it at the end of the line. The KWIC index system outputs a
 *  listing of all circular shifts of all lines in alphabetical order.
 * </file>
*/

//package kwic.ms;

/*
 * $Log$
*/

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.CharArrayWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;

/**
 *  This class is an implementation of the main/subroutine architectural solution 
 *  for the KWIC system. This solution is based on functional
 *  decomposition of the system. Thus, the system is decomposed into a number of 
 *  modules, each module being a function. In this solution all functions share access 
 *  to data, which is stored in the "core storage". The system is decomposed into the 
 *  following modules (functions):
 *  <ul>
 *  <li>Master Control (main). This function controls the sequencing among the
 *  other four functions.
 *  <li>Input. This function reads the data lines from the input medium (file) and
 *  stores them in the core for processing by the remaining modules. The characters are
 *  stored in a character array (char[]). The blank space is used to separate words in 
 *  a particular line. Another integer array (int[]) keeps the starting indices of 
 *  each line in the character array.
 *  <li>Circular Shift. This function is called after the input function has
 *  completed its work. It prepares a two-dimensional integer array (int[][]) to keep
 *  track of all circular shifts. The array is organized as follows: for each circular
 *  shift, both index of its original line, together with the index of the starting word of
 *  that circular shift are stored as one column of the array.
 *  <li>Alphabetizing. This function takes as input the arrays produced by the input
 *  and circular shift functions. It produces an array in the same format (int[][]) 
 *  as that produced by circular shift function. In this case, however, the circular 
 *  shifts are listed in another order (they are sorted alphabetically).
 *  <li>Output. This function uses the arrays produced by input and alphabetizing
 *  function. It produces a nicely formated output listing of all circular shifts.
 *  </ul>
 *  @author  dhelic
 *  @version $Id$
*/

public class KWIC{

//----------------------------------------------------------------------
/**
 * Fields
 *
 */
//----------------------------------------------------------------------

/*
 * Core storage for shared data
 *
 */

/**
 * Input characters
 *
 */

  private char[] chars_;

/**
 * Array that keeps line indices (line index is the index of the first character of a line)
 *
 */

  private int[] line_index_;

/**
 * 2D array that keeps circular shift indices (each circular shift index is a column
 * in this 2D array, the first index is the index of the original line from line_index_ 
 * array, the second index is the index of the starting word from chars_ array of 
 * that circular shift)
 *
 */

  private int[][] circular_shifts_;

/**
 * 2D array that keeps circular shift indices, sorted alphabetically
 *
 */

  private int[][] alphabetized_;

//----------------------------------------------------------------------
/**
 * Constructors
 *
 */
//----------------------------------------------------------------------

//----------------------------------------------------------------------
/**
 * Methods
 *
 */
//----------------------------------------------------------------------

//----------------------------------------------------------------------
/**
 * Input function reads the raw data from the specified file and stores it in the core storage.
 * If some system I/O error occurs the program exits with an error message.
 * The format of raw data is as follows. Lines are separated by the line separator
 * character(s) (on Unix '\n', on Windows '\r\n'). Each line consists of a number of
 * words. Words are delimited by any number and combination of the space chracter (' ')
 * and the horizontal tabulation chracter ('\t'). The entered data is parsed in the 
 * following way. All line separators are removed from the data, all horizontal tabulation
 * word delimiters are replaced by a single space character, and all multiple word
 * delimiters are replaced by a single space character. Then the parsed data is represented 
 * in the core as two arrays: chars_ array and line_index_ array.
 * @param file Name of input file
 */

  public void input(String file){
    try{
      CharArrayWriter writer = new CharArrayWriter();
      ArrayList line_indices = new ArrayList();
      BufferedReader reader = new BufferedReader(new FileReader(file));

      line_indices.add(new Integer(0));
      String line = reader.readLine();      
      while(line != null){
        StringTokenizer tokenizer = new StringTokenizer(line); //default delimiters:" \t\n\r\f"
        while(tokenizer.hasMoreTokens()){
          writer.write(tokenizer.nextToken());
          if(tokenizer.hasMoreTokens())
            writer.write(" ");
        }
        line_indices.add(new Integer(writer.size()));
        line = reader.readLine();
      }

      chars_ = writer.toCharArray();
      line_indices.remove(line_indices.size() - 1);
      line_index_ = new int[line_indices.size()];
      for(int i = 0; i < line_indices.size(); i++)
        line_index_[i] = ((Integer) line_indices.get(i)).intValue();
    }catch(FileNotFoundException exc){
      exc.printStackTrace();
      System.err.println("KWIC Error: Could not open " + file + "file.");
      System.exit(1);
    }catch(IOException exc){
      exc.printStackTrace();
      System.err.println("KWIC Error: Could not read " + file + "file.");
      System.exit(1);
    }
  }

//----------------------------------------------------------------------
/**
 * This function processes arrays prepared by the input
 * function and produces circular shifts of the stored lines. A circular
 * shift is a line where the first word is removed from the begin of a line
 * and appended at the end of the line. To obtain all circular shifts of a line
 * we repeat this process until we can't obtain any new lines. Circular shifts 
 * are represented as a 2D array that keeps circular shift indices (each circular 
 * shift index is a column in this 2D array, the first index is the index of 
 * the original line from line_index_ array, the second index is the index of 
 * the starting word from chars_ array of that circular shift)
 */

  public void circularShift(){
    ArrayList word_indices = new ArrayList();
    ArrayList line_indices = new ArrayList();

    for(int i = 0; i < line_index_.length; i++){
      word_indices.add(new Integer(line_index_[i]));
      line_indices.add(new Integer(i));
      int last_index = 0;
      if(i != (line_index_.length - 1))
        last_index = line_index_[i + 1];
      else
        last_index = chars_.length;
      for(int j = line_index_[i]; j < last_index; j++){
        if(chars_[j] == ' '){
          word_indices.add(new Integer(j + 1));
          line_indices.add(new Integer(i));
        }
      }
    }
    
    circular_shifts_ = new int[2][word_indices.size()];
    for(int i = 0; i < word_indices.size(); i++){
      circular_shifts_[0][i] = ((Integer) line_indices.get(i)).intValue();
      circular_shifts_[1][i] = ((Integer) word_indices.get(i)).intValue();
    }
  }

//----------------------------------------------------------------------
/**
 * This function sorts circular shifts lines alphabetically. The sorted shifts
 * are represented in the same way as the unsorted shifts with the only difference
 * that now they are ordered alphabetically. This function implements binary search
 * to sort the shifts.
 */

  public void alphabetizing(){
    alphabetized_ = new int[2][circular_shifts_[0].length];
    int alphabetized_count = 0;
    int low = 0; 
    int high = 0; 
    int mid = 0; 
    
    for(int i = 0; i < alphabetized_[0].length; i++){
      int line_count = circular_shifts_[0][i];
      int shift_begin = circular_shifts_[1][i];
      int line_begin = line_index_[line_count];
      int line_end = 0;      
      if(line_count == (line_index_.length - 1))
        line_end = chars_.length;
      else
        line_end = line_index_[line_count + 1];

      String shift = "";      
      if(line_begin != shift_begin){
        shift += new String(chars_, shift_begin, line_end - shift_begin);
        shift += " ";
        shift += new String(chars_, line_begin,  shift_begin - line_begin - 1);
      }else
        shift += new String(chars_, line_begin, line_end - line_begin);

      low = 0; //binary search
      high = alphabetized_count - 1;
      while(low <= high){ 
        mid = (low + high) / 2;
        int mid_line_count = alphabetized_[0][mid];
        int mid_shift_begin = alphabetized_[1][mid];
        int mid_line_begin = line_index_[mid_line_count];
        int mid_line_end = 0;
        if(mid_line_count == (line_index_.length - 1))
          mid_line_end = chars_.length;
        else
          mid_line_end = line_index_[mid_line_count + 1];        
        
        String mid_line = "";        
        if(mid_line_begin != mid_shift_begin){
          mid_line += new String(chars_, mid_shift_begin, mid_line_end - mid_shift_begin);
          mid_line += " ";
          mid_line += new String(chars_, mid_line_begin, mid_shift_begin - mid_line_begin - 1);
        }else
          mid_line += new String(chars_, mid_line_begin, mid_line_end - mid_line_begin);
        
        int compared = shift.compareTo(mid_line);        
        if(compared > 0)
          low = mid + 1;
        else if(compared < 0)
          high = mid - 1;
        else{
          low = mid;
          high = mid - 1;
        }
      }

      System.arraycopy(alphabetized_[0], low, alphabetized_[0], low + 1, alphabetized_count - low);
      System.arraycopy(alphabetized_[1], low, alphabetized_[1], low + 1, alphabetized_count - low);
      alphabetized_[0][low] = line_count;
      alphabetized_[1][low] = shift_begin;
      alphabetized_count++;
    }
  }

//----------------------------------------------------------------------
/**
 * This function prints the sorted shifts at the standard output.
 */

  public void output(){
    for(int i = 0; i < alphabetized_[0].length; i++){
      int line_count = alphabetized_[0][i];
      int shift_begin = alphabetized_[1][i];
      int line_begin = line_index_[line_count];
      int line_end = 0;
      if(line_count == (line_index_.length - 1))
        line_end = chars_.length;
      else
        line_end = line_index_[line_count + 1];
      
      if(line_begin != shift_begin){
        for(int j = shift_begin; j < line_end; j++)
          System.out.print(chars_[j]);
        System.out.print(' ');
        for(int j = line_begin; j < (shift_begin - 1); j++)
          System.out.print(chars_[j]);
      }else
        for(int j = line_begin; j < line_end; j++)
          System.out.print(chars_[j]);
      System.out.print('\n');
    }    
  }

//----------------------------------------------------------------------
/**
 * This function controls all other functions in the system. It implements
 * the sequence of calls to other functions to obtain the desired functionality
 * of the system. Before any other function is called, main function checks the 
 * command line arguments. The program expects exactly one command line argument
 * specifying the name of the file that contains the data. If the program have
 * not been started with proper command line arguments, main function exits
 * with an error message. Otherwise, the input function is called first to read the 
 * data from the file. After that the circularShift and alphabetizing 
 * functions are called to produce and sort the shifts respectivelly. Finally, the output
 * function prints the sorted shifts at the standard output.
 * @param args command line argumnets
 */

  public static void main(String[] args){
    KWIC kwic = new KWIC();
    if(args.length != 1){
      System.err.println("KWIC Usage: java kwic.ms.KWIC file_name");
      System.exit(1);
    }
    kwic.input(args[0]);
    kwic.circularShift();
    kwic.alphabetizing();
    kwic.output();
  }

//----------------------------------------------------------------------
/**
 * Inner classes
 *
 */
//----------------------------------------------------------------------

}
