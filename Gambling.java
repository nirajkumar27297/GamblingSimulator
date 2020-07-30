import java.util.Random;
public class Gambling {
	
	private int gamblingAmount;
	//Considering 1 to be Win Case
	private final int PLAYWIN=1;
	//Considering 0 to be Lose case
	private final int PLAYLOSE=0;
	//Bet Amount
	private  int bet;
	//Default constructor to initilaize amount betamount
	Gambling()
	{
		this.gamblingAmount=100;
		this.bet=1;
	}
	//Parametrized constructor to initilaize amount betamount
	Gambling(final int gamblingAmount,final int bet)
	{
		this.gamblingAmount=gamblingAmount;
		this.bet=bet;
	}
	

	
	

	/**
	 * @return the gamblingAmount
	 */
	public int getGamblingAmount() {
		return gamblingAmount;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Creating Gambling Object
		Gambling gamblingObj=new Gambling();
		System.out.println(gamblingObj.getGamblingAmount());
		

	}

}
