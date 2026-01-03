/**
 * Problem: Majority Element (LeetCode #169)
 * Topic: Arrays & Sorting
 * Logic: Sort the array using Merge Sort and then perform a linear scan 
 * to find the most frequent consecutive element.
 * * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 */

 class MajorityElement {

    public int majorityElement(int[] nums) {

        return majorityElement1(mergeSort(nums));

    }

    private static int[] mergeSort(int[] nums){

        if(nums.length <= 1) return nums;

        int mid  = nums.length/2;

        int[] left  = new int[mid];

        int[] right = new int[nums.length-mid];


        for(int i = 0; i < mid; i++){

            left[i] = nums[i];

        }

        for(int i = mid; i < nums.length; i++){

            right[i-mid] = nums[i];

        }

        mergeSort(left);

        mergeSort(right);

        return merge(left,right,nums);

    }

    private static int[] merge(int[] left, int[] right, int[] nums){

        int i = 0;

        int j = 0;

        int k = 0;


        while(i < left.length && j < right.length){

            if(left[i] < right[j]){

                nums[k] = left[i];

                i++;

            }

            else{

                nums[k] = right[j];

                j++;

            }

          k++;

        } 

        

        while(i < left.length){

            nums[k] = left[i];

            i++;

            k++;

        }

        while(j < right.length){

            nums[k] = right[j];

            j++;

            k++;

        }

        return nums;

    }

    private int majorityElement1(int[] num){

        if(num.length == 1) return num[0];

        int prevCount = 0;

        int currentCount = 0;

        int maxValue = 0;


        for(int i = 0; i < num.length-1; i++){

            if(num[i] != num[i+1]){

                currentCount = 0;

            }

            else{

                currentCount++;

            }

            if(prevCount < currentCount){

                prevCount = currentCount;

                maxValue = num[i];

            }

        }

        return maxValue;

    }

} 
