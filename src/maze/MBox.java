package maze;

import dijkstra.VertexInterface;

/** Classe abstraite des cases du labyrinthe
 * 
 * @author Anaïs BAYANI
 *
 */
public abstract class MBox implements VertexInterface{
	private int columnIndex ;
	private int lineIndex ;
	
	public MBox (int lineIndex, int columnIndex) {
		this.lineIndex = lineIndex;
		this.columnIndex = columnIndex; 
	}
	
	@Override
	public final int getLine() {
		return lineIndex ; 
	}
	
	@Override
	public final int getColumn() {
		return columnIndex;
	}
	
	@Override
	public final String getLabel(){
		return getClass().getSimpleName(); 
	}
	
	 
}
