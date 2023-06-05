public class Main {
	static boolean[] arr;
	public static void main(String[] args) {
		arr = new boolean[10001];
		for(int i=1;i<10001;i++) {
			indo(i);
		}
		for(int i=1;i<10001;i++) {
			if(!arr[i]) {
				System.out.println(i);
			}
		}
		
	}
	private static void indo(int i) {
		int sum = i;
		String str = Integer.toString(i);
		for(int j=0; j<str.length();j++) {
			sum+=str.charAt(j)-'0';
		}
		if(sum<10001) {
			arr[sum] = true;
		}
	}
	
}