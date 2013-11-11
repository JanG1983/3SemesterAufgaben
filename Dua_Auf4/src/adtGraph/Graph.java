package adtGraph;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Ali
 */
public class Graph {

    static final String FILE = "src/knoten.txt";
    static ArrayList<Vertex> knoten = new ArrayList();
    static ArrayList<Edge> kanten = new ArrayList();
    

    public static void main(String[] args) throws FileNotFoundException, IOException {
    	Vertex vertex = null;
       
        FileReader fr = new FileReader(FILE);
        BufferedReader br = new BufferedReader(fr);
        
        String i = br.readLine();
        Integer anzahl = new Integer(i);
        for(int k=1;k<=anzahl;k++){
        	vertex.id=3;
        	knoten.add(vertex);
        	

        }
                //
           
        //

       
    }

    int getGraph(String knotenname) {

        return 0;
    }
}
