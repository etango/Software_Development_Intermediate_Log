import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.text.DecimalFormat;


/**
 * @author ETango
 * *@version: 3/18/2016
 * ITMD_411_Lab_3_Elton_Tang
 * Records.java
 * 
 * Lab 3
 */




public class Records extends BankRecord {
	
/**
 * 
 * @average_income(BankRecord[] client, int n)
 * This method was designed to take in two parameters one client and n for how many people.
 * @param client
 * The method takes in the array of the client.
 * @param n
 * The method takes in the number to divide the average from.
 *
 *@try was use to check the value for n to ensure is not negative or 0. So when dividing the average will not crash the program but throws an error and where.
 *
 *for syntax was use to add up the total of the income by fetching the income from client[i].getincome() where is goes through the array depending how long the array list. The variable 
 *total_income holds the added sum, then in the try method it checks for n for error before dividing then divide the total_income and assign it to average.
 *
 *Next part is extra credit portion. Using String region1,...,region3 for each region, allow an easier comparison for each income. Using the array.sort to sort the region in order in a easier order for a faster
 *compile time. For method is use here to to look at each region by using the if statement to compare client[i].getRegion.equals to region then adding the total income for that region. Also providing a n counter
 *to add up each resident to divide by later. 
 *
 *
 *Then the final step was to write to a file bankrecords.txt by opening the file and have system.out.println to write into it. 
 */
	
public static void average_income(BankRecord[] client,int n){
	
	DecimalFormat moneyformat = new DecimalFormat("#.00");
	Arrays.sort(client,new Compare());
	double total_income = 0;
	double income_inner = 0, income_rural= 0,income_suburban = 0, income_town = 0;
	double avg_inner = 0, avg_rural = 0, avg_suburban = 0, avg_town = 0;
	double n1 = 0,n2 = 0,n3 = 0,n4 = 0;
	double average=0;
	String region1 = "INNER_CITY";
	String region2 = "RURAL";
	String region3 = "SUBURBAN";
	String region4 = "TOWN";
	
	for (int i = 0; i<client.length;i++){
	total_income = total_income + client[i].getIncome();
	}
	
	try{
		if (n!=0 || n>0){
			average = total_income / n;
		}
	}catch (Exception e){
		System.out.print("Error! value n is either 0.");
	}
	
	
	System.out.println("Average income is: $" + moneyformat.format(average));
	
	for (int i=0; i<client.length; i++){
	
		if (client[i].getRegion().equals(region1)){
			income_inner = income_inner + client[i].getIncome();
			n1++;			
		}
		else if (client[i].getRegion().equals(region2)){
			income_rural = income_rural + client[i].getIncome();
			n2++;
		}
		else if (client[i].getRegion().equals(region3)){
			income_suburban = income_suburban + client[i].getIncome();
			n3++;
		}
		else if (client[i].getRegion().equals(region4)){
			income_town = income_town + client[i].getIncome();
			n4++;
		}
	}
	avg_inner = income_inner/n1;
	avg_rural = income_rural/n2;
	avg_suburban = income_suburban/n3;
	avg_town = income_town/n4;
	double N = n1+n2+n3+n4;
	
	if(N != 600){
		System.out.print("Error in calculating the average income per region");
	}
	
	else {
	System.out.println("Innercity region average income: $" + moneyformat.format(avg_inner) + " Rural region average income: $" + moneyformat.format(avg_rural) + " Suburban region average income: $" + moneyformat.format(avg_suburban) + " Town region average income: $" + moneyformat.format(avg_town));
	
	PrintWriter out;
	try {
		
		File file = new File("bankrecords.txt");
		if(!file.exists()){
			file.createNewFile();
		}
		out = new PrintWriter(new BufferedWriter(new FileWriter("bankrecords.txt",true)));
		out.println("Average income is: $" + moneyformat.format(average));
		out.println("Innercity region average income: $" + moneyformat.format(avg_inner) + " Rural region average income: $" + moneyformat.format(avg_rural) + " Suburban region average income: $" + moneyformat.format(avg_suburban) + " Town region average income: $" + moneyformat.format(avg_town));
		out.close();
	} catch (IOException e) {
		System.out.print("Error occur in writing to file bankrecords.txt at method avg income.");
		e.printStackTrace();
		e.getMessage();
	}
	}
	  

}

/**
 * 
 * @param client takes in an array.
 * @Compare_Max_Min is a class I made to use to compare max and min value and return the max value or min value depending which method is used.
 * First I needed to assign each variable a initial value from the data instead of assigning a zero as it would not be reliable as there was no 0 in csv file, also it would have the min value be 0 where compare.
 * I did this by using a for loop for each region to assign a value to inner_max that is use to hold the max value and inner_min to hold the min value later. 
 * This accurate and more reliable. 
 * 
 * Then using the for loop to cycle through the array and comparing age through each region and putting it through the max and min method to return the correct value to max and min variable.
 */

public static void max_min_age_per_location(BankRecord[] client){
	Compare_Max_Min comparator = new Compare_Max_Min();
	Arrays.sort(client,new Compare());
	int inner_max =0, rural_max =0, suburban_max = 0, town_max = 0;
	int inner_min =0, rural_min =0, suburban_min =0, town_min=0;
	
	String region1 = "INNER_CITY";
	String region2 = "RURAL";
	String region3 = "SUBURBAN";
	String region4 = "TOWN";
	
	
	for (int i=0; i< client.length;i++){
		if(client[i].getRegion().equals(region1)){
			inner_max = client[i].getAge();
			inner_min = client[i].getAge();
			break;
		}
	}
	for (int i=0; i< client.length;i++){
		if(client[i].getRegion().equals(region2)){
			rural_max = client[i].getAge();
			rural_min = client[i].getAge();
			break;
		}
	}
	
	for (int i=0; i< client.length;i++){ 
		if(client[i].getRegion().equals(region3)){
			suburban_max = client[i].getAge();
			suburban_min = client[i].getAge();
			break;
		}
	}
	for (int i=0; i< client.length;i++){
		if(client[i].getRegion().equals(region4)){
			town_max = client[i].getAge();
			town_min = client[i].getAge();
			break;
		}
	}
	
	for (int i=0; i<client.length; i++){
		if (client[i].getRegion().equals(region1)){
			inner_max = comparator.compareMax(inner_max, client[i].getAge());
			inner_min = comparator.compareMin(inner_min, client[i].getAge());
			
		}
		
		else if (client[i].getRegion().equals(region2)){
			rural_max = comparator.compareMax(rural_max, client[i].getAge());
			rural_min = comparator.compareMin(rural_min, client[i].getAge());
		}
		
		else if (client[i].getRegion().equals(region3)){
			suburban_max = comparator.compareMax(suburban_max,client[i].getAge());
			suburban_min = comparator.compareMin(suburban_min, client[i].getAge());
		}
		
		else if (client[i].getRegion().equals(region4)){
			town_max = comparator.compareMax(town_max, client[i].getAge());
			town_min = comparator.compareMin(town_min, client[i].getAge());
		}
	}
	
	System.out.println("Innercity region max age: " + inner_max + " Rural region max age: " + rural_max +" Suburban region max age:  " +suburban_max + " Town region max age: " + town_max + "\n" 
			+ "Innercity region min age: " + inner_min + " Rural region min age: " + rural_min +" Suburban region min age:  " +suburban_min + " Town region min age: " + town_min  );

	
	PrintWriter out;
	try {
		out = new PrintWriter(new BufferedWriter(new FileWriter("bankrecords.txt",true)));
		out.println("Innercity region max age: " + inner_max + " Rural region max age: " + rural_max +" Suburban region max age:  " +suburban_max + " Town region max age: " + town_max + "\n" 
				+ "Innercity region min age: " + inner_min + " Rural region min age: " + rural_min +" Suburban region min age:  " +suburban_min + " Town region min age: " + town_min  );
		out.close();
	} catch (IOException e) {
		System.out.print("Error occur in writing to file bankrecords.txt at max and min age method.");
		e.printStackTrace();
		e.getMessage();
	}
}

/**
 * 
 * @param client take in an array
 * Basically for loop to cycle through the array and if statement to check for genders and mortgages. If female and mortgages is true, it adds to the female counter.
 */
public static void female_mortgages(BankRecord[] client){
	String mortgages = "YES";
	String gender = "FEMALE";
	String saving = "YES";
	int female_count = 0;
	int female_count1 = 0;
	
	for (int i=0; i<client.length;i++){
		if (client[i].getSex().equals(gender))
			if(client[i].getMortgage().equals(mortgages)){
				female_count++;
		}
	}
	
	System.out.println("Number of Females with mortgages : " + female_count);
	
	for (int i=0; i<client.length;i++){
		if (client[i].getSex().equals(gender))
			if(client[i].getMortgage().equals(mortgages)&& client[i].getSave_act().equals(saving)){
				female_count1++;
		}
	}
	
	System.out.println("Number of Females with mortgages and saving account : " +  female_count1);

		PrintWriter out;
		try {
			out = new PrintWriter(new BufferedWriter(new FileWriter("bankrecords.txt",true)));
			out.println("Number of Females with mortgages:" +  female_count);
			out.println("Number of Females with mortgages and saving account : " +  female_count1);
			out.close();
		} catch (IOException e) {
			System.out.print("Error occur in writing to file bankrecords.txt at method female and mortgages method.");
			e.printStackTrace();
			e.getMessage();
		}
		
	}


/**
 * 
 * @param client take in array.
 * This method is the same idea as the max and min method. It cycles through the array with a for loop and have if statement to check for condition of the male if they have a car or children.
 * Since children was an integer and not a string, I set variable children 0 so when it client[i].getChildren if it greater than 0 then they have a children. Which is consider yes.
 * Then the counter male for each region counts up. 
 */
public static void male_car_children_per_location(BankRecord[] client){
	Arrays.sort(client,new Compare());
	int inner_count=0, rural_count=0,suburban_count=0,town_count=0;
	String gender = "MALE";
	String region1 = "INNER_CITY";
	String region2 = "RURAL";
	String region3 = "SUBURBAN";
	String region4 = "TOWN";
	String yes = "YES";
	int inner_male = 0, rural_male = 0,suburban_male = 0, town_male = 0;
	int children = 0;
	
	for (int i=0; i<client.length;i++){
		if (client[i].getRegion().equals(region1) && client[i].getSex().equals(gender) && client[i].getCar().equals(yes) && client[i].getChildren() > children){
			inner_male++;
			
		}
		
		else if (client[i].getRegion().equals(region2) && client[i].getSex().equals(gender) && client[i].getCar().equals(yes) && client[i].getChildren() > children){
			rural_male++;
		}
		
		else if (client[i].getRegion().equals(region3) && client[i].getSex().equals(gender) && client[i].getCar().equals(yes) && client[i].getChildren() > children){
			suburban_male++;
		}
		
		else if (client[i].getRegion().equals(region4) && client[i].getSex().equals(gender) && client[i].getCar().equals(yes) && client[i].getChildren() > children){
			town_male++;
		
	}
	}
	
	System.out.println("Innercity region males with car & children: " + inner_male + " Rural region males with car & children: " + rural_male + " Suburban region males with car & children: " + suburban_male + " Town region males with car & children: " + town_male);
	PrintWriter out;
	try {
		out = new PrintWriter(new BufferedWriter(new FileWriter("bankrecords.txt",true)));
		out.println("Innercity region males with  car & children: " + inner_male+ " Rural region males with car & children: " + rural_male + " Suburban region males with car & children: " + suburban_male + " Town region males with car & children: " + town_male); 
		out.close();
	} catch (IOException e) {
		System.out.print("Error occur in writing to file bankrecords.txt at method male");
		e.printStackTrace();
		e.getMessage();
	}
}

/**
 * 
 * @param args
 * This is the main method that executes all the other method.
 * First I call the class BankRecord and assign the name clientrecord for object. Then I called clientrecord.readData(); that calls to the previous class and execute the readData(); which read information from
 * csv file and assign it into an array and run through the rest of the program that are executed from readData(); This gives our array.
 * 
 * I assign value n to 600 because I know the array list is 600.
 * Then I call our other method and input the client which is out array.
 * Then write to the bankrecords.txt of time stamp and programmer author.
 */
public static void main(String[] args) {
		
		BankRecord clientrecord = new BankRecord();
		clientrecord.readData();
		int n = 600;		
		System.out.print("\n" + "------------------------------------------------------------------------------------------------------------------------------" +"\n");
	
		average_income(client,n);
		max_min_age_per_location(client);
		female_mortgages(client);
		male_car_children_per_location(client);
		
		
		String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
		System.out.println("Time/Date: " + timeStamp + "\nProgrammed by Elton Tang Student\n");
		
		PrintWriter out;
		try {
			out = new PrintWriter(new BufferedWriter(new FileWriter("bankrecords.txt",true)));
			out.println("Time/Date: " + timeStamp + "\nProgrammed by Elton Tang Student\n");
			out.close();
			System.out.println("Completed");
		} catch (IOException e) {
			System.out.print("Error occur in writing to file bankrecords.txt at main method.");
			e.printStackTrace();
			e.getMessage();
		}
	
}
	
}
