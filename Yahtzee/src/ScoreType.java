
public enum ScoreType {
	ONES(0),
	TWOS(1),
	THREES(2),
	FOURS(3),
	FIVES(4),
	SIXES(5),
	THREE_OF_A_KIND(6),
	FOUR_OF_A_KIND(7),
	FULL_HOUSE(8),
	SMALL_STRAIGHT(9),
	LARGE_STRAIGHT(10),
	YAHTZEE(11),
	CHANCE(12);
	
	static final int NUM_SCORE_TYPES = 13;
	
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
