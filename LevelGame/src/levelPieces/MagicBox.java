package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class MagicBox extends GamePiece implements Moveable {
	private int moveRight = 0; // 1 for true; 0 for false;
	
	public MagicBox()
	{
		super('§', gameEngine.GameEngine.BOARD_SIZE / 4 * 3);
	}
	
	public MagicBox(int location) {
		super('§', location);
	}
	
	// Moves to ends of the map and turns around.
	@Override
	public void move(Drawable[] pieces, int playerLocation) {
		pieces[getLocation()] = null; // remove previous symbol
		
		switch (getLocation())
		{
		case 0:
			moveRight = 1;
			break;
		case gameEngine.GameEngine.BOARD_SIZE - 1:
			moveRight = 0;
			break;
			default:
		}
		
		switch (moveRight) {
		case 1:
			if (pieces[this.getLocation() + 1] == null) {
				setLocation(this.getLocation() + 1);
			}
			else {
				setLocation(this.getLocation() - 1);
				moveRight = 0;
			}
			break;
		case 0:
		    if (pieces[this.getLocation() - 2] == null) {
		    	setLocation(this.getLocation() - 2);
		    }
			else if (pieces[this.getLocation() - 1] == null) {
				setLocation(this.getLocation() - 1);
			}
			else {
				setLocation(this.getLocation() + 1);
				moveRight = 1;
			}
			break;
		default:
		}
		
		pieces[getLocation()] = this;
	}

	/*
	 * Gives player a point if player lands on the piece.
	 */
	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		if(playerLocation == this.getLocation()) // advances player if player lands on the star
		{
			pieces[getLocation()] = null; // removes symbol in current locations
			this.setLocation(gameEngine.GameEngine.BOARD_SIZE / 4 * 3);
			pieces[getLocation()] = this;
			return InteractionResult.GET_POINT;
		}
		else return InteractionResult.NONE;
	}	
}
