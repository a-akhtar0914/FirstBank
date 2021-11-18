import java.util.Scanner;

public class FirstBank {
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		System.out.println("please Enter your Name: ");
		String name = sc.nextLine();//gets user input using scanner to scan method, this makes the program more personal with actual names being used.
		System.out.println("please Enter your Account ID: ");
		String ID = sc.nextLine();
		Account User = new Account( name , ID);
		User.showMenu();
		
	}

}
