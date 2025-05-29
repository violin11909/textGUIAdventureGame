package textGUIAdventureGame;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Game {
	JFrame window;
	Container con;
	JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
	JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
	JTextArea mainTextArea;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);
	JButton startButton, choice1, choice2, choice3, choice4;
	
	TitleScreenHandler tsHandler = new TitleScreenHandler();
	ChoiceHandler choiceHandler = new ChoiceHandler();
	
	int playerHP;
	String weapon, position;
	
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
		startButton.addActionListener(tsHandler);
		startButton.setFocusPainted(false);
		
		titleNamePanel.add(titleNameLabel);
		startButtonPanel.add(startButton);
		con.add(titleNamePanel);
		con.add(startButtonPanel);
		
	}
	
	public void createGameScreen() {
		titleNamePanel.setVisible(false);
		startButtonPanel.setVisible(false);
		
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(100, 100, 600, 250);
		mainTextPanel.setBackground(Color.black);
		con.add(mainTextPanel);
		
		mainTextArea = new JTextArea("This is the main text area.");
		mainTextArea.setBounds(100, 100, 600, 250);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextPanel.add(mainTextArea);
		
		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(250, 350, 300, 150);
		choiceButtonPanel.setBackground(Color.black);
		choiceButtonPanel.setLayout(new GridLayout(4, 1));
		con.add(choiceButtonPanel);
		
		choice1 = new JButton("choice1");
		choice1.setBackground(Color.black);
		choice1.setForeground(Color.white);
		choice1.setFont(normalFont);
		choice1.setFocusPainted(false);
		choice1.addActionListener(choiceHandler);
		choice1.setActionCommand("c1");
		choiceButtonPanel.add(choice1);
		
		choice2 = new JButton("choice2");
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.white);
		choice2.setFont(normalFont);
		choice2.setFocusPainted(false);
		choice2.addActionListener(choiceHandler);
		choice2.setActionCommand("c2");
		choiceButtonPanel.add(choice2);
		
		choice3 = new JButton("choice3");
		choice3.setBackground(Color.black);
		choice3.setForeground(Color.white);
		choice3.setFont(normalFont);
		choice3.setFocusPainted(false);
		choice3.addActionListener(choiceHandler);
		choice3.setActionCommand("c3");
		choiceButtonPanel.add(choice3);
		
		choice4 = new JButton("choice4");
		choice4.setBackground(Color.black);
		choice4.setForeground(Color.white);
		choice4.setFont(normalFont);
		choice4.setFocusPainted(false);
		choice4.addActionListener(choiceHandler);
		choice4.setActionCommand("c4");
		choiceButtonPanel.add(choice4);
		
		playerPanel = new JPanel();
		playerPanel.setBounds(100, 15, 600, 50);
		playerPanel.setBackground(Color.black);
		playerPanel.setLayout(new GridLayout(1, 4));
		con.add(playerPanel);
		
		hpLabel = new JLabel("HP: ");
		hpLabel.setFont(normalFont);
		hpLabel.setForeground(Color.white);
		playerPanel.add(hpLabel);
		
		hpLabelNumber = new JLabel();
		hpLabelNumber.setFont(normalFont);
		hpLabelNumber.setForeground(Color.white);
		playerPanel.add(hpLabelNumber);
		
		weaponLabel = new JLabel("Weapon: ");
		weaponLabel.setFont(normalFont);
		weaponLabel.setForeground(Color.white);
		playerPanel.add(weaponLabel);
		
		weaponLabelName = new JLabel();
		weaponLabelName.setFont(normalFont);
		weaponLabelName.setForeground(Color.white);
		playerPanel.add(weaponLabelName);
	
		playerSetup();
	}
	
	public void playerSetup() {
		playerHP = 15;
		weapon = "Knife";
		hpLabelNumber.setText("" + playerHP);
		weaponLabelName.setText(weapon);
		
		townGate();
	}
	
	public void townGate() {
		position = "townGate";
		mainTextArea.setText("You are at the gate of the town.\nA guard is standing in front of you.\n\nWhat do you want to do?");
		choice1.setText("Talk to the guard");
		choice2.setText("Attack the guard");
		choice3.setText("Leave");
		choice4.setText("");
	}
	
	public void talkGuard() {
		position = "talkGuard";
		mainTextArea.setText("Guard: Hello stranger! I have never seen you before. I'm sorry but we can't let stranger into our town.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void attack() {
		
	}
	
	public class TitleScreenHandler implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			createGameScreen();
		}
	}
	
	public class ChoiceHandler implements ActionListener {
		
		public void actionPerformed(ActionEvent event) {
			String cmd = event.getActionCommand();
			switch(position) {
			case "townGate":
				switch(cmd) {
				case "c1": talkGuard(); break;
				case "c2": break;
				case "c3": break;
				case "c4": break;
				}
				break;
			case "talkGuard":
				switch(cmd) {
				case "c1": townGate(); break;
				case "c2": break;
				case "c3": break;
				case "c4": break;
				}
				break;
			}
		}
	}
}
