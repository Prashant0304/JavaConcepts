class CheckAnagram{
	public static void main(String args[]){
		String str="Welcome";
		String str1="comeWel";
		if(str == null || str1 ==null || str.length()!=str1.length()){
			System.out.print("Not anagram");
			return;
		}
		str=str.toLowerCase();
		str1=str1.toLowerCase();
		
		int freq[]=new int[26];
		
		for(int i=0;i<str.length();i++){
			freq[str.charAt(i)-'a']++;
			freq[str1.charAt(i)-'a']--;
		}
		
		boolean anagram=true;
		for(int i=0;i<freq.length;i++){
			if(freq[i]!=0){
				anagram=false;
				break;
			}
		}
		if(anagram){
			System.out.print("Anagram");
		}else{
			System.out.print("Not Anagram");
		}
	}
}