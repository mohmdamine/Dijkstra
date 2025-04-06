package dijkstra1_pfe.dijkstra;

import java.util.*;



public class Graphe {
    private List<Noeud> noeuds;

    public Graphe(int nombreDeNoeud) {
        noeuds = new ArrayList<>(nombreDeNoeud);
        for (int i = 0; i < nombreDeNoeud; i++) {
            noeuds.add(new Noeud("v" + i));
        }
    }

    public void addEdge(int source, int destination, double valeur) {
        Noeud s = noeuds.get(source);
        Edge e = new Edge(noeuds.get(destination), valeur);
        s.filsList.add(e);
    }

    public Noeud getNoeud(int indice) {
        return noeuds.get(indice);
    }

    public List<Noeud> getNoeuds() {
        return noeuds;
    }
}
