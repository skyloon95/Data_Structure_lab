/*
 *파일명 : FindMax.java
 *작성일 : 2017.9.5
 *작성자 : 201432014 모설아
 *설 명 : 최댓값 도출 
 */
package lab0_5;

/**
 * @author snow
 *
 */
public class FindMax {

	public static int getMaxIndex(int[] arr) {
		int maximum = arr[0];
		int indexOfMaximum = 0;
		
		for(int i = 0 ; i<arr.length ; i++) {
			if(arr[i]>maximum) {
				maximum = arr[i];
				indexOfMaximum = i;
			}
		}
		
		return indexOfMaximum;
	}
}
