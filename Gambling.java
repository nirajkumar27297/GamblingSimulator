
import java.util.*;
class GamblingPlay {
	
	private int gamblingAmount;
	//Considering 1 to be Win Case
	private final int PLAYWIN=1;
	//Considering 0 to be Lose case
	private final int PLAYLOSE=0;
	//Bet Amount
	private  int bet;
	//Initial glaming amount
	static private int intGamblingAmount;
	//Default constructor to initilaize amount bet amount
	GamblingPlay()
	{
		this.gamblingAmount=100;
		this.bet=1;
		this.intGamblingAmount=this.gamblingAmount;
	}
	//Parametrized constructor to initilaize amount bet amount
	GamblingPlay(final int gamblingAmount,final int bet)
	{
		this.gamblingAmount=gamblingAmount;
		this.bet=bet;
		this.intGamblingAmount=this.gamblingAmount;
	}
	
	public void gamblingPlay()
	
	{
		Random rand=new Random();
		//Creating random number within range 0-1
		final int playCheck=rand.nextInt(2);
		//if 1 then win case or lose case
		if(playCheck==this.PLAYWIN)
		{
			this.gamblingAmount+=bet;
		}
		else
		{
			this.gamblingAmount-=bet;
		}
		
	}
	public void letsPlayDay()
	{  int stake=this.gamblingAmount;
		while(true)
		{   //if the Amount is above 50% of original or below 50% of original then signing out of game
			if(this.getGamblingAmount()==0.5*stake|| this.getGamblingAmount()==1.5*stake)
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
	 * @return the intGamblingAmount
	 */
	public static int getIntGamblingAmount() {
		return intGamblingAmount;
	}
	
	/**
	 * @return the gamblingAmount
	 */
	public int getGamblingAmount() {
		return gamblingAmount;
	}
}
public class Gambling {
	
	public void playDays(int n)
	{	
		//Initialise totalAmount to 0
		int totalAmount=0;
		
		
		//To count for each Day
		for(int i=0;i<n;i++)
		{	
			
			//creating object for each day
			GamblingPlay gamblingObj = new GamblingPlay();
			//calculating amount for each day
			gamblingObj.letsPlayDay();
			
			totalAmount += gamblingObj.getGamblingAmount();
		
		}
		int residualTotalAmount=totalAmount - GamblingPlay.getIntGamblingAmount() * n;
		//if totalresidualAmount is greater than 0 then it's a win  or a lose 
		if(residualTotalAmount>0)
		{
			System.out.println("Won By "+residualTotalAmount);
		}
		else if(residualTotalAmount<0)
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
		//Creating object for Gambling class
		Gambling objGambling=new Gambling();
		//Playing for 20 days
		objGambling.playDays(20);
		
		

	}

}
	



