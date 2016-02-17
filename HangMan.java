//Max Paul
//Hangman
public class HangMan
{
	String word, wrong, reveal;
	char letter;
	int timesWrong;
	boolean won;

	public void guessLetter(char guess)//checks the letter and either adds it to the wordSoFar or adds it to the incorrect guesses
	{
		String updated = "";
		int lettersChecked = 0;
		boolean yesOrNo = true;
		for(int i = 0; i<word.length(); i++)
		{
			lettersChecked ++;
			if(word.charAt(i) == guess)
			{
				lettersChecked = 0;
				for(int j = 0; j<i; j++)
				{
					updated+=reveal.charAt(i);
				}
				updated+=guess;
				for(int k = i; k<word.length(); k++)
				{
					updated +=reveal.charAt(i);
				}
			reveal = updated;
			}
		}
		if(lettersChecked == word.length()-1)
		{
			yesOrNo = false;
		}

		if(yesOrNo == false)
		{
			wrong += guess;
			timesWrong++;
		}

	}
	public void guessWord(String guess)//no penalty for getting it wrong, but that does not need to be the case later
	{
		if(guess == word)
			won = true;
	}
	public String getIncorrectLetters()
	{
		return wrong;
	}
	public void newWord()//gets a new word and then changes it to dashes (computer becomes --------)
	{
		word = "temp";//Dictionary.getRandomWord();
		String blank = "";
		reveal = blank;
		for(int i = 0; i<word.length(); i++)
		{
			reveal+= "-";
		}
	}
	String getWordSoFar()
	{
		return reveal;
	}
	public String getWord()
	{
		return word;
	}
	public int getAmtIncorrectGuesses()
	{
		return timesWrong;
	}
	public boolean win()
	{
		return won;
	}
	/*
	public String consoleDrawing()
	{
		return DrawHangMan.getStringDrawing();
	}
	public Image guiDrawing();
	{
		return DrawHangMan.getImage();
	}
	*/


}