package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Tree extends GamePiece implements Drawable{

	
	public Tree()
	{
		super('T', 1);
	}
	
	public Tree(char symbol, int location) {
		super(symbol, location);
	}

	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		// TODO Auto-generated method stub
		return null;
	}
	


}
