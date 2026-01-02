public class HeapSort {

    public static void heapSort(int[] arr) {
        int n = arr.length;

        // STEP 1: Build Max Heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // STEP 2: Extract elements one by one
        for (int i = n - 1; i > 0; i--) {

            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Call heapify on reduced heap
            heapify(arr, i, 0);
        }
    }

    // Heapify function (Max Heap)
    static void heapify(int[] arr, int n, int i) {
        int largest = i;          
        int left = 2 * i + 1;     
        int right = 2 * i + 2;    

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 10, 3, 5, 1};

        heapSort(arr);

        System.out.println("Sorted Array:");
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}
