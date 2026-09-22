class Reversearry{
	public static void main(String args[]){
		int arr[]={21,43,54,65,66,51};
		if(arr.length==0){
			System.out.println("Array is empty");
			return;
		}
		int l=0, r=arr.length-1;
		while(l<r){
		  int temp = arr[r];
		  arr[r]=arr[l];
		  arr[l]=temp;
		  l++;
		  r--;
		}
		System.out.println("The reversed array is ");
		
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		
	}
}