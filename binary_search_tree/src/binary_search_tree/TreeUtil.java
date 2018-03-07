package binary_search_tree;

public class TreeUtil {
	Node root;
	Node parent;

	public TreeUtil(int num) {
		root = new Node(num);
		Node parent = null;
	}

	public boolean find(int num) {
		Node tmp = root;
		parent = tmp;

		while(tmp!=null) {
			if(tmp.data == num) {
				return true;
			}

			else if(tmp.data < num) {
				parent = tmp;
				tmp = tmp.rLink;
			}

			else {
				parent = tmp;
				tmp = tmp.lLink;
			}
		}
		return false;
	}
	
	public boolean add(int num) {
		if(find(num)) {
			return false;
		}
		else {
			if(parent.data < num) {
				parent.rLink = new Node(num);
			}
			else {
				parent.lLink = new Node(num);
			}
			return true;
		}
	}
}
