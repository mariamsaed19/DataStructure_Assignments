package eg.edu.alexu.csd.datastructure.linkedList.cs76_cs88;
import java.awt.Point;
import java.lang.Math;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Polynomial implements IPolynomialSolver {
/**
* Set polynomial terms (coefficients & exponents)
* @param poly
* name of the polynomial
* @param terms
* array of [coefficients][exponents]
*/

public SingleLinked Alinked = new SingleLinked();
public SingleLinked Blinked = new SingleLinked();
public SingleLinked Clinked = new SingleLinked();
public SingleLinked result = new SingleLinked();
public void setPolynomial(char poly, int[][] terms){
 
     switch(poly){
         case 'A':
             this.arraytolist(terms, Alinked);
             break;
        case 'B':
             this.arraytolist(terms, Blinked);
             break;
        case 'C':
             this.arraytolist(terms, Clinked);
             break; 
     }
 }   


/**
* Print the polynomial in ordered human readable representation
* @param poly
* name of the polynomial
* @return polynomial in the form like 27x^2+x-1
*/
public String print(char poly){
    StringBuilder str = new StringBuilder();
    int flag =0;
    Node curr=null;
    switch(poly){
    case 'A':
       curr = Alinked.head;
        break;
   case 'B':
       curr = Blinked.head;
        break;
   case 'C':
        curr = Clinked.head;
        break; 
   case 'R':
	   curr = result.head;
	   break;
    }
    if(curr==null){
        return null;
    }
    while(curr!=null){
       Point x = (Point) curr.element;
        if(x.y==1) {
        if(x.x != 0 && x.x !=1) {
        str.append(x.x);
       	str.append("x");
       	flag=1;}
        else if(x.x==1) {
        str.append("x");
        flag=1;
        }
        }
        else if(x.y==0) {
        if (x.x !=0) {
        str.append(x.x);
        flag=1;}
        }
        else {
        if(x.x != 0 && x.x !=1) {	
        str.append(x.x);
        str.append( "x");
        str.append("^");
        str.append(x.y);
        flag=1;
     }
        else if(x.x==1) {
        	  str.append( "x");
              str.append("^");
              str.append(x.y);
              flag=1;
           
        }
        }
       if(curr.next!=null){
    	   if(flag!=0) {
           str.append("+");
           flag=0;}
           }
        curr=curr.next;
       }
  if(str.length() > 0) {
    if(str.charAt(str.length()-1)=='+') {
    	str.deleteCharAt(str.length()-1);
    	str.toString() ;
    }}
  else {
	str.append(0);
  }
  
    return str.toString() ;
}
/**
* Clear the polynomial
* @param poly
* name of the polynomial
*/
public void clearPolynomial(char poly){
       switch(poly){
         case 'A':
            Alinked.clear();
             break;
        case 'B':
             Blinked.clear();
             break;
        case 'C':
            Clinked.clear();
             break; 
     }
    
}
/**
* Evaluate the polynomial
* @param poly
* name of the polynomial
* @param the
* polynomial constant value
* @return the value of the polynomial
*/
public float evaluatePolynomial(char poly, float value){
    float result1 = 0 ;
    Node curr = null;
      switch(poly){
         case 'A':
             curr = Alinked.head;
            
             break;
        case 'B':
             curr = Blinked.head;
            
             break;
        case 'C':
               
             curr = Clinked.head;
            
             break; 
        case 'R':
     	   curr = result.head;
     	   break;
         }
          while(curr!=null){
                Point x = (Point) curr.element;
                float z= (float) Math.pow(value, x.y);
                result1 += (float)( (x.x * z)) ;
                curr=curr.next;
          }
         return  result1 ;
}
/**
* Add two polynomials
* @param poly1
* first polynomial
* @param poly2
* second polynomial
* @return the result polynomial
*/
public int[][] add(char poly1, char poly2){
	
    Node curr1=null,curr2=null;
    switch(poly1){
         case 'A':
            curr1=Alinked.head;
             break;
        case 'B':
            curr1=Blinked.head;
             break;
        case 'C':
            curr1=Clinked.head;
             break; 
     }
    switch(poly2){
         case 'A':
            curr2=Alinked.head;
             break;
        case 'B':
            curr2=Blinked.head;
             break;
        case 'C':
            curr2=Clinked.head;
             break; 
     }
    if(curr1==null || curr2==null){
         return null;
    }
    result.clear();
     while(curr1!=null&&curr2!=null){
         Point p1=new Point();
         p1=(Point) curr1.element;
         Point p2=new Point ();
         p2=(Point) curr2.element;
         
         if(p1.y>p2.y){
             result.add(p1);     
             curr1=curr1.next;
         }
         else if(p1.y==p2.y){
             Point r=new Point() ;
             r.setLocation(p1.x+p2.x,p1.y);
             result.add(r);
             curr1 =curr1.next;
             curr2=curr2.next;
         }
         else {
             result.add(p2);
             curr2=curr2.next;
         }

         }
     
        while(curr1==null&&curr2!=null){
             Point p = (Point) curr2.element;
             result.add(p);
             curr2=curr2.next;
        }
         
     
     
         while(curr2==null&&curr1!=null){
             Point p = (Point) curr1.element;
             result.add(p);
             curr1=curr1.next;
        }
         
     
    int[][]arr=listtoarray(result);
    return arr;
}
/**
* Subtract two polynomials
* @param poly1
* first polynomial
* @param poly2
* second polynomial
* @return the result polynomial
*/
public int[][] subtract(char poly1, char poly2){

    Node curr1=null,curr2=null;
    switch(poly1){
         case 'A':
            curr1=Alinked.head;
             break;
        case 'B':
            curr1=Blinked.head;
             break;
        case 'C':
            curr1=Clinked.head;
             break; 
     }
    switch(poly2){
         case 'A':
            curr2=Alinked.head;
             break;
        case 'B':
            curr2=Blinked.head;
             break;
        case 'C':
            curr2=Clinked.head;
             break; 
     }
         if(curr1==null || curr2==null){
             return null;
         }
     	result.clear();
          while(curr1!=null&&curr2!=null){
         Point p1=(Point) curr1.element,
         p2=(Point) curr2.element;
         
         if(p1.y>p2.y){
             result.add(p1);     
             curr1=curr1.next;
         }
         else if(p1.y==p2.y){
             Point r=new Point() ;
             r.setLocation(p1.x-p2.x,p1.y);
             result.add(r);
             curr1 =curr1.next;
             curr2=curr2.next;
         }
         else {
             result.add(p2);
             curr2=curr2.next;
         }

         }
     
        while(curr1==null&&curr2!=null){
             Point p = (Point) curr2.element;
             p.x = -p.x;
             result.add(p);
             curr2=curr2.next;
        }
         
     
     
         while(curr2==null&&curr1!=null){
             Point p = (Point) curr1.element;
             p.x = -p.x;
             result.add(p);
             curr1=curr1.next;
        }
         
     
    int[][]arr=listtoarray(result);
    return arr;
     
     
}
/**
* Multiply two polynomials
* @param poly1
* first polynomial
* @param poly2
* second polynomial
* @return the result polynomial
*/
public int[][] multiply(char poly1, char poly2){

    Node head2=null,curr1=null,curr2=null;
    switch(poly1){
         case 'A':
            curr1=Alinked.head;
             break;
        case 'B':
           curr1=Blinked.head;
             break;
        case 'C':
            curr1=Clinked.head;
             break; 
     }
    switch(poly2){
         case 'A':
            head2=curr2=Alinked.head;
             break;
        case 'B':
            head2=curr2=Blinked.head;
             break;
        case 'C':
            head2=curr2=Clinked.head;
             break; 
     }
     if(curr1==null || curr2==null){
         return null;
         }
 	result.clear();
    while(curr1!=null){
        Point p1 = (Point) curr1.element;
        while(curr2!=null){
           Point p2 = (Point) curr2.element;
           Point r = new Point() ;
           r.setLocation(p1.x*p2.x,p1.y+p2.y);  
           result.add(r);
           curr2=curr2.next;
        }
        curr1=curr1.next;
        curr2=head2;
    }
    Node curr = result.head; 
    for(int i=0;i<result.size();i++){ 
        Point p1 = (Point)result.get(i);
        for(int j=i+1;j<result.size();j++){
            Point p2 = (Point)result.get(j);
            if(p1.y==p2.y){
            p2.setLocation(p1.x+p2.x,p1.y);
            curr.element = p2 ;
            result.remove(j);
            j--;
            }
        }
        curr=curr.next;
    }
    
    int[][]arr=listtoarray(result);
    return arr;
}


public void arraytolist(int [][] a, SingleLinked l){
	l.clear();
 
    for (int i = 0; i < a.length; i++) {     
        for (int j = i+1; j < a.length; j++) {     
           if(a[i][1] < a[j][1]) {    
        	   int temp1 = a[i][1];
               int temp2 = a[i][0];
               a[i][1]=a[j][1];
               a[i][0]= a[j][0];
               a[j][1]=temp1;
               a[j][0]=temp2;
           }     
        }}     
    
    for(int i =0 ;i<a.length ;i++){
     Point b = new Point();
      b.setLocation(a[i][0], a[i][1]);
      
      l.add(b);
      
    }
}

    
    
public  int [][] listtoarray (SingleLinked a){
    int[][] m = new int [a.size()][2];
    Point b = new Point();
    int c=0;
    for(int i=0; i< a.size();i++ ){
        b = (Point)a.get(i);
        if(b.x!=0) {
        m[i][0]= b.x;
        m[i][1]=b.y;
        c++;}
    }
    
    if(c!=0) {
    	int[][] newm = new int[c][2];
    	 for(int i=0; i< c;i++ ) {
    		 newm[i][0]=m[i][0];
    		 newm[i][1]=m[i][1];
    	 }
    	 for(int i=0; i<c;i++){
    		 for(int j=i+1;j<c;j++) {
    	        if (newm[i][1] < newm[j][1]){
    	            int temp1 = newm[i][1];
    	            int temp2 = newm[i][0];
    	            newm[i][1]=newm[j][1];
    	            newm[i][0]= newm[j][0];
    	            newm[j][1]=temp1;
    	            newm[j][0]=temp2;
    	        }      
    	    }}
    	 return newm;
    }
    else 
    {int[][] newm = new int[1][2];
    	newm[0][0]=0;
    	newm[0][1]=0;
    	return newm;
    }   

}
  
  public String modify(String s) { 
      
      // Creating a pattern 
      Pattern patt = Pattern.compile("[\\s()]"); 

      // Searching pattern in s. 
      Matcher mat = patt.matcher(s); 

      // Replacing 
      return mat.replaceAll(""); 
 }
  
}
    
    
    
    

