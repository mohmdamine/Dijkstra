package dijkstra1_pfe.dijkstra;

public class Edge {
	public final Noeud suivant;
	public final double weight;
	public Edge(Noeud suivant, double weight){
		this.suivant = suivant;
		this.weight = weight;
	}
}
