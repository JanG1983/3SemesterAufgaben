/*---------------------------------------------------
 * Hochschule für Technik Stuttgart
 * Fachbereich Vermessung, Informatik und Mathematik
 * Schellingstr. 24
 * D-70174 Stuttgart
 *
 * Volker Coors, Markus Deininger
 * 17.10.2008
 *
 * Datenstrukturen und Algorithmen
 * SG Informatik und SG Informationslogistik
 *
 * Hausübung 3: ADT Stack
 * 
 * ------------------------------------------------*/

package stack;
/*
 * Die Exception soll ausgelöst werden, falls aus einem leeren Stack
 * das oberste Element gelesen oder geholt werden soll.
 */

public class StackEmptyException extends RuntimeException {
	
	public StackEmptyException(){
		super();
	}

}
