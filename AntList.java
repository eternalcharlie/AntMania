
public class AntList {
private Ant[] data=new Ant[0];
/**Once an ant eats a food, an new ant is born at the origin point.
 * */
public static void born(AntList ants){
	Ant a = new Ant();
	ants.addAnt(a);
}
/**Creat a given amount of ants.
 * @param count*/
public void create (int count){
	data=new Ant[count];
	for (int i=0; i<count; i++){
		data[i]=new Ant();
	}
}
public void moveAll(FoodList foods, AntList ants){
	for (int i=0;i<data.length;i++){
		data[i].move();
		data[i].eat(foods, ants);
	}
}
public void drawAll(){
	for (int i=0;i<data.length;i++){
		data[i].drawAnt();
	}
}
public void addAnt(Ant a){
	Ant[] temp=new Ant[data.length+1];
	for(int i=0;i<data.length;i++){
		temp[i]=data[i].copyAnotherAnt();
//		System.out.println("I am here");
	}
	temp[data.length]=a;
	data=temp;
}
public int getAnts(){
	return data.length;
}
}