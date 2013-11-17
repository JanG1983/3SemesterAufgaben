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

	public static void main(String[] args) throws IOException {
		boolean run = true;
		boolean euler;
		String startTiefensuche;
		String startBreitensuche;
		parseGraph();
		euler = istEulerGraph();
		Scanner sc = new Scanner(System.in);
		System.out.println("grad : um den Grad des Graphen zu erhalten.");
		System.out
				.println("isEuler : um zu pruefen ob der Graph ein Euler Graph ist.");
		System.out.println("tiefensuche : um eine Tiefensuche auszuführen.");
		System.out.println("breitensuche : um eine Breitensuche auszuführen");
		System.out.println("exit : um das Programm zu verlassen.");
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
			case "breitensuche":
				System.out.println("Bitte Startknoten eingeben: ");
				startBreitensuche = sc.nextLine().toUpperCase();
				// nodeVisited.add(startBreitensuche);
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
			if ((getGrad(getStartNode(i))) % 2 == 1) {
				checkEuler = false;
				break;

			} else if (getGrad(getNextNode(i)) % 2 == 1) {
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
			if (getStartNode(i).equals((knotenname))) {
				counter++;

			} else if (getNextNode(i).equals(knotenname)) {
				counter++;
			}

		}

		return counter;
	}

	private static void tiefensuche(String startKnoten) {

		for (int i = 0; i < kanten.size(); i++) {
			if (getStartNode(i).equals(startKnoten)) {
				if (!(nodeVisited.contains(getNextNode(i)))) {
					nodeVisited.add(getNextNode(i));
					startKnoten = getNextNode(i);
					tiefensuche(startKnoten);

				}
			} else if (getNextNode(i).equals(startKnoten)) {
				if (!(nodeVisited.contains(getStartNode(i)))) {
					nodeVisited.add(getStartNode(i));
					startKnoten = getStartNode(i);
					tiefensuche(startKnoten);

				}

			}

		}

	}

	private static void breitensuche(String startKnoten) {
		Queue<String> q = new LinkedList<String>();
		String tempNode;
		q.add(startKnoten);
		while (!(q.isEmpty())) {
			tempNode = q.poll();
			nodeVisited.add(tempNode);
			for (int i = 0; i < kanten.size(); i++) {

				if (getStartNode(i).equals(tempNode)
						&& !nodeVisited.contains(getNextNode(i))
						&& !q.contains(getNextNode(i))) {
					q.add(getNextNode(i));

				} else if (getNextNode(i).equals(tempNode)
						&& !nodeVisited.contains(getStartNode(i))
						&& !q.contains(getStartNode(i))) {
					q.add(getStartNode(i));
				}

			}
		}

	}

	public static String getStartNode(int index) {

		return kanten.get(index).v0.name;

	}

	public static String getNextNode(int index) {

		return kanten.get(index).v1.name;

	}
}
