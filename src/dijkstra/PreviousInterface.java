package dijkstra;

import java.util.ArrayList;
/** Interface des prédécesseurs
 * 
 * @author Anaïs BAYANI
 *
 */
public interface PreviousInterface {
	
	/** Attribue un prédecesseur à un sommet
	 * @param v : le sommet auquel on attribue un prédecesseur
	 * @param newPrevious : le prédecesseur en question
	 */
	public void setPrevious(VertexInterface v, VertexInterface newPrevious);
	
	/** Renvoie le prédecesseur d'un sommet
	 * @param v : le sommet dont on veut le prédecesseur
	 * @return le prédecesseur
	 */
	public VertexInterface getPrevious(VertexInterface v);
	
	/** Renvoie le chemin le plus court jusqu'à un sommet sous forme de liste
	 * @param v : le sommet jusqu'auquel on cherche le plus court chemin
	 * @return la ArrayList des prédecesseurs successifs formant le plus court chemin
	 */
	public ArrayList<VertexInterface> shortestPathTo(VertexInterface v);
}
