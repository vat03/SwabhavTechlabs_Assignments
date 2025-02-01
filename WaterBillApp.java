package com.aurionpro.conditionalstatements;

import java.util.Scanner;

public class WaterBillApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the number of units consumed: ");
		int unitsConsumed = scanner.nextInt();
		
		int meterCharge = 75;
		int charge = 0;
		
		if(unitsConsumed <= 100)
		{
			charge = unitsConsumed * 5;
		}
		else
		{
			if(unitsConsumed <= 250)
			{
				charge = unitsConsumed * 10;
			}
			else
			{
				charge = unitsConsumed * 20;
			}
		}
		
		int totalWaterBill = charge + meterCharge;
		
		System.out.println("Total Water bill is: "+totalWaterBill);
		
		scanner.close();
	}
}
