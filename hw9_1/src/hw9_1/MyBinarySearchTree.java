/* 
 * ���ϸ�: MyBinarySearchTree.java
 * �ۼ���: 2017.11.22
 * �ۼ���: �𼳾�
 * ����: int�� Ű�� �����ϴ� ����Ž��Ʈ���� �����ڷᱸ���� ������ Ŭ����
 */

package hw9_1;

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
		if(contains(root, key))
			return false;
		else {
			Node tmp = root;

			while(tmp!=null) {
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
			return true;
		}
	}
}