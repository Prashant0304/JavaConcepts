class CountOccurancesOfCharacter{
	public static void main(String args[]){
		String str="Messessepie";
		char target='e';
		if(str==null || str.isEmpty()){
			System.out.print("Given string is empty");
			return;
		}
		int count=0;
		str=str.toLowerCase();
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)==target){
				count++;
			}
		}
		System.out.print("Occurances of the chacter "+target+" is "+count);
	}
}