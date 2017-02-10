package testing;

import static org.junit.Assert.*;

import org.junit.Test;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import levelPieces.WhackAMole;
import levelPieces.MagicBox;
import levelPieces.Tree;
import gameEngine.Player;

public class TestMovingPieces {

	/*
	 * Strategy:
	 * - Places the player at space 10.
	 * - Places a tree on both sides of player (tree is only drawable)
	 * - Place the mole at the beginning of the board and move it 200
	 * 	 times. The mole should only move the the spaces within 5 spaces
	 *   on either side of the player but not ever show up on the spaces
	 *   with the trees or where the player's location.
	 */
	@Test
	public void testWhackAMoleMovement() {
		// Each test will create its own list of pieces
		Drawable[] pieces = new Drawable[GameEngine.BOARD_SIZE];
		// places a tree on either side of the player
		pieces[9] = new Tree(9);
		pieces[11] = new Tree(11);
		pieces[10] = new Player(10);
		
		// The WhackAMole piece should randomly move to a space within 5 spaces of the player
		// as long as the space is NULL.
		WhackAMole mole = new WhackAMole(0);
		pieces[0] = mole;
		
		// Keeps track of the number of times the mole shows up on a space
		int count5 = 0;
		int count6 = 0;
		int count7 = 0;
		int count8 = 0;
		int count12 = 0;
		int count13 = 0;
		int count14 = 0;
		int count15 = 0;
		
		// moves the mole 200 times
		for (int i = 0; i < 200; i++) {
			mole.move(pieces, 10);
			int loc = mole.getLocation();
			// the next 3 for loops test that mole never shows up where it isn't supposed to
			for (int j = 0; j < 5; j++) {
				if (loc == j) 
					fail("Invalid square selected!");
			}
			for (int j = 9; j < 12; j++) {
				if (loc == j)
				{
					//System.out.println(j);
					fail("Invalid square selected!");
				}
			}
			for (int j = 16; j < GameEngine.BOARD_SIZE; j++) {
				if (loc == j)
					fail("Invalid square selected!");
			}
			if (loc == 5) count5++;
			if (loc == 6) count6++;
			if (loc == 7) count7++;
			if (loc == 8) count8++;
			if (loc == 12) count12++;
			if (loc == 13) count13++;
			if (loc == 14) count14++;
			if (loc == 15) count15++;
		}
		/*// debug
		System.out.println(count5);
		System.out.println(count6);
		System.out.println(count7);
		System.out.println(count8);
		System.out.println(count12);
		System.out.println(count13);
		System.out.println(count14);
		System.out.println(count15);
		*/
		// Ensure each option is randonmly chosen some number of times	
		assert(count5 > 1);
		assert(count6 > 1);
		assert(count7 > 1);
		assert(count8 > 1);
		assert(count12 > 1);
		assert(count13 > 1);
		assert(count14 > 1);
		assert(count15 > 1);
	}

	/*
	 * Strategy:
	 * - Place trees at both ends of the board.
	 * - Place player in the center of the board.
	 * - Place MagicBox on left half.
	 * - Move it 100 times.
	 * - It should never move on top of the trees, on top of the player,
	 *   or into the other side of the board.
	 * - Repeat test for the right side of the board. 
	 * - Repeat test with empty board.
	 * - The empty board test ensures all spaces are visited from the box 
	 *   moving from side to side - as designed.
	 */
	@Test
	public void testMagicBox() {
		// Each test will create its own list of pieces
		Drawable[] pieces = new Drawable[GameEngine.BOARD_SIZE];
		// Place trees at ends.
		pieces[0] = new Tree();
		pieces[GameEngine.BOARD_SIZE - 1] = new Tree();
		// Place player in the center of the board.
		pieces[GameEngine.BOARD_SIZE / 2] = new Player(GameEngine.BOARD_SIZE / 2);
		// Place MagicBox on left half of the board.
		MagicBox box = new MagicBox(1);
		pieces[1] = box;
		// Move the MagicBox 100 times.
		for (int i = 0; i < 100; i++) {
			box.move(pieces, GameEngine.BOARD_SIZE / 2);
			for (int j = GameEngine.BOARD_SIZE; j < GameEngine.BOARD_SIZE - 1; j++) {
				if (box.getLocation() == j) fail("Invalid square selected!");
			}
		}
		// Move the MagicBox to the other half
		pieces[box.getLocation()] = null;
		box.setLocation(GameEngine.BOARD_SIZE - 2);
		pieces[GameEngine.BOARD_SIZE - 2] = box;
		// Move box 100 times.
		//System.out.println(GameEngine.BOARD_SIZE / 2);
		//System.out.println(GameEngine.BOARD_SIZE - 2);
		for (int i = 0; i < 100; i++) {
			box.move(pieces, GameEngine.BOARD_SIZE / 2);
			//System.out.println(box.getLocation());
			for (int j = 0; j < GameEngine.BOARD_SIZE / 2; j++) {
				if (box.getLocation() == j) {
					//System.out.println(j);
					fail("Invalid square selected!");
				}
			}
		}
		
		// Test with empty board.
		// Clearing the board.
		pieces[0] = null;
		pieces[GameEngine.BOARD_SIZE - 1] = null;
		pieces[GameEngine.BOARD_SIZE / 2] = null;
		// This array keeps track of what spaces have been visited.
		int[] spaces = new int[GameEngine.BOARD_SIZE];
		// Move box 100 times; 
		for (int i = 0; i < 100; i++) {
			box.move(pieces, GameEngine.BOARD_SIZE + 5); // assumes player is not on the board
			spaces[box.getLocation()] = 1;
		}
		// Checks to see that all spaces of the board has been visited by the box
		for (int i = 0; i < GameEngine.BOARD_SIZE; i++) {
			if (spaces[i] == 0) fail("Space was not visited");
		}
		
	}
}
