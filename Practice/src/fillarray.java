import javax.swing.*;

public class fillarray {

	public static void main(String[] args) {
		
		String [] countries = new String[8];
		
		for (int i=0; i<8; i++) {
			countries[i]= JOptionPane.showInputDialog("Enter a Country " + (i+1));
			
		}
		
		for (String string : countries) {
			System.out.println("Country is " + string);
			
		}

	}

}
