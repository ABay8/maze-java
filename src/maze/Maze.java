package maze;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import dijkstra.ASet;
import dijkstra.Dijkstra;
import dijkstra.GraphInterface;
import dijkstra.Pi;
import dijkstra.Previous;
import dijkstra.VertexInterface;

/** Classe du labyrinthe
 * 
 * @author Anaïs BAYANI
 *
 */
public class Maze implements GraphInterface{
	
	private MBox[][] maze;
	private int width;
	private int height;
	
	public Maze(int i, int j) {
		this.maze = new MBox[i][j];
		this.width = j;
		this.height = i;
	}
	
	/** Renvoie le maze sous forme de GraphInterface
	 * 
	 * @return Maze sous forme de grapheInterface
	 */
	public final GraphInterface toGraphI() {
		Maze m = new Maze(getHeight(), getWidth());
		for(int i=0; i<getHeight(); i++) {
			for(int j = 0; j<getWidth(); j++) {
				m.getMaze()[i][j]= getMaze()[i][j];
			}
		}
		GraphInterface g = (GraphInterface) m;
		return g;
	}
	
	/** Renvoie le labyrinthe sous forme de tableau de MBox
	 * @return tableau de MBox représentant le labyrinthe
	 */
	public final MBox[][] getMaze() {
		return maze;
	}
	
	/** Renvoie la largeur du labyrinthe
	 * @return la largeur
	 */
	public final int getWidth() {
		return width;
	}
	
	/** Renvoie la hauteur du labyrinthe
	 * @return la hauteur
	 */
	public final int getHeight() {
		return height;
	} 
	
	@Override
	public final ArrayList<VertexInterface> getAllVertices() {
		ArrayList<VertexInterface> mazeInter = new ArrayList<VertexInterface>();
		for(int line = 0; line < height; line++) {
			for (int column = 0; column < width; column++) {
				mazeInter.add(maze[line][column]);
			}
		}
		return mazeInter ;
	}
	
	@Override
	public final ArrayList<VertexInterface> getSuccessors(VertexInterface vertex) {
		ArrayList<VertexInterface> successors = new ArrayList<VertexInterface>() ;
		MBox box = (MBox)vertex;
		int i = box.getLine();         
		int j = box.getColumn();
		try{
			MBox box1 = maze[i-1][j];
			if ( box1.getLabel().compareTo("WBox") != 0 ) {
				successors.add(box1);
			}
		}
		catch (Exception e) {}
		try {
			MBox box2 = maze[i+1][j];
			if ( box2.getLabel().compareTo("WBox") != 0 ) {
				successors.add(box2);
			}
		}
		catch (Exception e) {}
		
		try {
			MBox box3 = maze[i][j-1];
			if ( box3.getLabel().compareTo("WBox") != 0 ) {		
				successors.add(box3);
			}
			
		}
		catch (Exception e) {}
		
		try {
			MBox box4 = maze[i][j+1];
			if ( box4.getLabel().compareTo("WBox") != 0 ) {
				successors.add(box4);
			}
		}catch (Exception e) {}
		
		return successors; 
	}
	
	@Override
	public final int getWeight(VertexInterface src , VertexInterface  dst) {
		ArrayList<VertexInterface> successors = getSuccessors(src);
		if (successors.contains(dst))
		{
			return 1;
		}
		
		else 
		{
			return 0;
		}
			
		
	}
	
