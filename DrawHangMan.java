import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

public class DrawHangMan
{
	BufferedImage man;

	//guesses will be 0-6, with 6 being losing state
	public String getStringDrawing(int wrongGuesses)
	{
		String res = "";
		if(wrongGuesses>0) System.out.print("  ,-----.\n /       \\\n(         )\n \\       /\n  `--.--'\n"); //drawhead
		if(wrongGuesses>4) System.out.print("   ,'|`,\n  ,' | `,\n /   |   \\\n<    '    >\n"); //both arms + torso
		else
		if(wrongGuesses>3) System.out.print("   ,'|\n  ,' |\n /   |\n<    '\n"); //left arm + torso
		else
		if(wrongGuesses>2) System.out.print("     |\n     |\n     |\n     |\n"); //just torso
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
	public BufferedImage getImage(int wrongGuesses)
	{
		try {
			man = ImageIO.read(new File("man0.jpg"));
			return man;
		}catch (IOException e){
			return null;
		}
	}
}