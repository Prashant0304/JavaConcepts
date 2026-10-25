class MissingNumber{
	public static void main(String args[]){
		int arr[]={1,2,3,4,5,6,7,8,10};
		int n=arr.length+1;
		int expectedSum=(n*(n+1)/2);
		int actualSum=0;
		for(int i=0;i<arr.length;i++){
			actualSum+=arr[i];
		}
		if(expectedSum==actualSum){
			System.out.print("There is no missing number in the givem array");
		}
		else{
			int missingNumber=expectedSum-actualSum;
			System.out.print("The missing number in the givem array is : "+missingNumber);
		}
	}
}