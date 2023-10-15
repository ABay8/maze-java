package maze;

import java.io.IOException;

public class MainTest {

	public static void main(String[] args) throws IOException, MazeReadingException {

			Maze maze = new Maze(1,1);
			int[] size = maze.fileSize("data/labyrinthe.txt");
			maze = new Maze(size[0], size[1]);
			maze.initFromTextFile("data/labyrinthe.txt");
			maze.resolution();
	}		
}
