class Nonreapeatedchar{
	public static void main(String args[]){
		String str="MESSSEPPOTOMIA";
		if(str==null || str.isEmpty()){
			System.out.println("String is empty");
			return;
		}
		int arr[] = new int[255];
		str=str.toUpperCase();
		for(int i=0;i<str.length();i++){
			arr[str.charAt(i)]++;
		}
		for(int i=0;i<str.length();i++){
			if(arr[str.charAt(i)]==1){
				System.out.println("The non repeated character is "+str.charAt(i));
				break;
			}
		}
		
	}
}