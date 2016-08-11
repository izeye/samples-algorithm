package com.izeye.algorithm.sort.merge;

import java.util.ArrayList;
import java.util.List;

/**
 * List-based top-down merge sort.
 *
 * @author Johnny Lim
 */
public abstract class ListBasedTopDownMergeSort {

	private ListBasedTopDownMergeSort() {
	}

	public static List<Integer> sort(List<Integer> numbers) {
		int size = numbers.size();
		if (size <= 1) {
			return numbers;
		}

		int middleIndex = size / 2;
		List<Integer> left = new ArrayList<>(numbers.subList(0, middleIndex));
		List<Integer> right = new ArrayList<>(numbers.subList(middleIndex, size));
		left = sort(left);
		right = sort(right);
		return merge(left, right);
	}

	private static List<Integer> merge(List<Integer> left, List<Integer> right) {
		List<Integer> result = new ArrayList<>();
		while (!left.isEmpty() && !right.isEmpty()) {
			if (left.get(0) <= right.get(0)) {
				result.add(left.remove(0));
			}
			else {
				result.add(right.remove(0));
			}
		}
		result.addAll(left);
		result.addAll(right);
		return result;
	}

}
