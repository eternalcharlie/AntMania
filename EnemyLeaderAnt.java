
public class EnemyLeaderAnt extends EnemyAnt{
	private int w,h;
	public void move() {

	}

	public void eat(FoodList foods, EnemyAntList enemyAnts){
		super.eat(foods, enemyAnts);
		w++;
		h++;
	}
	public void drawLeaderAnt(FoodList foods, EnemyAntList enemyAnts) {
		Zen.fillRect(super.getX(), super.getY(), w, h);
//		System.out.println(super.getX()+" , "+super.getY());
		super.eat(foods, enemyAnts);//need fix!!!!
	}
	
	
	public EnemyLeaderAnt() {
		super();
		w=2;
		h=2;
		super.setX(2);
		super.setY(2);
	}
}
