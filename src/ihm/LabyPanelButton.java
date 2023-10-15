package ihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.* ;

import javax.swing.JButton;

import maze.ABox;
import maze.DBox;
import maze.EBox;
import maze.MBox;
import maze.WBox;

public final class LabyPanelButton extends JButton implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1095937183714343460L;
	private final LabyApp labyApp;
	private MBox box;
	private final int i;
	private final int j;
	
	
	public LabyPanelButton(LabyApp l, MBox box, int i, int j) {
		super();
		labyApp = l;
		this.box = box;
		this.i = i;
		this.j = j;
		
		addActionListener(this);
		
	}
	
	public Color chooseColor() {
		switch(box.getLabel()) {
		case("EBox") : return Color.WHITE;
		case("WBox") : return Color.BLACK;
		case("ABox") : return Color.RED;
		case("DBox") : return Color.GREEN;
		case("CBox") : return Color.PINK;
		}
		return null;
		
	}
	
	
	
	@Override
	protected final void paintComponent(Graphics g)
	{
	   super.paintComponent(g) ;
			
	   int w = getWidth() ;
	   int h = getHeight() ;
			
	   g.setColor(chooseColor()) ;
	   g.fillRect(0, 0, w, h) ;
	}
	
	
	
	@Override
	public final void actionPerformed(ActionEvent e) {
		String boxType = labyApp.getLabyAppModel().getChange();
		labyApp.getLabyAppModel().changeBox(boxType, i, j);
		if(boxType != null) {
			if(boxType.equals("ABox"))
					box = new ABox(i,j);
			if(boxType.equals("DBox"))
					box = new DBox(i,j);
			if(boxType.equals("EBox"))
				box = new EBox(i,j);
			if(boxType.equals("WBox"))
				box = new WBox(i,j);
		}
		
		
		if(boxType != null) {
			if(boxType.equals("ABox"))
					labyApp.getLabyAppModel().setChange(null);
			if(boxType.equals("DBox"))
					labyApp.getLabyAppModel().setChange(null);
		}
	
	}
	
	public final void notifyForUpdate() {
		repaint();
		
	}
	
}
