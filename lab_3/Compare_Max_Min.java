
/**
 * @author ETango
 * *@version: 3/18/2016
 * ITMD_411_Lab_3_Elton_Tang
 * Records.java
 * 
 * Lab 3
 */



public class Compare_Max_Min {


/**
 * 
 * @param num1 takes in a one value
 * @param num2 takes in another value
 * @return the num that is max.
 * 
 * The method use the if statement to compare the number and return whichever one is greater than the other number.
 */
	public int compareMax(int num1, int num2) {
			if (num1 > num2){
				return num1;
			}
			
			else if (num2 > num1){
				return num2;
			}
			
			else {
				return num1;
			}
	}
	
	/**
	 * 
	 * @param num1 takes in a one value
	 * @param num2 takes in another value
	 * @return the num that is min.
	 * 
	 * The method use the if statement to compare the number and return whichever one is less than the other number.
	 */
	public int compareMin(int num1,int num2){
		if (num1 > num2){
			return num2;
				
		}
		
		else if (num2>num1){
			return num1;
		}
		
		else {
			return num1;
		}
	}
}
