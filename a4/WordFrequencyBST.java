// Name:
// Student number: V00

public class WordFrequencyBST {
	private TreeNode root;
	private int numElements;

	public WordFrequencyBST() {
		root = null;
		numElements = 0;
	}

	/*
	 * Purpose: Update the BST by handling input word
	 * Parameters: String word - The new word to handle
	 * Returns: Nothing
	 * Explanation: If there is no entry in the tree
	 *   representing the word, then the a new entry
	 *   should be created and placed into the correct
	 *   location of the BST. Otherwise, the existing
	 *   entry for the word should have its frequency
	 *   value incremented.
	 */
	public void handleWord(String word) {

			if(numElements == 0){
				  TreeNode k = makeTreeNode(word);
			    root = k;
					numElements++;
			}
			else{
				  handleWordHelper(root, word);
			}

	}

  //this function inserts the new node into the tree recursively
	public void handleWordHelper(TreeNode k, String word){

		  //base case is that the word already appears in the array, add to frequency
		  if(k.compareTo(word) == 0){
				  k.addToFrequency();
			}

			/*if the new word is before the current node's word in the dictionary,
			move to the left*/
			else if(k.compareTo(word) > 0){

					/*if there is nothing to the left, insert the new node, as it is the
				  first occurence*/
				  if(k.left == null){

							TreeNode n = makeTreeNode(word);
							k.left = n;
							numElements++;
					}

					//if there is something to the left, make recursive call
					else handleWordHelper(k.left, word);
			}

			else{

					//same as left side but reversed
					if(k.right == null){
						  TreeNode n = makeTreeNode(word);
							k.right = n;
							numElements++;
					}

					else handleWordHelper(k.right, word);
			}
	}

	/*
	 * Purpose: Get the frequency value of the given word
	 * Parameters: String word - the word to find
	 * Returns: int - the word's associated frequency
	 */
	public int getFrequency(String word) {

		  if(numElements == 0){
				  return 0;
			}

		  return getFrequencyHelper(root, word);
	}

  //this function recursively goes through the tree to find the frequency of a word
	public int getFrequencyHelper(TreeNode k, String word){

		  int res = 0;
		  Entry l = k.getData();

			//if this is true, the word has been found
		  if(k.compareTo(word) == 0){
				  res = l.getFrequency();
			}

			//if compareTo != 0, then we must move through the tree
			else if(k.compareTo(word) > 0){

					if(k.left != null){
						  res = getFrequencyHelper(k.left, word);
					}

			}

			else{
				  if(k.right != null){
						  res = getFrequencyHelper(k.right, word);
					}
			}
			return res;
	}

	//this is my function that creates a Tree Node
		public TreeNode makeTreeNode(String word){
			  Entry l = new Entry(word);
			  TreeNode k = new TreeNode(l);
				return k;
		}

	/****************************************************
	* Helper functions for Insertion and Search testing *
	****************************************************/

	public String inOrder() {
		if (root == null) {
			return "empty";
		}
		return "{" + inOrderRecursive(root) + "}";
	}

	public String inOrderRecursive(TreeNode cur) {
		String result = "";
		if (cur.left != null) {
			result = inOrderRecursive(cur.left) + ",";
		}
		result += cur.getData().getWord();
		if (cur.right != null) {
			result += "," + inOrderRecursive(cur.right);
		}
		return result;
	}

	public String preOrder() {
		if (root == null) {
			return "empty";
		}
		return "{" + preOrderRecursive(root) + "}";
	}

	public String preOrderRecursive(TreeNode cur) {
		String result = cur.getData().getWord();
		if (cur.left != null) {
			result += "," + preOrderRecursive(cur.left);
		}
		if (cur.right != null) {
			result += "," + preOrderRecursive(cur.right);
		}
		return result;
	}


	/****************************************************
	* Helper functions to populate a Heap from this BST *
	****************************************************/

	public MaxFrequencyHeap createHeapFromTree() {
		MaxFrequencyHeap maxHeap = new MaxFrequencyHeap(numElements+1);
		addToHeap(maxHeap, root);
		return maxHeap;
	}

	public void addToHeap(MaxFrequencyHeap h, TreeNode n) {
		if (n != null) {
			addToHeap(h, n.left);
			h.insert(n.getData());
			addToHeap(h, n.right);
		}
	}
}
