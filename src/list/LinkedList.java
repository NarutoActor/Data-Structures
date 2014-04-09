package list;
import java.util.NoSuchElementException;
public class LinkedList<T> {
Node<T> front;
	public class Node <T>{
		Node<T> next;
		T data;
		public Node(T data){
			this.data = data;
		}
	}
	public void add(T data){
		addtoRear(data);
	}
	public void addtoRear(T data){
		if(front==null){
			front = new Node<T>(data);
			front.next=null;
		}
		else if(front.next==null){
			front.next = new Node<T>(data);
			front.next.next=null;
		}
		else{
			Node<T> temp = front;
			Node<T> prev = front;
			
			while(temp!=null){
				prev = temp;
				temp = temp.next;
			}
			prev.next = new Node<T>(data);
			prev.next.next=null;
		}
		
	}//End of METHOD
	public void addtoFront(T data){
		Node<T> temp = new Node<T>(data);
		temp.next= front;
		front = temp;
	}
	public void addBefore(int index, T data){
		if(index==0){
			Node<T> f = new Node<T>(data);
			f.next = this.front;
			this.front=f;
		}
		else{
		addAfter(index-1,data);
		}
	}
	public void addAfter(int index, T data){
		Node<T> spot = getNode(index);
		Node<T> after = spot.next;
		Node<T> added = new Node<T>(data);
		spot.next = added;
		added.next = after;
	}
	public int numberOfOccurrences(T target){
		int n=0;
		Node<T> temp = front;
		while(temp != null){
			if(temp.data==target){
				n = n + 1;
			}
			temp = temp.next; 
		}
		return n;
	}
	public void removeEvens(){
		Node<T> temp = front;
		if(this.Size()%2!=0){
			this.add((T)(this.get(0)));
		}
		while(temp!=null){
		temp.next = temp.next.next;
		temp=temp.next;
		}
		
	}
	public void removeOdds(){
		Node<T> temp = front.next;
		if(this.Size()%2==0){
			this.add((T)(this.get(0)));
		}
		while(temp!=null){
		temp.next = temp.next.next;
		temp=temp.next;
		}
		front = front.next;
	}
	public LinkedList<T> getEvens(){//TODO error padding
		Node<T> temp = front.next;
		LinkedList<T> j = new LinkedList<T>();
		while(temp!=null){
		j.add(temp.data);
		temp=temp.next.next;
		}
		return j;
	}
	public LinkedList<T> getOdds(){
		Node<T> temp = front;
		LinkedList<T> j = new LinkedList<T>();
		while(temp!=null){
		j.add(temp.data);
		temp=temp.next.next;
		}
		return j;
	}
	public static <T>void diference(LinkedList<T> A, LinkedList<T> B){//A-B
		
	}
	public static <T extends Comparable<T>> LinkedList<T> merge(LinkedList<T> A, LinkedList<T> B){//Thinking about swiching to fronts
		
		return null;
	}
	public T get(int index){
		Node<T> temp = front;
		
		for(int i=0;i<index;i++){
			temp = temp.next;
		}
		return (T)(temp.data);
	}
	public Node<T> getNode(int index){
		Node<T> temp = front;
		
		for(int i=0;i<index;i++){
			temp = temp.next;
		}
		return temp;
	}
	public void delete(T target) throws NoSuchElementException{
		deleteMethod(target,false);
	}
	public void deleteAll(T target) throws NoSuchElementException{
		deleteMethod(target,true);
	}
	private void deleteMethod(T target, boolean all) throws NoSuchElementException{
		if(front==null){
			throw new NoSuchElementException();
		}
		else if(front!=null && front.data==target){
			front = front.next;
			return;
		}
		Node<T> temp = front;
		Node<T> prev = front;
		int amount = 0;
		while(temp!=null){
			
			if(temp.data==target){
				prev.next = temp.next;
				if(!all){
				return;
				}
				amount = amount + 1;
			}
			prev = temp;
			temp = temp.next;
			
		}
		if(amount == 0){
		throw new NoSuchElementException();
		}
	}//End of Method
	public void clear(){
		front = null;
	}
	public boolean exist(T target){
		Node<T> temp = front;
		while(temp!=null){
			if(temp.data==target){
				return true;
			}
			temp = temp.next;
		}
		return false;
		
	}
	public int Size(){
		int size = 0;
		Node<T> temp = front;
		while(temp!=null){
			size = size + 1;
			temp = temp.next;
		}
		return size;
	}
	public Object[] toArray(){
		Node<T> temp = front;
		Object[] o = new Object[Size()];
		for(int i=0;i<o.length;i++){
			o[i] = temp.data;
			temp = temp.next;
		}
		return o;
	}
	public void print(){
		for(Node<T> temp=front;temp!=null;temp=temp.next){
			System.out.print(temp.data+"\t");
		}
		System.out.println();

	}
	public LinkedList<T> reverse(){
		LinkedList<T> L = new LinkedList<T>();
		
		for(Node<T> temp=front;temp!=null;temp=temp.next){
			L.addtoFront(temp.data);
		}
		return L;
	}
	public CLL<T> toCircular(){
		CLL<T> n = new CLL<T>();
		for(Node<T> temp = front;temp!=null;temp=temp.next){
			n.add(temp.data);
		}
		return n;
	}
}
