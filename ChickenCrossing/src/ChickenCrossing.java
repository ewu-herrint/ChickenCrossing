import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class ChickenCrossing 
{
	public static void main(String[] args) throws FileNotFoundException 
	{
		Node root = MakeResources.makeTree();
		
		String[] array = MakeResources.makeArray();
		
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
		
		while(in.hasNextLine())
		{
			String line = in.nextLine();
			
			for(int x = 0; x < line.length(); x++)
			{			
				if(line.charAt(x) == '0')
				{
					curr = curr.getLeft();
					if(curr.getData() != null)
					{
						results += curr.getData();
						curr = root;
					}
				}
				
				else if(line.charAt(x) == '1')
				{
					curr = curr.getRight();
					if(curr.getData() != null)
					{
						results += curr.getData();
						curr = root;
					}
				}
			}
			results += " ";
		}
		
		in.close();
		
		return results;
	}
	
	private static int[] getCoords(String s)
	{
		String[] results = s.split(" ");
		int[] nums = new int[results.length];
		int[] coords = new int[results.length/2];
		
		for(int x = 0; x < results.length; x++)
		{
			nums[x] = getNumber(results[x]);
		}
		
		for(int x = 0, y = 0; y < nums.length / 2; x = x + 2, y++)
		{
			coords[y] = Integer.valueOf(String.valueOf(nums[x]) + String.valueOf(nums[x + 1]));
		}
		
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
