package com.yml.bst;

public class BinarySearchTree<K extends Comparable<K>> {
	private BinaryNode<K> root;

	public void add(K key) {
		this.root = this.addRecursively(root, key);
	}

	/**
	 * method to add new node into the binary search tree
	 * 
	 * @param current
	 * @param key
	 * @return
	 */
	private BinaryNode<K> addRecursively(BinaryNode<K> current, K key) {
		if (current == null)
			return new BinaryNode<>(key);
		int compareResult = key.compareTo(current.key);
		if (compareResult == 0)
			return current;
		if (compareResult < 0) {
			current.left = addRecursively(current.left, key);
		} else {
			current.right = addRecursively(current.right, key);
		}

		return current;
	}

	public int getSize() {
		return this.getSizeRecursive(root);
	}

	/**
	 * method to get the size of the tree
	 * 
	 * @param current
	 * @return
	 */
	private int getSizeRecursive(BinaryNode<K> current) {
		return current == null ? 0 : 1 + this.getSizeRecursive(current.left) + this.getSizeRecursive(current.right);
	}

	public void search(K key) {
		this.search(key, root);
	}

	/**
	 * method to implement search operation
	 * 
	 * @param
	 * @param
	 */
	private void search(K key, BinaryNode<K> root) {
		if (root == null) {
			System.out.println(key + " not found");
			return;
		}
		int compareResult = key.compareTo(root.key);
		if (compareResult == 0)
			System.out.println(key + " is found");
		else if (compareResult < 0)
			search(key, root.left);
		else
			search(key, root.right);
	}

	public void printNodes() {
		printNodes(root);
	}

	/**
	 * method to display nodes of binary search tree
	 * 
	 * @param root
	 */
	private void printNodes(BinaryNode<K> root) {
		if (root == null)
			return;
		printNodes(root.left);
		System.out.print(root.key + " ");
		printNodes(root.right);

	}

}
