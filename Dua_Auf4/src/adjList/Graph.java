package adjList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import adtGraph.Edge;
import adtGraph.Vertex;

public class Graph {

	static final String FILE = "src/knoten.txt";
	static ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
	static ArrayList<String> nodeVisited = new ArrayList<String>();
	static ArrayList<Integer> edgeAr1 = new ArrayList<Integer>();
	static ArrayList<Integer> edgeAr2 = new ArrayList<Integer>();

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

		//namen verarbeiten ?!?
		
		while (sc.hasNext()) {
			String[] edgeArray = new String[3];
			edgeArray = sc.nextLine().split(" ");
			int edge1 = Integer.parseInt(edgeArray[0]);
			int edge2 = Integer.parseInt(edgeArray[1]);
			edgeAr1.add(edge1);
			edgeAr2.add(edge2);
		}
		sc.close();

			
		
		
		
	}

	static boolean istEulerGraph() {
//		boolean checkEuler = false;
//		for (int i = 0; i < kanten.size(); i++) {
//			if ((getGrad(kanten.get(i).v0.name)) % 2 == 1) {
//				checkEuler = false;
//				break;
//
//			} else if (getGrad(kanten.get(i).v1.name) % 2 == 1) {
//				checkEuler = false;
//				break;
//			} else {
//				checkEuler = true;
//			}
//
//		}
		return true;
	}

	static int getGrad(String knotenname) {
//		int counter = 0;
//		for (int i = 0; i < kanten.size(); i++) {
//			if (kanten.get(i).v0.name.equals(knotenname)) {
//				counter++;
//
//			} else if (kanten.get(i).v1.name.equals(knotenname)) {
//				counter++;
//			}
//
//		}

		return 0;
	}

	private static void tiefensuche(String startKnoten) {

//		for (int i = 0; i < kanten.size(); i++) {
//			if (kanten.get(i).v0.name.equals(startKnoten)) {
//				if (!(nodeVisited.contains(kanten.get(i).v1.name))) {
//					nodeVisited.add(kanten.get(i).v1.name);
//					startKnoten = kanten.get(i).v1.name;
//					tiefensuche(startKnoten);
//
//				}
//			} else if (kanten.get(i).v1.name.equals(startKnoten)) {
//				if (!(nodeVisited.contains(kanten.get(i).v0.name))) {
//					nodeVisited.add(kanten.get(i).v0.name);
//					startKnoten = kanten.get(i).v0.name;
//					tiefensuche(startKnoten);
//
//				}
//
//			}
//
//		}

	}
	
	private static void breitensuche(String startKnoten){
//		Queue<String> q = new LinkedList<String>();
//
//		String tempNode;
//		String nextNode;
//		q.add(startKnoten);
//		for (int i = 0; i < kanten.size(); i++) {
//			if(kanten.get(i).v0.name.equals(startKnoten)){
//				nextNode=kanten.get(i).v1.name; 
//				q.add(nextNode);
//			}
//			
//		}
//		while(!q.isEmpty()){
//			System.out.println(q.poll());
//		}	
	}
}
