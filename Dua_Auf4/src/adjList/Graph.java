package adjList;

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
	static ArrayList<ArrayList<Integer>> kanten = new ArrayList<ArrayList<Integer>>();
	static ArrayList<Integer> nodeVisited = new ArrayList<Integer>();
	static ArrayList<Integer> leftEdge = new ArrayList<Integer>();
	static ArrayList<Integer> rightEdge = new ArrayList<Integer>();
	static int count = 1;

	public static void main(String[] args) throws FileNotFoundException,
			IOException {
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
				nodeVisited.add(findId(startTiefensuche));
				tiefensuche(findId(startTiefensuche));
				System.out.println("Besuchte Felder: ");
				for (int i = 0; i < nodeVisited.size(); i++) {
					for (int j = 0; j < knoten.size(); j++) {
						if (nodeVisited.get(i).equals(knoten.get(j).id)) {
							System.out.println(knoten.get(j).name);
						}
					}
				}
				nodeVisited.clear();
				break;
			case "breitensuche":
				System.out.println("Bitte Startknoten eingeben: ");
				startBreitensuche = sc.nextLine().toUpperCase();
				breitensuche(findId(startBreitensuche));
				System.out.println("Besuchte Felder: ");
				for (int i = 0; i < nodeVisited.size(); i++) {
					for (int j = 0; j < knoten.size(); j++) {
						if (nodeVisited.get(i).equals(knoten.get(j).id)) {
							System.out.println(knoten.get(j).name);
						}
					}
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
			leftEdge.add(Integer.parseInt(edgeArray[0]));
			rightEdge.add(Integer.parseInt(edgeArray[1]));
		}
		int count = 1;
		while (count <= anzahl) {
			ArrayList<Integer> temp = new ArrayList<Integer>();

			for (int i = 0; i < leftEdge.size(); i++) {
				if (leftEdge.get(i) == count) {
					temp.add(rightEdge.get(i));
				}
			}
			for (int i = 0; i < rightEdge.size(); i++) {
				if (rightEdge.get(i) == count) {
					temp.add(leftEdge.get(i));
				}
			}
			kanten.add(count - 1, temp);
			count++;
		}
		sc.close();
	}

	static boolean istEulerGraph() {
		boolean checkEuler = true;

		for (int i = 0; i < kanten.size(); i++) {
			if (kanten.get(i).size() % 2 == 1) {
				checkEuler = false;
			}
		}
		return checkEuler;
	}

	static int getGrad(String knotenname) {
		int tempId = findId(knotenname);
		return (kanten.get(tempId - 1).size());
	}

	private static void tiefensuche(int startKnoten) {

		while (nodeVisited.size() < kanten.size()) {

			int tempNode = getNextNode(startKnoten);
			if (!(nodeVisited.contains(tempNode))) {
				nodeVisited.add(tempNode);
				startKnoten = tempNode;
				count = 1;
			}
			if (nodeVisited.size() < kanten.size()) {
				if (nodeVisited.containsAll(kanten.get(tempNode - 1))) {
					startKnoten = nodeVisited.get(nodeVisited.size() - count);
					count++;
				}
			}
		}
	}

	private static void breitensuche(int startKnoten) {

		Queue<Integer> q = new LinkedList<Integer>();
		int tempNode;
		q.add(startKnoten);

		while (!(q.isEmpty())) {
			tempNode = q.poll();
			nodeVisited.add(tempNode);

			for (int i = 0; i < kanten.get(tempNode - 1).size(); i++) {
				if (!(nodeVisited.contains(kanten.get(tempNode - 1).get(i)))
						&& !(q.contains(kanten.get(tempNode - 1).get(i)))) {
					q.add(kanten.get(tempNode - 1).get(i));
				}
			}

		}

	}

	private static int findId(String startKnoten) {
		int tempId = 1;
		for (int i = 0; i < knoten.size(); i++) {
			if (knoten.get(i).name.equals(startKnoten)) {
				tempId = knoten.get(i).id;
			}
		}
		return tempId;
	}

	public static String getStartNode(int index) {

		return "";

	}

	public static int getNextNode(int id) {

		int rnd = (int) ((Math.random() * (kanten.get(id - 1).size())));
		return (kanten.get(id - 1).get(rnd));

	}
}
