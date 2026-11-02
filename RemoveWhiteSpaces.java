class RemoveWhiteSpaces{
	public static void main(String args[]){
		String str="I Love My Life";
		if(str==null || str.isEmpty()){
			System.out.print("The given string is Empty");
			return;
		}
		char arr[]=str.toCharArray();
		int pos=0;
		for(int i=0;i<arr.length;i++){
			if(arr[i]!=' '){
				arr[pos]=arr[i];
				pos++;
			}
		}
		String result = new String(arr,0,pos);
		System.out.print(result);
	}
}