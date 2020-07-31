import java.util.*;

class GamblingPlay {
	
	private int gamblingAmount;
	//Considering 1 to be Win Case
	private final int PLAYWIN = 1;
	//Considering 0 to be Lose case
	private final int PLAYLOSE = 0;
	//Bet Amount
	private  int bet;
	//Initial glaming amount
	static private int intGamblingAmount;
	//Default constructor to initilaize amount bet amount
	GamblingPlay()
	{
		this.gamblingAmount = 100;
		this.bet = 1;
		this.intGamblingAmount = this.gamblingAmount;
	}
	//Parametrized constructor to initilaize amount bet amount
	GamblingPlay(final int gamblingAmount,final int bet)
	{
		this.gamblingAmount = gamblingAmount;
		this.bet = bet;
		this.intGamblingAmount = this.gamblingAmount;
	}
	
	/**
	 * @return the intGamblingAmount
	 */
	public static int getIntGamblingAmount() {
		return intGamblingAmount;
	}
	public void gamblingPlay()
	{
		Random rand = new Random();
		//Creating random number within range 0-1
		final int playCheck=rand.nextInt(2);
		//if 1 then win case or lose case
		if(playCheck == this.PLAYWIN)
		{
			this.gamblingAmount += bet;
		}
		else
		{
			this.gamblingAmount -= bet;
		}
		
	}
	public void letsPlayDay()
	{  int stake = this.gamblingAmount;
		while(true)
		{   //if the Amount is above 50% of original or below 50% of original then signing out of game
			if(this.getGamblingAmount() == 0.5*stake || this.getGamblingAmount() == 1.5*stake)
			{
				break;
			}
			else
			{
				this.gamblingPlay();
			}
		}
	}
	
	/**
	 * @return the gamblingAmount
	 */
	public int getGamblingAmount() {
		return gamblingAmount;
	}
}

public class Gambling {
	
	public void playDays(int n,int monthNumber)
	{	
		int totalAmount = 0;
		int amount = 0;
		int countWin = 0;
		int countLose = 0;
		System.out.println("For the month "+monthNumber);
		//To count for each Day of the month
		for(int i=0;i<n;i++)
		{	//creating object for each day
			GamblingPlay gamblingObj = new GamblingPlay();
			//calculating amount for each day
			gamblingObj.letsPlayDay();
			amount = gamblingObj.getGamblingAmount();
			totalAmount += amount;
			//finding residual amount
			int residualAmount = amount - GamblingPlay.getIntGamblingAmount() ;
			
			//if residualAmount is greater than 0 then it's a win game or a lose game
			if(residualAmount > 0)
			{
				countWin++;
			}
			
			else	
			{	
				countLose++;
			}
		}
		
		System.out.println("The Number Of Winning Days Are "+countWin);
		System.out.println("The Number Of Losing Days Are "+countLose);
		//finding totalResidualAmount
		int residualTotalAmount = totalAmount - n * GamblingPlay.getIntGamblingAmount();
		//if totalresidualAmount is greater than 0 then it's a win  or a lose 
		if(residualTotalAmount > 0)
		{
			System.out.println("Won By "+residualTotalAmount);
		}
		else if(residualTotalAmount < 0)
		{
			System.out.println("Lost By "+Math.abs(residualTotalAmount));
		}
		else
		{
			System.out.println("Neither Won Or Lost");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int monthNumber=0;
		while(true)
		{	
			monthNumber += 1;
			Gambling objGambling = new Gambling();
			//Playing for each Day
			objGambling.playDays(30,monthNumber);
			System.out.println("Want to play next month Enter 1 ");
			int a=sc.nextInt();
			if(a!=1)
			{
				break;
			}
	
		}

	}

}
