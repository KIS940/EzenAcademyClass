package Practice.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class Menus{
// 메뉴정보를 보여주는 클래스로, 맨처음 세팅된 메뉴아이템 정보를 보여줍니다.
	private List<MenuItem> _menusList = new ArrayList<>();
	
	public void setMenu(String menuName, int menuPrice, int menuCount)
	{
		_menusList.add(setMenuItem(menuName, menuPrice, menuCount));
	}
	
	public List<MenuItem> getMenu()
	{
		return _menusList;
	}
	
	private MenuItem setMenuItem(String menuName, int menuPrice, int menuCount)
	{
		MenuItem menuItem = new MenuItem(menuName, menuPrice, menuCount);
		return menuItem;
	}
}
