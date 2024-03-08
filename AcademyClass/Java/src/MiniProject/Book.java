package MiniProject;

public class Book {
	   private String name;
	   public String name2 = name;
	   String author;
	   String company;
	   String day;
	   int num;
	   public Book(String name, String author, String company, String day, int num) {
	      this.name = name;
	      this.author = author;
	      this.company = company;
	      this.day = day;
	      this.num = num;
	   }
	   public String getName() {
	      return name;
	   }
	   public void setName(String name) {
	      this.name = name;
	   }
	   public String getAuthor() {
	      return author;
	   }
	   public void setAuthor(String author) {
	      this.author = author;
	   }
	   public String getCompany() {
	      return company;
	   }
	   public void setCompany(String company) {
	      this.company = company;
	   }
	   public String getDay() {
	      return day;
	   }
	   public void setDay(String day) {
	      this.day = day;
	   }
	   public int getNum() {
	      return num;
	   }
	   public void setNum(int num) {
	      this.num = num;
	   }
}
