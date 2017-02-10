package testing;

import static org.junit.Assert.*;

import org.junit.Test;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import levelPieces.Claymore;
import levelPieces.WhackAMole;
import levelPieces.MagicBox;
import levelPieces.FakeMagicBox;
import levelPieces.Star;

public class TestInteractions {

	@Test
	public void testClaymore() {
		Drawable[] pieces = new Drawable[GameEngine.BOARD_SIZE];
		Claymore claymore = new Claymore(10);
		pieces[10] = claymore;
		// Hits player if player on space or one left of claymore
		assertEquals(InteractionResult.HIT, claymore.interact(pieces, 10));
		assertEquals(InteractionResult.HIT, claymore.interact(pieces, 9));
		// These loops ensure no interaction if not on or left 1 of claymore
		for (int i = 0; i < 9; i++) 
			assertEquals(InteractionResult.NONE, claymore.interact(pieces, i));
		for (int i = 11; i < GameEngine.BOARD_SIZE; i++) 
			assertEquals(InteractionResult.NONE, claymore.interact(pieces, i));
	}
	
	@Test
	public void testWhackAMole() {
		Drawable[] pieces = new Drawable[GameEngine.BOARD_SIZE];
		WhackAMole mole = new WhackAMole(10);
		pieces[10] = mole;
		// Kills player if player on same space
		assertEquals(InteractionResult.KILL, mole.interact(pieces, 10));
		// These loops ensure no interaction if not on same space
		for (int i = 0; i < 10; i++) 
			assertEquals(InteractionResult.NONE, mole.interact(pieces, i));
		for (int i = 11; i < GameEngine.BOARD_SIZE; i++) 
			assertEquals(InteractionResult.NONE, mole.interact(pieces, i));
	}
	
	@Test
	public void testMagicBox() {
		Drawable[] pieces = new Drawable[GameEngine.BOARD_SIZE];
		MagicBox realBox = new MagicBox(10);
		pieces[10] = realBox;
		// These loops ensure no interaction if not on same space
		for (int i = 0; i < 10; i++) 
			assertEquals(InteractionResult.NONE, realBox.interact(pieces, i));
		for (int i = 11; i < GameEngine.BOARD_SIZE; i++) 
			assertEquals(InteractionResult.NONE, realBox.interact(pieces, i));
		// Gives player point if player lands on same space
		assertEquals(InteractionResult.GET_POINT, realBox.interact(pieces, 10));
	}
	
	@Test
	public void testFakeMagicBox() {
		Drawable[] pieces = new Drawable[GameEngine.BOARD_SIZE];
		FakeMagicBox fakeBox = new FakeMagicBox(10);
		pieces[10] = fakeBox;
		// Does nothing regardless of player location
		for (int i = 0; i < GameEngine.BOARD_SIZE; i++) 
			assertEquals(InteractionResult.NONE, fakeBox.interact(pieces, i));
	}
	
	@Test
	public void testStar() {
		Drawable[] pieces = new Drawable[GameEngine.BOARD_SIZE];
		Star star = new Star(10);
		pieces[10] = star;
		// Advances player if player on same space or 1 space to either side
		assertEquals(InteractionResult.ADVANCE, star.interact(pieces, 10));
		assertEquals(InteractionResult.ADVANCE, star.interact(pieces, 9));
		assertEquals(InteractionResult.ADVANCE, star.interact(pieces, 11));
		// These loops ensure no interaction if not on same space
		for (int i = 0; i < 9; i++) 
			assertEquals(InteractionResult.NONE, star.interact(pieces, i));
		for (int i = 12; i < GameEngine.BOARD_SIZE; i++) 
			assertEquals(InteractionResult.NONE, star.interact(pieces, i));
	}
}
