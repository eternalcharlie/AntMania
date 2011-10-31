
public class EnemyAntList {
	private EnemyAnt[] data=new EnemyAnt[0];
	public static int deadAnts=0;
	/**Once an ant eats a food, an new ant is born at the origin point.
	 * */
	public static void born(EnemyAntList enemyAnts){
		EnemyAnt a = new EnemyAnt();
		enemyAnts.addAnt(a);
	}
	/**Create a given amount of ants.
	 * @param count*/
	public void create (int count){
		data=new EnemyAnt[count];
		for (int i=0; i<count; i++){
			data[i]=new EnemyAnt();
		}
	}
	public void moveAll(FoodList foods, EnemyAntList enemyAnts){
		for (int i=0;i<data.length;i++){
			data[i].move();
			data[i].eat(foods, enemyAnts);
		}
	}
	public void drawAll(){
		for (int i=0;i<data.length;i++){
			
			data[i].drawAnt();
		}
	}
	public void addAnt(EnemyAnt a){
		EnemyAnt[] temp=new EnemyAnt[data.length+1];
		for(int i=0;i<data.length;i++){
			temp[i]=data[i].copyAnotherAnt();
//			System.out.println("I am here");
		}
		temp[data.length]=a;
		data=temp;
	}
	public int getAnts(){
		return data.length-deadAnts;
//		return data.length;
	}
	public EnemyAnt getAnt(int i){
		return data[i];
	}
	public void clearBattleLand(){
		EnemyAnt [] temp = new EnemyAnt[data.length-deadAnts];
		for (int i=0;i<data.length-deadAnts;i++){
			temp[i]=data[data[i].isDead()?i+1:i];
		}
		data=temp;
	}

}
