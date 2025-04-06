package dijkstra1_pfe.main;


import javax.swing.*;

import dijkstra1_pfe.dijkstra.Algorithm;
import dijkstra1_pfe.dijkstra.GraphPanel;
import dijkstra1_pfe.dijkstra.Graphe;
import dijkstra1_pfe.dijkstra.Noeud;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Graphe g = new Graphe(9);
        g.addEdge(0, 1, 4); g.addEdge(0, 7, 8);
        g.addEdge(1, 2, 8); g.addEdge(1, 7, 11); g.addEdge(2, 1, 8);
        g.addEdge(2, 8, 2); g.addEdge(2, 5, 4); g.addEdge(2, 3, 7);
        g.addEdge(3, 2, 7); g.addEdge(3, 5, 14); g.addEdge(3, 4, 9);
        g.addEdge(4, 3, 9); g.addEdge(4, 5, 10);
        g.addEdge(5, 4, 10); g.addEdge(5, 3, 9); g.addEdge(5, 2, 4); g.addEdge(5, 6, 2);
        g.addEdge(6, 7, 1); g.addEdge(6, 8, 6); g.addEdge(6, 5, 2);
        g.addEdge(7, 0, 8); g.addEdge(7, 8, 7); g.addEdge(7, 1, 11); g.addEdge(7, 6, 1);
        g.addEdge(8, 2, 2); g.addEdge(8, 7, 7); g.addEdge(8, 6, 6);

        JFrame frame = new JFrame("Visualisation Dijkstra");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JTextField sourceField = new JTextField(5);
        JTextField destinationField = new JTextField(5);
        JButton button = new JButton("Calculer Dijkstra");

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Source (0-8):"));
        inputPanel.add(sourceField);
        inputPanel.add(new JLabel("Destination (0-8):"));
        inputPanel.add(destinationField);
        inputPanel.add(button);

        ArrayList<Noeud> cheminInitial = new ArrayList<>();
        GraphPanel graphPanel = new GraphPanel(g, cheminInitial);
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(graphPanel, BorderLayout.CENTER);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int source = Integer.parseInt(sourceField.getText());
                    int destination = Integer.parseInt(destinationField.getText());

                    if (source < 0 || source >= g.getNoeuds().size() || destination < 0 || destination >= g.getNoeuds().size()) {
                        throw new NumberFormatException();
                    }

                    for (Noeud n : g.getNoeuds()) {
                        n.minDistance = Double.POSITIVE_INFINITY;
                        n.trajet.clear();
                        n.pere = null;
                    }

                    Algorithm algo = new Algorithm();
                    algo.calculer(g.getNoeud(source));
                    Noeud destNode = g.getNoeud(destination);

                    ArrayList<Noeud> chemin = new ArrayList<>(destNode.trajet);
                    chemin.add(destNode);

                    GraphPanel nouveauPanel = new GraphPanel(g, chemin);
                    frame.getContentPane().removeAll();
                    frame.add(inputPanel, BorderLayout.NORTH);
                    frame.add(nouveauPanel, BorderLayout.CENTER);
                    frame.revalidate();
                    frame.repaint();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Entrée invalide : veuillez entrer des indices entre 0 et 8");
                }
            }
        });

        frame.setVisible(true);
    }
}


