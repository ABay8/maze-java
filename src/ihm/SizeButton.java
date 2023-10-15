package ihm;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JOptionPane;


public final class SizeButton extends JButton implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3707120106791835751L;
	private final LabyApp labyApp;
	
	public SizeButton(LabyApp l) {
		super("Size");
		labyApp = l;
		
		addActionListener(this);
		setBackground(Color.GRAY);
	}

	public final void notifyForUpdate() {
		repaint();
	}
	
	@Override
	public final void actionPerformed(ActionEvent evt)
	   {
		int height = labyApp.getLabyAppModel().getMaze().getHeight();
		int width = labyApp.getLabyAppModel().getMaze().getWidth();
		try{int newHeight = Integer.parseInt(JOptionPane.showInputDialog("What height?", height));
			int newWidth = Integer.parseInt(JOptionPane.showInputDialog("What width?", width));
			if((newHeight<1 || newWidth<1)|| (newHeight==1 && newWidth==1) || (newHeight==1 && newWidth==2) || (newHeight==2 && newWidth==1)) {
				JOptionPane.showMessageDialog(null, "Taille incorrecte" , "Erreur", JOptionPane.ERROR_MESSAGE);
			//	labyApp.getLabyAppModel().SetSize(height, width);
			}
			else 
			labyApp.getLabyAppModel().SetSize(newHeight, newWidth);
		}
		catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Il faut donner un nombre !" , "Erreur", JOptionPane.ERROR_MESSAGE);
		}
	   }
}
