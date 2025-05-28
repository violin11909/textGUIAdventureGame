package textGUIAdventureGame;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Game {
	JFrame window;
	Container con;
	JPanel titleNamePanel, startButtonPanel;
	JLabel titleNameLabel;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
	JButton startButton;
	
	//TitleScreenHandler tsHandler = new TitleScreenHandler();
	
	public static void main(String[] args) {
		new Game();
	}
	
	public Game() {
		window = new JFrame();
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.BLACK);
		window.setLayout(null);
		window.setVisible(true);
		con = window.getContentPane();
		
		//place for title texts
		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(100, 100, 600, 150); //100 from bound, size 600*150
		titleNamePanel.setBackground(Color.BLACK);
		titleNameLabel = new JLabel("ADVENTURE");
		titleNameLabel.setForeground(Color.WHITE);
		titleNameLabel.setFont(titleFont);
		
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(300, 400, 200, 100);
		startButtonPanel.setBackground(Color.BLACK);
		
		startButton = new JButton("START");
		startButton.setBackground(Color.BLACK);
		startButton.setForeground(Color.WHITE);
		startButton.setFont(normalFont);
		
		titleNamePanel.add(titleNameLabel);
		startButtonPanel.add(startButton);
		con.add(titleNamePanel);
		con.add(startButtonPanel);
		
	}

}
