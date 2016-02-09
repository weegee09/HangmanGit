//Bill joseph
//Hangman Runner(Console)

import java.util.Scanner;

public class HangmanRunner
{
	public static void main(String[] args)
	{
		HangMan man = new HangMan();
		String result;
		String title = "\t\t\t\t~~HangMan~~";
		String dashes;
		String incorrect;
		String word;
		String drawing;
		int incorrectGuesses = 0;
		boolean hasWon = false;
		while(hasWon == false)
		{
			dashes = man.getWordSoFar();
			incorrect = man.getIncorrectLetters();
			word = man.getWord();
			drawing = "\nWaiting on Paolo Got me like\n";//man.consoleDrawing();
			incorrectGuesses = man.getAmtIncorrectGuesses();
			hasWon = man.win();
			Picture(title,dashes,incorrect,word,drawing,incorrectGuesses,hasWon);
		}
	}
	public static void Picture(String title, String dashes, String incorrect,String word,String drawing,int incorrectGuesses,boolean hasWon)
	{
		HangMan man = new HangMan();
		String guess = "";
		Scanner sc = new Scanner(System.in);
		String result = "";
		result += title + "\nWord: " + dashes + "\nIncorrect Letters: " + incorrect;
		result += "\t\t\t\t\tNumber Incorrect: " + incorrectGuesses + "\n" + drawing + "\nYour Guess: " ;

		System.out.print(result);
		guess = sc.nextLine();

		if(guess.length() > 1)
			man.guessWord(guess);
		else
			man.guessLetter(guess.charAt(0));

		result += guess;

	}
}