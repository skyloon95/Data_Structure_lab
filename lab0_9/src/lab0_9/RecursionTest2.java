/**
 * RecursionTest2.java
 * 201432014 �𼳾�
 * 2017.11.13
 * ��;˰��� �׽�Ʈ 2
 */
package lab0_9;

/**
 * @author skylo
 *
 */
public class RecursionTest2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("lab0_9: �𼳾�");

		// int�� �迭 1 ~ 5 �� ����
		int[] array1 = {22, 11, 33};
		int[] array2 = {9, 8, 7, 6, 5, 4, 3, 2, 1};
		int[] array3 = {10, 40, 10, 50, 20};
		int[] array4 = {-2};
		int[] array5 = {};

		// �迭 1 ~ 5�� ���� ���
		System.out.println("���� ����մϴ�.");
		System.out.println(sum(array1, 0, array1.length - 1)); // 66
		System.out.println(sum(array2, 0, array2.length - 1)); // 45
		System.out.println(sum(array3, 0, array3.length - 1)); // 130
		System.out.println(sum(array4, 0, array4.length - 1)); // -2
		System.out.println(sum(array5, 0, array5.length - 1)); // 0

		// �迭 1 ~ 5�� �ּҰ��� ���
		System.out.println("�ּҰ��� ����մϴ�.");
		System.out.println(min(array1, 0, array1.length - 1)); // 11
		System.out.println(min(array2, 0, array2.length - 1)); // 1  
		System.out.println(min(array3, 0, array3.length - 1));  // 10   
		System.out.println(min(array4, 0, array4.length - 1)); // -2
		System.out.println(min(array4, 0, array5.length - 1));  // ���� �߻��ϰ� ����
	}

	// array[lb..ub] �� ���� �����ϴ� �޼ҵ�
	public static int sum(int[] array, int lb, int ub) {
		if(lb > ub) { // ������ �ش��ϴ� ���� ���� 0�� ���
			return 0;
		}
		else { // lb <= ub�� ���. ��, ������ �ش��ϴ� ���� ���� 1 �̻��� ���
			return array[lb] + sum(array, lb + 1, ub);
		}
	}

	// array[lb..ub] �� �ּҰ��� �����ϴ� �޼ҵ� - ��, ���� ���� 1 �̻��� ���(lb <= ub)�� �۵�
	public static int min(int[] array, int lb, int ub) {
		// ������ �ش��ϴ� ���� ���� 0�� ��� ���� �߻�
		if(lb > ub) {
			throw new IllegalArgumentException("lb:" + lb + " ub:" + ub);
		}
		// ����: ������ �ش��ϴ� ���� ���� 1�̸� �� ���Ұ� �ּҰ��̰�, �� �̻��̸� ��������� �ּҰ��� ���Ͽ� ����
		else if(lb==ub)
			return array[lb];
		else {
			int tmp = min(array, lb+1, ub);
			return array[lb]<=tmp ? array[lb] : tmp;
		}
	}

}
