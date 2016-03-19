import java.util.Comparator;

/**
 * @author ETango
 * *@version: 3/18/2016
 * ITMD_411_Lab_3_Elton_Tang
 * Records.java
 * 
 * Lab 3
 */
public class Compare implements Comparator<BankRecord>, Comparable<BankRecord>{



	public int compareTo(BankRecord o) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * This takes the object from BankRecord and take the region from the object and sort it.
	 */
	@Override
	public int compare(BankRecord o1, BankRecord o2) {
		
		return o1.getRegion().compareTo(o2.getRegion());
		
	}



}
