package dijkstra1_pfe.dijkstra;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class GraphPanel extends JPanel {
    private Graphe graphe;
    public ArrayList<Noeud> chemin;
    private Map<String, Point> positions;

    public GraphPanel(Graphe graphe, ArrayList<Noeud> chemin) {
        this.graphe = graphe;
        this.chemin = chemin;
        this.positions = new HashMap<>();
        generateNodePositions();
    }

    private void generateNodePositions() {
        int rayon = 200;
        int centreX = 350;
        int centreY = 250;
        int total = graphe.getNoeuds().size();

        for (int i = 0; i < total; i++) {
            double angle = 2 * Math.PI * i / total;
            int x = (int) (centreX + rayon * Math.cos(angle));
            int y = (int) (centreY + rayon * Math.sin(angle));
            positions.put(graphe.getNoeud(i).nom, new Point(x, y));
        }
    }

    private boolean estDansChemin(Noeud a, Noeud b) {
        for (int i = 0; i < chemin.size() - 1; i++) {
            Noeud n1 = chemin.get(i);
            Noeud n2 = chemin.get(i + 1);
            if ((n1 == a && n2 == b) || (n1 == b && n2 == a)) {
                return true;
            }
        }
        return false;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Arêtes
        for (Noeud n : graphe.getNoeuds()) {
            Point p1 = positions.get(n.nom);
            for (Edge e : n.filsList) {
                Point p2 = positions.get(e.suivant.nom);
                if (estDansChemin(n, e.suivant)) {
                    g.setColor(Color.RED);
                } else {
                    g.setColor(Color.LIGHT_GRAY);
                }
                g.drawLine(p1.x, p1.y, p2.x, p2.y);

                g.setColor(Color.BLACK);
                g.drawString(String.valueOf((int) e.valeur), (p1.x + p2.x) / 2, (p1.y + p2.y) / 2);
            }
        }

        // Noeuds
        for (Noeud n : graphe.getNoeuds()) {
            Point p = positions.get(n.nom);
            if (!chemin.isEmpty() && n == chemin.get(0)) {
                g.setColor(Color.GREEN);
            } else if (!chemin.isEmpty() && n == chemin.get(chemin.size() - 1)) {
                g.setColor(Color.ORANGE);
            } else if (chemin.contains(n)) {
                g.setColor(Color.RED);
            } else {
                g.setColor(Color.CYAN);
            }

            g.fillOval(p.x - 15, p.y - 15, 30, 30);
            g.setColor(Color.BLACK);
            g.drawOval(p.x - 15, p.y - 15, 30, 30);
            g.drawString(n.nom, p.x - 10, p.y + 5);
        }
    }
}
