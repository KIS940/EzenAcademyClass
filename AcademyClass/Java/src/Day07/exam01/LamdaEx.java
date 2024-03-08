package Day07.exam01;

public class LamdaEx {

	public static void main(String[] args) {
		Person person = new Person();
		person.action(() ->{
			System.out.println("출근을 합니다.");
			System.out.println("프로그래밍을 합니다.");
		});
		
		person.action(() -> System.out.println("퇴근합니다."));
	}

}
