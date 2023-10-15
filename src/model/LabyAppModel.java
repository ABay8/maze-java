package model;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.event.*;

import maze.Maze;
import maze.MazeReadingException;

public class LabyAppModel {

	
	private Maze maze = new Maze(10,10);
	private boolean modifiedMaze = false;
	private String change = null;
	private String fileName = "";
	
	public LabyAppModel(String fileName) throws MazeReadingException {

		this.fileName = fileName;
		int[] size = maze.fileSize(fileName);
		maze = new Maze(size[0], size[1]);
		maze.initFromTextFile(fileName);
		
	}
	
	private ArrayList<ChangeListener> listeners = new ArrayList<ChangeListener>() ;

	public final void addObserver(ChangeListener listener) {
		listeners.add(listener) ;
	}
	
	public final Maze getMaze() {
		return maze;
	}
	
	public final void setFileName(String fileName) throws MazeReadingException {
		this.fileName = fileName;
		int[] size = maze.fileSize(fileName);
		maze = new Maze(size[0], size[1]);
		maze.initFromTextFile(fileName);
		modifiedMaze = true;
		stateChanges();
	}
		
	public void stateChanges() {
        ChangeEvent evt = new ChangeEvent(this) ;
        for (ChangeListener listener : listeners)
        	listener.stateChanged(evt);
	} 
	
	public final void resolution() throws MazeReadingException {
		maze.resolution(); 
		modifiedMaze = true;
		stateChanges();
	}

	public final void reset() {
		maze.reset();
		modifiedMaze = true;
		stateChanges();
	}
	
	public final void resetTotal() {
		maze.resetTotal();
		modifiedMaze = true;
		stateChanges();
		
	}
	public final boolean isMazeModified() {
		return modifiedMaze;
	}

	public void setMazeModified(boolean b) {
		modifiedMaze = b;
	}

	public final void setChange(String change) {
		this.change = change;
	}
	
	public final String getChange() {
		return change;
	}
	
	
	
	public final void changeBox(String boxType, int i, int j) {
		maze.changeBox(boxType, i, j);
		modifiedMaze = true;
		stateChanges();
	}
	
	public final void SaveToTextFile(String fileName) {
		try {
			maze.saveToTextFile(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public final void SetSize(int newHeight, int newWidth) {
		maze.setSize(newHeight, newWidth);
		modifiedMaze = true;
		stateChanges();
		
	}

}
