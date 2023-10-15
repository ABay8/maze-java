package maze;

/**
 * Les exceptions liées à la lecture d'un labyrinthe
 * @author Anaïs BAYANI
 *
 */
@SuppressWarnings("serial")
public class MazeReadingException extends Exception{
	String fileName;
	int lineIndex;
	String message;
	
	public MazeReadingException(String fileName, int lineIndex, String message) {
		super(message);
		this.fileName = fileName;
		this.lineIndex = lineIndex;
		this.message = message;
	}

	public MazeReadingException(String fileName, String message) {
		super(message);
		this.fileName = fileName;
		this.message = message;
		this.lineIndex = 0;
	}
	
	public MazeReadingException(String message) {
		super(message);
		this.fileName = null;
		this.message = message;
		this.lineIndex = 0;
	}


}
