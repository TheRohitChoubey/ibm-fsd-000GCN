package comm.example7;
import java.util.*;

public class Tester {
	public static int[] arr = {100,1,20,30,0};
	public static int[] b = new int[5];
	
	public static void mergesort(int low, int high){
		if(low<high) {
			int mid= (low+high)/2;
			mergesort(low,mid);
			mergesort(mid+1,high);
			merges(low,mid,high);
		}
	}
	
	public static void merges(int low, int mid, int high){
		int i= low;
		int j= mid+1;
		int k = low;
		
		while((i<=mid) && (j<=high)) {
			if(arr[i]>=arr[j]) {
				b[k++]=arr[j++];
			}
			else {
				b[k++]=arr[i++];
			}
		}
		
		while(i<=mid) {
			b[k++]=arr[i++];
		}
		
		while(j<=high) {
			b[k++]=arr[j++];
		}
		
		for(int l=low; l<=high; l++) {
			arr[l]=b[l];
		}
		
	}
	
	public static void main(String[] args) {
		
		/*
		Arrays.sort(arr);
		
		System.out.println("Sorted array ="+Arrays.toString(arr));
		
		System.out.println((Arrays.binarySearch(arr, 0)));
		*/
		mergesort(0,4);
		for(int i=0; i<5; i++) {
			System.out.print(arr[i]+" ");
		}
	}
}










