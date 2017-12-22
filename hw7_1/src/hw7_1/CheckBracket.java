/*
 *CheckBracket.java
 *201432014 �𼳾�
 *2017.10.27
 *��ȣ �˻� 
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
		System.out.println("hw7_1 : �𼳾�\n");
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("��ȣ�� �Է�(��ȣ (), {}, [], <> �� ����Ͽ� �Է��� ��) : ");
		String str = scan.nextLine();
		
		if(checkBracket(str))
			System.out.println("�ùٸ� ��ȣ�� �Դϴ�.");
		else
			System.out.println("�߸��� ��ȣ�� �Դϴ�.");
	}
	
	// ��ȣ�� üũ �޼ҵ�
	private static boolean checkBracket(String str) {

		char tmp;	// �ӽ÷� ���ڸ� ������ ����
		
		// ���ڿ� ������ ����
		for(int i = 0 ; i<str.length() ; i++) {
			tmp = str.charAt(i); // ���ڿ��� ���� �ε����� �޾� tmp�� ����
			
			// ���� ��ȣ�� ��� ���ÿ� Ǫ��
			if(tmp=='('||tmp=='{'||tmp=='['||tmp=='<')
				stack.push(tmp);
			
			// ���� ��ȣ�� �ƴѰ�� ������ ������� �ʴٸ� �� �Ͽ� ¦�� �´��� üũ. ������ ���� �ε����� ����, Ʋ���� false����
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
			
			// ���� ��ȣ�� �ƴ�(��ȣ�̿��� ���ڴ� �������� �����Ƿ� �ݴ°�ȣ��)�� ������ ����ִ� ��� false ����
			else
				return false;
		}
		
		// ���ڿ��� ���� üũ�ߴµ� ������ ����ִ� ��� true ����
		if(stack.isEmpty())
			return true;
		// ���ڿ��� ���� üũ�ߴµ� ������ ���� ������� ������ ���� ��ȣ�� �ִ� ���̹Ƿ� false ����
		else
			return false;
	}
}
