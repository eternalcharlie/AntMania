import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * Main Class including main method of the entire project.
 * 
 * @author weichen7, sichen5
 */
public class AntVsAnt extends JFrame{
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Initialization of JFrame and status bar.
//		JFrame status = new JFrame();
//		status.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		status.getContentPane().setLayout(new FlowLayout());
//		JButton statusButton = new JButton("Open Status Bar");
//		status.getContentPane().add(statusButton);
		

		//----
//		status.setSize(200,200);
//		status.setVisible(true);
		//----
		double start = System.currentTimeMillis();
		boolean end = false;
		AntList ants = new AntList();
		FoodList foods = new FoodList();
		EnemyAntList enemyAnts = new EnemyAntList();
		LeaderAnt leaderA = new LeaderAnt();
		EnemyLeaderAnt leaderB = new EnemyLeaderAnt();
		String playerA="";
		String playerB="";
		try{
		//----------USER INPUT SESSION STARTS--------
		playerA = JOptionPane.showInputDialog("Please input the name of person who will control RED ants.");
		playerB = JOptionPane.showInputDialog("Please input the name of person who will control BLUE ants.");
		if(playerA.equals(playerB)) {JOptionPane.showMessageDialog(null, "Well, I don't understand who is who.");
		System.exit(ABORT);}
		String nofAnts = JOptionPane.showInputDialog("How many ants do you want for "+playerA+"?");
		String nofEnemyAnts = JOptionPane.showInputDialog("How many ants do you want for "+playerB+"?");
		String nofFoods = JOptionPane.showInputDialog("How many foods do you want?");
		
		
		//---------USER INPUT SESSION ENDS---------
		

		
		//----------INITIALIZATION OF ALL VARIABLES

		ants.create(Integer.parseInt(nofAnts));
		// ------------

		foods.dropFood(Integer.parseInt(nofFoods));
		// ------------

		enemyAnts.create(Integer.parseInt(nofEnemyAnts));
		// --------------

		//------------END OF INITIALIZATION
		}
		catch (NumberFormatException ex){
			JOptionPane.showMessageDialog(null, "Invalid Number! Game cannot start.");
			System.exit(ABORT);
		}
		JOptionPane.showMessageDialog(null, "Game Starts!");
		while (Zen.isRunning() && !end) {
			// ants.drawAll();

			// ants.clearBattleLand();
			// enemyAnts.clearBattleLand();
			Zen.flipBuffer();
			// initialization of background
			Zen.setColor(0, 0, 0);
			Zen.fillRect(0, 0, Zen.getZenWidth(), Zen.getZenHeight());
			// initialization of ants
			Zen.setColor(255, 0, 0);
			ants.drawAll();
			ants.moveAll(foods, ants, enemyAnts);
			// initialization of foods
			Zen.setColor(0, 255, 0);
			foods.drawAll();
			// initialization of EnemyAnts
			Zen.setColor(0, 0, 255);
			enemyAnts.drawAll();
			enemyAnts.moveAll(foods, enemyAnts);
			// ----------------------------

			// Protect your eyes
//			JLabel text = new JLabel (playerA+" has "+ants.getAnts()+" remaining ants, while "+playerB+" has "+enemyAnts.getAnts());
//			text.setFont(new Font("Serif", Font.PLAIN, 10));
//			status.add(text);
//			status.setSize(200,200);
//			status.setVisible(true);
			System.out.println(playerA+" has "+ants.getAnts()+" remaining ants, while "+playerB+" has "+enemyAnts.getAnts());
			// initialization of Leaders
			Zen.setColor(255, 255, 255);
			leaderA.drawLeaderAnt(foods, ants);
			Zen.setColor(255, 255, 0);
			leaderB.drawLeaderAnt(foods, enemyAnts);
			if (ants.getAnts() == 0 || enemyAnts.getAnts() == 0){
				end = true;
			String winner = ((ants.getAnts()>0)?playerA:playerB);
			
			JOptionPane.showMessageDialog(null, winner+" wins the game!");
//			System.out.println(winner+" wins the game!");
			}
			//Control of leader ants. 
			String user = Zen.getEditText();
			if (user.length() != 0) {
				char c = Zen.getEditText().charAt(0);
				switch (c) {
				case 'd':
					leaderA.setX(leaderA.getX() + 1);
					break;
				case 'a':
					leaderA.setX(leaderA.getX() - 1);
					break;
				case 's':
					leaderA.setY(leaderA.getY() + 1);
					break;
				case 'w':
					leaderA.setY(leaderA.getY() - 1);
					break;
				case 'j':
					leaderB.setX(leaderB.getX() - 1);
					break;
				case 'l':
					leaderB.setX(leaderB.getX() + 1);
					break;
				case 'k':
					leaderB.setY(leaderB.getY() + 1);
					break;
				case 'i':
					leaderB.setY(leaderB.getY() - 1);
					break;
				default:
					break;
				}
				Zen.setEditText("");
			}

			// ----------------------

		}

	}
}

// class status extends JFrame{
//	 public status(){
//		 setTitle("Status");
//		 setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
//		 getContentPane().setLayout(new FlowLayout());
//		 getContentPane().add(new JLabel("THIS IS THE 2rd JFRAME"));
//		 setSize(200, 200);
//		 setVisible(true);
//	 }
// }
