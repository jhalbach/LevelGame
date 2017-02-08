package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Claymore extends GamePiece {
	// Distance away from claymore that will trigger it.
	private final static int CLAYMORE_SENSITIVITY = 1; // if player enters this radius, player dies
	
	public Claymore()
	{
		super('<', gameEngine.GameEngine.BOARD_SIZE / 2);
	}
	
	public Claymore(int location) {
		super('<', location);
	}
	
	/*
	 * Adds a pain unit to player if player is on or 1 space left of the claymore. 
	 */
	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {	
		// interacts with player within 2 spaces
		if(playerLocation + CLAYMORE_SENSITIVITY >= this.getLocation() && 
		   playerLocation <= this.getLocation())	
		{
			return InteractionResult.HIT;
		}
		else return InteractionResult.NONE;
	}	
}
