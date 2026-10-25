class CountOccurances{
	public static void main(String args[]){
		int arr[]={5,3,4,6,6,8,2,1,3,5,6,8};
		int target=8;
		int count=0;
		for(int i=0;i<arr.length;i++){
			if(arr[i]==target){
			count++;
			}
	}
	System.out.print(target +" occurces "+count +" times");
	}
}