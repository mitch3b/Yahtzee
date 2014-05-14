import org.junit.Ignore;
import org.junit.Test;


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
	public void randomFullGame(){
		PlayerCard card = new PlayerCard();
		for(ScoreType scoreType: ScoreType.scoreTypes){
			Hand hand = new Hand();
			card.markScore(scoreType, hand);
		}
		
		card.printScore();
	}
	
	@Ignore
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
}
