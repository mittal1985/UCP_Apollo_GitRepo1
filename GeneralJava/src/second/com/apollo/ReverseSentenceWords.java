package second.com.apollo;

import java.util.ArrayList;
import java.util.List;

public class ReverseSentenceWords {
public static void main(String[] args) {
	
	String sentnec="I am a big fool";
	String[] arr= sentnec.split(" ");
	int len = arr.length;
	System.out.println(len);
	List<String> list = new ArrayList();
	
	for (int i =len-1;i>=0;i--) {
		list.add(arr[i]);
	}
	
	
	System.out.println(list.toString());
	
}

}
