/*
 *파일명 : ArrayListTest
 *작성자 : 201432014 모설아
 *작성일 : 2017.09.21
 *내용 : ArrayList 활용 
 */
package hw5_2;

/**
 * @author snow
 *
 */

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hw5_2 : 모설아\n");

		//ArrayList 객체 생성
		ArrayList<Integer> list = new ArrayList<Integer>();

		//list에 저장
		list.add(20);
		list.add(30);
		list.add(20);
		list.add(40);
		list.add(-999);
		list.add(50);
		list.add(90);
		list.add(10);

		//list 내용 전체 출력
		System.out.println(list);

		//list의 크기
		System.out.println("리스트 크기 = "+list.size()+"\n");

		//Scanner 객체 생성
		Scanner scan = new Scanner(System.in);

		//list 조회

		System.out.print("조회할 인덱스 입력 : ");
		int ipt = scan.nextInt();
		System.out.println("인덱스 "+ipt+"의 원소 = "+list.get(ipt)+"\n");




		//갱신

		System.out.print("777로 갱신할 인덱스 입력 : ");
		ipt = scan.nextInt();
		list.set(ipt, 777);
		System.out.println(list+"\n");


		//삽입

		System.out.print("999를 삽입할 인덱스 입력 : ");
		ipt = scan.nextInt();
		list.add(ipt, 999);
		System.out.println(list+"\n");



		//삭제

		System.out.print("삭제할 인덱스 입력 : ");
		ipt = scan.nextInt();
		int x = list.remove(ipt);
		System.out.println("인덱스 "+ipt+"의 원소 = "+x);
		System.out.println(list+"\n");

	}


}


