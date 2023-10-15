package dijkstra;

import java.util.ArrayList;

import maze.MBox;

/** Classe d'implémentation de l'algorithme de Dijkstra
 * 
 * @author Anaïs BAYANI
 *
 */
public final class Dijkstra {
	
	/** Algorithme de Dijkstra
	 * 
	 * @param g : le graphe des sommets
	 * @param r : Le sommet de départ
	 * @param a : Les sommets examinés
	 * @param pi : Table des valeurs pi
	 * @param previous : Table des sommets pères
	 * @return la table des sommets pères ( qui forment le plus court chemin)
	 */
	public final static PreviousInterface dijkstra(GraphInterface g, VertexInterface r, ASetInterface a, PiInterface pi, PreviousInterface previous) {
		a.addVertex(r);
		VertexInterface pivot = r ;
		pi.setPi(r, 0);
		ArrayList<VertexInterface> graphe = g.getAllVertices();
		
		for (VertexInterface vertex : graphe) {
			if(vertex != r) {
				pi.setPi(vertex, Integer.MAX_VALUE -10);
			}
		}
		for(int i = 0; i<graphe.size() -1 ; i++) {
			ArrayList<VertexInterface> successors = g.getSuccessors(pivot);
			for(VertexInterface y : successors) {
				if (!a.inIt(y)) {
					if (pi.getPi(pivot) + g.getWeight(pivot, y) < pi.getPi(y)) {
						pi.setPi( y, pi.getPi(pivot) + g.getWeight(pivot, y));
						previous.setPrevious(y, pivot);
					}
				}
			} 
			
			int minPi= Integer.MAX_VALUE ;
			VertexInterface newPivot = null ;
			for (VertexInterface vertex : graphe ) {
				if ( !(a.inIt(vertex)) && (pi.getPi(vertex)<minPi)) {
					minPi = pi.getPi(vertex);
					newPivot = vertex;
				}
			}
			pivot = newPivot ;
			a.addVertex(pivot);
			
		
		}
		for(VertexInterface y : graphe) {
			if (((MBox)y).getLabel().equals("A"))
				System.out.println(previous.getPrevious(y));
		}
		return previous;
}	
	
}
