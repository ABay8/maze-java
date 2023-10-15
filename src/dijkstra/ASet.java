package dijkstra;

import java.util.HashSet;

/** Ensemble A (Set de hashage contenant les sommets déjà examinés)
 * 
 * @author Anaïs BAYANI
 *
 */
public final class ASet implements ASetInterface {

	private HashSet<VertexInterface> aset;
	
	public ASet () {
		this.aset =  new HashSet<VertexInterface>();
		//Set<VertexInterface> s = Collections.synchronizedSet(aset);
	}		
	
	@Override
	public final void addVertex(VertexInterface vertex) {
		this.aset.add(vertex); 
		
	}


	@Override
	public final boolean inIt(VertexInterface vertex) {
		return aset.contains(vertex);
	}

	
}
