//Packages
import java.util.*;
import java.io.*;
import java.text.*;

//Object Class 
public class HotelReg{

	/* - Global Private Variables - */
	private double roomCost, soujournCost,
				   clientRewardsPoints, cost, rewards;
	private int stayPeriod, nights, guest;
	private String userInputCode, packageDescription;
	private char userCode;
	private boolean inputLoopWhile;
	private Scanner keyIn = new Scanner(System.in);								/*	Set the Scanner	*/
	private DecimalFormat floatPoint = new DecimalFormat("#.##");				/*	Set the Decimal Format */

	/* Set the public variables */	/*	--	We want to hide the data as much as possible so this is not the best method	--	*/
	public double totalRewards, totalSpent;
	public int memberCount, totalStayed;
	
	/* - Object Constructor - */
	public HotelReg(String a){
		this.packageDescription = a;											/*	Set the packageDescription	*/
		memberCount = 0;														/*	Initalize Member 	*/
		totalSpent = 0;															/*	Initialize total spent */
		totalStayed = 0;														/* 	Initialize total stayed */
		totalRewards = 0;														/*	Initialize total rewards */
	}

	/* - Set the character and boolean var || return bool for while - */
	public boolean inputLoop(){
		System.out.print("Please enter your code: ");
		userInputCode = keyIn.nextLine();
		userInputCode = userInputCode.toUpperCase();
		userCode = userInputCode.charAt(0);

		inputLoopWhile = userCode == 'N' || userCode == 'S'
						 || userCode == 'G' || userCode == 'P';					/*	Set the return boolean for While */

		return inputLoopWhile;													/*	Return the boolean	*/

	}

	/* - Return boolean for if/else statement - Non Member */
	public boolean identifyNon(){
		return userCode == 'N';													/*	If customer is a nonmember */
	}

	/* - Return boolean for if/else statement - Silver */
	public boolean identifySilver(){
		return userCode == 'S';													/*	If customer is a a silver member */
	}

	/* - Return boolean for if statement - Gold */
	public boolean identifyGold(){
		return userCode == 'G';													/*	If customer is a gold member */
	}

	/* Print out cost */
	public void workForCost(double a, int r){
		System.out.print("Please enter the length of your visit: ");			/*	User prompt visit length */
		stayPeriod = keyIn.nextInt();											/*	Scan the visit length */
		System.out.print("Please enter the cost of the room: ");				/*	User prompt room cost */
		roomCost = keyIn.nextDouble();											/*	Scan the room cost */

		keyIn.nextLine();														/*	Clear the keyboard	*/

		/* - Calculate the soujorn cost - */
		soujournCost = (stayPeriod * roomCost + 20) * 1.094;					

		/* - Call upon rewards method - */
		calculatePoints(a,r);

		memberCount++;															/*	Add the Member count */
		totalSpent += soujournCost;												/*	Add to the total amount of money spent */
		totalStayed += stayPeriod;												/*	Add to the total period stay */
		totalRewards += clientRewardsPoints;									/*	Add to the total rewards earned */

		/*	Print out */
		System.out.println("The " + packageDescription
							+ " stayed for " + stayPeriod + " nigths. " +
							"He payed $" 
							+ floatPoint.format(soujournCost) + ". He also earned " 
							+ floatPoint.format(clientRewardsPoints) 
							+ " rewards points");
	}

	/* - Calculate the rewards point - */
	private void calculatePoints(double b, int c){
		clientRewardsPoints = soujournCost * b + c;								/*	Calculate the rewards points */
	}

	/* - Last Print out - */
	public void lastPrintOut(){
		System.out.println("We entertained " + memberCount + " "
							+ packageDescription + " totaling " 
							+ totalStayed
							+ " nights spent and profiting $" 
							+ floatPoint.format(totalSpent) 
							+ ".\nThey also earned a combined " 
							+ floatPoint.format(totalRewards) 
							+ " reward points");
	}

	/* - Add the guest numbers - */
	public void addGuest(int g, int u, int e, int s){
		guest = g + u + e + s;													/*	Add the guest */
	}

	/* - Add the nights numbers - */
	public void addNights(int n, int i, int g, int h){
		nights = n + i + g + h;													/*	Add the nights */
	}

	/* - Add the cost numbers - */
	public void addCost(double q, double o, double v, double z){
		cost = q + o + v + z;													/*	Add the cost */
	}

	/* - Add the rewards numbers - */
	public void addRewards(double r, double w, double d, double j){
		rewards = r + w + d + j;												/*	Add the rewards */
	}

	/* - Last General print Out - */
	public void lastGeneral(){
		System.out.println("We have a total of " 
							+ guest + " that visited the Marriot.\n"
							+ "They stayed " + nights + " nights "
							+ " and our revenue was $" 
							+ floatPoint.format(cost)
							+ ".\nOur guest had rewards totaling: " 
							+ floatPoint.format(rewards));
	}

}
