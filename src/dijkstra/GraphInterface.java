package dijkstra;

import java.util.ArrayList;

/** Interface du graphe contenant les sommets
 * 
 * @author Anaïs BAYANI
 *
 */
public interface GraphInterface {
	
	
	/** Donne le poids de l'arrête formée par les deux sommets
	 * @param v : extrémité de l'arrête
	 * @param u : l'autre extrémité
	 * @return le poids de l'arrête dans le graphe
	 */
	public int getWeight(VertexInterface v, VertexInterface u);
	
	
	/** Renvoie les sommets voisins
	 * @param vertex : le sommet dont on cherche les voisins
	 * @return la ArrayList des voisins
	 */
	public ArrayList<VertexInterface> getSuccessors(VertexInterface vertex);
	
	/** Renvoie tous les sommets du graphe
	 * @return la ArrayList des sommets du graphe
	 */
	public ArrayList<VertexInterface> getAllVertices();
	

}
