package Lap3;

import java.util.Arrays;

public class MyArray {
	int[] array;

	public MyArray(int[] array) {
		this.array = array;
	}
	// task 1.1
	public int interativeLinearSearch(int target) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == target) {
				return i;
			}
		}
		return -1;
	}

	public int recursiveLinearSearch(int target) {
		return recursiveLinearSearchHelp(target, 0);
	}

	public int recursiveLinearSearchHelp(int target, int i) {
		if (i == array.length)
			return -1;
		if (array[i] == target)
			return i;
		return recursiveLinearSearchHelp(target, i + 1);
	}
	// task 1.2
	public int interativeBinearSearch(int target) {
		Arrays.sort(array);
		int mid = (array.length / 2) - 1;
		if (target == array[mid])
			return mid;
		if (target < array[mid]) {
			for (int i = 0; i < mid; i++) {
				if (array[i] == target)
					return i;
			}
		}
		if (target > array[mid]) {
			for (int i = mid + 1; i < array.length; i++) {
				if (array[i] == target)
					return i;
			}
		}
		return -1;
	}

	public int recursiveBinearSearch(int target) {
		Arrays.sort(array);
		return recursiveBinearSearchHelp(target, 0, array.length - 1);
	}

	public int recursiveBinearSearchHelp(int target, int low, int high) {
		if (low > high)
			return -1;
		else {
			int mid = (low + high) / 2;
			if (target == array[mid])
				return mid;
			else {
				if (target < mid)
					return recursiveBinearSearchHelp(target, low, mid - 1);
				return recursiveBinearSearchHelp(target, mid + 1, high);
			}
		}
	}
	//task 1.3
	// add phuong thuc nay vao phuong thuc search va doi thu tu 2 dong return
		public static void sortDescendingOrder(int[] array) {
			int left = 0;
			int right = array.length - 1;
			while (left < right) {
				int temp = array[left];
				array[left] = array[right];
				array[right] = temp;
				left++;
				right--;
			}
		}

	
	
	public static void main(String[] args) {
		MyArray arr = new MyArray(new int[] { 12, 10, 9, 45, 2, 10, 11, 45 });
		
		System.out.println(arr.interativeLinearSearch(45));
		System.out.println(arr.recursiveLinearSearch(45));
		// mang sau khi sort tang dan {2, 9, 10, 10, 11, 12, 45, 45 }
		System.out.println(arr.interativeBinearSearch(45));
		System.out.println(arr.recursiveBinearSearch(45));
	}
}
