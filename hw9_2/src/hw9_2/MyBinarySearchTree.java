/* 
 * 파일명: MyBinarySearchTree.java
 * 작성일: 2017.11.28
 * 작성자: 모설아
 * 설명: int형 키값 저장하는 이진탐색트리를 연결자료구조로 구현한 클래스
 */

package hw9_2;

import java.util.NoSuchElementException;

class MyBinarySearchTree {
	private Node root = null;// 트리의 루트 노드를 가리킬 인스턴스 변수 root 선언하고 null로 초기화
	// (가) ...



	// 트리의 노드를 표현하는 클래스 - 필드(int형 key, leftChild, rightChild), 생성자(key값을 매개변수하여 초기화)
	private class Node {
		// (나) ...
		public int key;
		public Node leftChild;
		public Node rightChild;

		public Node(int key) {
			this.key = key;
			this.leftChild = null;
			this.rightChild = null;
		}



	}

	// (1) 전체조회를 위한 toString() 오버라이드
	@Override
	public String toString() {
		String result = inorder(root);
		return result;
	}

	// p를 루트로 하는 트리를 중위 순회하며 키값을 문자열로 리턴하는 메소드(재귀 알고리즘)
	private String inorder(Node p) {
		String result = "";
		if(p != null) {
			result += inorder(p.leftChild);
			result += p.key + " ";
			result += inorder(p.rightChild);
		}
		return result;
	}

	// (2) 재귀 삽입
	public void insert(int key) { 
		root = insertKey(root, key);
	}

	// p를 루트로 하는 트리에 key를 삽입하는 메소드 (재귀 알고리즘)
	private Node insertKey(Node p, int key) {
		if(p == null) {		
			Node newNode = new Node(key);
			return newNode;	
		}
		else if(key < p.key) {
			p.leftChild = insertKey(p.leftChild, key);
			return p;		// 루트 불변
		}
		else if(key > p.key) {
			p.rightChild = insertKey(p.rightChild, key);
			return p;		// 루트 불변        
		}
		else {  // key = p.key 인 경우 삽입 실패
			System.out.println("Insertion fail! key duplication : " + key);
			return p;  	// 루트 불변
		}
	}   

	// (3) 후위 순회
	public void printPostorder() {
		postorder(root);
		System.out.println();
	}

	// p를 루트로 하는 트리를 후위 순회하며 키값을 출력하는 메소드
	private void postorder(Node p) {
		// (다) ...
		if(p.leftChild!=null) {
			postorder(p.leftChild);
		}
		if(p.rightChild!=null) {
			postorder(p.rightChild);
		}
		if(p!=null) {
			System.out.print(p.key+" ");
		}
	}

	// (4) 검색 - 트리에 key가 존재하는 지 여부를 리턴하는 메소드  
	public boolean contains(int key) {
		return contains(root, key);
	}

	private boolean contains(Node tmp, int key) {
		if(tmp==null)
			return false;
		else {
			if(tmp.key == key)
				return true;
			else if(tmp.key>key)
				return contains(tmp.leftChild, key);
			else
				return contains(tmp.rightChild, key);
		}
	}

	// (5) 최대값 조회 - 트리의 최대 키 값을 리턴하는 메소드  
	public int max() throws NoSuchElementException {
		if(root == null) {
			// 공백 트리인 경우 예외 발생
			throw new NoSuchElementException("최대값 조회 실패");
		}
		else {
			// 공백 트리가 아닌 경우, 최대 키 값을 찾아 리턴
			return max(root);
		}
	}

	private int max(Node tmp) {
		return (tmp.rightChild==null)?tmp.key : max(tmp.rightChild);
	}

	// (6) 삽입  - 트리에 key를 삽입하고, 삽입 실패 여부를 리턴하는 메소드 (반복 알고리즘)
	public boolean add(int key) {
		if(contains(key))
			return false;
		else {
			Node tmp = root;

			if(root==null)
				root = new Node(key);

			else {
				while(true) {
					if(key>tmp.key) {
						if(tmp.rightChild==null) {
							tmp.rightChild = new Node(key);
							break;
						}
						else {
							tmp = tmp.rightChild;
						}
					}
					else {
						if(tmp.leftChild==null) {
							tmp.leftChild = new Node(key);
							break;
						}
						else {
							tmp = tmp.leftChild;
						}
					}
				}
			}
			return true;
		}
	}

	// 기본적인 제거 알고리즘
	public boolean remove(int item) {
		Node p = root; 
		Node parent = null;
		int deg = 0; // 삭제해야할 노드의 차수

		// 노드 탐색
		while(p != null){

			if(p.key == item)
				break;
			
			else if(p.key > item) {
				parent = p;
				p = p.leftChild;
			}
			else {
				parent = p;
				p = p.rightChild;
			}
		}

		// 탐색 후 p 값이 null인 경우 해당하는 원소가 없으므로 실패 리턴
		if(p == null)
			return false;

		// 자식 노드가 있는지 확인.
		if(p.leftChild != null)
			deg++;
		if(p.rightChild != null)
			deg++;

		// 자식노드 수에 따른 삭제
		if(deg==0) {
			removeZeroChildTree(parent, p);
			return true;
		}
		else if(deg==1) {
			removeOneChildTree(parent, p);
			return true;
		}
		else if(deg==2) {
			removeTwoChildTree(p);
			return true;
		}
		else
			return false;
	}

	// 자식 노드가 없는 트리의 삭제.
	private void removeZeroChildTree(Node parent, Node p){
		if(parent == null) // 부모가 없는 루트 노트의 경우 루트를 null로
			root = null;

		else{	//	아닌 경우 p를 가리키는 parent의 링크를 삭제해서 가비지로 보냄
			if(parent.rightChild == p)
				parent.rightChild = null;
			else
				parent.leftChild = null;
		}
	}

	// 자식 노드가 한개인 트리의 삭제
	private void removeOneChildTree(Node parent, Node p){
		if(parent == null) // 부모가 없는 경우 루트 노드이므로 루트에 하위 노드를 연결.
			root = p.leftChild == null ? p.rightChild : p.leftChild;

		else{	//	자신이 매달려있는 부모의 링크 위치에 자신의 자식 노드를 연결하여 논리적으로 p를 가비지로 보냄.
			if(parent.rightChild == p)
				parent.rightChild = p.leftChild == null ? p.rightChild : p.leftChild;
			else
				parent.leftChild = p.leftChild == null ? p.rightChild : p.leftChild;
		}
	}

	// 자식이 둘인 트리의 삭제
	private void removeTwoChildTree(Node p){
		// 왼쪽 서브트리에서 최대 값을 찾아 삭제할 노드의 값을 바꿈
		Node max = p.leftChild;
		Node parent = p;

		while(max.rightChild != null){	//	현재 노드의 좌측 자식 노드중 가장 큰 값을 가진 노드 검색
			parent = max;
			max = max.rightChild;
		}

		p.key = max.key;	//	받아온 p의 값을 max의 값으로 변경시킨다. 사실상 p의 값은 지워지고 max값이 p 위치에 간다.

		// 트리에 남아있는 중복된 max를 찾아내여 삭제.
		if(max.leftChild != null) // max 노드가 가장 큰 노드이므로 오른쪽 자식은 존재하지 않으므로 자식이 둘인 경우는 없기 때문에 자식 1개인경우와 2개인 경우만 체크.
			removeOneChildTree(parent, max);
		else
			removeZeroChildTree(parent, max);
	}

}