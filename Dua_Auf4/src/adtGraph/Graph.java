package adtGraph;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Graph {

	static final String FILE = "src/knoten.txt";
	static ArrayList<Vertex> knoten = new ArrayList<Vertex>();
	static ArrayList<Edge> kanten = new ArrayList<Edge>();
	static ArrayList<String> nodeVisited = new ArrayList<String>();

	public static void main(String[] args) throws FileNotFoundException,
			IOException {
		boolean run = true;
		boolean euler;
		String startTiefensuche;
		String startBreitensuche;
		parseGraph();
		euler = istEulerGraph();
		Scanner sc = new Scanner(System.in);

		System.out.println("grad :um den Grad des Graphen zu erhalten.");
		System.out
				.println("isEuler :um zu pruefen ob der Graph ein Euler Graph ist.");
		System.out.println("exit :um das Programm zu verlassen.");
		while (run) {
			System.out.println("Bitte Befehl eingeben: ");
			String console = sc.nextLine();
			console = console.toLowerCase();
			switch (console) {
			case "grad":
				System.out.println("Bitte den Knotennamen eingeben: ");
				System.out.println(getGrad(sc.nextLine().toUpperCase()));
				break;
			case "iseuler":
				if (euler) {
					System.out.println("Graph ist ein Euler Graph");
				} else {
					System.out.println("Graph ist kein Euler Graph");
				}
				break;
			case "tiefensuche":
				System.out.println("Bitte Startknoten eingeben: ");
				startTiefensuche = sc.nextLine().toUpperCase();
				nodeVisited.add(startTiefensuche);
				tiefensuche(startTiefensuche);
				System.out.println("Besuchte Felder: ");
				for (int i = 0; i < nodeVisited.size(); i++) {
					System.out.println(nodeVisited.get(i));
				}
				nodeVisited.clear();
				break;
			case "br":
				System.out.println("Bitte Startknoten eingeben: ");
				startBreitensuche = sc.nextLine().toUpperCase();
				nodeVisited.add(startBreitensuche);
				breitensuche(startBreitensuche);
				System.out.println("Besuchte Felder: ");
				for (int i = 0; i < nodeVisited.size(); i++) {
					System.out.println(nodeVisited.get(i));
				}
				nodeVisited.clear();
				break;
			case "exit":
				run = false;
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

	static boolean istEulerGraph() {
		boolean checkEuler = false;
		for (int i = 0; i < kanten.size(); i++) {
			if ((getGrad(kanten.get(i).v0.name)) % 2 == 1) {
				checkEuler = false;
				break;

			} else if (getGrad(kanten.get(i).v1.name) % 2 == 1) {
				checkEuler = false;
				break;
			} else {
				checkEuler = true;
			}

		}
		return checkEuler;
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

	private static void tiefensuche(String startKnoten) {

		for (int i = 0; i < kanten.size(); i++) {
			if (kanten.get(i).v0.name.equals(startKnoten)) {
				if (!(nodeVisited.contains(kanten.get(i).v1.name))) {
					nodeVisited.add(kanten.get(i).v1.name);
					startKnoten = kanten.get(i).v1.name;
					tiefensuche(startKnoten);

				}
			} else if (kanten.get(i).v1.name.equals(startKnoten)) {
				if (!(nodeVisited.contains(kanten.get(i).v0.name))) {
					nodeVisited.add(kanten.get(i).v0.name);
					startKnoten = kanten.get(i).v0.name;
					tiefensuche(startKnoten);

				}

			}

		}

	}
	
	private static void breitensuche(String startKnoten){
		Queue<String> q = new LinkedList<String>();

		String tempNode;
		String nextNode;
		String k;
		
		q.offer(startKnoten);
		for (int i = 0; i < kanten.size(); i++) {
			if(kanten.get(i).v0.name.equals(startKnoten)){
				nextNode=kanten.get(i).v1.name; 
				q.add(nextNode);
			
			}
			if(kanten.get(i).v1.name.equals(startKnoten)){
				nextNode=kanten.get(i).v0.name; 
				q.add(nextNode);
				
				
			}
			
			while(!q.isEmpty()){
				
				tempNode=q.poll();
				nodeVisited.add(tempNode);
				
			}
			
		}
		
		
		
//		while(!q.isEmpty()){
//			tempNode=q.
//		}
		
	}
}
