/**
 * 
 */
package util;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

import util.enumData.City;

/**
 * @author G
 *
 */
public class FromIntToCity {

	public static City toCity(int block) {
		switch(block) {
			case 1:
			case 2:
				return City.BEIJING;
			case 3:
			case 4:
				return City.NANJING;
			case 5:
			case 6:
				return City.SHANGHAI;
			case 7:
			case 8:
				return City.GUANGZHOU;
			default:
				return null;
		
		}
	}
}
