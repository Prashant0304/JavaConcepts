class TwoSum{
	public static void main(String args[]){
		int arr[]={2,4,3,5,6,1,-1};
		int target=5;
		int count=0;
		for(int i=0;i<arr.length;i++){
			for(int j=i+1;j<arr.length;j++){
				if(arr[i]+arr[j]==target){
					System.out.println("Pair found : "+arr[i]+ " ,"+arr[j]);
					count++;
				}
			}
		}
		System.out.println("Total pair count : "+count);
	}
}