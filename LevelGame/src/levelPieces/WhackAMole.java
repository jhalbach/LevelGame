package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class WhackAMole extends GamePiece implements Moveable  {	// will randomly move


	public WhackAMole()
	{
		super('W', 2);
	}
	
	public WhackAMole(int location) {
		super('W', location);
	}
	
	/*
	 * Used to generate a random number to place the mole on the map.
	 */
	private int getRandNum() {
		int n = 5;
		int delta = (-n + (int)(Math.random() * ((n + n) + 1))) % 6;	//generation of random code from the Internet
		return delta;
	}
	
	// Places mole within n spaces from the player.
	@Override
	public void move(Drawable[] pieces, int playerLocation) {
		int randNum = getRandNum();
		//System.out.println("location: " + getLocation());
		int arrayIndex = (randNum + playerLocation) % gameEngine.GameEngine.BOARD_SIZE  + 1;
		while (arrayIndex < 0 || arrayIndex >= gameEngine.GameEngine.BOARD_SIZE || pieces[arrayIndex] != null) {
			randNum = getRandNum();
			arrayIndex = (randNum + playerLocation) % gameEngine.GameEngine.BOARD_SIZE + 1;
		}
	
		pieces[getLocation()] = null; // remove previous symbol
		setLocation( (randNum + playerLocation) % gameEngine.GameEngine.BOARD_SIZE  + 1); //board size + 1,
		pieces[getLocation()] = this;
	}

	/*
	 * Kills player if player moves onto the mole's square.
	 */
	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		if(playerLocation == this.getLocation())
		{
			return InteractionResult.KILL;
		}
		else return InteractionResult.NONE;
	}
}
