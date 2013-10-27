
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
 * Testrahmen zur Ausführung der Klasse Stack.java; Bedienung:
 * 
 * Eingabe eines Werts; z.B. 5:		>5
 * Auslesen eines Werts:			<
 * Ausgabe des obersten Werts		?
 * Ausgabe der Stackgröße			#
 * Leeren des Stacks				!
 * Beenden des Programms			exit
 * 
 * nach jeder Aktion wird der aktuelle Stack angezeigt.
 */
import java.io.*;

public class StackFrame {

	public static void main(String[] args) {

		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader buffer = new BufferedReader(in);
		
		char c;
		String v;
		int s;


		Object val;								
		Stack stack = new Stack();	

		System.out.println(stack.version() + "\n");
		System.out.println("Befehl eingeben:");
		System.out.println("\t'>int'\t[push <object>]");
		System.out.println("\t'<'\t[pop]");
		System.out.println("\t'?'\t[peek]");
		System.out.println("\t'#'\t[size]");
		System.out.println("\t'!'\t[empty]");
		System.out.println("\t'exit'\t[Ende]");
				
		while (true)
			try{
				System.out.print(": ");
				String input = buffer.readLine();
				if (input.equals("exit")){
					System.out.println("Programm beendet.");
					return;
				}
				c = input.charAt(0);
				v = input.substring(1).trim();
				switch(c){
					case '>' :		
								val = v;					
								stack.push(val);
								break;
					case '<' :	val = stack.pop();
								System.out.println("\t'" + val + "' entnommen");
								break;
					case '?' :	val = stack.peek();
								System.out.println("\t'" + val + "' gefunden");
								break;
					case '!' :	stack.empty();
								System.out.println("\tStack ist geleert.");
								break;
					case '#' :	s = stack.size();
								System.out.println("\t" + s + " Element(e) im Stack.");
								break;
					default  :  break;
				}
				System.out.println("\t" + stack.toString());
			}
			
			catch ( StackEmptyException e) {
				System.out.println("Fehler: Der Stack ist leer; der Befehl wurde ignoriert.");
				System.out.println("\t" + stack.toString());
			}
			catch ( StackFullException e) {
				System.out.println("Fehler: Der Stack ist voll; der Befehl wurde ignoriert.");
				System.out.println("\t" + stack.toString());
			}
			
			catch ( IOException e) {
				e.printStackTrace();
			}
	}
}
