package com.aurionpro.Day3HW;

import java.util.*;

public class Substring {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
	
		System.out.print("Enter a String: ");
		String inputString = scanner.nextLine();
		
		System.out.print("\nEnter the substring to be checked: ");
		String subString = scanner.nextLine();
		
		int stringLength = inputString.length();
		int subStringLength = subString.length();
		
		int[] inputArray = new int[stringLength];
		int[] subStringArray = new int[subStringLength];
		
		for (int i = 0; i < stringLength; i++) {
			inputArray[i] = inputString.charAt(i);
		}
		
		for (int i = 0; i < subStringLength; i++) {
			subStringArray[i] = subString.charAt(i);
		}
		
		System.out.println();
		
		if(stringLength < subStringLength)
		{
			System.out.println("No substring present as substring is greater than string !!");
		}
		else if(stringLength == subStringLength)
		{
			System.out.println("Both strings of same length so no substring present !!");
		}
		else
		{
			boolean subStringFound = false;
			
			for (int i = 0; i <= stringLength - subStringLength; i++) {
				int j;
				for (j = 0; j < subStringLength; j++) {
					if(inputArray[i+j] != subStringArray[j])
					{
						break;
					}
				}
				if(j == subStringLength)
				{
					subStringFound = true;
				}
			}
			
			if(subStringFound){
				System.out.println(subString+" is a substring of "+inputString+".");
			}
			else
			{
				System.out.println(subString+" is not a substring of "+inputString+".");
			}
		}
		scanner.close();
	}
}
