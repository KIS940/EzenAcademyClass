package MiniProject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class EX {
    private List<Book> is = new ArrayList<Book>();
    private HashMap<Integer, String> bookInfo = new HashMap<Integer, String>();
    private Scanner sc = new Scanner(System.in);
 	
	public static void main(String[] args) {
		EX ex = new EX();

		boolean flag = false;
		while(!flag)
		{
			System.out.println("=====================================");
			System.out.println("도  서  관  리  시  스  템");
			System.out.println("=====================================");
			System.out.println("1.도서등록");
			System.out.println("2.도서리스트 조회");
			System.out.println("3.도서정보 조회");
			System.out.println("4.도서정보 수정");
			System.out.println("5.도서정보 삭제");
			System.out.println("6.종료");
			int choice = ex.sc.nextInt();
			switch(choice)
			{
				case 1:
					System.out.println("1.도서등록");
					ex.RegisterBook();
					ex.SetBookInfo();
					break;
				case 2:
					System.out.println("2.도서목록 조회");
					ex.ListUpBook();
					break;
				case 3:
					System.out.println("3.도서 정보 조회");
					ex.GetBookInfo();
					break;
				case 4:
					System.out.println("4.도서 정보 수정");
					ex.FixBookInfo();
					break;
				case 5:
					System.out.println("5.도서 삭제");
					ex.DeleteBookInfo();
					break;
				case 6:
					flag = true;
					break;	
			}
		}
	}

	private void RegisterBook()
	{
		System.out.println("(1).이름");
		String sca = sc.next();
		boolean chN = false;
		if(is != null)
		{
			for(Book d : is)
			{
				if(d.getName().equals(sca))
				{
					while(!chN)
					{
						System.out.println("다시 입력하세요.");
						System.out.println(sca + " : ");
						System.out.println("(1).이름");
						String csca = sc.next();
						if(!d.getName().equals(csca))
						{
							sca = csca;
							chN = true;
						}
						else
							continue;
					}
				}
			}
		}
		System.out.println("(2).지은");
		String sca1 = sc.next();
		System.out.println("(3).출판");
		String sca2 = sc.next();
		System.out.println("(4).출판일");
		String sca3 = sc.next();
		System.out.println("(5).책번호");
		int sca4 = sc.nextInt();

		is.add(SetBook(sca,sca1,sca2,sca3,sca4));
		
		
//		if(bookInfo != null)
//		{
//			String checkName = GetBookName(bookInfo, sca4);
//			if(checkName != null)
//			{
//				System.out.println("다시 입력하세요.");
//				System.out.println("(1).이름");
//				String csca = sc.next();
//				System.out.println("(2).지은");
//				String csca1 = sc.next();
//				System.out.println("(3).출판");
//				String csca2 = sc.next();
//				System.out.println("(4).출판일");
//				String csca3 = sc.next();
//				System.out.println("(5).책번호");
//				int csca4 = sc.nextInt();
//				is.add(SetBook(csca,csca1,csca2,csca3,csca4));
//			}
//			else
//				is.add(SetBook(sca,sca1,sca2,sca3,sca4));
//
//		}
//		else
//			is.add(SetBook(sca,sca1,sca2,sca3,sca4));
	}
	
	private Book SetBook(String name, String author, String company, String day, int num)
	{
		Book book = new Book(name,author,company,day,num);
		return book;
	}
	
	private void ListUpBook()
	{
		int count = 0;
		for(Book li : is)
		{
			++count;
			System.out.println("[" + count + ". ]" + li.getName());
		}	
	}
	
	private void SetBookInfo()
	{
		for(Book li : is)
		{
			int num = li.num;
			String name = li.name;
			bookInfo.put(num, name);
		}
	}
	
	private String GetBookName(HashMap<Integer, String> bookInfo, int num)
	{
		return bookInfo.get(num);
	}
	
	private List<Book> GetBookData(List<Book> books, String bookName)
	{
		List<Book> li= new ArrayList<>();
		for (Book book : books) {
            if (book.name.equals(bookName)) {
                li.add(book);
            }
        }
		return li;
	}
	
	private void GetBookInfo()
	{
		System.out.println("조회 하실 도서 번호를 입력하세요");
		int num = sc.nextInt();
		String bookName = GetBookName(bookInfo, num);
		if(bookName != null)
		{			
			List<Book> book = GetBookData(is, bookName);
			for(Book li : book)
			{
				System.out.println("선택하신 책 정보");
				System.out.println("1.책 이름 : " + li.getName());
				System.out.println("2.지은이 : " + li.getAuthor());
				System.out.println("3.출판사 : " + li.getCompany());
				System.out.println("4.출판일 : " + li.getDay());
				System.out.println("5.책번호 : " + li.getNum());
			}
		}
		else
		{
			System.out.println("조회하신 번호가 없습니다.");
		}
	}
	
	private void FixBookInfo() 
	{
		System.out.println("수정 하실 도서 번호를 입력하세요");
		int num = sc.nextInt();
		String bookName = GetBookName(bookInfo, num);
		if(bookName != null)
		{
			List<Book> book = GetBookData(is, bookName);
			Book bookData = null;
			for(Book li : book)
			{
				System.out.println("수정 하실 정보 번호를 입력하세요");
				System.out.println("1.책 이름 : " + li.getName());
				System.out.println("2.지은이 : " + li.getAuthor());
				System.out.println("3.출판사 : " + li.getCompany());
				System.out.println("4.출판일 : " + li.getDay());
				System.out.println("5.책번호 : " + li.getNum());
				bookData = li;
			}
			int sca = sc.nextInt();
			switch(sca)
			{
			case 1:
				System.out.println("수정 하실 내용을 입력하세요");
				System.out.print("1.책 이름 : ");
				String st1 = sc.next();
				bookData.setName(st1);
				break;
			case 2:
				System.out.println("수정 하실 내용을 입력하세요");
				System.out.print("2.지은이 : ");
				String st2 = sc.next();
				bookData.setAuthor(st2);
				break;
			case 3:
				System.out.println("수정 하실 내용을 입력하세요");
				System.out.print("3.출판사 : ");
				String st3 = sc.next();
				bookData.setCompany(st3);
				break;
			case 4:
				System.out.println("수정 하실 내용을 입력하세요");
				System.out.print("4.출판일 : ");
				String st4 = sc.next();
				bookData.setDay(st4);
				break;
			case 5:
				System.out.println("수정 하실 내용을 입력하세요");
				System.out.print("5.책번호 : ");
				int st5 = sc.nextInt();
				bookData.setNum(st5);
				break;
			}
		}
	}
	
	private void DeleteBookInfo()
	{
//		List<String> bookNames = new ArrayList<String>();
//		for(BookEx li : is)
//		{
//			String name = li.getName();
//			bookNames.add(name);
//		}
//		int count = 0;
//		for(String name : bookNames)
//		{
//			++count;
//			System.out.println(count + "." + name + " ");
//		}
		System.out.println("삭제 하실 도서 번호를 입력하세요.");
		int num = sc.nextInt();
		String bookName = GetBookName(bookInfo, num);
		for(Book li : is)
		{
			if(li.getName().equals(bookName))
			{
				is.remove(li);
				bookInfo.remove(num);
				System.out.println("삭제가 완료되었습니다");
				break;
			}
		}
	}
}
