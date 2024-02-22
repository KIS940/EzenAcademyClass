package MiniProject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Library {

	public static void main(String[] args) {
		Library library = new Library();
		BookEx book1 = new BookEx("이것이자바다","신용권","한빛","2012.2.12",1);
//		BookEx book2 = new BookEx("이것이C다","신요권","한빛","2011.1.11",3);
//		BookEx book3 = new BookEx("이것이C++다","시용권","한빛","2013.3.13",4);
//		BookEx book4 = new BookEx("이것이C#다","신용궈","한빛","2014.4.14",2);

		List<BookEx> books = new ArrayList<>();
		books.add(book1);
//		books.add(book2);
//		books.add(book3);
//		books.add(new BookEx("이것이C#다","신용궈","한빛","2014.4.14",2));
		
		HashMap<Integer, String> bookInfo = new HashMap<Integer, String>();
		
		for(BookEx li : books)
		{
			int num = li.num;
			String name = li.name;
			bookInfo.put(num, name);
		}

		String bookName = library.GetBookName(bookInfo, 1);
		List<BookEx> book = library.GetBookInfo(books, bookName);
		for(BookEx li : book)
		{
			System.out.println("선택하신 책 정보");
			System.out.println("1.책 이름 : " + li.getName());
			System.out.println("2.지은이 : " + li.getAuthor());
			System.out.println("3.출판사 : " + li.getCompany());
			System.out.println("4.출판일 : " + li.getDay());
			System.out.println("5.책번호 : " + li.getNum());
		}
			
	}
	
	public String GetBookName(HashMap<Integer, String> bookInfo, int num)
	{
		return bookInfo.get(num);
	}
	
	public List<BookEx> GetBookInfo(List<BookEx> books, String bookName)
	{
		List<BookEx> li= new ArrayList<>();
		for (BookEx book : books) {
            if (book.name.equals(bookName)) {
                li.add(book);
            }
        }
		return li;
	}
}
