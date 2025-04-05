package dijkstra1_pfe.dijkstra;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class GraphPanel extends JPanel{
	 private Graphe graphe;
	    private Map<String, Point> positions;
	    private List<Noeud> chemin;

	    public GraphPanel(Graphe graphe, List<Noeud> chemin) {
	        this.graphe = graphe;
	        this.chemin = chemin;

	        positions = new HashMap<>();
	        // Positionner les noeuds manuellement
	        positions.put("v0", new Point(100, 50));
	        positions.put("v1", new Point(200, 50));
	        positions.put("v2", new Point(300, 100));
	        positions.put("v3", new Point(400, 200));
	        positions.put("v4", new Point(300, 300));
	        positions.put("v5", new Point(200, 250));
	        positions.put("v6", new Point(100, 300));
	        positions.put("v7", new Point(50, 200));
	        positions.put("v8", new Point(200, 150));
	    }

	    @Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);

	        // Dessiner les arêtes
	        for (Noeud noeud : graphe.getNoeuds()) {
	            Point p1 = positions.get(noeud.nom);
	            for (Edge edge : noeud.filsList) {
	                Point p2 = positions.get(edge.suivant.nom);
	                g.setColor(Color.GRAY);
	                g.drawLine(p1.x, p1.y, p2.x, p2.y);
	                g.drawString("" + (int)edge.valeur, (p1.x + p2.x) / 2, (p1.y + p2.y) / 2);
	            }
	        }

	        // Dessiner les chemins de Dijkstra
	        g.setColor(Color.RED);
	        for (int i = 0; i < chemin.size() - 1; i++) {
	            Point p1 = positions.get(chemin.get(i).nom);
	            Point p2 = positions.get(chemin.get(i + 1).nom);
	            g.drawLine(p1.x, p1.y, p2.x, p2.y);
	        }

	        // Ajouter le dernier saut jusqu’à la destination
	        if (chemin.size() > 0) {
	            Point p1 = positions.get(chemin.get(chemin.size() - 1).nom);
	            Point p2 = positions.get(graphe.getNoeudByNom(chemin.get(chemin.size() - 1).pere.nom).nom);
	            g.drawLine(p1.x, p1.y, p2.x, p2.y);
	        }

	        // Dessiner les noeuds
	        for (Noeud noeud : graphe.getNoeuds()) {
	            Point p = positions.get(noeud.nom);
	            g.setColor(Color.CYAN);
	            g.fillOval(p.x - 15, p.y - 15, 30, 30);
	            g.setColor(Color.BLACK);
	            g.drawOval(p.x - 15, p.y - 15, 30, 30);
	            g.drawString(noeud.nom, p.x - 10, p.y + 5);
	        }
	    }
	    
	    
}
