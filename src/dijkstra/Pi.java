package dijkstra;

import java.util.Hashtable;


/** Table de valeurs de pi de chaque sommet
 * 
 * @author Anaïs BAYANI
 *
 */
public final class Pi implements PiInterface  {

	private Hashtable<VertexInterface, Integer> pi ;
	
	
	public Pi() {
		this.pi = new Hashtable<VertexInterface, Integer>();
	}
	
	public final Hashtable<VertexInterface, Integer> getTable() {
		return pi;
	}
	
	public final void setTable(Hashtable<VertexInterface, Integer> table) {
		pi = table ; 
	}
	
	@Override
	public final int getPi(VertexInterface vertex) {
		return pi.get(vertex);
	}

	@Override
	public final void setPi(VertexInterface vertex, int valeur) {
		pi.put(vertex, valeur);
	}

}
