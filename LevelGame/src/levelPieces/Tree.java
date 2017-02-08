package levelPieces;

import gameEngine.Drawable;

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
		symbol = 'T';
		this.location = location;
	}

	/*
	 *	Prints the symbol for the tree. 
	 */
	public void draw() {
		System.out.print(symbol);
	}
}