	/** Implémente un labyrinthe depuis un fichier txt
	 * 
	 * @param fileName : le fichier contenant le labyrinthe voulu
	 * @throws MazeReadingException (N'accepte pas les labyrinthes avec un chemin tracé)
	 */
	public final void initFromTextFile(String fileName) throws MazeReadingException {
		try { 
			@SuppressWarnings("resource")
			BufferedReader txt = new BufferedReader(new FileReader(fileName));
			//PrintStream out = System.out ;
			String line = null;
			int lineIndex = 0;
			this.fileSize(fileName);
			while ((line = txt.readLine()) != null) {
				for(int i =0; i<line.length(); i++) {
					String charact = Character.toString(line.charAt(i));
					if( charact.equals("E") ) {
						EBox e = new EBox(lineIndex, i); 
						maze[lineIndex][i] = e;
					}
					else if (charact.equals("W")) {
						WBox w = new WBox(lineIndex, i) ;
						maze[lineIndex][i] = w;
					}
					else if (charact.equals("A")) {
						ABox a = new ABox(lineIndex, i) ;
						maze[lineIndex][i] = a;
					}
					else {
						DBox d = new DBox(lineIndex, i) ;
						maze[lineIndex][i] = d;
					}
					 
					if (!charact.equals("A") && !charact.equals("W") && !charact.equals("E") && !charact.equals("D") )
						throw new MazeReadingException(fileName, lineIndex, "Labyrinthe incorrect "
								+ "car il contient des caractères non acceptés à la ligne " + lineIndex);
				}
				//out.println(line);
				lineIndex ++;
			}
			
		}
		catch (MazeReadingException e) {
			e.getMessage();
			e.printStackTrace();
			throw e;
		//	System.exit(1);
		}
		catch (IOException e){
			e.printStackTrace();
		}
		/*finally {
			.close();
		} */
	} // 
		
	
	/** Sauvegarde le labyrinthe dans un fichier
	 * 
	 * @param fileName : le fichier dans lequel on veutg sauvegarder le labyrinthe
	 * @throws FileNotFoundException
	 */
	public final void saveToTextFile(String fileName) throws FileNotFoundException {
		PrintWriter txt = new PrintWriter(fileName);
		for (int i = 0 ; i < maze.length ; i++) {
			for(int j = 0; j < maze[i].length; j++) {
				if( "EBox".compareTo(maze[i][j].getLabel()) == 0) {
					txt.write('E'); 
				}
				else if ("WBox".equals(maze[i][j].getLabel())) {
					txt.write('W'); 
				}
				else if ("ABox".equals(maze[i][j].getLabel())) {
					txt.write('A');
				}
				else if ("DBox".equals(maze[i][j].getLabel())) {  
					txt.write('D');
				}
				else if ("CBox".equals(maze[i][j].getLabel())) {   
					txt.write('.');
				}
			}
			txt.write("\n"); 
		}
		txt.close();
	}

	/**Renvoie la case de départ
	 * @return la case de départ
	 */
	private final VertexInterface getDBox() throws MazeReadingException {
		try {
			int compt = 0;
			VertexInterface box = null;
			for(int i = 0; i < maze.length; i++) {
				for (int j = 0; j < maze[i].length ; j++ ) {
					if (maze[i][j] == null) throw new MazeReadingException("Il y a des cases manquantes!");
					if (maze[i][j].getLabel().equals("DBox")) {
						box = maze[i][j];
						compt++;
					}
				}
			}
			if (compt == 0) throw new MazeReadingException("Pas de case de Départ!");
			if (compt > 1) throw new MazeReadingException("Il y a plusieurs cases de Départ!");
			return box;
		}
		catch(MazeReadingException e) {
			e.getMessage();
			e.printStackTrace();
			throw e;
	//		System.exit(1);
		}
	}
	

	/**Renvoie la case d'arrivée
	 * @return la case d'arrivée
	 */
	private final VertexInterface getABox() throws MazeReadingException{
		try{
			VertexInterface box = null;
			int compt = 0;
			for(int i = 0; i < height; i++) {
				for (int j = 0; j < width ; j++ ) {
					if (maze[i][j].getLabel().equals("ABox")) {
						box = maze[i][j];
						compt++;
						}
					}
				}
			if (compt == 0) throw new MazeReadingException("Pas de case d'Arrivée!");
			if (compt > 1) throw new MazeReadingException("Il y a plusieurs cases d'Arrivée!");
			return box;
			}
		catch(MazeReadingException e) {
			e.getMessage();
			e.printStackTrace();
			throw e;
	//		System.exit(1);
		}
	}
	
	/** Indique la présence de cases traversées
	 * 
	 * @return true si contient des CBox
	 */
	private final boolean containsCBox(){
		int compt = 0;
		for(int i = 0; i < height; i++) {
			for (int j = 0; j < width ; j++ ) {
				if (maze[i][j].getLabel().equals("CBox")) {
					compt++;
					}
				}
			}
		if (compt >= 1) return true;
		else return false;
	}
	
