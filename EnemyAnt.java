
public class EnemyAnt{
	private int x,y;
	private boolean dead=false;
	private boolean lasergun;
	
	public void fight(){
		
	}
	/**@param foods*/
	public void eat(FoodList foods, EnemyAntList enemyAnts){
		if (!dead){
		for (int i=0;i<foods.getQuantity();i++){
			if (Math.abs(foods.getFood(i).getX()-x)<2&&Math.abs(foods.getFood(i).getY()-y)<2&&!foods.getFood(i).isEaten()){
				EnemyAntList.born(enemyAnts);
				foods.getFood(i).eaten(foods);
			}
			}
		}
	}
	public void move(){
		if(dead){}
		else{
		x=(x>Zen.getZenWidth()?x-Zen.getZenWidth()+20:x);
		x=(x<0)?Zen.getZenWidth():x;
		y=(y>Zen.getZenHeight()?y-Zen.getZenHeight()-20:y);
		y=(y<0?Zen.getZenHeight():y);
		{
			int direction=(int)(4*Math.random())+1;
			switch (direction){
			case 1: x++; break;
			case 2: y++; break;
			case 3: x--; break;
			case 4: y--; break;
			default: break;
			}
		}
		}
	}
	public void Kill(){
		if (!dead){
		dead=true;
		EnemyAntList.deadAnts++;
		}
		}
	public void drawAnt(){
		if(!dead)
		Zen.fillRect(x, y, 5, 5);
		}
	public EnemyAnt(){
		x=(Zen.getZenWidth())/4;
		y=(Zen.getZenHeight())/4;
	}
	public EnemyAnt copyAnotherAnt(){
		EnemyAnt copy = new EnemyAnt();
		copy.x=x;
		copy.y=y;
		copy.dead=dead;
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
