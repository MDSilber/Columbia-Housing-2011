import java.io.*;
import java.util.*;

public class Housing {

	public static void main(String[] args) throws IOException 
	{
		File housing = new File("rooms.txt");
		Scanner checker = new Scanner(housing);
		Scanner input = new Scanner(System.in);
		boolean UNIFound = true;

		System.out.println("\nPlease enter in your UNI.");
		String UNI = input.next();
		System.out.println("Please enter how many people in your suite.");
		int numberInSuite = input.nextInt();
		
		int numberOfSuites = 0;
		ArrayList<Integer> lotteryNumbers = new ArrayList<Integer>();
		
		while(checker.hasNextLine())
		{
			String currentUNI = checker.next();
			if(UNI.equals(currentUNI))
			{
				break;
			}
			
			String type = checker.next();
			checker.next();

			
				lotteryNumbers.add(checker.nextInt());
			

			if(!checker.hasNext())
			{
				System.out.println("\nYour UNI was not found. It might be withheld. Check housing PDF.");
				UNIFound = false;
				break;
			}
		}
	
		if(UNIFound)
		{
			for(int i = 0; i<lotteryNumbers.size()-1; i++)
			{
				int numberOfRepititions = 1;
				int temp = lotteryNumbers.get(i);
				while(lotteryNumbers.get(i+1) == temp && i<(lotteryNumbers.size()-2))
				{
					numberOfRepititions++;
					i++;
					if(numberOfRepititions == numberInSuite)
					{
						numberOfSuites++;
					}
				}
			}
                	System.out.println("\nThere are " + numberOfSuites +" groups of " + numberInSuite + " picking before you.");
		}
	}
}
