class MaxHeap {
    int[] heap;
    int size;
    int capacity;

    MaxHeap(int capacity) {
        this.capacity = capacity;
        heap = new int[capacity];
        size = 0;
    }

    // INSERT 
    void insert(int val) {
        if (size == capacity) {
            System.out.println("Heap Full");
            return;
        }

        int i = size;
        heap[i] = val;
        size++;

        while (i > 0) {
            int parent = (i - 1) / 2;
            if (heap[parent] < heap[i]) {
                int temp = heap[parent];
                heap[parent] = heap[i];
                heap[i] = temp;
                i = parent;
            } else {
                break;
            }
        }
    }

  //DELETE
    int delete() {
        if (size == 0) {
            System.out.println("Heap Empty");
            return -1;
        }

        int root = heap[0];
        heap[0] = heap[size - 1];
        size--;

        int i = 0;
        while (i < size) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int largest = i;

            if (left < size && heap[left] > heap[largest])
                largest = left;

            if (right < size && heap[right] > heap[largest])
                largest = right;

            if (largest != i) {
                int temp = heap[i];
                heap[i] = heap[largest];
                heap[largest] = temp;
                i = largest;
            } else {
                break;
            }
        }
        return root;
    }

    void printHeap() {
        for (int i = 0; i < size; i++)
            System.out.print(heap[i] + " ");
        System.out.println();
    }
}
