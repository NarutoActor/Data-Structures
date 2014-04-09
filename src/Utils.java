import java.util.*;


public class Utils {
public void addAfterfront(){
	
}
public static int EvalPostFix(String Postfix){
	Stack<Integer> s = new Stack<Integer>();
	int a, b;
	for(int i=0;i<Postfix.length();i++){
		if(Character.isDigit(Postfix.charAt(i))){
			s.push(Integer.parseInt(""+Postfix.charAt(i)));
		}
		else if(Postfix.charAt(i)=='*'){
			a = s.pop();
			b = s.pop();
			s.push(a*b);
		}
		else if(Postfix.charAt(i)=='+'){
			a = s.pop();
			b = s.pop();
			s.push(a+b);
		}
		else if(Postfix.charAt(i)=='-'){
			a = s.pop();
			b = s.pop();
			s.push(a-b);
		}
		else if(Postfix.charAt(i)=='/'){
			a = s.pop();
			b = s.pop();
			s.push(b/a);
		}
	}
	return s.pop();
}
	//public static String InfixToPostfixConvert(String infixBuffer){
		//Stack<Character> s = new Stack<Character>
		//return null;
	//}
	public static String InfixtoPostfix(String ini){
		String post = "";
		if(ini.charAt(0)=='('){
			
		}
		return null;
	}
	

}
