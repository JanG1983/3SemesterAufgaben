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
		String[] edgeArray=new String[3];
		edgeArray=sc.nextLine().split(" ");
		int startPoint= Integer.parseInt(edgeArray[0]);
		
		int endPoint=Integer.parseInt(edgeArray[1]);
		double weight=Double.parseDouble(edgeArray[2]);
		Edge ed=new Edge(knoten.get(startPoint-1),knoten.get(endPoint-1),weight);
		kanten.add(ed);
		
		}
		int grad;
		grad=getGrad(kanten.get(2).v0.name);
		System.out.println(grad);
		sc.close();
	}

	static int getGrad(String knotenname) {
		
		return 0;
	}
}
