public class LeaderAnt extends Ant {
	private int w,h;
	public void move() {

	}
//	
//	public void eat(FoodList foods, AntList ants){
//		super.eat(foods, ants);
//		w++;
//		h++;
//	}
	public void drawLeaderAnt(FoodList foods, AntList ants) {
		Zen.fillRect(super.getX(), super.getY(), 2, 2);
//		System.out.println(super.getX()+" , "+super.getY());
		super.eat(foods, ants);//need fix!!!!
	}
	
	
	public LeaderAnt() {
		super();
//		w=2;
//		h=2;
		super.setX(10);
		super.setY(10);
	}
}