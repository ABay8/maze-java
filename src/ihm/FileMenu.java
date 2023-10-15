package ihm;

import javax.swing.JMenu;

public final class FileMenu extends JMenu{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 303818958232631146L;
	private final LabyApp labyApp;
	private final SaveMenuItem saveMenuItem;
	private final OpenMenuItem openMenuItem;
	
	public FileMenu(LabyApp l) {
		super("file");
		this.labyApp=l;
		add(saveMenuItem = new SaveMenuItem(l));
		add(openMenuItem = new OpenMenuItem(l));
		
	}
	
	public final void notifyForUpdate() {
		openMenuItem.notifyForUpdate();
		saveMenuItem.notifyForUpdate();
	}
	
	
}
