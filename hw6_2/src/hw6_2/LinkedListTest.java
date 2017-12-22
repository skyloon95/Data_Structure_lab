/*
 *파일명 : LinkedListTest.java
 *작성자 : 201432014 모설아
 *작성일 : 2017.9.22
 *내용 : LinkedList 활용 
 */
package hw6_2;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * @author snow
 *
 */

public class LinkedListTest {

	private static int select= -1; // 기본값.
	private static Scanner scan = new Scanner(System.in);
	private static LinkedList<Integer> list = new LinkedList<Integer>();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hw6_2 : 모설아\n");

		System.out.println("==========Linked List 관리 프로그램==========\n");

		// 메인 루프 (프로그램 종료 선택시 루프 종료)
		while(true) {
			selection();

			if(select==9) {
				break;
			}

			processing();
		}

	}
	// 메뉴 선택 메소드 (사용자가 제대로 된 메뉴를 선택 할 떄 까지 반복)
	private static void selection() {

		while(true) {
			inform();

			try {
				select = scan.nextInt();
			} catch(InputMismatchException e){
				scan.nextLine(); // 입력 오류시 추가 오류 방지를 위한 버퍼 삭제
				select = -1; // 오류 방지용 select default값 설정.
			}
			if((select>0&&select<7)||select==9) {
				break;
			}
			else {
				System.out.println("\n입력 오류\n");
			}
		}
	}

	// 기본 안내문 출력 메소드
	private static void inform() {
		System.out.println("1)리스트 출력  2)맨앞 삽입  3)맨앞 삭제  4)검색  5)인덱스 삽입  6)인덱스 삭제  9)종료");
		System.out.print("원하시는 작업을 정수 입력을 통해 선택해주세요. : ");
	}

	// 
	private static void processing(){
		switch(select) {
		case 1:
			System.out.println("<<리스트 출력>>\n"+list.toString()+"\n");
			break;

		case 2:
			try {
				System.out.print("<<맨앞 삽입>>\n"+"맨앞에 삽입할 정수를 입력 해주세요 : ");
				list.addFirst(scan.nextInt());
				System.out.println("추가완료.\n");
			} catch(InputMismatchException e) {
				System.out.println("정수만 추가 가능합니다\n");
				scan.nextLine();
			}
			break;

		case 3:
			try {
				System.out.println("<<맨앞 삭제>>");
				list.removeFirst();
				System.out.println("삭제 완료!\n");
			} catch(NoSuchElementException e) {
				System.out.println("리스트가 비어있습니다. 삭제 실패\n");
			}
			break;

		case 4:
			try {
				System.out.print("<<검색>>\n찾으실 원소를 입력해주세요 : ");
				boolean asw = list.contains(scan.nextInt());
				if(asw==true) System.out.println("찾으시는 원소가 이 리스트에 포함되어 있습니다.\n");
				else System.out.println("찾으시는 원소가 이 리스트에 포함되어 있지 않습니다.\n");
			} catch(InputMismatchException e) {
				System.out.println("정수만 입력 가능합니다. 검색실패\n");
				scan.nextLine();
			}
			break;

		case 5:
			try {
				System.out.print("<<인덱스 삽입>>\n삽입할 인덱스와 정수를 차례대로 입력 해주세요 : ");
				int idx=scan.nextInt();
				int number=scan.nextInt();
				list.add(idx, number);
				System.out.println("추가완료.\n");
			} catch(InputMismatchException e){
				System.out.println("정수로만 입력해주세요. 삽입 실패.\n");
				scan.nextLine();
			} catch(IndexOutOfBoundsException e) {
				System.out.println("인덱스 오류. 삽입실패.\n");
			}
			break;

		case 6:
			try {
			System.out.print("<<인덱스 삭제>>\n삭제할 인덱스를 입력해주세요 : ");
			list.remove(scan.nextInt());
			System.out.println("삭제 완료!\n");
			} catch(InputMismatchException e){
				System.out.println("정수로만 입력해주세요. 삭제 실패.\n");
				scan.nextLine();
			} catch(IndexOutOfBoundsException e) {
				System.out.println("인덱스 오류. 삭제실패.\n");
			}
			break;

		case 9:
			break;
		}
	}
}
