public class Ant{
	private int x,y;
	private boolean dead=false;
	private boolean lasergun;
	public void fight(){
		
	}
	/**@param foods*/
	public void eat(FoodList foods, AntList ants){
		for (int i=0;i<foods.getQuantity();i++){
			if (Math.abs(foods.getFood(i).getX()-x)<2&&Math.abs(foods.getFood(i).getY()-y)<2&&!foods.getFood(i).isEaten()){
				AntList.born(ants);
				foods.getFood(i).eaten(foods);
			}
		}
	}
	public void move(){
		x=(x>Zen.getZenWidth()?x-Zen.getZenWidth()+20:x);
		x=(x<Zen.getZenWidth()?x:x);
		y=(y>Zen.getZenHeight()?y-Zen.getZenHeight()-20:y);
		y=(y<Zen.getZenHeight()?y:y);
		if(!dead){
			int antdirection=(int)(4*Math.random())+1;
			switch (antdirection){
			case 1: x++; break;
			case 2: y++; break;
			case 3: x--; break;
			case 4: y--; break;
			default: break;
			}
		}
	}
	public void Kill(){
		dead=true;
	}
	public void drawAnt(){
		Zen.fillRect(x, y, 5, 5);
	}
	public Ant(){
		x=0;
		y=0;
	}
	public Ant copyAnotherAnt(){
		Ant copy = new Ant();
		copy.x=x;
		copy.y=y;
		return copy;
	}
	public void setX(int xx){
		x=xx;
	}
	public void setY(int yy){
		y=yy;
	}
	public boolean isDead (){
		return dead;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
}



