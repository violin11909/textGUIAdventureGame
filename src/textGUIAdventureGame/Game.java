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
	
	int playerHP, monsterHP, silverRing = 0;
	String weapon, position;
	boolean eastVisited = false, monsterBeated = false;
	
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
		monsterHP = 20;
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
	
	public void attackGuard() {
		position = "attackGuard";
		mainTextArea.setText("Guard: Hey! Don't be stupid.\n\nThe guard hit you so hard so you gave up.\n(You received 3 damages)");
		playerHP = Math.max(0, playerHP - 3);
		hpLabelNumber.setText("" + playerHP);
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void crossRoad() {
		position = "crossRoad";
		mainTextArea.setText("You are at the cross road.\nIf you go south, you will reach the town.");
		choice1.setText("Go north");
		choice2.setText("Go east");
		choice3.setText("Go south");
		choice4.setText("Go west");
	}
	
	public void north() {
		position = "north";
		mainTextArea.setText("There is a river. You drink the water and rest at the  riverside.\n\n(Your HP is recovered by 2.)");
		playerHP = Math.min(playerHP + 1, 15);
		playerHP = Math.min(playerHP + 1, 15);
		hpLabelNumber.setText("" + playerHP);
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void east() {
		position = "east";
		if (eastVisited) {
			mainTextArea.setText("There is nothing left here in the forest.");
		} else {
			eastVisited = true;
			mainTextArea.setText("You walked into a forest and found a Long Sword\n\n(You obtained the Long Sword.)");
			weapon = "Long Sword";
			weaponLabelName.setText(weapon);
		}
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void west() {
		position = "west";
		mainTextArea.setText("You encounter the Goblin!");
		choice1.setText("Fight");
		choice2.setText("Run");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void fight() {
		position = "fight";
		mainTextArea.setText("Monster HP: " + monsterHP + "\n\nWhat do you do?");
		choice1.setText("Attack");
		choice2.setText("Run");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void noFight() {
		position = "noFight";
		mainTextArea.setText("The Goblin is already killed.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void playerAttack() {
		position = "playerAttack";
		
		int playerDamage = 0;
		if (weapon.equals("Knife")) {
			playerDamage = new java.util.Random().nextInt(3);
		} else if (weapon.equals("Long Sword")) {
			playerDamage = new java.util.Random().nextInt(8);
		}
		
		monsterHP = Math.max(0, monsterHP - playerDamage);
		
		mainTextArea.setText("You attacked the monster and gave " + playerDamage + " damages!");	
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void monsterAttack() {
		position = "monsterAttack";
		
		int monsterDamage = 0;
		monsterDamage = new java.util.Random().nextInt(4);
		
		playerHP = Math.max(0, playerHP - monsterDamage);
		hpLabelNumber.setText("" + playerHP);
		
		mainTextArea.setText("The monster attacked you and gave " + monsterDamage + " damages!");	
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void lose() {
		position = "lose";
		mainTextArea.setText("You are dead.\n\nGAME OVER");
		choice1.setText("");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		choice1.setVisible(false);
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	
	public void win() {
		position = "win";
		mainTextArea.setText("You defeated the monster!\nThe monster dropped the Silver Ring.\n\n(You obtained the Silver Ring.)");
	
		silverRing = 1;
		monsterBeated = true;
		
		choice1.setText("Go West (cross road)");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void ending() {
		position = "ending";
		mainTextArea.setText("Oh, you killed that Goblin!?\nThank you so much. You are the hero!\n\nWelcome to our town.");
	
		choice1.setText("");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		choice1.setVisible(false);
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
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
				case "c1": 
					if (silverRing == 1) {
						ending();
					} else {
						talkGuard(); 
					}
					break;
				case "c2": attackGuard(); break;
				case "c3": crossRoad(); break;
				case "c4": break;
				}
				break;
				
			case "talkGuard":
				switch(cmd) {
				case "c1": townGate(); break;
				//we can just leave other choices like this
				}
				break;
				
			case "attackGuard":
				switch(cmd) {
				case "c1": 
					if (playerHP < 1) {
						lose();
					} else {
						townGate(); 
					}
					break;
				}
				break;
				
			case "crossRoad":
				switch(cmd) {
				case "c1": north(); break;
				case "c2": east(); break;
				case "c3": townGate(); break;
				case "c4": 
					if (monsterBeated) {
						noFight();
					} else {
						west(); 
					}
					break;
				}
				break;
				
			case "north":
				switch(cmd) {
				case "c1": crossRoad(); break;
				}
				break;
				
			case "east":
				switch(cmd) {
				case "c1": crossRoad(); break;
				}
				break;
			
			case "west":
				switch(cmd) {
				case "c1": fight(); break;
				case "c2": crossRoad(); break;
				}
				break;
			
			case "fight":
				switch(cmd) {
				case "c1": playerAttack(); break;
				case "c2": crossRoad(); break;
				}
				break;
				
			case "noFight":
				switch(cmd) {
				case "c1": crossRoad(); break;
				}
				break;
				
			case "playerAttack":
				switch(cmd) {
				case "c1": 
					if (monsterHP < 1) {
						win();
					} else {
						monsterAttack();
					}
					break;
				}
				break;
				
			case "monsterAttack":
				switch(cmd) {
				case "c1": 
					if (playerHP < 1) {
						lose();
					} else {
						fight();
					}
					break;
				}
				break;
				
			case "win":
				switch(cmd) {
				case "c1": crossRoad(); break;
				}
				break;
			}
		}
	}
}
