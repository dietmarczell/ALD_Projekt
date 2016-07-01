package Final;

public class BinaryTree {

	public Node root;
	
	
	public void addNote(int key, String name)
	{
		
		Node newNode = new Node(key, name);
		
		if(root == null)
		{
			root = newNode;
			
		}
		else
		{
			Node focusNode = root;
			
			Node parent;
			
			while(true)
			{
				parent = focusNode;
				
				if(key < focusNode.Key)
				{
					focusNode = focusNode.leftChild;
					if(focusNode == null)
					{
						parent.leftChild = newNode;
						return;
					}
				}
				else
				{
					focusNode = focusNode.rightChild;
					if(focusNode == null)
					{
						parent.rightChild=newNode;
						return;
					}
				}
			}
		}
		
		
	}
	
	
	public void printNode(Node focusNode)
	{
		if(focusNode!=null)
		{
			printNode(focusNode.leftChild);
			System.out.println(focusNode);
			printNode(focusNode.rightChild);
		
		}
	}
	
	public Node search(String name, Node node)
	{
		if(node !=null)
		{
			if(node.name.equals(name))
			{
				return node;
			}
			else
			{
				Node foundNode = search(name, node.leftChild);
						
					if(foundNode == null)
					{
						foundNode = search(name, node.rightChild);
					}
					return foundNode;
						
			}
		}
			else
			{
				return null;
			}
		}
		
	
	public class Node{
		
		int Key;
		String name;
		Node leftChild;
		Node rightChild;
		
		Node(int key, String name) {
			
			Key = key;
			this.name = name;
		}

		@Override
		public String toString() {
			return name +" has the key " +Key;
		}
		
		public Integer getKey() {
			return Key;
		}
		public String getname() {
			return name;
		}
	}
		
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BinaryTree theTree = new BinaryTree();
		
		theTree.addNote(50, "Boston");
		
		theTree.addNote(25, "Birmingham");
		theTree.addNote(15, "Rapid City");
		theTree.addNote(30, "New York");
		theTree.addNote(75, "Washington");
		theTree.addNote(85, "Bar Harbor");
		theTree.addNote(55, "Miami");
		theTree.addNote(22, "Orlando");
		
		theTree.printNode(theTree.root);
		
		System.out.println("------------------------------");
		
		
		System.out.println(theTree.search("Miami", theTree.root));
		System.out.println(theTree.search("Orlando", theTree.root));

	}
		
	
	
	
	
	

}
