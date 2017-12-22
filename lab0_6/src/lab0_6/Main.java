/*
 *파일명 : Main.java
 *작성일 : 2017.9.11
 *작성자 : 201432014 모설아
 *내용 : 드라이버클래스
 */
package lab0_6;

/**
 * @author snow
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("lab0_6 : 모설아\n");
		
		System.out.print("2개의 정수를 입력하세요 : ");
		
		java.util.Scanner scan = new java.util.Scanner(System.in);
		
		int x = scan.nextInt();
		int y = scan.nextInt();
		
		MyPair pair = new MyPair(x,y);
		
		System.out.println(pair.toString());
		System.out.println("합 = "+pair.sum());
		System.out.println("평균 = "+pair.average());
		
		pair.swap();
		
		System.out.println("\nswap 실행 후");
		System.out.println(pair.toString());
		System.out.println("합 = "+pair.sum());
		System.out.println("평균 = "+pair.average());
	}

}
