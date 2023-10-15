package dijkstra;

/** Interface de la table pi 
 * 
 * @author Anaïs BAYANI
 *
 */
public interface PiInterface {
	
	
	/** Renvoie la valeur de pi du sommet
	 * @param vertex : le sommet dont on veut la valeur de pi
	 * @return la valeur de pi
	 */
	public int getPi(VertexInterface vertex);
	
	/** Donne une valeur de pi à un sommet
	 * @param vertex : le sommet auquel on donne une valeur de pi
	 * @param valeur : la valeur de pi que l'on donne
	 */
	public void setPi(VertexInterface vertex, int valeur); 
	

}
