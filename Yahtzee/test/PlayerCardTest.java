import junit.framework.Assert;

import org.junit.Ignore;
import org.junit.Test;


/**
 * Ignored test cases are for visual verification
 */
public class PlayerCardTest {

	@Test
	@Ignore
	public void playGame(){
		PlayerCard card = new PlayerCard();
		
		int[] nums = {2, 3, 4, 5, 6};
		Hand hand = new Hand(nums);
		
		card.markScore(ScoreType.LARGE_STRAIGHT, hand);
		card.markScore(ScoreType.SMALL_STRAIGHT, hand);
		card.markScore(ScoreType.ONES, hand);
		card.markScore(ScoreType.FIVES, hand);
		
		card.printScore();
	}
	
	@Test
	@Ignore
	public void randomFullGame(){
		PlayerCard card = new PlayerCard();
		for(ScoreType scoreType: ScoreType.scoreTypes){
			Hand hand = new Hand();
			card.markScore(scoreType, hand);
		}
		
		card.printScore();
	}
	
	@Test	
	(expected = IllegalArgumentException.class)
	public void playGameSameValue(){
		PlayerCard card = new PlayerCard();
		
		int[] nums = {2, 3, 4, 5, 6};
		Hand hand = new Hand(nums);
		
		card.markScore(ScoreType.FULL_HOUSE, hand);
		card.markScore(ScoreType.FULL_HOUSE, hand);
		
		card.printScore();
	}
	
	@Test
	public void maxHand(){
		PlayerCard card = new PlayerCard();
		
		int[] nums = {1, 1, 1, 1, 1};
		Hand hand = new Hand(nums);
		card.markScore(ScoreType.ONES, hand);
		card.markScore(ScoreType.YAHTZEE, hand);
		
		int[] nums2 = {2, 2, 2, 2, 2};
		hand = new Hand(nums2);
		card.markScore(ScoreType.TWOS, hand);
		
		int[] nums3 = {3, 3, 3, 3, 3};
		hand = new Hand(nums3);
		card.markScore(ScoreType.THREES, hand);
		
		int[] nums4 = {4, 4, 4, 4, 4};
		hand = new Hand(nums4);
		card.markScore(ScoreType.FOURS, hand);
		
		int[] nums5 = {5, 5, 5, 5, 5};
		hand = new Hand(nums5);
		card.markScore(ScoreType.FIVES, hand);
		
		int[] nums6 = {6, 6, 6, 6, 6};
		hand = new Hand(nums6);
		card.markScore(ScoreType.SIXES, hand);
		card.markScore(ScoreType.THREE_OF_A_KIND, hand);
		card.markScore(ScoreType.FOUR_OF_A_KIND, hand);
		card.markScore(ScoreType.CHANCE, hand);
		
		int[] numsFH = {4, 5, 4, 5, 5};
		hand = new Hand(numsFH);
		card.markScore(ScoreType.FULL_HOUSE, hand);
		
		int[] numsStr = {2, 3, 4, 5, 6};
		hand = new Hand(numsStr);
		card.markScore(ScoreType.SMALL_STRAIGHT, hand);
		card.markScore(ScoreType.LARGE_STRAIGHT, hand);
		
		
		Assert.assertTrue(card.playerDone());
		Assert.assertEquals(375, card.printScore());
	}
}
