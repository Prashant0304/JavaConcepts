class ReverseString{
	public static void main(String args[]){
		String str="Welcome to my beautiful life";
		if(str==null || str.isEmpty()){
			System.out.print("Given string is empty");
			return;
		}
		char arr[]=str.toCharArray();
		int l=0,r=arr.length-1;
		while(l<r){
			char temp = arr[l];
			arr[l] = arr[r];
			arr[r] = temp;
			l++;
			r--;
		}
		System.out.print(new String(arr));
	}
}