import java.awt.Image;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.io.File;
import java.io.IOException;

public interface IDrawHangMan
{
	String getStringDrawing(int wrongGuesses); //Output a hangman in string form
	ImageIcon getImage(int wrongGuesses); //Output
}