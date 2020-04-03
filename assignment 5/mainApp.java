package eg.edu.alexu.csd.datastructure.stack;

import java.util.Scanner;
/**
 * user interface to convert infix expression to postfix
 * and evaluate numeric postfix expressions
 * @author DELL
 *
 */
public class mainApp {

	public static void main(String[] args) {
		ExpressionEvaluator x=new ExpressionEvaluator();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		int flag =1;
		while(flag!=0) {
		System.out.println("\t\t\t\t\t\tChoose option from the menu below");
		System.out.println("1: Convert From infix To postfix\r\n" + 
				"2: Evaluate a postfix numeric expression" );
		int choice1=0;
		try {       
		    choice1 = Integer.parseInt(sc.next()); // Parse string into number
		} catch (NumberFormatException e) {
		   
		}
		switch (choice1) {
		case 1:
			System.out.println("Enter a Valid infix expression please :");
			sc.nextLine();
			String data = sc.nextLine();
			try {
				x.infixToPostfix(data);
				System.out.println("Your postfix expression is : "+x.infixToPostfix(data));
			}
			catch(Exception e) {
				System.out.println("Invalid Expression Format !");
			}
			flag=menu();
			break;
		case 2:
			System.out.println("Enter a Valid numeric postfix expression please :");
			String data2 = sc.next();
			try {
				x.evaluate(data2);
				System.out.println("Your result of the postfix expression is :   "+x.evaluate(data2));
			}
			catch(Exception e) {
				System.out.println("Invalid Expression Format !");
			}

			flag=menu();
			break;

		default :
			System.out.println("Invalid Choice !");
		}
	}
		System.out.println("End Of Program");
	}
	/**
	 * menu function is used to display two options after every operation
	 * 1 go back to menu 
	 * 0 end the program
	 * @return choice number
	 */
	public static int menu(){
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
	    System.out.println(" back to menu >>1    exit>>0");  
		int a = -1;
		try {       
		    a = Integer.parseInt(sc.next()); // Parse string into number
		} catch (NumberFormatException e) {
		   
		}
		while(a!=0&&a!=1){
			System.out.println("Invalid choice !");
			System.out.println(" back to menu >>1    exit>>0");
			try {       
			    a = Integer.parseInt(sc.next()); // Parse string into number
			} catch (NumberFormatException e) {
			   
			}
		}
		return a;
	}

}
