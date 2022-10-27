package question1;


public class Bulls {
	
	static String randNum = "";
	
	static String generateRandNum() {
		int randomNumber = 1000 + ((int) (Math.random() * 10000) % 9000);
		randNum = Integer.toString(randomNumber);
		while (hasRepeatingDigits(randNum)) {
			generateRandNum();
		}
		return randNum;
	}

	
	
	static boolean hasRepeatingDigits(String num) {
		for (int i = 0; i < num.length() - 1; i++) {
			for (int j = i + 1; j < num.length(); j++) {
				if (num.charAt(i) == num.charAt(j)) {
					return true;
				}
			}
		}
		return false;
	}
	
	static boolean containsNonDigits(String num) {
		if (!num.matches("^[0-9]+$")) {
			return true;
		}
		return false;
	}
	
	
	static int computeBulls(String num1, String num2) {
		int bullCounter = 0;

		for (int i = 0; i < num1.length(); i++) {
			if (num1.charAt(i) == num2.charAt(i)) {
				bullCounter++;
			}
		}
		return bullCounter;
	}

	static int computeCows(String num1, String num2) {
		int cowsCounter = 0;
		for (int i = 0; i < num1.length(); i++) {
			for (int j = 0; j < num2.length(); j++) {
				if (i != j) {
					if (num1.charAt(i) == num2.charAt(j)) {
						cowsCounter++;
					}
				}
			}
		}
		return cowsCounter;
	}
	
	
	 
}
