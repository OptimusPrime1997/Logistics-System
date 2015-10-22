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
 *  Name:    CircularShifter.java
 * 
 *  Purpose: Produces circular shifts of input lines
 * 
 *  Created: 05 Nov 2002 
 * 
 *  $Id$
 * 
 *  Description:
 *    Produces circular shifts of input lines
 * </file>
*/

package kwic.es;

/*
 * $Log$
*/

import java.util.Observable;
import java.util.Observer;
import java.util.ArrayList;

/**
 *  CircularShifter class implemets the "Observer" part of the standard 
 *  "Observable"-"Observer" mechanism. Thus, an instance of CircularShifter
 *  class declares its interest in tracking changes in an object of LineStorage
 *  class, which holds the original lines read from a KWIC input file. Any event
 *  produced and sent by that LineStorageWrapper object (e.g. whenever a new line
 *  has been added) is catched by CircularShiter object. In turn, this leads
 *  to production of circular shifts for the newly added line. Circular shifts
 *  are kept within an CircularShifter object again in the form of a LineStorageWrapper 
 *  object.
 *  @author  dhelic
 *  @version $Id$
*/

public class CircularShifter implements Observer{

//----------------------------------------------------------------------
/**
 * Fields
 *
 */
//----------------------------------------------------------------------

/**
 * LineStorageWrapper for circular shifts
 *
 */

  private LineStorageWrapper shifts_;

//----------------------------------------------------------------------
/**
 * Constructors
 *
 */
//----------------------------------------------------------------------

//----------------------------------------------------------------------
/**
 * Defualt constructor.
 * @param shifts storage for shifted lines
 */

  public CircularShifter(LineStorageWrapper shifts){
    shifts_ = shifts;
  }

//----------------------------------------------------------------------
/**
 * Methods
 *
 */
//----------------------------------------------------------------------

//----------------------------------------------------------------------
/**
 */

  public void update(Observable observable, Object arg){
    LineStorageWrapper lines = (LineStorageWrapper) observable;
    LineStorageChangeEvent event = (LineStorageChangeEvent) arg;
    switch(event.getType()){
    case LineStorageChangeEvent.ADD:
      String[] line = lines.getLine(lines.getLineCount() - 1);
      for(int i = 0; i < line.length; i++){
        ArrayList words = new ArrayList();
        for(int j = i; j < (line.length + i); j++)
          words.add(line[j % line.length]);
        String[] line_rep = new String[words.size()];
        for(int k = 0; k < line_rep.length; k++)
          line_rep[k] = (String) words.get(k);
        shifts_.addLine(line_rep);
      }
      break;
    default:
      break;      
    }
  }

//----------------------------------------------------------------------
/**
 * Inner classes
 *
 */
//----------------------------------------------------------------------

}
