/*
 * ���ϸ�: MyDoublyLinkedList.java
 * �ۼ���: �𼳾�
 * �ۼ���: 2017�� 10�� 10��
 * ����: ���߿����ڷᱸ���� ��������Ʈ�� ������ MyDoublyLinkedList Ŭ����
 */

package hw6_3;

public class MyDoublyLinkedList {

	private Node head;	// ����Ʈ�� ù��° ��带 ����ų ����
	private int count;	// ����Ʈ�� ���� ���� ��Ÿ���� ����

	public MyDoublyLinkedList() {
		head = null;
		count = 0;
	}

	// ����Ʈ ���̸� ����
	public int size() {
		return count;
	}

	// ����Ʈ�� �� �տ� item�� ����
	public void addFirst(int item) {

		// (1) �����Ͱ� item�� ���ο� ��� ����
		Node newNode = new Node(item);

		// (2) ���ο� ��带 ����Ʈ�� �� �տ� ����
		if(head != null) {
			newNode.rlink = head;
			head.llink = newNode;
			head = newNode;
		}
		else {
			head = newNode;
		}

		// (3) ���� �� 1 ����
		count ++;

	}

	// ����Ʈ �� �� ���� ������ ����
	public int removeFirst() throws NullPointerException {
		Node tmp = head;

		if(head!=null) {
			if(head.rlink!=null) {
				tmp.rlink.llink = null;
				head = tmp.rlink;
				this.count--;
			}
			else {
				head=null;
				this.count--;
			}
		} else {
			throw new NullPointerException();
		}

		return tmp.data;
	}

	// �Է¹��� �� ����.
	public void remove(int item) {
		Node tmp = head;

		if(count!=0) {
			if(head.data==item) {
				if(count==1) {
					head=null;
					this.count--;
				}
				else {
					head = tmp.rlink;
					head.llink = null;
					this.count--;
				}
			}
			else {
				while(tmp.rlink!=null) {
					tmp = tmp.rlink;
					if(tmp.data==item) {
						if(tmp.rlink!=null) {
							tmp.rlink.llink = tmp.llink;
							tmp.llink.rlink = tmp.rlink;
							this.count--;
							break;
						} else
						{
							tmp.llink.rlink = null;
							this.count--;
						}
					}

				}

			}
		}
	}


	// ����Ʈ�� ����⿬���� ����� �̷�������� Ȯ��
	public void printLink() {
		if (head == null) {
			System.out.println("���鸮��Ʈ��");
		}
		else {
			// ����Ʈ�� ���������� ���
			Node temp = head;
			System.out.print("����Ʈ ����=" + count + " ������ ��ũ: ");
			while(temp.rlink != null) {
				System.out.print(temp.data + "->");
				temp = temp.rlink;
			}
			System.out.print(temp.data);

			// ����Ʈ�� ���������� ���
			System.out.print(" ������ ��ũ: ");
			while(temp.llink != null) {
				System.out.print(temp.data + "->");
				temp = temp.llink;
			}
			System.out.println(temp.data);
		}
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		if (head == null) {
			return "[]";
		}
		else {
			// ����Ʈ�� ���������� ���
			Node temp = head;
			buffer.append("[");
			while(temp.rlink != null) {
				buffer.append(temp.data + ",");
				temp = temp.rlink;
			}
			buffer.append(temp.data+"]");
		}
		return buffer.toString();
	}

	// ���߿��Ḯ��Ʈ ��� ����
	private class Node {
		int data;
		Node llink; 
		Node rlink;

		Node() {
			this(0, null, null);
		}
		Node(int data) {
			this(data, null, null);
		}
		Node(int data, Node llink, Node rlink) {
			this.data = data;
			this.llink = llink;
			this.rlink = rlink;
		}
	}
}
