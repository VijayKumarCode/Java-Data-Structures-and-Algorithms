/**
 * Problem: Merge Sorted Array (LeetCode #88)
 * Pattern: Two Pointers (Backwards)
 * * Logic: Since the first array has extra space at the end, we start 
 * comparing elements from the back to avoid overwriting values.
 * * Time Complexity: $O(m + n)$ - We visit each element in both arrays once.
 * Space Complexity: $O(1)$ - We modify the input array in-place.
 */

class MergeSort {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k=0;
        for(int i = 0; i < m+n; i++){
            if(i<m){
                nums1[k] = nums1[i];
            }
            else{
                nums1[k] =nums2[k-m];
            }
            k++;
        }
       System.out.println(Arrays.toString(mergeNonDec(nums1)));
    }
    public static int[] mergeNonDec(int[] nums1){
        if(nums1.length <= 1){
            return nums1;
        }
        int mid = nums1.length/2;
        int[] left = new int[mid];
        int[] right = new int[nums1.length-mid];

        for(int i = 0; i < mid; i++){
            left[i] = nums1[i];
        }
        for(int i = mid; i < nums1.length; i++){
            right[i-mid] = nums1[i];
        }
        mergeNonDec(left);
        mergeNonDec(right);
        return mergeSort(left,right,nums1);
    }
    public static int[] mergeSort(int[] left, int[] right, int[] nums1){
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < left.length && j < right.length){
            if(left[i] < right[j]){
                nums1[k] = left[i];
                i++;
            }
            else{
                nums1[k] = right[j];
                j++;
            }
            k++;
        }
        while(i < left.length){
            nums1[k]= left[i];
            i++;
            k++;
        }
        while(j < right.length){
            nums1[k] = right[j];
            j++;
            k++;
        }
        return nums1;
    }
}
