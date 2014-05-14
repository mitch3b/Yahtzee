
public enum ScoreType {
	ONES(1),
	TWOS(2),
	THREES(3),
	FOURS(4),
	FIVES(5),
	SIXES(6),
	THREE_OF_A_KIND(7),
	FOUR_OF_A_KIND(8),
	FULL_HOUSE(9),
	SMALL_STRAIGHT(10),
	LARGE_STRAIGHT(11),
	YAHTZEE(12),
	CHANCE(13);
	
	static final int NUM_SCORE_TYPES = 14; //Let 0 sit empty
	
	final int index;
	private ScoreType(int i){
		index = i;
	}
	
	//TODO Don't love this but good enough for now
	public final static ScoreType[] scoreTypes = {ScoreType.ONES,
		ScoreType.TWOS,
		ScoreType.THREES,
		ScoreType.FOURS,
		ScoreType.FIVES,
		ScoreType.SIXES,
		ScoreType.THREE_OF_A_KIND,
		ScoreType.FOUR_OF_A_KIND,
		ScoreType.FULL_HOUSE,
		ScoreType.SMALL_STRAIGHT,
		ScoreType.LARGE_STRAIGHT,
		ScoreType.YAHTZEE,
		ScoreType.CHANCE};
}
