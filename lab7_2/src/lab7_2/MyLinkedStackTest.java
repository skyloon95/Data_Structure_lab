/*
 * MyLinkedStackTest.java
 * 2017.10.12
 * 201432014 모설아
 * MyLinkedList 활용
 */
package lab7_2;

public class MyLinkedStackTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("lab7_2 : 모설아\n");

		MyLinkedStack stk = new MyLinkedStack();
		java.util.Scanner scan = new java.util.Scanner(System.in);
		int select = 0;
		
		System.out.println("========LinkedStack 관리자=======\n");
		do {
			System.out.print("1)삽입  2)삭제  3)조회  4)전체삭제  5)종료\n메뉴 선택 : ");

			select = scan.nextInt();

			switch(select) {
			case 1:
				System.out.println("<<삽입>>");
				System.out.print("삽입 할 정수 입력 : ");
				stk.push(scan.nextInt());
				System.out.println("삽입 완료!\n");
				break;

			case 2:
				System.out.println("<<삭제>>");
				try {
					System.out.println("삭제 완료\n삭제한 원소 : "+stk.pop()+"\n");
				} catch(NullPointerException e) {
					System.out.println("삭제 실패!\n스택이 비었습니다.\n");
				}
				break;

			case 3:
				System.out.println("<<조회>>");
				try {
					System.out.println("스택 최상위 원소 : "+stk.peek()+"\n");
				} catch(NullPointerException e) {
					System.out.println("조회 실패\n스택이 비었습니다.\n");
				}
				break;

			case 4:
				System.out.println("<<전체 삭제>>");
				try {
					popAll(stk);
				} catch(NullPointerException e) {
					System.out.println("\n스택이 성공적으로 비워졌습니다.\n");
				}
				break;
				
			case 5:
				System.out.println("프로그램 종료");
				break;

			default:
				System.out.println("잘못 선택하셨습니다.\n");
				break;

			}

		} while(select!=5);

	}

	private static void popAll(MyLinkedStack stk) throws NullPointerException{
		if(stk.isEmpty()) {
			System.out.println("삭제 실패!\n스택이 비었습니다.\n");
		} else {
			System.out.println("삭제 시작");
			while(true) {
				System.out.print(stk.pop()+" ");
			}
		}
	}

}
