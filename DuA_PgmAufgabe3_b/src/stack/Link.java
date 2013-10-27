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

/*
 * Klasse zur Realisierung einer verketteten Listen;
 * "data" nimmt die Datenelement auf; 
 * "next" verweist auf das nächste Element der Liste oder ist "null"
 */

package stack;

public class Link {
	
	protected Object data;
	protected Link next;
	
	public Link(){				// Erzeugt ein neues, leeres Link-Objekt
		this.data = null;
		this.next = null;
	}
	
	public Link(Object data){	// Erzeugt ein neues, gefülltes Link-Objekt
		this.data = data;
		this.next = null;
	}
}
