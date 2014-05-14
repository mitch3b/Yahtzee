import org.junit.Test;


public class DieTest {

	@Test
	(expected = IllegalArgumentException.class)
	public void DieTooSmall(){
		new Die(Die.MIN - 1);
	}

	@Test
	(expected = IllegalArgumentException.class)
	public void DieTooLarge(){
		new Die(Die.MAX + 1);
	}
}
