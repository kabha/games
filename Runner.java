package question1;

import javax.swing.JOptionPane;

public class Runner {
	

	
	private static void printWelcomeMessage() {
	
		
		JOptionPane.showMessageDialog(null, "Welcome to the game of BULLS and COWS." +'\n'+
				"The objective in this game is for you to guess a 4-digit number."+'\n'+
				"The computer responds with how close your guess is to the target."+'\n'+
				"BULLS = # common digits with exact matches."+'\n'+ 
				"COWS = # common digits in wrong position.");
	}
	
	
	public static void main(String[] args){
		
		printWelcomeMessage();
		
		Bulls.randNum = Bulls.generateRandNum();
		System.out.println(Bulls.randNum);
		
		
		boolean guessed = false;
		int guesses = 1;
		do{
			int bulls = 0;
			int cows = 0;
			System.out.print("Guess a 4-digit number with no duplicate digits: "+guesses+":");
			String guessedNumber = JOptionPane.showInputDialog("Guess a 4-digit number with no duplicate digits: "+guesses+":");

			guesses++;
			bulls = Bulls.computeBulls(guessedNumber, Bulls.randNum);
			cows = Bulls.computeCows(guessedNumber, Bulls.randNum);
			
			if(bulls == 4){
				System.out.println("Bulls = " + bulls + "\tCows = " + cows);
				System.out.println("Congratulations! You won with " + guesses + " guesses.");
				JOptionPane.showMessageDialog(null,"Bulls = " + bulls + "\tCows = " + cows+" "+'\n'+"Congratulations! You won with " + guesses + " guesses.");
				guessed = true;
			}else if (Bulls.hasRepeatingDigits(guessedNumber)) {
				System.out.println("Your guess should not contain repeating digits.");
				JOptionPane.showMessageDialog(null,"Your guess should not contain repeating digits.");
			} else if (guessedNumber.length() != 4) {
				System.out.println("Your guess should contain 4 symbols (Digits)");
				JOptionPane.showMessageDialog(null,"Your guess should contain 4 symbols (Digits)");
			} else if (Bulls.containsNonDigits(guessedNumber)) {
				System.out.println("Your guess should not contain non-digits.");
				JOptionPane.showMessageDialog(null,"Your guess should not contain non-digits.");
			}else{
				System.out.println(cows+" Cows and "+bulls+" Bulls.");
				JOptionPane.showMessageDialog(null,cows+" Cows and "+bulls+" Bulls.");
			}
		}while(!guessed);
		System.out.println("You won after "+guesses+" guesses!");
		
	}


}
