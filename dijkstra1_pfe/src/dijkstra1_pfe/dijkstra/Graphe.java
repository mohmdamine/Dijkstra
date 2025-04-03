package dijkstra1_pfe.dijkstra;

import java.util.*;
import java.util.ArrayList;

public class Graphe {
	private ArrayList<Noeud> Noeuds;
	public Graphe(int numberVertices){
		Noeuds = new ArrayList<Noeud>(numberVertices);
		for(int i=0;i<numberVertices;i++){
			Noeuds.add(new Noeud("v"+Integer.toString(i)));
		}
	}
	
	public void addEdge(int source, int destination, int weight){
		Noeud s = Noeuds.get(source);
		Edge new_edge = new Edge(Noeuds.get(destination),weight);
		s.neighbours.add(new_edge);
	}
	
	public ArrayList<Noeud> getNoeuds() {
		return Noeuds;
	}
	
	public Noeud getNoeud(int vert){
		return Noeuds.get(vert);
	}
}
