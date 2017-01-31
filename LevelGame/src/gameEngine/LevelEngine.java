package gameEngine;

import java.util.ArrayList;

import levelPieces.GamePiece;
import levelPieces.Tree;

public class LevelEngine {

	//variables
	Drawable[] pieces = new Drawable[20]; //one piece one love
	int PlayerStartLoc = 10;
	
	//methods
	public void createLevel(int levelNum) {
		// TODO Auto-generated method stub
		
	}

	public Drawable[] getPieces() {
		// TODO Auto-generated method stub
		return pieces;
	}

	public ArrayList<Moveable> getMovingPieces() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<GamePiece> getInteractingPieces() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getPlayerStartLoc() {
		// TODO Auto-generated method stub
		return PlayerStartLoc;
	}
	
	
	
}
