package eg.edu.alexu.csd.datastructure.stack.cs78;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UiForStack {

	public static void main(String[] args) {
		stack stack = new stack();
		boolean flag = true;
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
	}

}
