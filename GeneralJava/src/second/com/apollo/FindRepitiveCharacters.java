package second.com.apollo;

public class FindRepitiveCharacters {
public static void main(String[] args) {
	String str = "Mittal";
	
	String[] arr=str.split("");
	
	for(int i =0;i<=arr.length-1;i++){
		int count = 0;
		for(int j =0;j<=arr.length-1;j++){
			if(arr[j].equalsIgnoreCase(arr[i])){
				count=count+1;
				
			}
		}
		if(count>1){
			System.out.println(arr[i]);
			arr[i]=arr[i].replace(arr[i],"");
		}
		
	}
	
	
	
	
}
}
