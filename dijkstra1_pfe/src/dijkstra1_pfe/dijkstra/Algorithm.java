package dijkstra1_pfe.dijkstra;

import java.util.*;



public class Algorithm {
    public void calculer(Noeud source) {
        source.minDistance = 0;
        PriorityQueue<Noeud> queue = new PriorityQueue<>();
        queue.add(source);

        while (!queue.isEmpty()) {
            Noeud u = queue.poll();

            for (Edge e : u.filsList) {
                Noeud v = e.suivant;
                double distanceParU = u.minDistance + e.valeur;
                if (distanceParU < v.minDistance) {
                    queue.remove(v);
                    v.minDistance = distanceParU;
                    v.pere = u;
                    v.trajet = new LinkedList<>(u.trajet);
                    v.trajet.add(u);
                    queue.add(v);
                }
            }
        }
    }
}
