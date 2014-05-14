import org.junit.Ignore;
import org.junit.Test;

/**
 * These are just for visual reference. Not to validate anything
 */
public class HandTest {

	@Test
	@Ignore
	public void testOnes(){
		Die[] dice = new Die[Hand.SIZE];
		
		for(int i = 1 ; i < 1 + Hand.SIZE ; ++i){
			dice[i - 1] = new Die(i);
		}
		
		Hand hand = new Hand(dice);
		
		hand.printScores();
	}
	
	@Test
	@Ignore
	public void twoOfTwo(){
		Die[] dice = new Die[Hand.SIZE];
		
		dice[0] = new Die(1);
		dice[1] = new Die(1);
		dice[2] = new Die(5);
		dice[3] = new Die(5);
		dice[4] = new Die(6);
		
		Hand hand = new Hand(dice);
		
		hand.printScores();
	}
	
	@Test
	@Ignore
	public void fullHouse(){
		Die[] dice = new Die[Hand.SIZE];
		
		dice[0] = new Die(3);
		dice[1] = new Die(3);
		dice[2] = new Die(3);
		dice[3] = new Die(4);
		dice[4] = new Die(4);
		
		Hand hand = new Hand(dice);
		
		hand.printScores();
	}

	@Test
	@Ignore
	public void straight(){
		Die[] dice = new Die[Hand.SIZE];
		
		dice[0] = new Die(6);
		dice[1] = new Die(1);
		dice[2] = new Die(3);
		dice[3] = new Die(4);
		dice[4] = new Die(5);
		
		Hand hand = new Hand(dice);
		
		hand.printScores();
	}
	
	@Test
	public void yahtzee(){
		Die[] dice = new Die[Hand.SIZE];
		
		dice[0] = new Die(4);
		dice[1] = new Die(4);
		dice[2] = new Die(4);
		dice[3] = new Die(4);
		dice[4] = new Die(4);
		
		Hand hand = new Hand(dice);
		
		hand.printScores();
	}
}
