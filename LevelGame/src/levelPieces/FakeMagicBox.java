package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class FakeMagicBox extends GamePiece implements Moveable {
	
	public FakeMagicBox()
	{
		super('§', gameEngine.GameEngine.BOARD_SIZE / 4);
	}
	
	public FakeMagicBox(int location) {
		super('§', location);
	}
	
	/*
	 * Moves away from the player unless something is in the way.
	 */
	@Override
	public void move(Drawable[] pieces, int playerLocation) {
		pieces[getLocation()] = null; // remove previous symbol
		boolean fakeBoxIsLeftOfPlayer = this.getLocation() < playerLocation;
		int moveRight;
		if (fakeBoxIsLeftOfPlayer == true) {
			moveRight = 1;
		} else {
			moveRight = 0;
		}
		
		switch (this.getLocation())
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
			if (pieces[this.getLocation() - 1] == null) {
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
	 * Does not interact with player.
	 */
	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		if(playerLocation == this.getLocation()) // advances player if player lands on the star
		{
			pieces[getLocation()] = null; // removes symbol in current locations
			this.setLocation(gameEngine.GameEngine.BOARD_SIZE / 4);
			pieces[getLocation()] = this;
			return InteractionResult.NONE;
		}
		else return InteractionResult.NONE;
	}	
}
