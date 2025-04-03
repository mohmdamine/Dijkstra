package dijkstra1_pfe.dijkstra;

import java.util.*;

public class Algorithm {
	
	public void calculer(Noeud source) {
		source.minDistance = 0;
		PriorityQueue<Noeud> queue = new PriorityQueue<>();
		queue.offer(source);
	
		while(!queue.isEmpty()){
		
			Noeud u = queue.poll(); 
	
			for(Edge neighbour:u.neighbours){
				Double newDist = u.minDistance+neighbour.weight;
			
				if(neighbour.suivant.minDistance>newDist){ 
				
					queue.remove(neighbour.suivant);
					neighbour.suivant.minDistance = newDist;
				
				
					neighbour.suivant.path = new LinkedList<Noeud>(u.path);
					neighbour.suivant.path.add(u);
				
				
					queue.add(neighbour.suivant);					 
				}
			}
		}
	}
}
