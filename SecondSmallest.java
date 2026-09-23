class SecondSmallest{
	public static void main(String args[]){
		int arr[]={12,43,21,44,56,75,-21,33};
		int smallest=Integer.MAX_VALUE;
		int secondsmallest=Integer.MAX_VALUE;
		for(int i=0;i<arr.length;i++){
			if(arr[i]<smallest){
				secondsmallest=smallest;
				smallest=arr[i];
			}
			else if(arr[i]<secondsmallest && arr[i]!=smallest){
				secondsmallest=arr[i];
			}
		}
		if(secondsmallest==Integer.MAX_VALUE){
			System.out.println("No second smallest value in given array");
		}
		else{
			System.out.println("Second smallest value in given array is "+secondsmallest);
		}
	}
}