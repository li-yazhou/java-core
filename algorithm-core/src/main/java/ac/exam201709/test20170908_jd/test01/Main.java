package ac.exam201709.test20170908_jd.test01;

import java.util.*;

public class Main {

//	public static int solution(String line) {
//		int len = line.length();
//		int temp = 0;
//		int result = 1;
//		for(int i = len - 1; i >= 0; i--) {
//			if(line.charAt(i) == ')') {
//				temp++;
//			}else if(line.charAt(i) == '(') {
//				result *= temp;
//				--temp;
//			}
//		}
//		return result;
//	}
//
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		while(sc.hasNext()) {
//			String line = sc.nextLine();
//			System.out.println(solution(line));
//		}
//		sc.close();
//	}




	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		System.out.println(calSolutions(input));
		sc.close();
	}

	public static int calSolutions(String input) {
		int length = input.length();
		int temp = 0;
		int sum = 1;
		for(int i = length - 1; i >= 0; i--) {
			if(input.charAt(i) == ')') {
				temp ++;
			}else if(input.charAt(i) == '(') {
				sum *= temp;
				temp --;
			}
		}
		return sum;
	}

}