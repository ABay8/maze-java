package ihm;

import java.awt.Color;

import javax.swing.JMenuBar;

public final class LabyMenuBar extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6502852388668973497L;
	private final FileMenu fileMenu;
	
	
	
	public LabyMenuBar(LabyApp l) {
		super();
		add(fileMenu = new FileMenu(l));
		setBackground(Color.YELLOW);
	}
	
	public final void notifyForUpdate() {
		fileMenu.notifyForUpdate();
		
	}
	
}
