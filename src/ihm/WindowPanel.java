package ihm;

import javax.swing.JPanel;
import java.awt.*;

public final class WindowPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8959710735769304797L;
	private final ButtonsPanel buttonsPanel;
	private final LabyPanel labyPanel;
	
	public WindowPanel(LabyApp l) {
		super();
		setLayout(new BorderLayout());
		add(buttonsPanel = new ButtonsPanel(l), BorderLayout.SOUTH);
		add(labyPanel = new LabyPanel(l), BorderLayout.CENTER);
	}

	public final void notifyForUpdate() {
		labyPanel.notifyForUpdate() ;
		buttonsPanel.notifyForUpdate() ;
	}

}
