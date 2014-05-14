import java.util.Scanner;


public class Game {
	private static final int MAX_ROLLS = 3;
	PlayerCard card = new PlayerCard();
	
	public Game(){
		
	}

	/**
	 * start the game
	 */
	public void start(){
		while(!card.playerDone()){
			startTurn();
		}
		
		System.out.println("Game Complete! Final Score:");
		card.printScore();
	}
	
	/**
	 * Will play a turn for the player
	 */
	private void startTurn(){
		System.out.println("START TURN!!");
		System.out.println("Current score card:");
		card.printScore();
		
		Hand hand = new Hand();
		int rollNumber = 0;
		boolean playerDoneEarly = false;
		
		while(rollNumber <= MAX_ROLLS && !playerDoneEarly){
			rollNumber++;
			System.out.println("Current roll: " + hand.toString());
			System.out.println("Possible Scores:");
			card.printOptions(hand);
			
			if(rollNumber >= MAX_ROLLS){
				break;
			}
			System.out.println("");
			System.out.println("Current dice: " + hand.toString());
			System.out.println("You have " + (MAX_ROLLS - rollNumber) + " rolls left.");
			
			System.out.println("Would you like to keep your roll? Y or N");
			
			boolean keepRoll = getBooleanFromPlayer();
			if(keepRoll){
				playerDoneEarly = true;
			}
			else{
				chooseDiceToKeep(hand);
			}
		}
		
		System.out.println("Roll is final: " + hand.toString());
		
		decideWhereToScore(hand);	
		
		System.out.println("TURN COMPLETE!");
	}
	
	/**
	 * Will retrieve a ScoreType from the player until
	 * a valid/unused ScoreType is retrieved. It then applies
	 * the hand to the playercard for that ScoreType
	 */
	private void decideWhereToScore(Hand hand){
		while(true){
			ScoreType scoreType = getPlayerOption(hand);
			try{
				card.markScore(scoreType, hand);
				return;
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
	}

	/**
	 * Gets a true or false from the player
	 */
	private boolean getBooleanFromPlayer() {
		Scanner in = new Scanner(System.in);
		
		while(true){
		    String input = in.nextLine();
		  
		    if(input.equalsIgnoreCase("Y") || input.equalsIgnoreCase("YES")){
		    	return true;
		    }
		    else if(input.equalsIgnoreCase("N") || input.equalsIgnoreCase("No")){
		    	return false;
		    }
		    else{
		    	System.out.println(input + " is an invalid response.");
		    }
		}
	}
	
	/**
	 * Will return which ScoreType the player wants to apply
	 * the hand to
	 * 
	 * @param hand
	 * @return ScoreType
	 */
	private ScoreType getPlayerOption(Hand hand){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the number of the option you would like:");
		
		while(true){
			card.printOptions(hand);
			
			String input = in.nextLine();
			
			try{
				int option = Integer.parseInt(input);
				
				if(option < 1 || option > ScoreType.NUM_SCORE_TYPES){
					System.out.println("Choice " + option + " is not an option.");
				}
				else{
					return ScoreType.scoreTypes[option - 1];
				}
			}
			catch(NumberFormatException e){
				System.out.println(input + " is not a number.");
			}
		}
	}
	
	/**
	 * Goes through the given hand and prompts the user for each.
	 * If user doesn't want to keep it, it is re-rolled
	 */
	private void chooseDiceToKeep(Hand hand){
		System.out.println("Current dice are: " + hand.toString());
		
		for(Die die : hand.dice){
			System.out.print("Keep " + die.getValue() + "?");
			
			boolean keepIt = getBooleanFromPlayer(); 
			if(!keepIt){
				die.roll();
			}
		}
	}
}
