class BinarySearch{
	public static void main(String args[]){
		int arr[]={2,4,6,8,10,12,14,16,18};
		int k=12;
		boolean found=false;
		int low=0 , high=arr.length-1;
		while(low<=high){
			int mid = low+(high-low)/2;
			if(k==arr[mid]){
				System.out.println("The value found at index : "+mid);
				found=true;
				break;
			}
			else if(k<arr[mid]){
				high=low-1;
			}
			else{
				low=low+1;
			}
		}
		if(!found){
			System.out.println("The element is not found in the array");
		}
	}
}