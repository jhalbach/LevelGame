package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class IED extends GamePiece {

	public IED()
	{
		super('I', gameEngine.GameEngine.BOARD_SIZE / 2);
	}
	
	public IED(char symbol, int location) {
		super(symbol, location);
	}

	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		if(playerLocation == this.getLocation())
		{
			return InteractionResult.KILL;
		}
		else return InteractionResult.NONE;
	}	
}
