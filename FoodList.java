/**What foods can do as a group.
 * @author weichen7, sichen5*/
public class FoodList {
	private Food data[]=new Food[0];
	public Food getFood(int i){
		return data[i];
	}
	public void dropFood(int count){
		data=new Food[count];
		for (int i=0;i<count;i++){
			data[i]=new Food();
			System.out.println(data[i].getX()+""+data[i].getY());
		}
	}
	public void drawAll(){
		for (int i=0;i<data.length;i++){
			data[i].drawFood();
		}
	}
	public int getQuantity(){
		return data.length;
	}
}
