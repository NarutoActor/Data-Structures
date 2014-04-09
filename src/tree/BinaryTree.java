package tree;
import java.util.ArrayList;
public class BinaryTree<T extends Comparable<T>> {
BTN<T> root;
	public BinaryTree(T data){
		root = new BTN(data);
	}
	public class BTN<T extends Comparable<T>>{
		T data;
		BTN<T> LeftChild;
		BTN<T> RightChild;
		public BTN(T data){
			this.data = data;
		}
	}
	public void add(T data){
		BTN<T> temp = root;
		int x = 0;
		while(temp!=null){
			x = temp.data.compareTo(data);
			if(x==0){
				//Duplicate Element
				return;
			}
			else if(x<0){//go Right
				if(temp.RightChild==null){
					temp.RightChild = new BTN<T>(data);
					return;
				}
				else{
					temp = temp.RightChild;
				}
			}
			else if(x>0){
				if(temp.LeftChild==null){
					temp.LeftChild = new BTN<T>(data);
					return;
				}
				else{
					temp = temp.LeftChild;
				}
			}
		}
	}
	public boolean find(T data){
		BTN<T> temp = root;
		int x = 0;
		while(temp!=null){
			x = temp.data.compareTo(data);
			if(x==0){
				return true;
			}
			else if(x<0){//go Right
				if(temp.RightChild==null){
					return false;
				}
				else{
					temp = temp.RightChild;
				}
			}
			else if(x>0){
				if(temp.LeftChild==null){
					return false;
				}
				else{
					temp = temp.LeftChild;
				}
			}
		}
		return false;
	}
	public String getCode(T data){
		BTN<T> temp = root;
		int x = 0;
		String code = "1";//used to be X
		while(temp!=null){
			x = temp.data.compareTo(data);
			if(x==0){
				return code;
			}
			else if(x<0){//go Right
				if(temp.RightChild==null){
					return "0";
				}
				else{
					temp = temp.RightChild;
					code = code +"1";
				}
			}
			else if(x>0){
				if(temp.LeftChild==null){
					return "0";
				}
				else{
					temp = temp.LeftChild;
					code = code + "0";
				}
			}
		}
		return "0";
	}
	public void printTree(){
		ArrayList<BTN<T>> noods = new ArrayList<BTN<T>>();
		ArrayList<BTN<T>> temp = new ArrayList<BTN<T>>();
		noods.add(root);
		int nulA = 0;
		boolean life = true;
		while(life){
		for(int i=0;i<noods.size();i++){
			if(noods.get(i)!=null){
			System.out.print(noods.get(i).data+",\t");
			}
			else{
				System.out.print(-1+",\t");
			}
		}
		System.out.println();
		for(int i=0;i<noods.size();i++){
			if(noods.get(i)!=null){
			temp.add(noods.get(i).LeftChild);
			temp.add(noods.get(i).RightChild);
			}
			else{
				temp.add(null);
				temp.add(null);
			}
		}
		noods = temp;
		temp = new ArrayList<BTN<T>>();
		for(int i = 0;i<noods.size();i++){
			if(noods.get(i)==null){
				nulA = nulA + 1;
			}
		}
		if(noods.size()==nulA){
			life = false;
		}
		else{
			nulA = 0;
		}
	}
		
	}
	public int height(){
		BTN<T> temp = root;
		
		return helper(temp,1);
	}
	private int helper(BTN<T> node, int k){
		if(hasChild(node)){
			k = k + 1;
			return Math.max(helper(node.LeftChild,k),helper(node.RightChild,k));
		}
		else{
			return k;
		}
	}
	public boolean hasChild(BTN<T> node){
		if(node==null){
			return false;
		}
		else if(node.LeftChild==null&&node.RightChild==null){
			return false;
		}
		else{
			return true;
		}
	}
	public Object[] toArray(){
		T[] o = (T[])new Object[NodeAmount()];
		return o;
	}
	public int NodeAmount(){
		BTN<T> temp = root;
		return helper2(temp,1)-1;
	}
	private int helper2(BTN<T> node, int k){
		
		if(node==null){
			return k;
		}
		//k= k + ChildAmount(node);
		return helper2(node.LeftChild,k)+helper2(node.RightChild,k);
		
		
	}
	public int ChildAmount(BTN<T> node){
		if(node==null){
			return 0;
		}
		else if((node.LeftChild!=null&&node.RightChild==null)||(node.LeftChild==null&&node.RightChild!=null)){
			return 1;
		}
		else if(node.LeftChild!=null&&node.RightChild!=null){
			return 2;
		}
		return 0;
	}
	public boolean isStrickBinary(){// 2 kids or no kids
		BTN<T> temp = root;
		return isStrickBinaryHelper(temp);
	}
	private boolean isStrickBinaryHelper(BTN<T> temp){
		if(temp==null){
			return true;
		}
		else if(temp.LeftChild==null&&temp.RightChild!=null){
			return false;
			
		}
		else if(temp.LeftChild!=null&&temp.RightChild==null){
			return false;
			
		}
		return isStrickBinaryHelper(temp.LeftChild)&&isStrickBinaryHelper(temp.RightChild);
		
	}
	private boolean isPerfectBalance(){
		return false;//TODO
	}
	public boolean isCompleateBinary(){
		return isPerfectBalance()&&isStrickBinary();
	}
	/**
	 * Printing the contents of the tree in an inorder way.
	 */
	public void printInorder(){
	  printInOrderRec(root);
	  System.out.println("");
	}

	/**
	 * Helper method to recursively print the contents in an inorder way
	 */
	private void printInOrderRec(BTN<T> currRoot){
	  if ( currRoot == null ){
	    return;
	  }
	  printInOrderRec(currRoot.LeftChild);
	  System.out.print(currRoot.data+"\t" );
	  printInOrderRec(currRoot.RightChild);
	}
	/**
	 * Printing the contents of the tree in a Preorder way.
	 */
	public void printPreorder() {
	  printPreOrderRec(root);
	  System.out.println("");
	}

	/**
	 * Helper method to recursively print the contents in a Preorder way
	 */
	private void printPreOrderRec(BTN<T> currRoot) {
	  if (currRoot == null) {
	    return;
	  }
	  System.out.print(currRoot.data + "\t");
	  printPreOrderRec(currRoot.LeftChild);
	  printPreOrderRec(currRoot.RightChild);
	}
	/**
	 * Printing the contents of the tree in a Postorder way.
	 */
	public void printPostorder() {
	  printPostOrderRec(root);
	  System.out.println("");
	}

	/**
	 * Helper method to recursively print the contents in a Postorder way
	 */
	private void printPostOrderRec(BTN<T> currRoot) {
	  if(currRoot==null){
	    return;
	  }
	  printPostOrderRec(currRoot.LeftChild);
	  printPostOrderRec(currRoot.RightChild);
	  System.out.print(currRoot.data + "\t");

	}
}
