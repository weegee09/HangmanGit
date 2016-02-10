import java.awt.Image;

public interface IDrawHangMan
{
	String getStringDrawing(int wrongGuesses); //Output a hangman in string form
	ImageIcon getImage(int wrongGuesses); //Output
}