package com.izeye.algorithm.sort.merge;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

/**
 * List-based bottom-up merge sort.
 *
 * @author Johnny Lim
 */
public abstract class ListBasedBottomUpMergeSort {

	private static final int ARRAY_SIZE = 32;

	private ListBasedBottomUpMergeSort() {
	}

	public static List<Integer> sort(List<Integer> numbers) {
		Node head = list2NodeHead(numbers);
		Node sorted = sort(head);
		return nodeHead2List(sorted);
	}

	private static Node sort(Node head) {
		Node[] array = new Node[ARRAY_SIZE];
		Node current = head;
		Node next;
		int i;
		while (current != null) {
			next = current.getNext();
			current.setNext(null);

			Node merged = current;
			for (i = 0; i < array.length && array[i] != null; i++) {
				merged = merge(array[i], merged);
				array[i] = null;
			}
			if (i == array.length) {
				i--;
			}
			array[i] = merged;
			current = next;
		}
		return mergeAll(array);
	}

	private static Node mergeAll(Node[] array) {
		Node result = null;
		for (Node a : array) {
			result = merge(a, result);
		}
		return result;
	}

	static Node merge(Node left, Node right) {
		if (left == null) {
			return right;
		}
		if (right == null) {
			return left;
		}

		Node result = null;
		Node prev = null;
		Node element = null;
		while (left != null && right != null) {
			if (left.getData() <= right.getData()) {
				element = left;
				left = left.getNext();
				element.setNext(null);
			}
			else {
				element = right;
				right = right.getNext();
				element.setNext(null);
			}

			if (prev == null) {
				result = element;
			}
			else {
				prev.setNext(element);
			}
			prev = element;
		}
		element.setNext(left != null ? left : right);
		return result;
	}

	static Node list2NodeHead(List<Integer> list) {
		Node node = null;
		Node next = null;
		for (int i = list.size() - 1; i >= 0; i--) {
			node = new Node();
			node.setData(list.get(i));
			if (next != null) {
				node.setNext(next);
			}
			next = node;
		}
		return node;
	}

	static List<Integer> nodeHead2List(Node head) {
		List<Integer> list = new ArrayList<>();
		for (Node node = head; node != null; node = node.getNext()) {
			list.add(node.getData());
		}
		return list;
	}

	@Data
	static class Node {

		private Node next;
		private int data;

		@Override
		public String toString() {
			return nodeHead2List(this).toString();
		}

		@Override
		public boolean equals(Object o) {
			return nodeHead2List(this).equals(nodeHead2List((Node) o));
		}

		@Override
		public int hashCode() {
			return nodeHead2List(this).hashCode();
		}

	}

}
