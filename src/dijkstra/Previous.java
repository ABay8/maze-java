package dijkstra;

import java.util.ArrayList;
import java.util.Hashtable;

/** Table des prédécesseurs
 * 
 * @author Anaïs BAYANI
 *
 */
public final class Previous implements PreviousInterface{

	private Hashtable<VertexInterface, VertexInterface> previousTable;
	
	public Previous() {
		this.previousTable = new Hashtable<VertexInterface, VertexInterface>();
	}
	
	public final Hashtable<VertexInterface, VertexInterface> getTable() {
		return previousTable;
	}
	
	@Override
	public final void setPrevious(VertexInterface v, VertexInterface newPrevious) {
		this.previousTable.put(v, newPrevious);
	}
	
	@Override
	public final VertexInterface getPrevious(VertexInterface v) {
		VertexInterface p = this.previousTable.get(v);
		return p;
	}

	@Override
	public final ArrayList<VertexInterface> shortestPathTo(VertexInterface v) {
		ArrayList<VertexInterface> path = new ArrayList<VertexInterface>();
		VertexInterface u = v;
		while(u != null) 
			{
				v = u;
				path.add(v);
				u = getPrevious(v);
			}
		return path;
	}
	
	public final boolean inPrevious(VertexInterface v) {
		return previousTable.containsKey(v);
	}
}
