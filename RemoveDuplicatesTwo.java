class RemoveDuplicatesTwo{
	public static void main(String args[]){
		int arr[]={1,2,2,3,4,4,5,5,5};
		int slow=0;
		for(int fast =slow+1;fast<arr.length;fast++){
			if(arr[slow]!=arr[fast]){
				slow++;
				arr[slow]=arr[fast];
			}
		}
		System.out.println("After removig duplicates array value is ");
		for(int i=0;i<=slow;i++){
			System.out.print(arr[i]+" ");
		}
	}
}