/*
 *CheckBracket.java
 *201432014 모설아
 *2017.10.27
 *괄호 검사 
 */
package hw7_1;

import java.util.Scanner;
import java.util.Stack;


/**
 * @author skylo
 *
 */
public class CheckBracket {
	private static Stack stack = new Stack();
	
	public static void main(String[] args) {
		System.out.println("hw7_1 : 모설아\n");
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("괄호식 입력(괄호 (), {}, [], <> 만 사용하여 입력할 것) : ");
		String str = scan.nextLine();
		
		if(checkBracket(str))
			System.out.println("올바른 괄호식 입니다.");
		else
			System.out.println("잘못된 괄호식 입니다.");
	}
	
	// 괄호식 체크 메소드
	private static boolean checkBracket(String str) {

		char tmp;	// 임시로 문자를 저장할 변수
		
		// 문자열 끝까지 실행
		for(int i = 0 ; i<str.length() ; i++) {
			tmp = str.charAt(i); // 문자열의 현재 인덱스를 받아 tmp에 저장
			
			// 여는 괄호인 경우 스택에 푸쉬
			if(tmp=='('||tmp=='{'||tmp=='['||tmp=='<')
				stack.push(tmp);
			
			// 여는 괄호가 아닌경우 스택이 비어있지 않다면 팝 하여 짝이 맞는지 체크. 맞으면 다음 인덱스로 진행, 틀리면 false리턴
			else if(!stack.isEmpty()){
				tmp = (char) stack.pop();
				if(tmp=='(') {
					if(str.charAt(i)==')')
						continue;
					else
						return false;
				}
				else if(tmp=='{') {
					if(str.charAt(i)=='}')
						continue;
					else
						return false;
				}
				else if(tmp=='[') {
					if(str.charAt(i)==']')
						continue;
					else
						return false;
				}
				else {
					if(str.charAt(i)=='>')
						continue;
					else
						return false;
				}
			}
			
			// 여는 괄호가 아닌(괄호이외의 문자는 포함하지 않으므로 닫는괄호인)데 스택이 비어있는 경우 false 리턴
			else
				return false;
		}
		
		// 문자열을 전부 체크했는데 스택이 비어있는 경우 true 리턴
		if(stack.isEmpty())
			return true;
		// 문자열을 전부 체크했는데 스택이 비지 않은경우 닫히지 않은 괄호가 있는 것이므로 false 리턴
		else
			return false;
	}
}
