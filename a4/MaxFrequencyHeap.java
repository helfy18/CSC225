// Name: Johnathan Helfrich
// Student number: V00938369

public class MaxFrequencyHeap implements PriorityQueue {

	private static final int DEFAULT_CAPACITY = 10;
	private Entry[] data;
	private int size;

	public MaxFrequencyHeap() {
		  data = new Entry[DEFAULT_CAPACITY];
		  size = 0;
	}

	public MaxFrequencyHeap(int size) {

		  data = new Entry[size];
		  size = 0;
	}

	//this function was added, it returns the index of the parent
	public int parent(int index){
		  return index/2;
	}

	//this function was added to return the index of the left child
	public int leftChild(int index){
		  return (2 * index);
	}

	//this function was added to return the index of the right child
	public int rightChild(int index){
		  return ((2 *index) + 1);
	}

	public void insert(Entry element) {

		  data[++size] = element;
			bubbleUp(size);
	}


	public Entry removeMax() {

		  //1 based index
		  if(size <= 1){
			    return data[size--];
			}

      Entry rem = data[1];
			data[1] = data[size--];
			bubbleDown(1);
			return rem;
	}

	public boolean isEmpty() {

		  if(this.size == 0)
				  return true;

	    else
			    return false;
	}

	public int size() {
	    return this.size;
	}

	public void bubbleDown(int index){

		  //if there are no children, done
			if(index >= (size/2) && index <= size){
				  return;
			}

			//if the node is less than either child, it is in the wrong location
			if(data[index].getFrequency() < data[leftChild(index)].getFrequency() ||
			 data[index].getFrequency() < data[rightChild(index)].getFrequency()){

				  //if left > right, swap with left child, otherwise swap with right
				  if(data[leftChild(index)].getFrequency() > data[rightChild(index)].getFrequency()){
						  swap(index, leftChild(index));
							bubbleDown(leftChild(index));
					}

					else{
						  swap(index, rightChild(index));
							bubbleDown(rightChild(index));
					}
			}
	}

	public void bubbleUp(int index){

		  //two base cases. node is at top, or node is smaller than it's parent
			if(index == 1){
				  return;
			}

			if(data[index].getFrequency() < data[parent(index)].getFrequency())
				  return;

			//if both base cases fail, then the parent < child, and swap is required
			else{
				  swap(index, parent(index));
				  bubbleUp(parent(index));
			}
	}

	public void swap(int a, int b){

		   Entry temp = data[a];
			 data[a] = data[b];
			 data[b] = temp;
	}
}
