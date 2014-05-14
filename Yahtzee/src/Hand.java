
public class Hand {

	final static int SIZE = 5;

	Die[] dice = new Die[SIZE];
	
	public Hand(Die[] dice) {
		if(dice == null){
			throw new IllegalArgumentException("Illegal null dice in hand");
		}
		
		if(dice.length > SIZE){
			throw new IllegalArgumentException("Illegal hand size: " + dice.length);
		}
		
		for(int i = 0 ; i < dice.length ; ++i){
			this.dice[i] = dice[i];
		}
		
		for(int i = dice.length ; i < SIZE ; ++i){
			this.dice[i] = new Die();
		}
	}
	
	public Hand(){
		for(int i = 0 ; i < SIZE ; ++i){
			this.dice[i] = new Die();
		}
	}
	
	public Hand(int[] nums) {
		if(nums == null){
			throw new IllegalArgumentException("Illegal null int in hand");
		}
		
		if(nums.length > SIZE){
			throw new IllegalArgumentException("Illegal int size for hand: " + dice.length);
		}
		
		for(int i = 0 ; i < SIZE ; ++i){
			dice[i] = new Die(nums[i]);
		}
	}

	/**
	 * Used strictly for testing
	 */
	void printScores(){
		int[] scores = getScores();
		
		for(ScoreType scoreType : ScoreType.scoreTypes){
			System.out.println(scoreType + " " + scores[scoreType.index]);
		}
	}
	
	/**
	 * Will return an array of each score for this hand for
	 * every scoring option
	 */
	public int[] getScores(){
		int[] result = new int[ScoreType.NUM_SCORE_TYPES];
		
		for(ScoreType scoreType : ScoreType.scoreTypes){
			result[scoreType.index] = getScore(scoreType);
		}
		
		return result;
	}
	
	public int getScore(ScoreType scoreType){
		switch(scoreType){
			case ONES: return getOnesScore();
			case TWOS: return getTwosScore();
			case THREES: return getThreesScore();
			case FOURS: return getFoursScore();
			case FIVES: return getFiveScore();
			case SIXES: return getSixesScore();
			case THREE_OF_A_KIND: return getThreeOfAKindScore();
			case FOUR_OF_A_KIND: return getFourOfAKindScore();
			case FULL_HOUSE: return getFullHouseScore();
			case SMALL_STRAIGHT: return getSmallStraightScore();
			case LARGE_STRAIGHT: return getLargeStraightScore();
			case YAHTZEE: return getYahtzeeScore();
			case CHANCE: return getChanceScore();
		}
		
		throw new IllegalArgumentException("Bad ScoreType: " + scoreType);
	}

	private int getChanceScore() {
		int result = 0;
		
		for(Die die : dice){
			result += die.getValue();
		}
		
		return result;
	}

	private int getYahtzeeScore() {
		int val = dice[0].getValue();
		
		for(int i = 1 ; i < dice.length ; ++i){
			if(dice[i].getValue() != val){
				return 0;
			}
		}
		
		return 50;
	}

	private int getLargeStraightScore() {
		return (getMaxStraightSize() >= 5) ? 40 : 0;
	}

	private int getSmallStraightScore() {
		return (getMaxStraightSize() >= 4) ? 30 : 0;
	}
	
	private int getMaxStraightSize(){
		boolean[] vals = new boolean[Die.MAX + 1];
		
		for(Die die : dice){
			vals[die.getValue()] = true;
		}
		
		int maxLength = 0;
		int currentMax = 0;
		
		for(boolean exist : vals){
			if(!exist){
				maxLength = Math.max(maxLength, currentMax);
				currentMax = 0;
			}
			else{
				currentMax++;
			}			
		}
		
		return Math.max(maxLength, currentMax);
	}

	private int getFullHouseScore() {		
		int[] vals = new int[Die.MAX + 1];
		
		for(Die die : dice){
			vals[die.getValue()]++;
		}
		
		boolean foundThree = false;
		boolean foundTwo = false;
		
		for(int val : vals){
			if(val == 3){
				foundThree = true;
			}
			else if (val == 2){
				foundTwo = true;
			}
		}
		
		return (foundThree && foundTwo) ? 25 : 0;
	}

	private int getFourOfAKindScore() {
		return getXofOfKindScore(4);
	}

	private int getThreeOfAKindScore() {
		return getXofOfKindScore(3);
	}
	
	private int getXofOfKindScore(int x){
		int[] vals = new int[Die.MAX + 1];
		
		for(Die die : dice){
			vals[die.getValue()]++;
		}

		for(int val : vals){
			if(val >= x){
				return getChanceScore();
			}
		}
		
		return 0;
	}
	
	private int getIndividualScore(int num){
		int result = 0;
		
		for(Die die : dice){
			if(die.getValue() == num){
				result += num;
			}
		}
		
		return result;
	}

	private int getSixesScore() {
		return getIndividualScore(6);
	}

	private int getFiveScore() {
		return getIndividualScore(5);
	}

	private int getFoursScore() {
		return getIndividualScore(4);
	}

	private int getThreesScore() {
		return getIndividualScore(3);
	}

	private int getTwosScore() {
		return getIndividualScore(2);
	}

	private int getOnesScore() {
		return getIndividualScore(1);
	}

	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for(Die die : dice){
			stringBuilder.append(die.getValue() + " ");
		}
		
		return stringBuilder.toString();
	}

}
