import com.franka.objectmaster.*;

public class ObjectTest {

	public static void main(String[] args) {
		Wizard wizard = new Wizard();
		Human human = new Human();
		Ninja ninja = new Ninja();
		Samurai samurai = new Samurai();
		
		wizard.fireball(human);
		System.out.println(human.getHealth());
		wizard.heal(human);
		System.out.println(human.getHealth());
		
		ninja.steal(wizard);
		System.out.println(wizard.getHealth());
		System.out.println(ninja.getHealth());
		ninja.runAway();
		System.out.println(ninja.getHealth());
		
		samurai.deathBlow(human);
		System.out.println(samurai.howMany());
		System.out.println(samurai.getHealth());
		System.out.println(human.getHealth());
		System.out.println(human.isAlive());
		samurai.meditate();
		wizard.fireball(samurai);
		wizard.fireball(samurai);
		wizard.fireball(samurai);
		wizard.fireball(samurai);
		wizard.fireball(samurai);
		wizard.fireball(samurai);
		System.out.println(samurai.isAlive());
		wizard.fireball(samurai);
		System.out.println(samurai.getHealth());
		System.out.println(samurai.isAlive());
		System.out.println(samurai.howMany());

	}

}
