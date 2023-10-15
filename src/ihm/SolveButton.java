package ihm;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import maze.MazeReadingException;

public final class SolveButton extends JButton implements ActionListener {
	
	private static final long serialVersionUID = -4162929993780763818L;
	private final LabyApp labyApp;

	public SolveButton(LabyApp l) {
		super("Solve");
		labyApp = l;
		
		addActionListener(this);
		setBackground(Color.LIGHT_GRAY);
	}

	public final void notifyForUpdate() {
		repaint();
	}
	
	@Override
	public final void actionPerformed(ActionEvent evt)
	   {
		try {
			labyApp.getLabyAppModel().resolution();
		} catch (MazeReadingException e) {
			e.getMessage();  //VOIR POUR AFFICHER LE MESSAGE 
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
		}
	   }

}
