package eg.edu.alexu.csd.datastructure.stack.cs78;

public class ExpressionEvaluator implements IExpressionEvaluator {

	public String infixToPostfix(String expression) {
		char[] postfix = new char[100];
		int counter = 0;
		stack stack = new stack();
		stack stack1= new stack() ;
		for (int i = 0; i < expression.length(); i++) {
			char symb = expression.charAt(i);
			if (stack.size() == 0 && symb != '(' && symb != ')' && symb != '/' && symb != '*' && symb != '+'
					&& symb != '-') {
				stack.push(symb);
			} else if (stack1.size() == 0 || (symb == '/' || symb == '*')
					&& (stack1.peek() == (Object) '(' || stack1.peek() == (Object) '+' || stack1.peek() == (Object) '-'
							|| (stack1.peek() != (Object) '/' && stack1.peek() != (Object) '*'))) {
				stack1.push(symb);
			} else if ((symb == '+' || symb == '/' || symb == '*' || symb == '-') && stack1.peek() == (Object) '(') {
				stack1.push(symb);
			} else if (symb != '+' && symb != '/' && symb != '*' && symb != '-' && symb != '(' && symb != ')') {
				stack.push(symb);
			} else if (symb == '(') {
				stack1.push(symb);
			} else {
				int temp = counter;
				int j = 0;
				int size = stack.size();
				while (stack.size() != 0) {
					postfix[size + temp - j - 1] = (char) stack.peek();
					j++;
//                      postfix[counter]=(char)stack.peek() ;
					counter++;
					stack.pop();

				}
				while (stack1.size() != 0) {
					if (stack1.peek() == (Object) '(') {
						stack1.pop();
						break;
					}
					if (stack1.peek() != (Object) ')') {
						postfix[counter] = (char) stack1.peek();
						counter++;
						stack1.pop();
					} else {
						stack1.pop();
					}
				}

				if (symb != ')') {
					stack1.push(symb);
				}
			}
		}
		int temp = counter;
		int j = 0;
		int size = stack.size();
		while (stack.size() != 0) {
			postfix[size + temp - j - 1] = (char) stack.peek();
			j++;
//			 postfix[counter]=(char)stack.peek() ;
			counter++;
			stack.pop();
		}
		while (stack1.size() != 0) {
			postfix[counter] = (char) stack1.peek();
			counter++;
			stack1.pop();
		}
		for (int l = 0; l < counter; l++) {
			System.out.print((char)postfix[l]);
		}
		String s = new String();
//		s= postfix.toString();

	return postfix.toString() ;
	}

	public int evaluate(String expression) {
		stack value = new stack() ;
		for (int i = 0; i < expression.length(); i++) {

			if (expression.charAt(i) != '+' && expression.charAt(i) != '*' && expression.charAt(i) != '/' && expression.charAt(i) != '-') {
				value.push((int) expression.charAt(i));
			} else {
				int x = (int) value.pop() - 48;
				int y = (int) value.pop() - 48;
				if (expression.charAt(i) == '+') {
					int z = (int) x + (int) y;
					z += 48;
					value.push(z);
				}
				if (expression.charAt(i) == '-') {
					int z = (int) y - (int) x;
					z += 48;
					value.push(z);
				}
				if (expression.charAt(i) == '*') {
					int z = (int) y * (int) x;
					z += 48;
					value.push(z);
				}
				if (expression.charAt(i) == '/') {
					int z = (int) y / (int) x;
					z += 48;
					value.push(z);
				}
			}
		}
		return (int) value.pop() - 48 ;
	}

}
