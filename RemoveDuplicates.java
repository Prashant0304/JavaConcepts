import java.util.*;

class RemoveDuplicates{
	public static void main(String args[]){
		int arr[]={10,22,11,21,11,23,11,44,23};
		LinkedHashSet<Integer> set = new LinkedHashSet<>();
		for(int num:arr){
			set.add(num);
		}
		System.out.println("After removing dulipcated from an array");
		for(int num:set){
			System.out.print(num +" ");
		}
	}
}