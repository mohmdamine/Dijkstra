package dijkstra1_pfe.dijkstra;

import java.util.ArrayList;
import java.util.LinkedList;

public class Noeud implements Comparable<Noeud> {
	 public final String name;
		public ArrayList<Edge> neighbours;
		public LinkedList<Noeud> path;
		public double minDistance = Double.POSITIVE_INFINITY;
		public Noeud previous;
		public int compareTo(Noeud other){
			return Double.compare(minDistance,other.minDistance);		
		}
		public Noeud(String name){
			this.name = name;
			neighbours = new ArrayList<Edge>();
			path = new LinkedList<Noeud>();
		}
		public String toString(){
			return name;
		}	
}
