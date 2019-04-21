package eg.edu.alexu.csd.datastructure.stack.cs78;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ExpressionEvaluator l = new ExpressionEvaluator() ;
		System.out.println(l.infixToPostfix("2+3*4"));
		System.out.println(l.evaluate("12+7*"));

	}

}
