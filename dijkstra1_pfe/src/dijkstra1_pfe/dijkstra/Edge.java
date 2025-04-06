package dijkstra1_pfe.dijkstra;


public class Edge {
    public final Noeud suivant;
    public final double valeur;

    public Edge(Noeud suivant, double valeur) {
        this.suivant = suivant;
        this.valeur = valeur;
    }

