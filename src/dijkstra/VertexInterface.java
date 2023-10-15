package dijkstra;

/** Interface des sommets
 * 
 * @author Anaïs BAYANI
 *
 */
public interface VertexInterface {
	
	/** Renvoie l'indice de la ligne
	 * @return l'indice de la ligne
	 */
	public int getLine();
	
	/** Renvoie l'indice de la colonne
	 * @return l'indice de la colonne
	 */
	public int getColumn();
	
	/** Renvoie le type de sommet
	 * @return le type du sommet
	 */
	public String getLabel();
	
	
}
