
public class PlayerCard {
	private static final int BONUS_THRESHOLD = 63;
	private static final int BONUS = 35;
	int[] values = new int[ScoreType.NUM_SCORE_TYPES];
	boolean[] used = new boolean[ScoreType.NUM_SCORE_TYPES];
	
	public PlayerCard(){
		
	}
	
	public boolean playerDone(){
		for(ScoreType scoreType : ScoreType.scoreTypes){
			if(!used[scoreType.index]){
				return false;
			}
		}
		
		return true;
	}
	
	public void printOptions(Hand hand){
		int[] scores = hand.getScores();
		
		for(ScoreType scoreType : ScoreType.scoreTypes){
			if(used[scoreType.index]){
				System.out.println(scoreType.index + ": " + scoreType + " Already used." );
			}
			else{
				System.out.println(scoreType.index + ": " + scoreType + " " + scores[scoreType.index]);
			}
		}
	}

	public void markScore(ScoreType scoreType, Hand hand){
		if(used[scoreType.index]){
			throw new IllegalArgumentException("ScoreType " + scoreType + " already used.");
		}
		
		values[scoreType.index] = hand.getScore(scoreType);
		used[scoreType.index] = true;
	}
	
	/**
	 * Also prints out where the points came from
	 */
	public int printScore(){
		int result = 0;
		
		for(ScoreType scoreType : ScoreType.scoreTypes){
			if(used[scoreType.index]){
				System.out.println(scoreType + " " + values[scoreType.index]);
				result += values[scoreType.index];
			}
			else{
				System.out.println(scoreType + " NOT used." );
			}
			
			if(scoreType == ScoreType.SIXES){
				if(result >= BONUS_THRESHOLD){
					System.out.println("Bonus: Need " + BONUS_THRESHOLD + " Got " + result + ". SUCCESS!! +" + BONUS + " Points.");
					result += BONUS;
				}
				else{
					System.out.println("Bonus: Needed " + BONUS_THRESHOLD + " Got " + result + ". FAILURE");
				}
				
				System.out.println("");
			}
		}
		
		System.out.println("");
		System.out.println("Total score: " + result);
		
		return result;
	}
}
