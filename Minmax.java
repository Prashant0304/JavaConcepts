class Minmax{
	public static void main(String args[]){
		int arr[]={32,43,11,22,48,54,54};
		int min=arr[0];
		int max=arr[0];
		for(int i=0;i<arr.length;i++){
			if(arr[i]<min){
				min=arr[i];
			}
			if(arr[i]>max){
				max = arr[i];
			}
		}
		System.out.println("Minimum value is "+min);
		System.out.println("Maximum value is "+max);
	}
}