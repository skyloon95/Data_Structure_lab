package test;

public class Main {

	public static void main(String[] args) {
		
		Node head = new Node();
	}
}

class Node {
	Integer data;
	Node llink;
	Node rlink;
	
	public Node() {
	}
	
	public Node(Integer data) {
		this.data = data;
		this.llink = null;
		this.rlink = null;
	}
	
	public Node(Integer data, Node llink, Node rlink) {
		this.data = data;
		this.llink = llink;
		this.rlink = rlink;
	}
	
	public void insertNode(Node Dr, Node pre, Integer x) {
		Node temp = new Node(x);
		temp.llink = pre;
		temp.rlink = pre.rlink;
		pre.rlink.llink = temp;
		pre.rlink = temp;
		
		if(temp.rlink != null) {
			temp.rlink.llink = new Node();
		}
		
	}
}
