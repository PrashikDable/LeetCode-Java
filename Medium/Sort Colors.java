/*
75.Sort Colors

Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, 
with the colors in the order red, white, and blue.
We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
You must solve this problem without using the library's sort function.

Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
*/

class Solution {
   
    public void swap(int[] nums, int x, int y){
            int temp = nums[x];
            nums[x] = nums[y];
            nums[y] = temp;
    }
    public void sortColors(int[] nums) {
        int low=0 , mid=0, high=nums.length-1;

        while(mid <= high){
            if(nums[mid] == 0){
                swap(nums,low,mid);
                mid++;
                low++;
            }
            else if(nums[mid] == 1){
                mid++;
            }
            else if(nums[mid] == 2){
                swap(nums,mid,high);
                high--;
            }
        }
    }
}

/*

EXPLANATION:

*low: Index to keep track of the position where the next 0 should be placed.
*mid: Index used for iterating through the array.
*high: Index to keep track of the position where the next 2 should be placed.

-Dutch National Flag Algorithm:
  *The algorithm uses three pointers (low, mid, and high) to partition the array into three sections: 0s on the left, 1s in the middle, and 2s on the right.
  *If the current element at mid is 0, it is swapped with the element at low, and both mid and low are incremented. This ensures that 0s are moved to the left.
  *If the current element at mid is 1, no swap is needed, and mid is simply incremented.
  *If the current element at mid is 2, it is swapped with the element at high, and high is decremented. This ensures that 2s are moved to the right.
  *The loop continues until mid surpasses high, ensuring that the entire array is sorted.

*Swap method is a simple utility function for swapping elements in the array. It takes the array nums, along with the indices i and j, and swaps the elements at 
 those positions.

*/