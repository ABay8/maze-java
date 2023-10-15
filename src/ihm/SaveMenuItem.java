package ihm;

import java.awt.event.*;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuItem;

public final class SaveMenuItem extends JMenuItem implements ActionListener{

		/**
	 * 
	 */
	private static final long serialVersionUID = -8305588904335126209L;
		private final LabyApp labyApp;
		
		public SaveMenuItem(LabyApp labyApp) {
			super("Save");
			this.labyApp = labyApp;
			addActionListener(this);
		}
	/**
	 * Sauvegarde le labyrinthe dans un fichier texte déjà existant 
	 */
		public final void actionPerformed(ActionEvent evt)
		   {
			final JFrame frame = new JFrame("JFileChooser Demo");

	        final JFileChooser fc = new JFileChooser();
	        fc.setMultiSelectionEnabled(false);
	        fc.setCurrentDirectory(new File("C:\\tmp"));

	        fc.showDialog(frame, "Choose");
	        
	        File file = fc.getSelectedFile();
	        String fileName = file.getPath();
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
	        labyApp.getLabyAppModel().SaveToTextFile(fileName);
		   }
		
		public final void notifyForUpdate() {
			repaint();
			
		}

}
