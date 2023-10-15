package ihm;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.*;

public final class ResetButton extends JButton implements ActionListener{
	
	private static final long serialVersionUID = -2426020047923083426L;
	private final LabyApp labyApp;
	
	public ResetButton(LabyApp l) {
		super("Reset path");
		labyApp = l;
		
		addActionListener(this);
		setBackground(Color.LIGHT_GRAY);
	}
	
	public final void notifyForUpdate() {
		repaint();
	}
	
	
	
	@Override
	public final void actionPerformed(ActionEvent e) {
		labyApp.getLabyAppModel().reset();
	}

}
