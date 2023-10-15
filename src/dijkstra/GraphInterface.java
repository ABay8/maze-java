package dijkstra;

import java.util.ArrayList;

/** Interface du graphe contenant les sommets
 * 
 * @author Ana�s BAYANI
 *
 */
public interface GraphInterface {
	
	
	/** Donne le poids de l'arr�te form�e par les deux sommets
	 * @param v : extr�mit� de l'arr�te
	 * @param u : l'autre extr�mit�
	 * @return le poids de l'arr�te dans le graphe
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
