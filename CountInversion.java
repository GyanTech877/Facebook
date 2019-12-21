/*
Count Inversions in an array.
Inversion Count for an array indicates – how far (or close) the array is from being sorted. If array is already sorted then inversion count is 0.
If array is sorted in reverse order that inversion count is the maximum.
Formally speaking, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j

Example:
The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).
*/

 static long countInversions(int[] arr) {
        if(arr == null || arr.length ==0) return 0;
        return mergeSortAndCount(arr,0,arr.length-1);
    }
    private static long mergeAndCount(int[] arr, int l, int m, int r) 
    { 
        int[] left = Arrays.copyOfRange(arr, l, m + 1); 
        int[] right = Arrays.copyOfRange(arr, m + 1, r + 1); 

        int i = 0, j = 0, k = l;
        long swaps = 0; 

        while (i < left.length && j < right.length) { 
            if (left[i] <= right[j]) 
                arr[k++] = left[i++]; 
            else { 
                arr[k++] = right[j++]; 
                swaps += (m + 1) - (l + i); 
            } 
        } 
        while (i < left.length) 
            arr[k++] = left[i++]; 
        while (j < right.length) 
            arr[k++] = right[j++]; 
        return swaps; 
    } 
  
    private static long mergeSortAndCount(int[] arr, int l, int r) 
    { 
        long count = 0; 
        if (l < r) { 
            int m = (l + r) / 2; 
            count += mergeSortAndCount(arr, l, m); 
            count += mergeSortAndCount(arr, m + 1, r); 
            count += mergeAndCount(arr, l, m, r); 
        } 
        return count; 
    } 
