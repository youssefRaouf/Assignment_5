package eg.edu.alexu.csd.datastructure.stack.cs78;

public class ExpressionEvaluator implements IExpressionEvaluator {

	public String infixToPostfix(String expression) {
		char[] postfix = new char[100];
		String s = new String();
		int counter = 0;
		stack stack = new stack();
		stack stack1 = new stack();
		for (int i = 0; i < expression.length(); i++) {
			char symb = expression.charAt(i);
			if (symb == ' ') {
				continue;
			}
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
//	while (stack1.size() != 0) {
				if (symb == ')') {
					while (stack1.size() != 0) {
						if (stack1.peek() == (Object) '(') {
							stack1.pop();
							break;
						}
						postfix[counter] = (char) stack1.peek();
						counter++;
						stack1.pop();
					}
				} else {
					if (stack1.peek() == (Object) '(') {
						stack1.pop();

					}
					if (stack1.peek() != (Object) ')') {
						postfix[counter] = (char) stack1.peek();
						counter++;
						stack1.pop();
					} else {
						stack1.pop();
					}
//			}
				}
                 if(stack1.size()!=0&&(symb=='+'||symb=='-')&&(stack1.peek()==(Object)'/'||stack1.peek()==(Object)'*'||stack1.peek()==(Object)'+'||stack1.peek()==(Object)'-')) {
                	while(stack1.size()!=0) {
                		postfix[counter] = (char) stack1.peek();
						counter++;
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
			if (stack.peek() != (Object) '(' && stack.peek() != (Object) ')') {
				postfix[size + temp - j - 1] = (char) stack.peek();
				j++;
//			 postfix[counter]=(char)stack.peek() ;
				counter++;
			}
//			j++;
			stack.pop();
		}
		while (stack1.size() != 0) {
			if (stack1.peek() != (Object) '(' && stack1.peek() != (Object) ')') {
				postfix[counter] = (char) stack1.peek();
				counter++;
			}
			stack1.pop();
		}
		for (int l = 0; l < counter; l++) {
			s += (char) postfix[l];
		}

		return s;
	}

	public int evaluate(String expression) {
		stack value = new stack();
		int k = 0;
		for (int i = 0; i < expression.length(); i++) {

			if (expression.charAt(i) != '+' && expression.charAt(i) != '*' && expression.charAt(i) != '/'
					&& expression.charAt(i) != '-') {
				value.push((double) expression.charAt(i));
			} else {
				double x = (double) value.pop() - 48;
				double y = (double) value.pop() - 48;
				if (expression.charAt(i) == '+') {
					double z = (double) x + (double) y;
					z += 48;
					value.push(z);
				}
				if (expression.charAt(i) == '-') {
					double z = (double) y - (double) x;
					z += 48;
					value.push(z);
				}
				if (expression.charAt(i) == '*') {
					double z = (double) y * (double) x;
					z += 48;
					value.push(z);
				}
				if (expression.charAt(i) == '/') {
					double z = (double) y / (double) x;
					z += 48;
					value.push(z);
				}

			}
			if (i == expression.length() - 1) {
				k = (int) ((double) value.pop() - 48);
			}
		}

		return k;
	}

}
