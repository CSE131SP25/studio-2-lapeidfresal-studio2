package studio2;

public class Ruin {

	public static void main(String[] args) {
		double startAmount = 2;
		double winChance = .7;
		int winLimit = 10;
		int totalSimulations = 0;
		String outcome = "start";
		int totalDays = 0;
		int daysLimit = 500;
		int loseCounter = 0;
		while (totalDays < daysLimit) {
			int win = 0;
			int lose = 0;
			double currentMoney = startAmount;
			while (currentMoney < winLimit && currentMoney > 0) {
				double result = Math.random();
				if (result <= winChance) {
					currentMoney++;
					outcome = "WIN";
					win++;
				}
				else {
					currentMoney--;
					outcome = "LOSE";
					lose++;
				}
				totalSimulations++;
				if (currentMoney == 0)
					loseCounter++;
			}
			totalDays++;
			System.out.println("Simulation " + totalDays + ": " + totalSimulations + " " + outcome);
			}
		System.out.println("Loses: " + loseCounter + " Simulations: " + totalDays);
		System.out.println("Ruin Rate from Simulation: " + (double) loseCounter/totalDays);
		
		double expectedRuin;
		if (winChance == .5) {
			expectedRuin = 1 - ((double) startAmount/winLimit);
		}
		else {
			double a = (1.0 - (double) winChance)/winChance;
			expectedRuin = (Math.pow(a, startAmount) - Math.pow(a,  winLimit)) / (1.0 - Math.pow(a,  winLimit));
		}
		System.out.println("Expected Ruin Rate " + expectedRuin);
	}
		
}
