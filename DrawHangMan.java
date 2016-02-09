import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class DrawHangMan
{
	//guesses will be 0-6, with 6 being losing state
	public String getStringDrawing(int wrongGuesses)
	{
		String res = "";
		if(wrongGuesses>0) res += "  ,-----.\n /       \\\n(         )\n \\       /\n  `--.--'\n"; //drawhead
		if(wrongGuesses>4)
			res += "   ,'|`,\n  ,' | `,\n /   |   \\\n<    '    >\n"; //both arms + torso
		else if(wrongGuesses>3)
			res += "   ,'|\n  ,' |\n /   |\n<    '\n"; //left arm + torso
		else if(wrongGuesses>2)
			res += "     |\n     |\n     |\n     |\n"; //just torso
		return res;
	}
	/*
  ,-----.
 /       \
(         )
 \       /
  `--.--'
   ,'|`,
  ,' | `,
 /   |   \
<    '    >
     X
    / \
   /   \
  /     \
 /       \
/         \
	*/
	public Image getImage(int wrongGuesses)
	{
		Image man = null;

		try {
			man = ImageIO.read(new File("./man" + wrongGuesses + ".jpg")); //man0.jpg to man6.jpg
			return man;
		}catch (IOException e){
			return null;
		}
	}
}