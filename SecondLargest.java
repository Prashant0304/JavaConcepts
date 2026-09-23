class SecondLargest{
	public static void main(String args[]){
		int largest = Integer.MIN_VALUE;
		int secondLargest = Integer.MIN_VALUE;
		int arr[]={10,20,30,40,50,60};
		for(int i=0;i<arr.length;i++){
			if(arr[i]>largest){
				secondLargest=largest;
				largest=arr[i];
			}
			else if(arr[i]>secondLargest && arr[i]!=largest){
				secondLargest=arr[i];
			}
		}
		if(secondLargest==Integer.MIN_VALUE){
			System.out.println("There is no second largest element in given array");
		}
		else{
			System.out.println("Second largest element in array "+secondLargest);
		}
	}
}