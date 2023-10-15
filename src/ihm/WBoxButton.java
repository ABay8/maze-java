package ihm;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public final class WBoxButton extends JButton implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5069248558844901126L;
	private final LabyApp labyApp;
	
	public WBoxButton(LabyApp l) {
		super("Wall");
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
		labyApp.getLabyAppModel().setChange("WBox");
	   }

}