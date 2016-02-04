import java.awt.Image;

public interface IDrawHangMan
{
	String getStringDrawing(int wrongGuesses); //Output a hangman in string form
	Image getImage(int wrongGuesses); //Output
}