package ihm;

import java.awt.event.*;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import maze.MazeReadingException;

public final class OpenMenuItem extends JMenuItem implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1561196736575169748L;
	private final LabyApp labyApp;
	
	public OpenMenuItem(LabyApp l) {
		super("Open");
		labyApp = l;
		addActionListener(this);
	}
	
	public final void actionPerformed(ActionEvent evt)
	   {
		final JFrame frame = new JFrame("JFileChooser Demo");

        final JFileChooser fc = new JFileChooser();
        fc.setMultiSelectionEnabled(false);
        fc.setCurrentDirectory(new File("C:\\tmp"));

        fc.showDialog(frame, "Choose a Text File");
        
        File file = fc.getSelectedFile();
        String fileName = file.getPath();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        try {
			labyApp.getLabyAppModel().setFileName(fileName);
		} catch (MazeReadingException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
		}

        
	   }
	
	public final void notifyForUpdate() {
		repaint();
		
	}


}
