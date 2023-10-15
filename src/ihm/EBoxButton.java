package ihm;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public final class EBoxButton extends JButton implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6052363924665455964L;
	private final LabyApp labyApp;
	
	public EBoxButton(LabyApp l) {
		super("Empty");
		labyApp = l;
		
		addActionListener(this);
		setBackground(Color.MAGENTA);
		
	}
	
	public final void notifyForUpdate() {
		repaint();
	}
	
	@Override
	public final void actionPerformed(ActionEvent evt)
	   {
		labyApp.getLabyAppModel().setChange("EBox");
	   }

}