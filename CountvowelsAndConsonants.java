class CountvowelsAndConsonants{
	public static void main(String args[]){
		String str="I Love my life";
		if(str==null || str.isEmpty()){
			System.out.print("Given string is empty");
			return;
		}
		str=str.toUpperCase();
		int vowelCount=0;
		int consonatCount=0;
		int countSpaces=0; 
		char arr[]=str.toCharArray();
		for(int i=0;i<arr.length;i++){
			if(arr[i]=='A'||arr[i]=='E'|| arr[i]=='I'||arr[i]=='O'||arr[i]=='U'){
					vowelCount++;
				}
			else if(arr[i]==' ' ){
				countSpaces++;
			}
			else if(Character.isLetter(arr[i])){
				consonatCount++;
			}
		}
		System.out.println("Vowel counts in given string "+vowelCount);
		System.out.println("Consonats counts in given string "+consonatCount);
		System.out.println("spaces counts in given string "+countSpaces);
		
	}
}