package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

// the one that moves randomly
public class WhackAMole extends GamePiece implements Moveable  {


	public WhackAMole()
	{
		super('W', 2);
	}
	
	public WhackAMole(char symbol, int location) {
		super(symbol, location);
	}

	
	//move randomly within n units of the player
	@Override
	public void move(Drawable[] pieces, int playerLocation) {
		int n = 5;
		int delta = -n + (int)(Math.random() * ((n + n) + 1));	//generation of random code from the Internet	
		//System.out.println("location: " + getLocation());
		pieces[getLocation()] = null; //get rid of whatever the whack a mole dude got on
		setLocation( (delta + playerLocation) % 22); //board size + 1, can't figure out how to make it see BOARD_SIZE, this makes sure we don't whack all over the place
		pieces[getLocation()] = this;
	}

	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		if(playerLocation == this.getLocation())
		{
			return InteractionResult.HIT;
		}
		else return InteractionResult.NONE;
		
	}
	

}
