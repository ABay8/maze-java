package ihm;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import javax.swing.JButton;

public final class TotalResetButton extends JButton implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3604056541400316308L;
	private final LabyApp labyApp;
	
	public TotalResetButton(LabyApp l) {
		super("Total Reset");
		labyApp = l;
		
		addActionListener(this);
		setBackground(Color.GRAY);
	}
	
	public final void notifyForUpdate() {
		repaint();
	}
	
	@Override
	public final void actionPerformed(ActionEvent evt) {
		labyApp.getLabyAppModel().resetTotal();
	}
}
