/*
 *파일명 : MyPair.java
 *작성일 : 2017.9.11
 *작성자 : 201432014 모설아
 *내용 : 두 수의 다양한 연산 클래스
 */
package lab0_6;

/**
 * @author snow
 *
 */
public class MyPair {

	private int x;
	private int y;
	
	public MyPair (int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	int sum () {
		return x+y;
	}
	
	double average() {
		return (double)((x+y)/2);
	}
	
	void swap() {
		int temp =x;
		x=y;
		y=temp;
	}

	@Override
	public String toString() {
		return "MyPair [x=" + x + ", y=" + y + "]";
	}
	

}
