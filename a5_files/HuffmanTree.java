/*
 * A Huffman Tree.
 * Huffman Trees are built with Huffman Nodes (HNodes)
 */
public class HuffmanTree {
	HNode root;

	public HuffmanTree(HNode root) {
		this.root = root;
	}

	/*
	 * Purpose: Decode the sequence of bits and return the associated string
	 * Parameters: BitQueue input - the input sequence of bits
	 * Returns: String - the decoded text
	 * Example:
	 *   For decoding an input, every time a 0-bit is read,
	 *   the associated letter is found in the left subtree.
	 *   Every time a 1-bit is read, the associated letter
	 *   is found in the right subtree.
	 *
	 *   When a leaf node is detected, a letter can be added
	 *   to the output String. To decode the next sequence of
	 *   bits, start traversing the tree from the root.
	 *
	 *   See the lecture exercise for more details.
	 */
	public String decode(BitQueue input) {
		String s = "";
		while(input.isEmpty() == false){
			try {
				s += decodeRecursive(root, input);
				//String i = input.dequeue();
			} catch (DecodeException e) {
				System.out.println(e);
			}
		}
		return s;
	}

	public String decodeRecursive(HNode cur, BitQueue input) throws DecodeException {
		if(input.isEmpty()){
			return cur.letter;
		}
		String i = input.front.bit;
		String s;
		if(i.equals("1")){
			if(cur.right == null){
				return cur.letter;
			}
			else{
				s = input.dequeue();
				s = decodeRecursive(cur.right, input);
			}
		}
		else{
			if(cur.left == null){
				return cur.letter;
			}
			else{
				s = input.dequeue();
				s = decodeRecursive(cur.left, input);
			}
		}
		return s;
	}
}
