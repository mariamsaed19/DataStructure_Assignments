package eg.edu.alexu.csd.datastructure.stack;

import java.util.Scanner;
/**
* Stack program implements stack method using linked list
* the output is based on operation
* it displays the final stack after every operation
*
*/
public class mainStack {


	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		Stack s =new Stack();
		int flag =1;
		while(flag!=0) {
		System.out.println("\t\t\t\t\t\tChoose option from the menu below");
		System.out.println("1: Push\r\n" + 
				"2: Pop\r\n" + 
				"3: Peek\r\n" + 
				"4: Get size\r\n" + 
				"5: Check if empty");
		int choice1=0;
		try {       
		    choice1 = Integer.parseInt(sc.next()); // Parse string into number
		} catch (NumberFormatException e) {
		   
		}
		switch (choice1) {
		case 1:
			System.out.println("Enter data please :");
			String data = sc.next();
			s.push(data);
			System.out.print("Your Stack now is : ");
			s.printStack();
			flag=menu();
			break;
		case 2:
			if(!s.isEmpty()) {
				System.out.println("you popped the element : "+s.pop());	
				System.out.print("Your Stack now is : ");
				s.printStack();
			}
			else {
				System.out.println("Your Stack is Empty !");
			}
			flag=menu();
			break;
		case 3:
			if(!s.isEmpty()) {
				System.out.println("you popped the element : "+s.peek());	
				System.out.print("Your Stack now is : ");
				s.printStack();
			}
			else {
				System.out.println("Your Stack is Empty !");
			}
			flag=menu();
			break;
		case 4:
			System.out.println("Your Stack size is : "+s.size());
			
			flag=menu();
			break;
		case 5:
			System.out.println("Is the Stack empty ? : "+s.isEmpty());
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
	 * 
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
