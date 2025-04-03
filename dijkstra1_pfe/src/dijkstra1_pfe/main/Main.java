package dijkstra1_pfe.main;

import dijkstra1_pfe.dijkstra.Algorithm;
import dijkstra1_pfe.dijkstra.Graphe;
import dijkstra1_pfe.dijkstra.Noeud;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Algorithm obj = new Algorithm();
		
		// Create a new graph.
		Graphe g = new Graphe(9);
		
		// Add the required edges.
		g.addEdge(0, 1, 4); g.addEdge(0, 7, 8);
		g.addEdge(1, 2, 8); g.addEdge(1, 7, 11); g.addEdge(2, 1, 8);
		g.addEdge(2, 8, 2); g.addEdge(2, 5, 4); g.addEdge(2, 3, 7);
		g.addEdge(3, 2, 7); g.addEdge(3, 5, 14); g.addEdge(3, 4, 9); 
		g.addEdge(4, 3, 9); g.addEdge(4, 5, 10); 
		g.addEdge(5, 4, 10); g.addEdge(5, 3, 9); g.addEdge(5, 2, 4); g.addEdge(5, 6, 2);
		g.addEdge(6, 7, 1); g.addEdge(6, 8, 6); g.addEdge(6, 5, 2);
		g.addEdge(7, 0, 8); g.addEdge(7, 8, 7); g.addEdge(7, 1, 11); g.addEdge(7, 6, 1);
		g.addEdge(8, 2, 2); g.addEdge(8, 7, 7); g.addEdge(8, 6, 6);
		
		// Calculate Dijkstra.
		obj.calculer(g.getNoeud(0));	

		// Print the minimum Distance.
		for(Noeud v:g.getNoeuds()){
			System.out.print("Vertex - "+v+" , Dist - "+ v.minDistance+" , Path - ");
			for(Noeud pathvert:v.path) {
				System.out.print(pathvert+" ");
			}
			System.out.println(""+v);
		}
	}
}
