import java.io.BufferedReader;
import java.text.DecimalFormat;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.NumberFormatException;
/**
 * 
 * @author Elton Tang
 * @version: 2/17/2016
 * ITMD_411_Lab_2_Elton_Tang
 * BankRecord.java
 * 
 * Lab 2
 */


/**
 * @BankRecord
 * The class of the BankRecord with the implements of Client.
 * The static BankRecord client[] is setup to 600 records in the array.
 * The List<List<String>> array = new ArrayList<>()
 * declare the type of the array value is string and allow easy adding or removing from the array.
 * DecimalFormat df = new DcimalFormat("#.00"); is used to format the string the correct format when print. 
 * Also declares the type of variable that will be used in the class.
 */
public class BankRecord implements Client {

	static BankRecord client[] = new BankRecord[600];
	static List<List<String>> array = new ArrayList<>();
	static DecimalFormat df = new DecimalFormat("#.00");
	
	private String id;
	private int age;
	private String sex;
	private String region;
	private double income;
	private String married;
	private int children;
	private String car;
	private String save_act;
	private String current_act;
	private String mortgage;
	private String pep;
	
	/**
	 * setter/getter where generated from source after the variable were declared above.
	 * @return it returns values of the parameter when called upon from getter in the array.
	 * @this set the value into the parameter in the setter. 
	 */
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public String getRegion() {
		return region;
	}


	public void setRegion(String region) {
		this.region = region;
	}


	public double getIncome() {
		return income;
	}


	public void setIncome(double income) {
		this.income = income;
	}


	public String getMarried() {
		return married;
	}


	public void setMarried(String married) {
		this.married = married;
	}


	public int getChildren() {
		return children;
	}


	public void setChildren(int children) {
		this.children = children;
	}


	public String getCar() {
		return car;
	}


	public void setCar(String car) {
		this.car = car;
	}


	public String getSave_act() {
		return save_act;
	}


	public void setSave_act(String save_act) {
		this.save_act = save_act;
	}

	public String getCurrent_act() {
		return current_act;
	}


	public void setCurrent_act(String current_act) {
		this.current_act = current_act;
	}


	public String getMortgage() {
		return mortgage;
	}


	public void setMortgage(String mortgage) {
		this.mortgage = mortgage;
	}


	public String getPep() {
		return pep;
	}


	public void setPep(String pep) {
		this.pep = pep;
	}



	/**
	 * @readData()
	 * It reads the data from the csv file and input into the array using FileReader. 
	 * Then place the value into the array and split the values with the , in the array. 
	 * then the processData(); is calling it to run next. 
	 */
	public static void readData(){
		
		String line;
		try(BufferedReader br = new BufferedReader (new FileReader("bank-detail.csv"))){
			while ((line=br.readLine())!=null)
				array.add(Arrays.asList(line.split(",")));
		}
			catch (IOException e){
				e.printStackTrace();
		}
		processData();
	}
	
	/**
	 * @processData()
	 * It takes the value from the value and input them into client that was declared earlier to hold 600 client.
	 * The for loop is use to input the value from the array into client in specific value holder.
	 * setId the setter is used to hold the value for id from array.get(i).(0). 
	 * 0 is equal to the id from the csv file. 
	 * 1 = age , 2= sex, and so on.
	 * 
	 * Then printData() is running afterwards. 
	 * 
	 */
	public static void processData(){
		
		
		for (int i=0; i<array.size();i++){
			
			client[i] = new BankRecord();
			client[i].setId(array.get(i).get(0));
			client[i].setAge(Integer.parseInt(array.get(i).get(1)));
			client[i].setSex(array.get(i).get(2));
			client[i].setRegion(array.get(i).get(3));
			client[i].setIncome(Double.parseDouble(array.get(i).get(4)));
			client[i].setMarried(array.get(i).get(5));
			client[i].setChildren(Integer.parseInt(array.get(i).get(6)));
			client[i].setCar(array.get(i).get(7));
			client[i].setSave_act(array.get(i).get(8));
			client[i].setCurrent_act(array.get(i).get(9));
			client[i].setMortgage(array.get(i).get(10));
			client[i].setPep(array.get(i).get(11));
			//System.out.println(array.get(i)); <- testing to see if array get value i. Test OK.
			
		}
		

		printData();
	}
	
	/**
	 * @printData()
	 * This method is printing out the data from array.
	 * The for loop is use to print out 25 records from the array in a formated order using system.out.printf.
	 */
	public static void printData(){
		String text1 = "ID";
		String text2 = "AGE";
		String text3 = "SEX";
		String text4 = "REGION"; 
		String text5 = "INCOME";
		String text6 = "MORTGAGE";
		
		System.out.printf("%1s%10s%10s%15s%12s%13s%n",text1,text2,text3,text4,text5,text6);
		for(int i=0;i<=25;i++){
			System.out.printf("%1s%5s%10s%15s%12s%10s%n",client[i].id,client[i].age,client[i].sex,client[i].region,"$"+df.format(client[i].income),client[i].mortgage,"\n");
		}
	}
	
	/**
	 * 
	 * @param args 
	 * This is just to run readData();
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub9
		readData();
	}

}
