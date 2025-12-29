public class HeapifyDemo {
  
    // MAX HEAPIFY
    static void maxHeapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest])
            largest = left;

        if (right < n && arr[right] > arr[largest])
            largest = right;

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            maxHeapify(arr, n, largest);
        }
    }

    // MIN HEAPIFY 
    static void minHeapify(int[] arr, int n, int i) {
        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] < arr[smallest])
            smallest = left;

        if (right < n && arr[right] < arr[smallest])
            smallest = right;

        if (smallest != i) {
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;

            minHeapify(arr, n, smallest);
        }
    }

    // BUILD MAX HEAP 
    static void buildMaxHeap(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeapify(arr, n, i);
        }
    }

    // BUILD MIN HEAP 
    static void buildMinHeap(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            minHeapify(arr, n, i);
        }
    }

    //  PRINT ARRAY
    static void printArray(int[] arr) {
        for (int x : arr)
            System.out.print(x + " ");
        System.out.println();
    }

    //  MAIN METHOD
    public static void main(String[] args) {

        int[] arr1 = {4, 10, 3, 5, 1};
        int[] arr2 = {4, 10, 3, 5, 1};

        System.out.println("Original Array:");
        printArray(arr1);

        buildMaxHeap(arr1);
        System.out.println("Max Heap:");
        printArray(arr1);

        buildMinHeap(arr2);
        System.out.println("Min Heap:");
        printArray(arr2);
    }
}
