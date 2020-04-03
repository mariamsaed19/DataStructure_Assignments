package eg.edu.alexu.csd.datastructure.stack;
/**
 * program to convert from infix expressions to postfix
 * and evaluate numeric postfix expressions
 *
 */
public class ExpressionEvaluator implements IExpressionEvaluator {
/**
* Takes a symbolic/numeric infix expression as input and converts it to
* postfix notation. There is no assumption on spaces between terms or the
* length of the term (e.g., two digits symbolic or numeric term)
*
* @param express
* infix expression
* @return postfix expression
 * @throws RuntimeException when the use enters Invalid format 
*/
@Override
public String infixToPostfix(String express)  {
	//remove white spaces
	express = express.replaceAll("\\s+","");
	StringBuilder exp=new StringBuilder(),expression=new StringBuilder(express);
	Stack s = new Stack();
	int count =0;
	//check 
	checkValid(expression.toString(),1);
	int z;
	for(int i=0;i<expression.length()-2;i++) {
		// add dummy zero to negative numbers
		
		if(i==0&&expression.charAt(i)=='-') {
			expression.insert(0,"(0");
			z=i+3;
			while(z<expression.length()&&!IsSign(expression.charAt(z))) {
				z++;
			}
			expression.insert(z,")");
		}
		else if(IsSign(expression.charAt(i))&&expression.charAt(i+1)=='-') {
			expression.insert(i+1,"(0");
			z=i+4;
			while(z<expression.length()&&!IsSign(expression.charAt(z))) {
				z++;
			}
			expression.insert(z,")");
		}
		
	}
	char[] str = expression.toString().toCharArray();
	int flag =0;
	//conversion
	for(z=0;z<str.length;z++){
		//operators 
		if(IsSign(str[z])) {
			if(s.isEmpty()) {
				s.push(str[z]);
			}
			else {
				int curr=checkP(str[z]),prev=checkP((char)s.peek());
				while(curr!=0) {
					if(curr>prev) {
						s.push(str[z]);

						break;
					}
					exp.append(s.pop());
					exp.append(" ");
					if(s.isEmpty()) {
						s.push(str[z]);	
						break;
					}
					prev=checkP((char)s.peek());
				}
			}
		}
		else if(str[z]=='(') {
			s.push(str[z]);
			count++;
		}
		else if(str[z]==')') {
			if(count==0) {
				throw new RuntimeException("Invalid Format !");
			}
			while(!s.isEmpty()) {
				if((char)s.peek()=='(') {
					s.pop();
					count--;
					break;
				}
				exp.append(s.pop());
				exp.append(" ");
			}
		}
		else {
			while(z<str.length&&str[z]!='('&&str[z]!=')'&&!IsSign(str[z])) {
				exp.append(str[z]);
				z++;
				flag=1;
			}
			exp.append(" ");
			
			
		}
		if(flag==1) {
			flag=0;
			z--;
		}
		
	}
	if(count!=0)
		throw new RuntimeException("Invalid Format ()!");
	while(!s.isEmpty()) {
		exp.append(s.pop());
		exp.append(" ");
	}

	return exp.toString().strip();
	
}
/**
* Evaluate a postfix numeric expression, with a single space separator
*
* @param expression
* postfix expression
* @return the expression evaluated value
*/

@Override
public int evaluate(String expression) {
	
	Stack s = new Stack();
	expression=expression.strip();
	//check
	checkValid(expression,2);
	//evaluate
	for(int i=0;i<expression.length();i++) {
		StringBuilder term=new StringBuilder();
		while(i<expression.length()&&!IsSign(expression.charAt(i))&&expression.charAt(i)!=' ') {
			term.append(expression.charAt(i));
			i++;
		}
		if((i<expression.length()&&expression.charAt(i)==' ')||i==expression.length()) {
			float t =Float.parseFloat(term.toString());
			s.push(t);
			term=term.delete(0,term.length());
		}
		else if(i<expression.length()&&IsSign(expression.charAt(i))) {
			if(s.size()<2) {
				throw new RuntimeException("Invalid Expression");
			}
				
			float x =(float)s.pop(),y=(float)s.pop(),result=0;
			switch (expression.charAt(i)){
			case '+':
				result=x+y;
				s.push(result);
				break;
			case '-':
				result=y-x;
				s.push(result);
				break;		
			case '*':
				result=x*y;
				s.push(result);
				break;		
			case '/':
				result=y/x;
				s.push(result);
				break;	
			}
			i++;
		}
	}
	float result=(float) s.pop();
	
	return (int) result;
}
//check if the expression is valid or not

/**
 * check whether the expression is valid or not
 * @param exp
 * @param z
 * z to determine if it is infix or postfix
 * 
 */
public void checkValid(String exp,int z) {
	if (z==1) {
		if(!exp.matches("[a-zA-Z0-9\\+\\-\\*/\\(\\)]*")) {
			throw new RuntimeException("Invalid format of expression");
		}
		int flag = 0;
		for(int i=0;i<exp.length()-1;i++) {
			//any sign except - at the beginning
			if(i==0&&exp.charAt(i)!='-'&&IsSign(exp.charAt(i))) {
				flag=1;
				break;
			}
			// two signs
			if(IsSign(exp.charAt(i))&&IsSign(exp.charAt(i+1))&&exp.charAt(i+1)!='-') {
				flag=1;
				break;
			}
			//sign at the end
			if(IsSign(exp.charAt(exp.length()-1))) {
				flag=1;
				break;
			}
			//-- signs e.g : 3+--9
			if(i+2<exp.length()&&IsSign(exp.charAt(i))&&exp.charAt(i+1)=='-'&&IsSign(exp.charAt(i+2))) {
				flag=1;
				break;
				
			}
			
	
		}
		if(flag==1)
		throw new RuntimeException("Invalid expression !");
	}
	else {
		String str = exp.replaceAll("\\s+", "");
		if(!str.matches("[0-9\\+\\-\\*/]*")) {
			throw new RuntimeException("Invalid format of expression");
		}
		
	}
}
//to check precedence
/**
 * check the precedence of operators
 * @param x
 * the char to be checked
 * @return an integer indicates the precedence of a given operator
 */
public int checkP(char x) {
	switch(x) {
	case '+':
	case'-' :
		return 1;
	case '*':
	case'/':
		return 2;
	}
	return 0;
}
// check if the char is +,-,*,/
/**
 * check if the given char is operator or not
 * @param x
 * the char to be checked
 * @return true if the char is an operator
 */
public boolean IsSign(char x) {
	
	if(x=='+'||x=='-'||x=='*'||x=='/') {
		return true;
	}
	
	return false;
	
}
}