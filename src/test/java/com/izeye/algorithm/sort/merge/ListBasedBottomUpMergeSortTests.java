package com.izeye.algorithm.sort.merge;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import static com.izeye.algorithm.sort.merge.ListBasedBottomUpMergeSort.Node;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for list-based bottom-up merge sort.
 *
 * @author Johnny Lim
 */
public class ListBasedBottomUpMergeSortTests {

	@Test
	public void testSort() {
		List<Integer> expected = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
		List<Integer> numbers = Arrays.asList(3, 4, 2, 1, 7, 5, 8, 9, 0, 6);

		List<Integer> sorted = ListBasedBottomUpMergeSort.sort(numbers);
		assertThat(sorted).isEqualTo(expected);
	}

	@Test
	public void testMerge() {
		Node expected = ListBasedBottomUpMergeSort.list2NodeHead(Arrays.asList(1, 2, 3, 4));
		Node left = ListBasedBottomUpMergeSort.list2NodeHead(Arrays.asList(1, 3));
		Node right = ListBasedBottomUpMergeSort.list2NodeHead(Arrays.asList(2, 4));

		Node merged = ListBasedBottomUpMergeSort.merge(left, right);
		assertThat(merged).isEqualTo(expected);
	}

}
