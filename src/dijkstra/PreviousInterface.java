package dijkstra;

import java.util.ArrayList;
/** Interface des pr�d�cesseurs
 * 
 * @author Ana�s BAYANI
 *
 */
public interface PreviousInterface {
	
	/** Attribue un pr�decesseur � un sommet
	 * @param v : le sommet auquel on attribue un pr�decesseur
	 * @param newPrevious : le pr�decesseur en question
	 */
	public void setPrevious(VertexInterface v, VertexInterface newPrevious);
	
	/** Renvoie le pr�decesseur d'un sommet
	 * @param v : le sommet dont on veut le pr�decesseur
	 * @return le pr�decesseur
	 */
	public VertexInterface getPrevious(VertexInterface v);
	
	/** Renvoie le chemin le plus court jusqu'� un sommet sous forme de liste
	 * @param v : le sommet jusqu'auquel on cherche le plus court chemin
	 * @return la ArrayList des pr�decesseurs successifs formant le plus court chemin
	 */
	public ArrayList<VertexInterface> shortestPathTo(VertexInterface v);
}
