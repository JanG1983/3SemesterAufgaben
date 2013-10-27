/*---------------------------------------------------
 * Hochschule f�r Technik Stuttgart
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
 * Haus�bung 3: ADT Stack
 * 
 * ------------------------------------------------*/

package stack;

/*
 * Aufgabe 1.a - Stack Implementierung als Array mit Exception-Handling
 * 
 * Vervollst�ndigen Sie zun�chst die Klasse Stack. Diese Klasse repr�sentiert
 * einen Stack der beliebige Objekte aufnimmt.
 * Erg�nzen Sie den Stack um eine Fehlerbehandlung f�r leere und volle Stacks. 
 * Nutzen Sie dazu die beiden Fehlerklassen StackEmptyException und
 * StackFullException. Die Fehler sollen ausgel�st werden, wenn eine Operation
 * einen Stack�berlauf oder �unterlauf verursachen w�rde.
 * Hinweis: dazu m�ssen Sie die Signatur einiger Stack-Methoden anpassen.
 * 
 *  Aufgabe 1.b - Stack Implementierung als verkettete Liste mit Exception-Handling
 *  
 *  Bauen Sie die Klasse Stack wie in der Vorlesung dargestellt um, so dass die
 *  Datenhaltung statt in einem Array nun als verkettete Liste erfolgt.
 *  Nutzen Sie dazu die Klasse Link. Realisieren Sie die Methode toString so,
 *  dass der Stack beginnend mit dem untersten Element ausgegeben wird.
 *  Optimieren Sie den Stack so, dass alle Methoden (au�er toString) nun die
 *  Komplexit�t O(1) besitzen. 
 *  Zusatzaufgabe: Wie k�nnten Sie die Methode toString ebenfalls mit O(1) realisieren? 
 */

public class Stack {

	// Implementierung der Methoden hier ...

	static int temp = 0;
	Object[] stack = new Object[20];

	public String version() { // gibt eine Versionsnummer zur�ck
		// diese Methode dient dazu, die verschiedenen Implementierungen zu
		// unterscheiden;
		// f�r jede neue Implementierung muss der Text angepasst werden.
		//return "Aufgabe 1.a - Stack; Implementierung als Array mit Exception-Handling";
		return "Version 1.b - Stack; Implementierung als verkettete Liste mit Exception-Handling";
	}

	public void empty() { // leert den Stack
		for (int i = 0; i < stack.length; i++) {
			stack[i] = null;
		}
	}

	public void push(Object element) throws StackFullException { // legt ein Element auf den Stack

		if (isFull()) {
			throw new StackFullException();
		} else {
			for (int i = 0; i < stack.length; i++) {
				if (stack[i] == null) {
					stack[i] = element;
					break;
				}

			}
		}
	}

	public Object pop() throws StackEmptyException{ // nimmt ein Element vom Stack
		Object buffer = new Object();
		if (isEmpty()) {
			throw new StackEmptyException();
		} else {
			buffer = stack[temp];
			stack[temp] = null;
		}
		return buffer;
	}

	public int size() { // aktuelle Anzahl Elemente in Stack
		return temp + 1;
	}

	public boolean isEmpty() { // ist der Stack leer?
		if (stack[0].equals(null)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isFull() { // ist der Stack voll?
		if (temp == stack.length - 1) {
			return true;
		} else {
			return false;
		}
	}

	public Object peek () throws StackEmptyException { // liest oberstes Element vom Stack,
							// ohne es zu vom Stack zu entfernen
		if (isEmpty()) {
			throw new StackEmptyException();
		}
		return stack[temp];
	}

	public String toString() {

		String s = new String();
		if (!(isEmpty())) {

			for (int i = 1; i < stack.length; i++) {
				if (stack[i] != null) {
					s = s.concat(" " + stack[i - 1].toString());
					temp = i;

				}
			}
			if (stack[temp] != null) {
				s = s.concat(" [" + stack[temp] + "]");
			}
		}

		return s;

	}

}
