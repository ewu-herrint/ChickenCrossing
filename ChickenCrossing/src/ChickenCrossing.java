import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * @author Tyler Herrin
 *
 */

public class ChickenCrossing 
{
	public static void main(String[] args) throws FileNotFoundException 
	{
		Node root = MakeResources.makeTree();			//	Call to other classes that make
		String[] array = MakeResources.makeArray();		//	the binary tree and array.
		
		String results = getResults( root);
		
		int[] coords = getCoords(results);
		
		System.out.println("Coordinates: " + coords[0] + " " + coords[1]);
		System.out.println("Why the chicken crossed the road: " + array[coords[0]] + array[coords[1]]);
	}
	
	private static String getResults(Node root) throws FileNotFoundException
	{
		Scanner in = new Scanner(new File("chicken.in"));
		Node curr = root;
		String results = "";
		
		while(in.hasNextLine()) // Check if at end of file.
		{
			String line = in.nextLine(); // Grab the next entry.
			
			for(int x = 0; x < line.length(); x++) // Progress through string 1 character at a time.
			{			
				if(line.charAt(x) == '0')	// If character is 0 go left down the tree.
				{
					curr = curr.getLeft();
					if(curr.getData() != null)	// If node isn't empty you are at the bottom of that branch.
					{
						results += curr.getData();	// Add that letter to the results.
						curr = root;
					}
				}
				
				else if(line.charAt(x) == '1')	// If character is 1 go right down the tree.
				{
					curr = curr.getRight();
					if(curr.getData() != null)	// If node isn't empty you are at the bottom of that branch.
					{
						results += curr.getData();	// Add that letter to the results.
						curr = root;
					}
				}
			}
			results += " "; // Add some delimiter between the different lines.
		}
		
		in.close();
		
		return results;
	}
	
	private static int[] getCoords(String s)
	{
		String[] results = s.split(" "); // Split the results by the delimiter decided on.
		int[] nums = new int[results.length]; // Make an array to hold each number.
		int[] coords = new int[results.length/2]; // Make an array half that size for combining integers.
		
		for(int x = 0; x < results.length; x++)
		{
			nums[x] = getNumber(results[x]);	// Get the numerical version of each number.
		}
		
		for(int x = 0, y = 0; y < nums.length / 2; x = x + 2, y++)
		{
			coords[y] = Integer.valueOf(String.valueOf(nums[x])	// For every pair of integers convert them
					+ String.valueOf(nums[x + 1]));				// into strings and concatenate them. Then
		}														// convert back into integers.
		
		return coords;
	}
	
	private static int getNumber(String s)
	{
		if(s.toUpperCase().compareTo("ZERO") == 0)
			return 0;
		if(s.toUpperCase().compareTo("ONE") == 0)
			return 1;
		if(s.toUpperCase().compareTo("TWO") == 0)
			return 2;
		if(s.toUpperCase().compareTo("THREE") == 0)
			return 3;
		if(s.toUpperCase().compareTo("FOUR") == 0)
			return 4;
		if(s.toUpperCase().compareTo("FIVE") == 0)
			return 5;
		if(s.toUpperCase().compareTo("SIX") == 0)
			return 6;
		if(s.toUpperCase().compareTo("SEVEN") == 0)
			return 7;
		if(s.toUpperCase().compareTo("EIGHT") == 0)
			return 8;
		if(s.toUpperCase().compareTo("NINE") == 0)
			return 9;
		
		throw new RuntimeException("String must be a number zero to nine.");
	}
}
