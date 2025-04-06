package dijkstra1_pfe.dijkstra;

import java.util.*;



public class Noeud implements Comparable<Noeud> {
    public final String nom;
    public List<Edge> filsList;
    public LinkedList<Noeud> trajet;
    public double minDistance = Double.POSITIVE_INFINITY;
    public Noeud pere;

    public Noeud(String nom) {
        this.nom = nom;
        this.filsList = new ArrayList<>();
        this.trajet = new LinkedList<>();
    }

    public int compareTo(Noeud autre) {
        return Double.compare(minDistance, autre.minDistance);
    }

    public String toString() {
        return nom;
    }
}
