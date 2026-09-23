class Palindrome{
	public static void main(String args[]){
		String str="Gadag";
		if(str==null || str.isEmpty()){
			System.out.println("Given string is empty");
			return;
		}
		str=str.toUpperCase();
		boolean isPalindrome=true;
		int l=0 , r=str.length()-1;
		while(l<r){
			if(str.charAt(l)!=str.charAt(r)){
				isPalindrome=false;
				break;
			}
			l++;
			r--;
		}
		if(isPalindrome){
			System.out.println("The given string is palindrome");
		}
		else{
			System.out.println("The given string is not palindrome");
		}
	}
}