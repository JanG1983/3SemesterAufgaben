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
 * Die Exception soll ausgelöst werden, falls in einen vollen Stack
 * ein neues Element eingefügt werden soll.
 */

public class StackFullException extends RuntimeException {
	
	public StackFullException(){
		super();
	}

}
