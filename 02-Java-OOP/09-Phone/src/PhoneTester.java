import com.franka.phone.*;

public class PhoneTester {
	public static void main(String[] args) {
		Galaxy s10 = new Galaxy("S10",99, "T-Mobile","Ring, Ring, Ring!");
		IPhone iphoneX = new IPhone("X", 99,"Verizon","Zong, Zing, Zong!");
		
		s10.displayInfo();
		System.out.println(s10.ring());
		System.out.println(s10.unlock());
		
		iphoneX.displayInfo();
		System.out.println(iphoneX.ring());
		System.out.println(iphoneX.unlock());
	}
}
