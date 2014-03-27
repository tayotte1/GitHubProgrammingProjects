import java.util.Scanner;
import java.io.*;

/** The purpose of this class is to match cell phone accounts 
 *  with plan options.
 *  @author Joanne Selinski
 */

public class pg10a {
	
	public static void main(String [] args) {

		PlanOptions thePlans = new PlanOptions();
		WirelessAccount joanne = new WirelessAccount("Joanne", "(410)516-4117");

		Plan planA = new Plan(60.00, 800);
		TextPlan planB = new TextPlan(44.99, 400, 450);
		DataPlan planC = new DataPlan(79.99, 700, 1200, 500);
		DataPlan planD = new DataPlan(120.00, 800, 1200, 2000);
		thePlans.add(planA);
		thePlans.add(planB);
		thePlans.add(planC);
		thePlans.add(new Plan(29.99, 300));
		thePlans.add(new TextPlan(34.99, 300, 800));
		thePlans.add(planD);
		planA.minsOverage(.20);
		planB.minsOverage(.40);
		planB.textOverage(.03);
		planC.minsOverage(.35);
		planC.textOverage(.02);
		thePlans.print();  // show all data members available for each plan
		Plan p = (Plan) thePlans.get(planC);
		System.out.println("equals tests: " + p.equals(planC) + " " + planA.equals(planC));  // should be true, false

		for (int i=0; i < 20; i++) {
			joanne.logCall("1200", "1500");
			joanne.logText();
			joanne.logData(i*3);
		}

		double bill1, bill2;
		bill1 = joanne.getCost(planC);
		System.out.printf("joanne's cost with planC: $%.2f \n", bill1);
		bill2 = joanne.getCost(planD);
		System.out.printf("joanne's cost with planD: $%.2f \n", bill2);
		if (bill1 <= bill2)
			joanne.setPlan(planC);
		else
			joanne.setPlan(planD);
		System.out.println("joanne's plan is " + joanne.getPlan());

		System.out.printf("joanne's first bill: $%.2f\n", joanne.bill());
		joanne.payment(40.00);  // make $40 payment
		System.out.printf("joanne's remaining bill: $%.2f\n", joanne.bill());
		joanne.interest(.05);  // charge 5% interest 
		bill1 = joanne.bill();
		System.out.printf("joanne's bill w/interest: $%.2f\n", bill1);
		joanne.payment(bill1);
		System.out.printf("joanne's final bill: $%.2f\n", joanne.bill());
		
		
		System.out.println("\n\n\n\n\n\n" + joanne.name);
	}  // main

}