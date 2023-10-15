package ihm;

import javax.swing.JPanel;
import java.awt.*;

public final class ButtonsPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8883747724082124182L;
	private final LabyApp labyApp;
	private final SolveButton solveButton;
	private final ResetButton resetButton;
	private final ABoxButton aBoxButton;
	private final DBoxButton dBoxButton;
	private final EBoxButton eBoxButton;
	private final WBoxButton wBoxButton;
	private final TotalResetButton totalResetButton;
	private final SizeButton sizeButton;
	
	
	public ButtonsPanel(LabyApp l) {
		super();
		labyApp = l;
		
		
		setLayout(new GridLayout(3,3));
		add(solveButton = new SolveButton(l));
		add(resetButton = new ResetButton(l));
		add(aBoxButton = new ABoxButton(l));
		add(dBoxButton = new DBoxButton(l));
		add(eBoxButton = new EBoxButton(l));
		add(wBoxButton = new WBoxButton(l));
		add(totalResetButton = new TotalResetButton(l));
		add(sizeButton = new SizeButton(l));
	}

	public void notifyForUpdate() {
		solveButton.notifyForUpdate() ;
		resetButton.notifyForUpdate();
		aBoxButton.notifyForUpdate();
		dBoxButton.notifyForUpdate();
		eBoxButton.notifyForUpdate();
		wBoxButton.notifyForUpdate();
		totalResetButton.notifyForUpdate();
		sizeButton.notifyForUpdate();
	}
	
}
