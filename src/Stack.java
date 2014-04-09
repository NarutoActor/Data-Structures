import list.CLL;


public class Stack <T>{
private CLL<T> stack;
int size=0;
public Stack(){
	stack = new CLL<T>();
}
public Stack(T data){
	stack = new CLL<T>();
	stack.add(data);
}
public void push(T data){
	size = size + 1;
	stack.add(data);
}
public T pop(){
	size = size - 1;
	T info = (T)(stack.deleteRear());
	return info;
}
public T peek(){
	T info = (T)(stack.getRear());
	return info;
}
public boolean isEmpty(){
	return stack.isEmpty();
}
}
