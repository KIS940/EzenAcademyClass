package Practice.Restaurant;

public class MenuItem {
//음식 메뉴를 나타내는 클래스로, 이름, 가격, 재고 수량 등의 속성을 가집니다.
	String foodName;
	int foodPrice;
	int foodCount;
	
	public MenuItem(String foodName, int foodPrice, int foodCount) {
		this.foodName = foodName;
		this.foodPrice = foodPrice;
		this.foodCount = foodCount;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public int getFoodPrice() {
		return foodPrice;
	}

	public void setFoodPrice(int foodPrice) {
		this.foodPrice = foodPrice;
	}

	public int getFoodCount() {
		return foodCount;
	}

	public void setFoodCount(int foodCount) {
		this.foodCount = foodCount;
	}
	
	
}
