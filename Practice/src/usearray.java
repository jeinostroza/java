
public class usearray {

	public static void main(String[] args) {
		
		int [] array = new int[5];
		
		array[0]=5;
		array[1]=38;
		array[2]=-15;
		array[3]=92;
		array[4]=71;
		
		for(int i=0;i<array.length;i++) {
			System.out.println(array[i]);
		}
		
		int[] array2= {45,78,12,23,56};
		
		for (int j=0; j<array2.length;j++) {
			System.out.println(array2[j]);
		}
		
		System.out.println("For each");
		
		for (int element : array2) {
			System.out.println(element);
			
		}
				
	}

}
