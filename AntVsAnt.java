public class AntVsAnt {
//问题是：在运行过一段时间之后，死掉的蚂蚁会重生。
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		boolean end = false;
		AntList ants = new AntList();
		ants.create(10);
		// ------------
		FoodList foods = new FoodList();
		foods.dropFood(10);
		// ------------
		EnemyAntList enemyAnts = new EnemyAntList();
		enemyAnts.create(10);
		// --------------
		LeaderAnt leaderA = new LeaderAnt();
		while (Zen.isRunning()&&!end) {
//			ants.drawAll();

//			ants.clearBattleLand();
//			enemyAnts.clearBattleLand();
			Zen.flipBuffer();
			// initialization of background
			Zen.setColor(0, 0, 0);
			Zen.fillRect(0, 0, Zen.getZenWidth(), Zen.getZenHeight());
			// initialization of ants
			Zen.setColor(255, 0, 0);
			ants.drawAll();
			ants.moveAll(foods, ants,enemyAnts);
			// initialization of foods
			Zen.setColor(0, 255, 0);
			foods.drawAll();
			// initialization of EnemyAnts
			Zen.setColor(0, 0, 255);
			enemyAnts.drawAll();
			enemyAnts.moveAll(foods, enemyAnts);
			// Protect your eyes
			System.out.println(ants.getAnts());
			System.out.println(enemyAnts.getAnts());
			// initialization of Leaders
			Zen.setColor(255, 255, 255);
			leaderA.drawLeaderAnt(foods, ants);
			if (ants.getAnts()==0||enemyAnts.getAnts()==0)
				end=true;
			String user = Zen.getEditText();
			if (user.length() != 0) {
				char c = Zen.getEditText().charAt(0);
				switch (c) {
				case 'd':
					leaderA.setX(leaderA.getX( )+1);
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
				default:
					break;
				}
				Zen.setEditText("");
			}
			leaderA.drawLeaderAnt(foods, ants);
//			 ----------------------

	}
	

}
}
