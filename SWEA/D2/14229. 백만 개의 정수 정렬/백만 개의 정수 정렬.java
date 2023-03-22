// 병합 정렬
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int[] arr = new int[1000000];
	static int[] sortedArr= new int[1000000];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<1000000;i++) {
			arr[i] = sc.nextInt();
		}
		int left = 0;
		int right = arr.length-1;
		mergeSort(arr,left,right);
		System.out.println(arr[500000]);
	}
	// 분할 과정
	public static void mergeSort(int[] arr,int left, int right) {
		if(left < right) {
			int mid = (left+right)/2;
			mergeSort(arr, left, mid);
			mergeSort(arr, mid+1, right);
			merge(arr, left, mid, right);
		}
	}
	// 병합 과정
	private static void merge(int[] arr, int left, int mid, int right) {
		int L = left;
		int R = mid+1;
		int idx = left;
		while(L <= mid && R <= right) {
			if(arr[L] <= arr[R]) {
				sortedArr[idx++] = arr[L++];
			}
			else {
				sortedArr[idx++] = arr[R++];
			}
		}
		if(L <= mid) {
			for(int i = L;i<=mid;i++) {
				sortedArr[idx++] = arr[i];
			}
		}
		else {
			for(int j=R;j<=right;j++) {
				sortedArr[idx++] = arr[j];
			}
		}
		for(int i = left; i<=right;i++) {
			arr[i] = sortedArr[i];
		}
		
	}
	
	
}
