// Name:
// Student number: V00

public class WordFrequencyReport {
	private static final int CAPACITY = 5;

	/*
	 * Purpose: Obtain the 5 most frequent words found
	 * Parameters: MaxFrequencyHeap h - the heap containing all the word entry data
	 * Returns: Entry[] - an array containing the top 5 entries (which are the
	 *     word, frequency pairs with the maximum frequency values)
	 */
	public static Entry[] overallMostFrequent(MaxFrequencyHeap h) {

		Entry[] top5 = new Entry[CAPACITY];
		int i;

		//populate the array with the five most frequent words
		for(i = 0; i < CAPACITY; i++){

				//if there are no more elements, there will be an error
				if(h.isEmpty()){
					  break;
				}

			  top5[i] = h.removeMax();
		}

		/*if i isn't capacity, then there are fewer than five words, and the array
		should be null*/
		if(i != CAPACITY){
			  for(int j = 0; j < CAPACITY; j++){
					  top5[j] = null;
				}
		}

		return top5;
	}

	/*
	 * Purpose: Obtain the 5 most frequent words found that are at least n charaters long
	 * Parameters: MaxFrequencyHeap h - the heap containing all the word entry data
	 *             int n - minimum word length to consider
	 * Returns: Entry[] - an array containing the top 5 entries (which are the
	 *     word, frequency pairs with the maximum frequency values of words
	 *     that are at least n characters long)
	 */
	public static Entry[] atLeastLength(MaxFrequencyHeap h, int n) {
		Entry[] top5 = new Entry[CAPACITY];
		int i;

		for(i = 0; i < CAPACITY; i++){

			  //if there are no more elements, there will be an error
				if(h.isEmpty()){
					  break;
				}

			  Entry ent = h.removeMax();

				/*check if the entry removed matches specifaction, otherwise decrement
				i so that the loop will continue to run*/
				if(ent.getWord().length() < n){
					  i--;
				}
				else{
					  top5[i] = ent;
				}
		}

		/*if i isn't capacity, then there are fewer than five words, and the array
		should be null*/
		if(i != CAPACITY){
				for(int j = 0; j < CAPACITY; j++){
						top5[j] = null;
				}
		}

		return top5;
	}

	/*
	 * Purpose: Obtain the 5 most frequent words found that begin with the given letter
	 * Parameters: MaxFrequencyHeap h - the heap containing all the word entry data
	 *             char letter - only words that begin with given letter are considered
	 * Returns: Entry[] - an array containing the top 5 entries (which are the
	 *     word, frequency pairs with the maximum frequency values of words
	 *     that begin with the given letter)
	 */
	public static Entry[] startsWith(MaxFrequencyHeap h, char letter) {
		Entry[] top5 = new Entry[CAPACITY];
		int i;

		for(i = 0; i < CAPACITY; i++){

			  if(h.isEmpty()){
					  break;
				}

				Entry ent = h.removeMax();

				/*check if the entry removed matches specifaction, otherwise decrement
				i so that the loop will continue to run*/
				if(ent.getWord().charAt(0) != letter){
					  i--;
				}
				else{
					  top5[i] = ent;
				}
				
		}

		/*if i isn't capacity, then there are fewer than five words, and the array
		should be null*/
		if(i != CAPACITY){
				for(int j = 0; j < CAPACITY; j++){
						top5[j] = null;
				}
		}

		return top5;
	}

}
