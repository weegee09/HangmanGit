//Madison Miatke
//Car Lot Launcher
//Spec: Utilizes car lot in a gui program

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;
import javax.swing.border.Border;



public class HangManLauncher extends JFrame implements ActionListener
{
	private HangMan game;

	//Buttons and labels
	private JLabel guessedWord;
	private JButton newWord;
	private JButton giveUp;
	private JLabel drawingSpace;
	private JButton[] letters;
	private ImageIcon icon;

	public static void main(String[] args)
	{
		new HangManLauncher();
	}

	public HangManLauncher()
	{
		game = new HangMan();
		Border border = BorderFactory.createLineBorder(Color.BLACK, 5);
		JFrame window = new JFrame("Hang Man");
		window.setBackground(new Color(255,0,0));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setTitle("Hang Man");
		window.setSize(800,600);

		Color bg =  new Color(102, 204, 51);



		//Center on Screen
		window.setLocationRelativeTo(null);

		JPanel userInterface = new JPanel();
		userInterface.setLayout(new BorderLayout());

		JPanel east = new JPanel();
		east.setOpaque(true);
      	east.setBackground(bg);
		east.setLayout(new GridLayout(9,2));
		letters = new JButton[26];
		for(int i = 0; i < 26; i++)
		{
			letters[i] = new JButton(Character.toString ((char) (i+65)));
			letters[i].addActionListener(this);
			east.add(letters[i]);
		}
		newWord = new JButton("New Word");
		newWord.addActionListener(this);
		east.add(newWord);

		JPanel north = new JPanel();
		north.setOpaque(true);
      	north.setBackground(bg);
		guessedWord = new JLabel(game.getWordSoFar(),SwingConstants.CENTER);
		guessedWord.setFont(new Font("Times Roman", Font.PLAIN, 60));
		guessedWord.setOpaque(true);
		guessedWord.setBackground(bg);
		north.add(guessedWord);

		JPanel center = new JPanel();
		center.setOpaque(true);
      	center.setBackground(bg);
		center.setLayout(new GridLayout(0,1));
		icon = new ImageIcon("imageTest.jpg");
		drawingSpace = new JLabel("", SwingConstants.CENTER);
		drawingSpace.setIcon(game.guiDrawing());
		center.add(drawingSpace);

		userInterface.add(center, BorderLayout.CENTER);
		userInterface.add(north, BorderLayout.NORTH);
		userInterface.add(east, BorderLayout.EAST);

		window.add(userInterface);

		window.setVisible(true);
	}

	public void actionPerformed(ActionEvent e)
	{
		for(int i = 0; i < 26; i++)
		{
			if(e.getSource() == letters[i])
			{
				letters[i].setEnabled(false);
				game.guessLetter((char) (i+97));
			}
		}

		if(e.getSource() == newWord)
		{
			for(int i = 0; i < 26; i++)
				letters[i].setEnabled(true);
			game.newWord();
		}

		guessedWord.setText(game.getWordSoFar());
		drawingSpace.setIcon(game.guiDrawing());


		if(game.win())
		{
			JOptionPane.showMessageDialog(new JFrame(),
			    "YOU WIN CONGRATS!",
			    "Winner",
   				JOptionPane.PLAIN_MESSAGE);
		}
		if(game.lose())
		{
			guessedWord.setText(game.getWord());
			JOptionPane.showMessageDialog(new JFrame(),
				"YOU GOT HUNG! THE WORD WAS '" + game.getWord() + "'!",
				"Loser",
				JOptionPane.PLAIN_MESSAGE);
		}
	}
}
