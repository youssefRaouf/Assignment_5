package eg.edu.alexu.csd.datastructure.stack.cs78;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {

	public static void main(String[] args) {
		stack stack = new stack();
		boolean flag = true;
		Scanner s5 = new Scanner(System.in);
		System.out.println("press 1 for stack UI and 2 for application UI , else for termination");
		int l = 0;
		try {
			l = s5.nextInt();

		} catch (InputMismatchException e) {
		}
		if (l == 1) {
			while (flag == true) {
				System.out.println(
						"please enter an operation 1>>push  2>>pop 3>>peek 4>>getsize  5>>checkifempty else>>terminate");
				Scanner s = new Scanner(System.in);
				int n = 0;
				try {
					n = s.nextInt();

				} catch (InputMismatchException e) {
				}
				if (n == 1) {
					System.out.println("enter the value");
					Scanner s1 = new Scanner(System.in);
					Object object = new Object();
					object = s1.next();
					stack.push(object);
				} else if (n == 2) {
					System.out.println(stack.pop());

				} else if (n == 3) {
					System.out.println(stack.peek());
				} else if (n == 4) {
					System.out.println(stack.size());
				} else if (n == 5) {
					if (stack.isEmpty()) {
						System.out.println("stack is empty");
					} else {
						System.out.println("stack is not empty");
					}
				} else {
					flag = false;
				}
			}
		} else if (l == 2) {
			ExpressionEvaluator expression = new ExpressionEvaluator();
			Scanner s6 = new Scanner(System.in);
			Scanner s7 = new Scanner(System.in);
			boolean flag1 = true;
			while (flag1) {
				System.out.println("enter your expression");
				String string = s6.nextLine();
				System.out.println("press 1>>postfix  2>>evaluation   else>>terminate");
				int k = 0;
				try {
					k = s7.nextInt();

				} catch (InputMismatchException e) {
				}
				if (k == 1) {
					System.out.println(expression.infixToPostfix(string));

				} else if (k == 2) {
					System.out.println(expression.evaluate(expression.infixToPostfix(string)));
				} else {
					flag1 = false;
				}
			}
		}
		System.out.println("fefef");
		int n = 5 ;
		System.out.println(n);
	}

}
