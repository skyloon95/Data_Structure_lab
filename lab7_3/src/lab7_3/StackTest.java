/*
 *StackTest.java
 *201432014 모설아
 *2017.10.27
 *Stack 클래스 사용해보기 
 */
package lab7_3;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author skylo
 *
 */
public class StackTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("lab7_3 : 모설아\n");

		Stack stack = new Stack();
		Scanner scan = new Scanner(System.in);

		int select = 0;

		do {
			System.out.println("======MyArrayStack 관리자======\n");
			System.out.print("1:삽입  2:삭제  3:조회  4:전체삭제  5:종료\n메뉴 선택 입력==>");
			select = scan.nextInt();

			switch(select) {
			case 1:
				System.out.println("\n<<삽입>>");
				System.out.print("삽입할 정수 원소 입력 : ");
				stack.push(scan.nextInt());
				System.out.println("삽입 완료\n\n");
				break;

			case 2:
				System.out.println("\n<<삭제>>");
				System.out.println("삭제된 원소 : "+stack.pop()+"\n\n");
				break;

			case 3:
				System.out.println("\n<<조회>>");
				System.out.println("현재 top 원소 : "+stack.peek()+"\n\n");
				break;

			case 4:
				System.out.println("\n<<전체삭제>>");
				System.out.println(popAll(stack));
				System.out.println("스택이 비었습니다.\n\n");
				break;

			case 5:
				break;

			default:
				System.out.println("잘못된 메뉴선택입니다.\n");
			}

		}while(select != 5);
	}

	private static String popAll(Stack stack) {
		StringBuilder tmp = new StringBuilder();

		while(!stack.isEmpty()) {
			tmp.append(stack.pop()).append(" ");
		}

		return "삭제한 원소 : "+tmp.toString();
	}
}
