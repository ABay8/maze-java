package ihm;

import model.*;
import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import maze.MazeReadingException;

public final class LabyApp extends JFrame implements ChangeListener{

	private static final long serialVersionUID = -2152080846033372031L;
	private final LabyMenuBar labyMenuBar;
	private final WindowPanel windowPanel;
	private LabyAppModel labyAppModel;
		
	public LabyApp() throws MazeReadingException {
		super("Labyrinthe");
		this.labyAppModel = new LabyAppModel("data/labyrinthe.txt");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setJMenuBar(labyMenuBar = new LabyMenuBar(this));
		setContentPane(windowPanel = new WindowPanel(this));
		labyAppModel.addObserver(this);
		pack();
		setVisible(true);
		
	}
	
	public final LabyAppModel getLabyAppModel() {
		return labyAppModel;
	}

	public final void setLabyAppModel(LabyAppModel lm) {
		labyAppModel = lm;
		
	}

	@Override
	public final void stateChanged(ChangeEvent e) {
		windowPanel.notifyForUpdate() ;
		labyMenuBar.notifyForUpdate();
	}
	
	
}
