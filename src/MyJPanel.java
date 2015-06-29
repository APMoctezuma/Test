import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.*;
public class MyJPanel extends JFrame
{
	private static final long serialVersionUID = 1L;
	int length = 600;
	int width = 600;
	JPanel left;
	JPanel right;
	JTextField stringinput;
	JTextField charinput;
	JButton go;
	JButton go2;
	JButton playagain;
	JLabel guesses;
	JLabel p;
	int g;
	Puzzle puzz;
	public MyJPanel()
	{
		setTitle("Hangman!");
		setSize(length, width);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		createcontents();
	}
	public void createcontents()
	{
		setLayout(new BorderLayout());
		left = new JPanel();
		left.setLayout(new BorderLayout());
		right = new JPanel();
		right.setLayout(new GridLayout(6,1));
		p = new JLabel("",SwingConstants.CENTER);
		left.add(BorderLayout.CENTER, p);
		g = 0;
		guesses = new JLabel("Number of guesses = " + g);
		stringinput = new JTextField("Put in the word/phrase!");
		charinput = new JTextField("What's your guess?");
		charinput.setEditable(false);
		go = new JButton("Go!");
		go.setBackground(Color.GREEN);
		go2 = new JButton("Take a guess!");
		playagain = new JButton("Start Over?");
		playagain.setBackground(Color.RED);
		go.addActionListener(new Listener());
		go2.addActionListener(new Listener());
		playagain.addActionListener(new Listener());
		right.add(stringinput);
		right.add(go);
		right.add(charinput);
		right.add(go2);
		right.add(guesses);
		right.add(playagain);
		add(BorderLayout.CENTER, left);
		add(BorderLayout.EAST, right);
	}
	private class Listener implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			if(arg0.getSource() == go)
			{
				String d = stringinput.getText();
				puzz = new Puzzle(d);
				p.setText(puzz.toString());
				stringinput.setEditable(false);
				stringinput.setText("The word has been chosen!");
				charinput.setEditable(true);
			}
			else if(arg0.getSource() == go2)
			{
				++g;
				char d = charinput.getText().charAt(0);
				puzz.letsedit(d);
				p.setText(puzz.toString());
				guesses.setText("Number of guesses = " + g);
				charinput.setText("");
				if(puzz.didtheywin())
				{
					charinput.setText("You won!");
				}
			}
			else
			{
				g = 0;
				guesses.setText("Number of guesses = " + g);
				charinput.setEditable(false);
				stringinput.setEditable(true);
				charinput.setText("");
				stringinput.setText("");
				p.setText("");
			}
		}	
	}
	public static void main(String[] args)
	{
		new MyJPanel();
	}
}
