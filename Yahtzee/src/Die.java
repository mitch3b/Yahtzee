
public class Die {
	public final static int MAX = 6;
	public final static int MIN = 1;
	private int value;
	
	public Die(){
		this(MIN);
		roll();
	}
	
	public Die(int num) {
		value = num;
	}

	public void roll(){
		value = (int)(Math.random()*MAX) + MIN;
	}
	
	public int getValue(){
		return value;
	}
}
