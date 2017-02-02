package levelPieces;

import java.util.ArrayList;
import gameEngine.Drawable;
import gameEngine.Moveable;

public class LevelEngine {

	//variables
	private static final int BOARD_SIZE = 21;
	private Drawable[] pieces; //one piece one love
	private int PlayerStartLoc = 2;
	//think we need to just make some more pieces, and the isMoveable and isInteractable and call it a fuckin day. also make another level
	
	//idk what I'm doing with this guy, I guess he should be initialized in pieces and somehow getMovingPieces should scan through everything to find the movable pieces
	//which could work if we add a bool in gamepiece for ismoveable, and override it only in the two movable pieces, same for interation i guess
	public Moveable MovingMole = new WhackAMole();
	
	//methods
	public void createLevel(int levelNum) {
		// TODO Auto-generated method stub
		System.out.println("level create called");
		if(levelNum == 1)
		{
			//having anything initialize based on position is pointless, since when it draws and when it looks for hits it only cares about position in the array
			pieces = new Drawable[BOARD_SIZE]; //the board size is 21
			pieces[1] = new Tree();
			pieces[18] = new Tree();
			pieces[4] = MovingMole;
		}
	}

	public Drawable[] getPieces() {
		// TODO Auto-generated method stub
		return pieces;
	}

	public ArrayList<Moveable> getMovingPieces() {
		// TODO Auto-generated method stub
		  ArrayList<Moveable> movers = new ArrayList<Moveable>();
		  movers.add(MovingMole);
		  /*This is how elements should be added to the array list*/
		  return movers;		
	}

	
	public ArrayList<GamePiece> getInteractingPieces() {
		  ArrayList<GamePiece> interactors = new ArrayList<GamePiece>();
		  interactors.add((GamePiece) MovingMole);		
		  return interactors;
	}

	public int getPlayerStartLoc() {
		return PlayerStartLoc;
	}
	
	
	
}
