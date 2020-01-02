import java.util.*;

public class inputData {

	public static void main(String[] args) {
		String name1 = "Jorge";
		String pass1 = "271170";
		String name = "";
		String pass ="";
		while (name != name1) {
			System.out.println("Please enter your name ");
			Scanner enter = new Scanner(System.in);
			name = enter.nextLine();
			if (name.equalsIgnoreCase(name1)) {
				System.out.println("Please enter your password");
				pass = enter.nextLine();
			if (pass.equalsIgnoreCase(pass1)) {
				System.out.println("You can enter");
			}else {
				System.out.println("Wrong password");
			}
		break;
		}
		}
		
		
		
	}
		

}