	/** Renvoie la taille d'un labyrinthe inscrit dans un fichier
	 * 
	 * @param fileName : le fichier dans lequel se trouve le labyrinthe dont on veut connaître la taille
	 * @return la taille du labyrinthe contenu dans le fichier
	 * @throws MazeReadingException
	 */
	public final int[] fileSize(String fileName) throws MazeReadingException {
		int[] size = new int[2];
		try{
			BufferedReader txt = new BufferedReader(new FileReader(fileName));
			String line = txt.readLine();
			if (line == null) {
				txt.close();
				throw new MazeReadingException (fileName, "Ce labyrinthe est vide!");
				}
			size[1] = line.length();
			int lineIndex = 1;
			
			while ((line = txt.readLine()) != null)  {
				lineIndex++;
				if (line.length() != size[1]) {
					txt.close();
					throw new MazeReadingException (fileName, "Il y a des cases manquantes ou en trop!");
					}
				}
			size[0] = lineIndex;
			
			txt.close();
			
			if((size[0]<=1 && size[1]<=1) || (size[0]==1 && size[1]==2) || (size[0]==2 && size[1]==1)) 
				throw new MazeReadingException (fileName, "Taille du labyrinthe incorrecte");	
		}
		catch (MazeReadingException e) {
			e.getMessage();
			e.printStackTrace();
			throw e;
		//	System.exit(1);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch( IOException e) {
			e.printStackTrace();}
		return size;
	}
		
		
	/** Résout le labyrinthe en transformant des cases vides en CBox (traversées)
	 * 	
	 * @throws MazeReadingException
	 */
	public final void resolution() throws MazeReadingException {
		try{
			if (containsCBox()) reset();
			GraphInterface g = toGraphI();
			VertexInterface r = getDBox();
			VertexInterface arrival = getABox();
			ASet a = new ASet();
			Pi pi = new Pi();
			
			Previous previous = new Previous();
			previous = (Previous) Dijkstra.dijkstra(g, r, a, pi, previous); 
			if(!previous.inPrevious(arrival)) throw new MazeReadingException("Ce labyrinthe est insoluble!");
			ArrayList<VertexInterface> path = previous.shortestPathTo(arrival); 
			for(int i = 0; i < getHeight() ; i++) {
				for (int j = 0; j < getWidth() ; j++ ) {
					if(path.contains(getMaze()[i][j]) && getMaze()[i][j]!= r && getMaze()[i][j] != arrival){ 
						maze[i][j] = new CBox(i,j) ;
					}
				}	
			}
		}
		catch(MazeReadingException e) {
			e.getMessage();
			e.printStackTrace();
			throw e;
	//		System.exit(1);
		}
		
		try {
			saveToTextFile("data/solution.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}
	}
	
	/** Renvoie le labyrinthe non résolu
	 * 
	 */
	public final void reset() {
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				if(maze[i][j].getLabel().equals("CBox"))
				maze[i][j]=new EBox(i,j);
			}
		}
	}
	
	/** Réinitialise le labyrinthe (que des cases vides)
	 * 
	 */
	public final void resetTotal() {
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				maze[i][j]=new EBox(i,j);
			}
		}
	}

	/** Modifie une case du labyrinthe en un type spécifié
	 * 
	 * @param boxType : indique en quel type transformer la case
	 * @param i : la ligne
	 * @param j : la column
	 */
	public final void changeBox(String boxType, int i, int j) {
		
		if(boxType != null) {
			if(boxType.equals("ABox")) maze[i][j] = new ABox(i,j);
			if(boxType.equals("DBox")) maze[i][j] = new DBox(i,j);
			if(boxType.equals("EBox")) maze[i][j] = new EBox(i,j);
			if(boxType.equals("WBox")) maze[i][j] = new WBox(i,j);
		}
	}

	/** Modifie la taille du labyrinthe
	 * 
	 * @param newHeight
	 * @param newWidth
	 */
	public final void setSize(int newHeight, int newWidth) {
		MBox[][] newMaze = new MBox[newHeight][newWidth];
		for(int i = 0; i < newHeight; i++) {
			for (int j = 0; j < newWidth; j++) {
				if(i < height && j < width) {
					newMaze[i][j] = maze[i][j];
				}
				else {
					newMaze[i][j] = new EBox(i,j);
				}
			}
		}
		maze = newMaze ;
		width = newWidth;
		height = newHeight;
		
	}

}
