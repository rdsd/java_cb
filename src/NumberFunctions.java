
public class NumberFunctions {

	public static void main(String[] args)
	{
		int num = 11;
		
		boolean isPrime = checkPrime(num);
		System.out.println("Number " + num + " is Prime? " + isPrime);
	}
	
	/*
	 * This function checks if a number is prime by checking whether it is exactly
	 * divisible by any number between 2 and half the number.
	 * O(n) = n/2 = n
	 */	
	public static boolean checkPrime(int num)
	{
		boolean isPrime = true;
		
		for(int i = 2; i < num/2; i++)
		{
			if((num % i) == 0)
			{
				isPrime = false;
				break;
			}
		}
		
		return isPrime;
	}
	
	
}
