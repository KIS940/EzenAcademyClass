package Practice.Restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Order{
//주문 정보를 나타내는 클래스로, 주문된 음식과 총 가격 등을 저장합니다.
	private List<MenuItem> _menus = new ArrayList<>();
	private Scanner sc = new Scanner(System.in);
	
	public List<MenuItem> menus = _menus;
	
	public void SetMenu(String menuName, int menuPrice, int menuCount)
	{
		_menus.add(SetMenuItem(menuName, menuPrice, menuCount));
	}
	
	private MenuItem SetMenuItem(String menuName, int menuPrice, int menuCount)
	{
		MenuItem menuItem = new MenuItem(menuName, menuPrice, menuCount);
		return menuItem;
	}
}
