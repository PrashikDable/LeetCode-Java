/*
189. Rotate Array

Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
*/

// SOLUTION:

class Solution {
    public static void reverse(int [] nums, int start, int end){
        while(start < end ){
            int temp = nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
            }
    }
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        int n = nums.length;
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }
}


// EXPLANTION

/*
	public static void reverse(int [] nums, int start, int end){
   	 while(start < end ){
        	int temp = nums[start];
        	nums[start] = nums[end];
        	nums[end] = temp;
        	start++;
        	end--;
    		}
	}
This method takes an array nums and two indices start and end. It reverses the elements in the subarray from start to end. It uses a two-pointer approach, swapping elements at start and end indices and then moving the pointers towards each other until they meet in the middle.

	public void rotate(int[] nums, int k) {
    		k %= nums.length;
    		int n = nums.length;
    		reverse(nums, 0, n-1);
    		reverse(nums, 0, k-1);
    		reverse(nums, k, n-1);
	}
k %= nums.length;: This ensures that k is reduced to the effective rotation steps within the length of the array. If k is greater than the length of the array, it wraps around.

int n = nums.length;: Stores the length of the array in variable n for convenience.

reverse(nums, 0, n-1);: Reverses the entire array. This effectively brings the last k elements to the front.

reverse(nums, 0, k-1);: Reverses the first k elements. This corrects the order of the first k elements.

reverse(nums, k, n-1);: Reverses the remaining elements from index k to the end. This corrects the order of the last n-k elements.

After these three reverse operations, the entire array is reversed, but the order within the first k and the last n-k elements is correct, achieving the desired rotation effect. The operations are performed in-place, so no additional space is used.

*/
