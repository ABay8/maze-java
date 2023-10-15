package ihm;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public final class DBoxButton extends JButton implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6913067145969671690L;
	private final LabyApp labyApp;
	
	public DBoxButton(LabyApp l) {
		super("Departure");
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
		labyApp.getLabyAppModel().setChange("DBox");
	   }

}
