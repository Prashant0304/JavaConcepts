class MoveZeros{
	public static void main(String args[]){
		int arr[]={0,1,0,12,4,0,5};
		int pos=0;
		for(int i=0;i<arr.length;i++){
			if(arr[i]!=0){
			  arr[pos]=arr[i];
			  pos++;
			}
		}
		while(pos<arr.length){
			arr[pos]=0;
			pos++;
		}
		System.out.println("After moving zeros array is : ");
		for(int num:arr){
			System.out.print(num+" ");
		}
	}
}