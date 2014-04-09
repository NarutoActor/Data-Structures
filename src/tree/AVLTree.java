package tree;

import java.util.NoSuchElementException;

import javax.management.RuntimeErrorException;

public class AVLTree<T extends Comparable<T>> {
	AVLNode<T> root;
	
	
	public class AVLNode<T extends Comparable<T>>{
		AVLNode<T> parent;
		AVLNode<T> left;
		AVLNode<T> right;
		T data;
		int height;
		int BF;//Balance Factor
	public AVLNode(T data){
		this.data = data;
	}
	}
	
	public void add(T data){
		if(root==null){
			root = new AVLNode<T>(data);
			return;
		}
		AVLNode<T> temp = root;
		int c = 0;
		while(temp!=null){
			c = temp.data.compareTo(data);
			if(c==0){
				//error duplicates
			}
			else if(c<0){
				if(temp.right==null){
					temp.right = new AVLNode<T>(data);
					UpdateHeight(temp);
					UpdateBF(temp);
				}
				else{
					temp = temp.right;
				}
			}
			else if(c>0){
				if(temp.left==null){
					temp.left = new AVLNode<T>(data);
					UpdateHeight(temp);
					UpdateBF(temp);
				}
				else{
					temp = temp.left;
				}
			}
			
		}
		if(!this.isBal()){
			//TODO Transformations and Roations
		}
	}
	private void UpdateHeight(AVLNode<T> par){
		while(par!=null){
			par.height = par.height + 1;
			par = par.parent;
		}
	}
	private void UpdateBF(AVLNode<T> par){
		int L,R;
		while(par!=null){
			if(par.left==null){
				L = 0;
			}
			else{
				L = par.left.height;
			}
			if(par.right==null){
				R = 0;
			}
			else{
				R = par.right.height;
			}
			par.BF = R - L;
			
		}
	}
	private boolean isBal(){
		if(Math.abs(root.BF)>1){
			return false;
		}
		return true;
	}
	public int getHeight(String unicode) throws NoSuchElementException{
		AVLNode<T> temp = root;
		return getHeightHelper(temp,unicode);
	}
	private int getHeightHelper(AVLNode<T> temp, String unicode){
		if(temp==null){
			throw new NoSuchElementException();
		}
		if(unicode.equals("")){
			return temp.height;
		}
		int d = Integer.parseInt(unicode.charAt(0)+"");
		if(d==1){
			if(unicode.length()>1){
				return getHeightHelper(temp.right,unicode.substring(1));
			}
			else{
				return getHeightHelper(temp.right,"");
			}
		}
		else if(d==0){
			if(unicode.length()>1){
				return getHeightHelper(temp.left,unicode.substring(1));
			}
			else{
				return getHeightHelper(temp.left,"");
			}
		}
		else{
			throw new RuntimeErrorException(null);
		}
	}
}
