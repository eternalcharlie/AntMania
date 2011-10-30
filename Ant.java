public class Ant{
	private int x,y;
	private boolean dead=false;
	private boolean lasergun;
	public void fight(EnemyAntList enemyAnts){
		for (int i=0; i<enemyAnts.getAnts();i++){
			if (!enemyAnts.getAnt(i).isDead()&&Math.abs(enemyAnts.getAnt(i).getX()-x)<2&&Math.abs(enemyAnts.getAnt(i).getY()-y)<2){
				this.Kill();
				enemyAnts.getAnt(i).Kill();
//				Zen.setColor(0, 0, 0);
//				Zen.fillRect(0, 0, Zen.getZenWidth(), Zen.getZenHeight());
//				Zen.setColor(255, 0, 0);
//				ants.drawAll();
//				Zen.setColor(0, 255, 0);
//				foods.drawAll();
//				Zen.setColor(0, 0, 255);
//				enemyAnts.drawAll();
//				Zen.setColor(255, 255, 255);
//				leaderA.drawLeaderAnt(foods, ants);
				
			}
		}
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
		dead=true;
		AntList.deadAnts++;
	}
	public void drawAnt(){
		if(!dead)
		Zen.fillRect(x, y, 5, 5);
		
	}
	public Ant(){

		x=(3*(Zen.getZenWidth()/4));
		y=(3*(Zen.getZenHeight()/4));
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



