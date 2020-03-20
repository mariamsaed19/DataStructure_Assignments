package eg.edu.alexu.csd.datastructure.linkedList.cs76_cs88;

import java.util.Scanner;

public class Mainlink {
  	static Polynomial poly = new Polynomial();
	static Scanner sc = new Scanner(System.in);
	public static int menu(){
	    System.out.println(" back to menu >>1    exit>>0");  
		int a = sc.nextInt();
		while(a!=0&&a!=1){
			System.out.println("Invalid choice !");
			System.out.println(" back to menu >>1    exit>>0");
			a=sc.nextInt();
		}
		return a;
	}
	public static char checkVar(int z){
	    char c ;
	   String str;
	    if(z==1){
	    System.out.println("Enter a variable (A,B or C)");
	    str = sc.nextLine();
	    if(str.length()>1) {
	    	c='x';
	    }
	    else {
	     c = str.charAt(0);
		c = Character.toUpperCase(c); 
	    }
		 while(c!='A'&&c!='B'&&c!='C'){
	         System.out.println("wrong variable \n Enter again");
	         str=sc.nextLine();
	         if(str.length()>1) {
	        	 c='z';
	         }
	         else {
	         c = str.charAt(0);
		     c = Character.toUpperCase(c); 
	         }
		}
	    }
	    else {
	        System.out.println("Enter a variable (A,B , C or R)");
	        str=sc.nextLine();
	        if(str.length()>1) {
	        	c='z';
	        }
	        else {
			c = str.charAt(0);
			c = Character.toUpperCase(c);
	        }
			while(c!='A'&&c!='B'&&c!='C'&&c!='R'){
				 System.out.println("wrong variable \n Enter again");
			        str=sc.nextLine();
			        if(str.length()>1) {
			        	c='z';
			        }
			        else {
					c = str.charAt(0);
					c = Character.toUpperCase(c);
			        }
		     }
	    }
		
		return c ;
	}
	public static char checkSet(char x){
	    while(poly.print(x)==null){
			System.out.println("variable not set  \n Enter again  or enter 1 >> menu , 0 >> exit");
			x= sc.next().charAt(0);
			if(Character.isDigit(x)){
			    return x;
			}
			else{
			x = Character.toUpperCase(x);		            
			}
	    }
			
	    return x ;
	}
	public static void main(String[] args) {

	  	int flag=1 ;
	 	System.out.println("\t\t\t\t\tPolynomial Solver");
	 	while(flag==1) {
			System.out.println("Choose an option");
			System.out.println("1- Set a polynomial variable\n2- Print the value of a polynomial variable\n3- Add two polynomials\n4- Subtract two polynomials\n5- Multiply two polynomials\n6- Evaluate a polynomial at some point\n7- Clear a polynomial variable");
			int choice1=0;
			try {       
			    choice1 = Integer.parseInt(sc.next()); // Parse string into number
			} catch (NumberFormatException e) {
			   
			}
			   sc.nextLine();
			switch(choice1) {
			case 1 :
		        char c = checkVar(1);
		        System.out.println("Insert the polynomial terms in the form:\n\t(coeff1, exponent1), (coeff2, exponent2), ..");
		        String str = sc.nextLine();
		        str= poly.modify(str);
	            String[] arrstr = str.trim().split("[,]"); 
		        int[][]arr=new int[arrstr.length/2][2];
		        int z=0;
		        for(int i=0;i<arrstr.length/2;i++){
		                arr[i][0]=Integer.parseInt(arrstr[z]);
		                z++;
		                arr[i][1]=Integer.parseInt(arrstr[z]);
		                z++;  
		        }
		        poly.setPolynomial(c, arr);
		        System.out.println("variable set");
		        flag= menu();
		        break;
			  case 2:
			        char c1 = checkVar(2);
			        c1=checkSet(c1);
			        if(Character.isDigit(c1)) {
			        	flag=Character.getNumericValue(c1);
			        	break;
			        }
			       String ans = poly.print(c1);
			       System.out.println(">> "+ans);
			        flag=menu();
			        break;
			  case 3 :
			      System.out.println("Insert first operand");
			        char first = checkVar(1);
			        first=checkSet(first);
			        if(Character.isDigit(first)) {
			        	flag=Character.getNumericValue(first);
			        	break;
			        }
			         System.out.println("Insert second operand");
			        char second = checkVar(1);
			        second = checkSet(second);
			        if(Character.isDigit(second)) {
			        	flag=Character.getNumericValue(second);
			        	break;
			        }
			       
			        int[][]ans2= poly.add(first,second);
			        System.out.print("Result set in R : ");
			        for(int i=0;i<ans2.length;i++){
			            System.out.print("("+ans2[i][0] +"," + ans2[i][1] + ") ");
			        }
			        System.out.println(" ");
			        flag=menu();
			     
			        break;
			  case 4:
			      System.out.println("Insert first operand ");
			        char first1 = checkVar(1);
			        first1=checkSet(first1);
			        if(Character.isDigit(first1)) {
			        	flag=Character.getNumericValue(first1);
			        	break;
			        }
			         System.out.println("Insert second operand");
			        char second1 = checkVar(1);
			        second1=checkSet(second1);
			        if(Character.isDigit(second1)) {
			        	flag=Character.getNumericValue(second1);
			        	break;
			        }
			        int[][]ans1= poly.subtract(first1,second1);
			        System.out.print("Result set in R : ");
			        for(int i=0;i<ans1.length;i++){
			            System.out.print("("+ans1[i][0] +"," + ans1[i][1] + ") ");
			        }
			        System.out.println(" ");
			        flag=menu();
			        break;
			  case 5 :
			      System.out.println("Insert first operand");
			        char first3 = checkVar(1);
			        first3=checkSet(first3);
			        if(Character.isDigit(first3)) {
			        	flag=Character.getNumericValue(first3);
			        	break;
			        }
			         System.out.println("Insert second operand");
			        char second3 = checkVar(1);
			        second3=checkSet(second3);
			        if(Character.isDigit(second3)) {
			        	flag=Character.getNumericValue(second3);
			        	break;
			        }
			        int[][]ans3= poly.multiply(first3,second3);
			        System.out.print("Result set in R : ");
			        for(int i=0;i<ans3.length;i++){
			            System.out.print("("+ans3[i][0] +"," + ans3[i][1] + ") ");
			        }
			        System.out.println(" ");
			        flag=menu();
			        break;
			  case 6 :
			        char choice6 = checkVar(2);
			        choice6=checkSet(choice6);
			        if(Character.isDigit(choice6)) {
			        	flag=Character.getNumericValue(choice6);
			        	break;
			        }
			        System.out.println("Enter the value");
			        float value = 0 ;
			        boolean v=false;
			        while (v==false) {
						try {       
						    value = Float.parseFloat(sc.next()); // Parse string into number
						    v=true;
						} catch (NumberFormatException e) {
						   System.out.println("Invalid Input Enter again");
						}
			        }
			        float ans5 = poly.evaluatePolynomial(choice6,  value);
			        System.out.println("the Result =" + ans5);
			        
			        flag=menu();
			        break;
			  case 7 :
			        char choice7 = checkVar(1);
			        poly.clearPolynomial(choice7);
			        System.out.println("Done !");
			        flag=menu();
			        break;
			        
			  default :
			  System.out.println("wrong choice !");
			   break;
		        
				
			}
	 	}
	 	System.out.println("end of program");	 	
	 	
	}
}