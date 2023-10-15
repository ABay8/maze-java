package dijkstra;

/**Interface de l'ensemble A (les sommets déjà examinés)
 * 
 * @author Anaïs BAYANI
 *
 */
public interface ASetInterface {
	
	/** Ajoute un sommet dans A
	 * @param vertex : le sommet à ajouter
	 */
	
	public void addVertex(VertexInterface vertex); 
	
	
	/** Confirme si un sommet est dans A ou no
	 * @param vertex : le sommet dont on teste la présence dans A
	 * @return True si vertex est dans A, False sinon
	 */
	
	public boolean inIt(VertexInterface vertex); 
}
