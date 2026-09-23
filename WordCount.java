class WordCount{
	public static void main(String args[]){
		String str="Hello my friends";
		if(str==null || str.isEmpty()){
			System.out.println("Given string is empty");
			return;
		}
		int count=1;
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)==' '){
				count++;
			}
		}
		System.out.println("The word count in given sentence is "+count);
	}
}