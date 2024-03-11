package MiniProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class MyLibrary {
	private List<Book> is = new ArrayList<Book>();
	private HashMap<Integer, String> bookInfo = new HashMap<Integer, String>();
	private Scanner sc = new Scanner(System.in);
	private Connection conn;

	public static void main(String[] args) {
		MyLibrary myLib = new MyLibrary();
		try {
			myLib.connectToDatabase();
			boolean flag = false;
			while (!flag) {
				System.out.println("=====================================");
				System.out.println("도  서  관  리  시  스  템");
				System.out.println("=====================================");
				System.out.println("1.도서등록");
				System.out.println("2.도서리스트 조회");
				System.out.println("3.도서정보 조회");
				System.out.println("4.도서정보 수정");
				System.out.println("5.도서정보 삭제");
				System.out.println("6.종료");
				int choice = myLib.sc.nextInt();
				switch (choice) {
				case 1:
					System.out.println("1.도서등록");
					myLib.registerBook();
					myLib.setBookInfo();
					break;
				case 2:
					System.out.println("2.도서목록 조회");
					myLib.listUpBook();
					break;
				case 3:
					System.out.println("3.도서 정보 조회");
					myLib.getBookInfo();
					break;
				case 4:
					System.out.println("4.도서 정보 수정");
					myLib.fixBookInfo();
					break;
				case 5:
					System.out.println("5.도서 삭제");
					myLib.deleteBookInfo();
					break;
				case 6:
					flag = true;
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			myLib.closeConnection();
		}

	}

	private void connectToDatabase() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "scott", "tiger");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void closeConnection() {
		if (conn != null) {
			try {
				conn.close();
				System.out.println("데이터베이스 연결이 닫혔습니다.");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void registerBook() {
		try {
			System.out.println("(1).이름");
			String sca = sc.next();
			boolean chN = false;
			if (is != null) {
				for (Book d : is) {
					if (d.getName().equals(sca)) {
						while (!chN) {
							System.out.println("다시 입력하세요.");
							System.out.println(sca + " : ");
							System.out.println("(1).이름");
							String csca = sc.next();
							if (!d.getName().equals(csca)) {
								sca = csca;
								chN = true;
							} else
								continue;
						}
					}
				}
			}
			System.out.println("(2).지은");
			String sca1 = sc.next();
			System.out.println("(3).출판");
			String sca2 = sc.next();
	        Date date = null;
	        boolean validDate = false;
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        while (!validDate) {
	            System.out.println("(4).출판일(yyyy-MM-dd 형식)");
	            String sca3 = sc.next();
	            try {
	                date = sdf.parse(sca3);
	                validDate = true;
	            } catch (ParseException e) {
	                System.out.println("올바른 형식의 날짜를 입력하세요 (yyyy-MM-dd 형식).");
	            }
	        }
			System.out.println("(5).책번호");
			int sca4 = sc.nextInt();
			Book newBook = new Book(sca, sca1, sca2, sdf.format(date), sca4);
			is.add(newBook);
//			is.add(SetBook(sca, sca1, sca2, sca3, sca4));
//			
			storeBookInDatabase(newBook);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	private Book SetBook(String name, String author, String company, String day, int num) {
//		Book book = new Book(name, author, company, day, num);
//		return book;
//	}
	private void storeBookInDatabase(Book book) {
	    try {
	        String sql = "INSERT INTO books2 (name, author, company, day, num) VALUES (?, ?, ?, ?, ?)";
	        PreparedStatement psmt = conn.prepareStatement(sql);
	        psmt.setString(1, book.getName());
	        psmt.setString(2, book.getAuthor());
	        psmt.setString(3, book.getCompany());
	        psmt.setString(4, book.getDay());
	        psmt.setInt(5, book.getNum());
	        
	        // Execute the insert query
	        psmt.executeUpdate();
	        
	        // Close the PreparedStatement
	        psmt.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	private void listUpBook() {
	    try {
	        // SQL 쿼리 작성
	        String sql = "SELECT * FROM books2";
	        
	        // PreparedStatement 생성
	        PreparedStatement psmt = conn.prepareStatement(sql);
	        
	        // SQL 쿼리 실행하여 결과셋 가져오기
	        ResultSet rs = psmt.executeQuery();
	        
	        // 결과 출력
	        while (rs.next()) {
	            System.out.println("===============전체 책 목록==============");
	            System.out.println("도서번호 : " + rs.getInt("num"));
	            System.out.println("도서제목: " + rs.getString("name"));
	            System.out.println("도서저자: " + rs.getString("author"));
	            System.out.println("출판사: " + rs.getString("company"));
	            System.out.println("출판일: " + rs.getString("day"));
	            System.out.println("=======================================\n");
	        }
	        
	        // 자원 해제
	        rs.close();
	        psmt.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	private void setBookInfo() {
		for (Book li : is) {
			int num = li.num;
			String name = li.getName();
			bookInfo.put(num, name);
		}
	}

	private String getBookName(HashMap<Integer, String> bookInfo, int num) {
		return bookInfo.get(num);
	}

	private List<Book> getBookData(List<Book> books, String bookName) {
		List<Book> li = new ArrayList<>();
		for (Book book : books) {
			if (book.getName().equals(bookName)) {
				li.add(book);
			}
		}
		return li;
	}

	private void getBookInfo() {
		System.out.println("조회 하실 도서 번호를 입력하세요");
		int num = sc.nextInt();
		String bookName = getBookName(bookInfo, num);
		if (bookName != null) {
			List<Book> book = getBookData(is, bookName);
			for (Book li : book) {
				System.out.println("선택하신 책 정보");
				System.out.println("1.책 이름 : " + li.getName());
				System.out.println("2.지은이 : " + li.getAuthor());
				System.out.println("3.출판사 : " + li.getCompany());
				System.out.println("4.출판일 : " + li.getDay());
				System.out.println("5.책번호 : " + li.getNum());
			}
		} else {
			System.out.println("조회하신 번호가 없습니다.");
		}
	}

	private void fixBookInfo() {
		System.out.println("수정 하실 도서 번호를 입력하세요");
		int num = sc.nextInt();
		String bookName = getBookName(bookInfo, num);
		if (bookName != null) {
			List<Book> book = getBookData(is, bookName);
			Book bookData = null;
			for (Book li : book) {
				System.out.println("수정 하실 정보 번호를 입력하세요");
				System.out.println("1.책 이름 : " + li.getName());
				System.out.println("2.지은이 : " + li.getAuthor());
				System.out.println("3.출판사 : " + li.getCompany());
				System.out.println("4.출판일 : " + li.getDay());
				System.out.println("5.책번호 : " + li.getNum());
				bookData = li;
			}
			int sca = sc.nextInt();
			switch (sca) {
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

	private void deleteBookInfo() {
		System.out.println("삭제 하실 도서 번호를 입력하세요.");
		int num = sc.nextInt();
		String bookName = getBookName(bookInfo, num);
		for (Book li : is) {
			if (li.getName().equals(bookName)) {
				is.remove(li);
				bookInfo.remove(num);
				System.out.println("삭제가 완료되었습니다");
				break;
			}
		}
	}
}
