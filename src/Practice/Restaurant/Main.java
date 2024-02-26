package Practice.Restaurant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
	private Order order = new Order();
	private Scanner scanner = new Scanner(System.in);
	private HashMap<Integer, String> storeFood = new HashMap<Integer, String>();

	private boolean isMenuSetting = false;
	private boolean isSameName = false;
//	private boolean isCheckMenuSetting = false;

	public static void main(String[] args) {
		Main main = new Main();
		main.SettingMenu();
	}

	private void SettingMenu()
	{
		while(!isMenuSetting)
		{
			System.out.println("메뉴판을 설정해주세요.");
			System.out.println("1.메뉴 이름");
			String name = scanner.next();
			if(order.menus != null)
			{
				for(MenuItem menu : order.menus)
				{
					if(menu.getFoodName().equals(name))
					{
						while(!isSameName)
						{
							System.out.println("중복된 메뉴 이름이 있습니다, 다시 입력하세요.");
							String name2 = scanner.next();
							if(!menu.getFoodName().equals(name2))
							{
								name = name2;
								isSameName = true;
							}
						}
					}
				}
			}
			System.out.println("2.메뉴 가격");
			int price = scanner.nextInt();
			System.out.println("3.메뉴 재고 수량");
			int count = scanner.nextInt();

			order.SetMenu(name, price, count);

			System.out.println("메뉴판을 더 설정하시겠습까? Y/N");
			String text = scanner.next();
			CheckMenu(text);
		}
	}

	private void CheckMenu(String text)
	{
		if(text.equals("n") || text.equals("N"))
		{
			System.out.println("메뉴 설정이 끝났습니다.");
			isMenuSetting = true;
		}
		else if(text.equals("y") || text.equals("Y"))
		{
			isMenuSetting = false;
		}
	}

	private void ShowMenu()
	{
		System.out.println("메뉴를 선택하고 카트에 담아주세요");
		int count = 0;
		for(MenuItem menu : order.menus)
		{
			++count;
			System.out.println(count + ". " + menu.getFoodName());
			storeFood.put(count, menu.getFoodName());
		}
		int choice = scanner.nextInt();
		if(storeFood.get(choice) != null)
		{
			List<MenuItem> choiceMenu = FindFoodInfo(order.menus, storeFood.get(choice));
			for(MenuItem menu : choiceMenu)
			{
				System.out.println("선택하신 메뉴는 " + menu.getFoodName() + " 입니다.");
				System.out.println("선택하신 메뉴 가격은 " + menu.getFoodPrice() + " 입니다");
				System.out.println("선택하신 메뉴 재고는 " + menu.getFoodCount() + " 입니다");
				System.out.println("선택하신 메뉴를 카트에 담으시겠습니까? Y/N");
				String text = scanner.next();
				if(text.equals("n") || text.equals("N"))
				{
					System.out.println(".");
				}
				else if(text.equals("y") || text.equals("Y"))
				{
					System.out.println("카트에 담겼습니다.");
				}
			}
		}
		else
		{
			System.out.println("선택하신 메뉴가 없습니다.");
		}
	}
	private List<MenuItem> FindFoodInfo(List<MenuItem> menuItemList, String name)
	{
		List<MenuItem> menuItems = new ArrayList<>();
		for(MenuItem menu : menuItemList)
		{
			if(menu.getFoodName().equals(name))
				menuItems.add(menu);
		}
		return menuItems;
	}
}
