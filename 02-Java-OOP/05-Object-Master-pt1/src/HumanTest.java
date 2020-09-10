import com.franka.objectmaster.*;

public class HumanTest {

	public static void main(String[] args) {
		Human player1 = new Human();
		Human player2 = new Human();
		System.out.println(player1.getIntelligence());
		System.out.println(player1.getStealth());
		System.out.println(player1.getStrength());
		player1.attack(player2);
		System.out.println(player2.getHealth());
	}

}
