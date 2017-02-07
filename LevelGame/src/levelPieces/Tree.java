package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

//this will be the one that is only drawable
public class Tree implements Drawable {

	char symbol;
	int location;
	
	public Tree()
	{
		symbol = 'T';
		location = 1;
	}
	
	public Tree(int location) {
		this.location = location;
	}

	public void draw() {
		System.out.print(symbol);
	}
}
