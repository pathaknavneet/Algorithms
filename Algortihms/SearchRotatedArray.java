package com.example;

public class SearchRotatedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = new int[] { 4, 5, 6, 7, 0, 1, 2 };

		int m = new SearchRotatedArray().search(arr, 9);
		System.out.println("element is present at index " + m);
	}

	public int search(int[] A, int target) {
		int begin = 0;
		int end = A.length - 1;
		return searchHelper(A, begin, end, target);

	}

	public int searchHelper(int[] A, int begin, int end, int target) {
		if (begin > end)
			return -1;
		if (begin == end) {
			if (target == A[begin]) {
				return begin;
			} else {
				return -1;
			}
		}

		int mid = (begin + end) / 2;
		if (A[mid] == target)
			return mid;
		if (A[begin] < A[mid]) {
			if (A[begin] <= target && target < A[mid]) {
				return searchHelper(A, begin, mid, target);

			}

			else {
				return searchHelper(A, mid, end, target);
			}
		}

		else if (A[mid] < A[begin]) {

			if (A[mid] < target && target <= A[end]) {
				return searchHelper(A, mid, end, target);
			} else {
				return searchHelper(A, begin, mid, target);
			}
		} else {
			return searchHelper(A, mid + 1, end, target);

		}

	}

}
