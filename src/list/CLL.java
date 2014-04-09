package list;
import java.util.NoSuchElementException;


public class CLL<T> {
	CLLNode<T> rear;
	public CLL(){
		
	}
public class CLLNode<T>{
	T data;
	CLLNode<T> next;
	public CLLNode(T data){
		this.data = data;
		next = this;
		this.next = next;
	}
}//CLL NODE CLASS
public void add(T data){
	addtoRear(data);
}
public void addtoRear(T data){
	if(rear==null){
		rear = new CLLNode<T>(data);
	}
	else{
	CLLNode<T> front = rear.next;
	rear.next = new CLLNode<T>(data);
	rear.next.next = front;
	rear = rear.next;
	}
}
public void addtoFront(T data){
	
}
public LinkedList toLinkedList(){
	LinkedList<T> l = new LinkedList<T>();
	CLL<T> r = this.reverse();
	CLLNode<T> temp = r.rear.next;
	do{
		l.addtoFront(temp.data);
		temp = temp.next;
	}while(temp!=r.rear.next);
	return l;
}
public void print(){
	CLLNode<T> temp = rear.next;//the front
	do{
		System.out.print(temp.data+"\t");
		temp = temp.next;
	}while(temp!=rear.next);
	System.out.println();
}
public CLL<T> reverse(){
	CLL<T> k = new CLL<T>();
	CLLNode<T> temp = this.rear;
	do{
	k.addAfterfront(temp.data);
	temp = temp.next;
	}while(temp!=rear);
	return k;
}
public int size(){
	int size = 0;
	CLLNode<T> temp = rear;//front
	do{
		size = size + 1;
		temp = temp.next;
	}while(temp!=rear);
	return size;
}
public void shiftL(int a){
	shift(a,false);
}
public void shiftR(int a){
	shift(a,true);
}
public void shift(int a, boolean swich){
	if(swich){//Right Shift
		//since left shifts are easier we will use left sifts to do right shifts
		//since left and right shifts are complemnts than we can infer the following
		//this.size()-rightsifs = leftshifts
		shiftL(this.size()-a);
	}else{//Left shift
		if(a<0){
			a = a * -1;
		}
		while(a>0){
			rear = rear.next;
			a=a-1;
		}
	}
}
public void printAmount(int n){
	if(n>this.size()){
		n = this.size();
	}
	CLLNode<T> temp = rear.next;
	for(int i=0;i<n;i++){
		System.out.print(temp.data+"\t");
		temp = temp.next;
	}
	System.out.println();
}
public boolean isEmpty(){
	if(rear==null){
	return true;
	}
	return false;
}
public T get(int index){
	CLLNode<T> temp = rear;
	
	for(int i=0;i<=index;i++){
		temp = temp.next;
	}
	return (T)(temp.data);
}
public T getRear(){
	T info = (T)(this.rear.data);
	return info;
}
public void deleteFirstOccurence(T target){
	CLLNode<T> front = this.rear.next;
	CLLNode<T> prev = this.rear;
	do{
		if(front.data==target){
			prev.next = front.next;
			return;
		}
		prev = front;
		front = front.next;
	}while(front!= rear.next);
	throw new NoSuchElementException();
} 
public T deleteRear(){
	T info = (T)(this.rear.data);
	CLL<T> r = this.reverse();
	r.rear.next = r.rear.next.next;
	this.rear = r.reverse().rear;
	return info;
}
public T deleteFront(){
	T info = (T)(this.rear.next.data);
	rear.next = rear.next.next;
	return info;
}
public void addAfterfront(T data){
	if(rear==null){
		rear = new CLLNode<T>(data);
		rear.next = rear;
	}
	else if(rear.next==rear){
		addtoRear(data);
	}
	else{
		CLLNode<T> front = rear.next;
		CLLNode<T> tempNode = front.next;
		front.next = new CLLNode<T>(data);
		front.next.next = tempNode;
		
	}
}
public CLL<T> deleteLastOccurence(T item) throws NoSuchElementException{
	CLL<T> trans = this.reverse();
	trans.deleteFirstOccurence(item);
	return trans.reverse();
}

}//CLL CLASS
