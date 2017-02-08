package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Star extends GamePiece {
	private final static int STAR_SENSITIVITY = 1;
	
	public Star()
	{
		super('*', gameEngine.GameEngine.BOARD_SIZE - 1);
	}
	
	public Star(int location) {
		super('*', location);
	}

	/*
	 * Advances player to next level if player is located within 1 square of the star. 
	 */
	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		if (this.getLocation() == playerLocation || 
			this.getLocation() + STAR_SENSITIVITY == playerLocation || 
			this.getLocation() - STAR_SENSITIVITY == playerLocation) // advances player if player lands on the star
		{
			return InteractionResult.ADVANCE;
		}
		else return InteractionResult.NONE;
	}	
}
