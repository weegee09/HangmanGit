import java.util.Scanner;

public class HangmanRunner
{
	public static void main(String[] args)
	{
		HangMan man = new HangMan();
		String result;
		String title;
		String dashes;
		String incorrect;
		String word;
		String drawing;
		int incorrectGuesses;
		boolean hasWon;
		while(hasWon = false)
		{
			Refresh(title,dashes,incorrect,word,drawing,incorrectGuesses,hasWon);
			result = Picture();
			System.out.println(result);
		}
	}
	public static void Refresh(String title, String dashes, String incorrect,String word,String drawing,int incorrectGuesses,boolean hasWon)
	{
		title = "~~HangMan~~";
		dashes = man.getWordSoFar();
		incorrect = man.getIncorrectLetters();
		word = man.getWord();
		drawing = man.consoleDrawing();
		incorrectGuesses = man.getAmtIncorrectGuesses();
		hasWon = man.win();
	}
	public static String Picture()
	{
		Scanner sc = new Scanner(System.in);
		String result = "";
		result += title + "\nWord: " + dashes + "\n" + drawing + "\nIncorrect Guesses: " + incorrect;
		result += "\tNumber Incorrect: " + incorrectGuesses + "\nYour Guess: " + word;
		word = sc.nextLine();

		return result;

	}
}