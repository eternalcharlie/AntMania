public class LeaderAnt extends Ant {
	private int w,h;
	public void move() {

	}
//	
	public void eat(FoodList foods, AntList ants){
		super.eat(foods, ants);
		w++;
		h++;
	}
	public void drawLeaderAnt(FoodList foods, AntList ants) {
		Zen.fillRect(super.getX(), super.getY(), w, h);
//		System.out.println(super.getX()+" , "+super.getY());
		super.eat(foods, ants);//need fix!!!!
	}
	
	
	public LeaderAnt() {
		super();
		w=10;
		h=10;
		super.setX(2);
		super.setY(2);
	}
}