package adtGraph;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Graph {

	static final String FILE = "src/knoten.txt";
	static ArrayList<Vertex> knoten = new ArrayList<Vertex>();
	static ArrayList<Edge> kanten = new ArrayList<Edge>();

	public static void main(String[] args) throws FileNotFoundException,
			IOException {
		boolean run=true;
		parseGraph();
		Scanner sc =new Scanner(System.in);
		//ToDo:
		//Groߟ-und Kleinschreibung ignorieren genauso 
		//wie Leerzeichen ausgabe bei falscher eingabe
		System.out.println("Bitte zum Verlassen exit eingeben: ");
		while(run){
			String console=sc.nextLine();
			switch (console){
			case "grad":
				System.out.println("Bitte den Knotennamen eingeben: ");
				System.out.println(getGrad(sc.nextLine()));
				break;
			case "exit":
				run=false;
				break;
			}
				
		}
		sc.close();
	
	}

	private static void parseGraph() throws FileNotFoundException {
		Scanner sc = new Scanner(new File(FILE));
		String countStr = sc.nextLine();
		countStr = countStr.trim();
		int anzahl = Integer.parseInt(countStr);
		String names = sc.nextLine();
		names = names.replaceAll(" ", "");
		String[] namesArray = new String[anzahl];
		namesArray = names.split(",");
		for (int i = 0; i < anzahl; i++) {
			Vertex vertex = new Vertex((i + 1), namesArray[i]);
			knoten.add(vertex);
		}
		while (sc.hasNext()) {
			String[] edgeArray = new String[3];
			edgeArray = sc.nextLine().split(" ");
			int startPoint = Integer.parseInt(edgeArray[0]);

			int endPoint = Integer.parseInt(edgeArray[1]);
			double weight = Double.parseDouble(edgeArray[2]);
			Edge ed = new Edge(knoten.get(startPoint - 1),
					knoten.get(endPoint - 1), weight);
			kanten.add(ed);

		}
		sc.close();
	}

	static int getGrad(String knotenname) {
		int counter = 0;
		for (int i = 0; i < kanten.size(); i++) {
			if (kanten.get(i).v0.name.equals(knotenname)) {
				counter++;

			} else if (kanten.get(i).v1.name.equals(knotenname)) {
				counter++;
			}

		}

		return counter;
	}
}
