
public class Food {
	private int x,y;
	private boolean eaten=false;
	public Food(){
		x=1+((int)(Zen.getZenWidth()*Math.random())-1);
		y=1+((int)(Zen.getZenHeight()*Math.random())-1);
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public void drawFood(){
		if (!eaten)
		Zen.fillRect(x, y, 2, 2);
//		System.out.println("Drawing food.");
	}
	public void eaten(FoodList foods){
		eaten=true;
		foods.drawAll();
	}
	public boolean isEaten(){
		return eaten;
	}
}
