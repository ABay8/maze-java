package ihm;

import java.awt.Color;
import java.awt.event.*;

import javax.swing.JButton;

public final class ABoxButton extends JButton implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5110640205774592144L;
	private final LabyApp labyApp;
	
	public ABoxButton(LabyApp l) {
		super("Arrival");
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
		labyApp.getLabyAppModel().setChange("ABox");
	   }

}
