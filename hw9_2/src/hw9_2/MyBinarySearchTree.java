/* 
 * ���ϸ�: MyBinarySearchTree.java
 * �ۼ���: 2017.11.28
 * �ۼ���: �𼳾�
 * ����: int�� Ű�� �����ϴ� ����Ž��Ʈ���� �����ڷᱸ���� ������ Ŭ����
 */

package hw9_2;

import java.util.NoSuchElementException;

class MyBinarySearchTree {
	private Node root = null;// Ʈ���� ��Ʈ ��带 ����ų �ν��Ͻ� ���� root �����ϰ� null�� �ʱ�ȭ
	// (��) ...



	// Ʈ���� ��带 ǥ���ϴ� Ŭ���� - �ʵ�(int�� key, leftChild, rightChild), ������(key���� �Ű������Ͽ� �ʱ�ȭ)
	private class Node {
		// (��) ...
		public int key;
		public Node leftChild;
		public Node rightChild;

		public Node(int key) {
			this.key = key;
			this.leftChild = null;
			this.rightChild = null;
		}



	}

	// (1) ��ü��ȸ�� ���� toString() �������̵�
	@Override
	public String toString() {
		String result = inorder(root);
		return result;
	}

	// p�� ��Ʈ�� �ϴ� Ʈ���� ���� ��ȸ�ϸ� Ű���� ���ڿ��� �����ϴ� �޼ҵ�(��� �˰���)
	private String inorder(Node p) {
		String result = "";
		if(p != null) {
			result += inorder(p.leftChild);
			result += p.key + " ";
			result += inorder(p.rightChild);
		}
		return result;
	}

	// (2) ��� ����
	public void insert(int key) { 
		root = insertKey(root, key);
	}

	// p�� ��Ʈ�� �ϴ� Ʈ���� key�� �����ϴ� �޼ҵ� (��� �˰���)
	private Node insertKey(Node p, int key) {
		if(p == null) {		
			Node newNode = new Node(key);
			return newNode;	
		}
		else if(key < p.key) {
			p.leftChild = insertKey(p.leftChild, key);
			return p;		// ��Ʈ �Һ�
		}
		else if(key > p.key) {
			p.rightChild = insertKey(p.rightChild, key);
			return p;		// ��Ʈ �Һ�        
		}
		else {  // key = p.key �� ��� ���� ����
			System.out.println("Insertion fail! key duplication : " + key);
			return p;  	// ��Ʈ �Һ�
		}
	}   

	// (3) ���� ��ȸ
	public void printPostorder() {
		postorder(root);
		System.out.println();
	}

	// p�� ��Ʈ�� �ϴ� Ʈ���� ���� ��ȸ�ϸ� Ű���� ����ϴ� �޼ҵ�
	private void postorder(Node p) {
		// (��) ...
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

	// (4) �˻� - Ʈ���� key�� �����ϴ� �� ���θ� �����ϴ� �޼ҵ�  
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

	// (5) �ִ밪 ��ȸ - Ʈ���� �ִ� Ű ���� �����ϴ� �޼ҵ�  
	public int max() throws NoSuchElementException {
		if(root == null) {
			// ���� Ʈ���� ��� ���� �߻�
			throw new NoSuchElementException("�ִ밪 ��ȸ ����");
		}
		else {
			// ���� Ʈ���� �ƴ� ���, �ִ� Ű ���� ã�� ����
			return max(root);
		}
	}

	private int max(Node tmp) {
		return (tmp.rightChild==null)?tmp.key : max(tmp.rightChild);
	}

	// (6) ����  - Ʈ���� key�� �����ϰ�, ���� ���� ���θ� �����ϴ� �޼ҵ� (�ݺ� �˰���)
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

	// �⺻���� ���� �˰���
	public boolean remove(int item) {
		Node p = root; 
		Node parent = null;
		int deg = 0; // �����ؾ��� ����� ����

		// ��� Ž��
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

		// Ž�� �� p ���� null�� ��� �ش��ϴ� ���Ұ� �����Ƿ� ���� ����
		if(p == null)
			return false;

		// �ڽ� ��尡 �ִ��� Ȯ��.
		if(p.leftChild != null)
			deg++;
		if(p.rightChild != null)
			deg++;

		// �ڽĳ�� ���� ���� ����
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

	// �ڽ� ��尡 ���� Ʈ���� ����.
	private void removeZeroChildTree(Node parent, Node p){
		if(parent == null) // �θ� ���� ��Ʈ ��Ʈ�� ��� ��Ʈ�� null��
			root = null;

		else{	//	�ƴ� ��� p�� ����Ű�� parent�� ��ũ�� �����ؼ� �������� ����
			if(parent.rightChild == p)
				parent.rightChild = null;
			else
				parent.leftChild = null;
		}
	}

	// �ڽ� ��尡 �Ѱ��� Ʈ���� ����
	private void removeOneChildTree(Node parent, Node p){
		if(parent == null) // �θ� ���� ��� ��Ʈ ����̹Ƿ� ��Ʈ�� ���� ��带 ����.
			root = p.leftChild == null ? p.rightChild : p.leftChild;

		else{	//	�ڽ��� �Ŵ޷��ִ� �θ��� ��ũ ��ġ�� �ڽ��� �ڽ� ��带 �����Ͽ� �������� p�� �������� ����.
			if(parent.rightChild == p)
				parent.rightChild = p.leftChild == null ? p.rightChild : p.leftChild;
			else
				parent.leftChild = p.leftChild == null ? p.rightChild : p.leftChild;
		}
	}

	// �ڽ��� ���� Ʈ���� ����
	private void removeTwoChildTree(Node p){
		// ���� ����Ʈ������ �ִ� ���� ã�� ������ ����� ���� �ٲ�
		Node max = p.leftChild;
		Node parent = p;

		while(max.rightChild != null){	//	���� ����� ���� �ڽ� ����� ���� ū ���� ���� ��� �˻�
			parent = max;
			max = max.rightChild;
		}

		p.key = max.key;	//	�޾ƿ� p�� ���� max�� ������ �����Ų��. ��ǻ� p�� ���� �������� max���� p ��ġ�� ����.

		// Ʈ���� �����ִ� �ߺ��� max�� ã�Ƴ��� ����.
		if(max.leftChild != null) // max ��尡 ���� ū ����̹Ƿ� ������ �ڽ��� �������� �����Ƿ� �ڽ��� ���� ���� ���� ������ �ڽ� 1���ΰ��� 2���� ��츸 üũ.
			removeOneChildTree(parent, max);
		else
			removeZeroChildTree(parent, max);
	}

}