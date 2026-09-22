class Max{
	public static void main(String args[]){
		int arr[]={12,43,23,47,55,22};
		int max=arr[0];
		for(int i=0;i<arr.length;i++){
			if(arr[i]>max){
				max=arr[i];
			}
		}
		System.out.println("The maximum value in an array is "+max);
	}
}