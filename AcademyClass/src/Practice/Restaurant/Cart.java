package Practice.Restaurant;

import java.util.List;

public class Cart {
//사용자의 장바구니를 나타내는 클래스로, 음식을 추가하고 제거하는 기능을 제공합니다.
	private List<MenuItem> _items;
	private int _totalPrice = 0;
	
	public void AdditionFood(MenuItem item)
	{
		_items.add(item);
	}
	public void RemoveFood(MenuItem item)
	{
		_items.remove(item);
	}
	
	public void TotalItemPrice()
	{
		_totalPrice = 0;
		for(MenuItem item : _items)
		{
			_totalPrice += item.foodPrice;
		}
	}
	
	public int GetTotalItemPrice()
	{
		return _totalPrice;
	}
}
