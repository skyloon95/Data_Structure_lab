/*
 * InsertionSort.java
 * 201432014 모설아
 * 2017.12.11
 * 삽입 정렬
 */
package net.skhu.hw;

import java.util.Scanner;

public class InsertionSort {
	private static int numOfStudent;
	private static Student[] list;
	
	public static void main (String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hw11_1 : 모설아	\n");
		Scanner scan = new Scanner(System.in);
		
		System.out.print("학생 수 입력 : ");
		numOfStudent = scan.nextInt();
		
		list = new Student[numOfStudent];
		
		for(int i = 0 ; i < numOfStudent ; ++i) {
			System.out.print("학생 "+(i+1)+"학번 입력 : " );
			int num = scan.nextInt();
			
			System.out.print("학생 "+(i+1)+"나이 입력 : ");
			int age = scan.nextInt();
			
			list[i] = new Student(num, age);
		}
		
		System.out.println("\n정렬 전 목록 출력\n");
		
		for(Student s : list) {
			System.out.println(s);
		}
		
		sorting();
		
		System.out.println("\n정렬 후 목록 출력\n");
		
		for(Student s : list) {
			System.out.println(s);
		}
	}
	
	private static void sorting () {
		for(int i = 1 ; i < numOfStudent ; ++i)
				goFoward(i);
	}
	
	private static void goFoward(int i) {
		for(int j = i ; j > 0 ; --j) {
			if(list[j].compareTo(list[j-1])<0) {
				swap(j, j-1);
			}
			else {
				break;
			}
		}
	}

	private static void swap(int i, int j) {
		Student tmp = list[i];
		list[i] = list[j];
		list[j] = tmp;
	}
	
	private static class Student implements Comparable{
		private int studentNum;
		private int age;
		
		public Student (int studentNum, int age) {
			this.studentNum = studentNum;
			this.age = age;
		}
		
		public int getStuentNum() {
			return this.studentNum;
		}
		
		public int getAge() {
			return this.age;
		}
		
		@Override
		public int compareTo(Object obj) {
			Student other = (Student)obj;
			
			if(other == null) {
				return 1;
			}
			else if(this.age == other.age) {
				return 0;
			}
			else if(this.age > other.age) {
				return 1;
			}
			else {
				return -1;
			}
		}
		
		@Override
		public String toString() {
			return "학번 : " + this.studentNum +" / " + "나이 : " +	 this.age;
		}
	}
}
