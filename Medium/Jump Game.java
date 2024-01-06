/*
55. Jump Game

You are given an integer array nums. You are initially positioned at the array's first index,
and each element in the array represents your maximum jump length at that position.
Return true if you can reach the last index, or false otherwise.

*/

// SOLUTION: 

class Solution {
    public boolean canJump(int[] nums) {
        int finalIndex = nums.length-1;
        
        for(int index=nums.length-2; index >= 0; index--){
            if(index+nums[index] >= finalIndex){
                finalIndex = index;
            }
        }
        return finalIndex == 0;
    }
}

/*
EXPLANATION: 

1.finalIndex is initialized to the last index of the array (nums.length - 1), indicating the target index to reach.

2.The loop iterates through the array in reverse order (from the second-to-last element to the first element).

3.For each index, it checks if the sum of the current index and its value (index + nums[index]) is greater than or equal to the current finalIndex.

4.If the condition is true, it means you can reach the finalIndex from the current index, so update finalIndex to the current index.

5.Continue iterating until you reach the beginning of the array (index 0).

6.Finally, check if the finalIndex is 0. If it is, then it means it's possible to reach the last index starting from the first index, 
and the function returns true. Otherwise, it returns false.
*/