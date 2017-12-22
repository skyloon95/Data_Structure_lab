/*
 *파일명 : Average.java
 *작성일 : 2017.8.29
 *작성자 : 모설아
 *설 명 : 평균 도출 
 */
package lab0_2;

/**
 * @author snow
 *
 */
public class Average {
	private int[] arr;
	private double average;
	private int[] oList; // 평균 이상인 값들의 집합
	
	public Average(int[] arr) {
		this.arr = arr;
	}
	
	public void takeAverage() { // 평균 도출
		int sum = 0;
		for(int i = 0; i<arr.length; i++) {
			sum+= arr[i];
		}
		
		average = (double)sum / arr.length;
	}
	
	public double getAverage() {
		return average;
	}
	
	public void takeOverAverages() { // 평균 이상인 값 체크.
		int count=0;
		for(int i = 0; i<arr.length; i++) { // 평균 이상 값 수 체크
			if(arr[i]>=average) {
				count++;
			}
		}
		
		oList = new int[count]; // 배열에 있는 평균 이상 값의 수 만큼 배열생성
		
		for(int i = 0 , j = 0; i<arr.length ; i++) { // 평균 이상 값 도출
			if(arr[i]>=average) {
				oList[j] = arr[i];
				j++;
			}
		}
	}
	
	public int[] getOverAverages() {
		return oList;
	}

}
