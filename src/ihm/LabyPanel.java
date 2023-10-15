package ihm;

import javax.swing.JPanel;
import java.awt.* ;

public final class LabyPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8275861509058651393L;
	private final LabyApp labyApp;
	
	
	public LabyPanel(LabyApp l) {
		super();
		labyApp = l;
		
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(500,500));
		fillGrid();	
		
	}
	
	public final void fillGrid() {
		removeAll();
		int width = labyApp.getLabyAppModel().getMaze().getWidth();
		int height = labyApp.getLabyAppModel().getMaze().getHeight();
		setLayout(new GridLayout(height, width));
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				LabyPanelButton lpb = new LabyPanelButton(labyApp, labyApp.getLabyAppModel().getMaze().getMaze()[i][j], i, j);
				add(lpb);
				lpb.notifyForUpdate();
				revalidate();
			}
		}
	}

	public final void notifyForUpdate() {
		if (labyApp.getLabyAppModel().isMazeModified()) {
			fillGrid();
			labyApp.getLabyAppModel().setMazeModified(false);
		}
		
	}
}
