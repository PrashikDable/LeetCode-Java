/*
45. Jump Game II

You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], 
you can jump to any nums[i + j] where:

*0 <= j <= nums[i] and
*i + j < n
Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].

*/

// SOLUTION

class Solution {
    public int jump(int[] nums) {
        int jumps=0;
        int destination = nums.length-1;
        int current=0 , maxJumps=0;

        if(nums.length == 1){return 0;}
            

        for(int i=0; i<destination; i++){
            maxJumps =Math.max(maxJumps,i+nums[i]);
            
            if(i == current ){
                current = maxJumps;
                jumps++;
            
            if(maxJumps >= destination){
                return jumps;
                }
            }
        }
        return jumps;
    }
}

/*
EXPLANATION:

1.Initialization:

*jumps: This variable keeps track of the number of jumps needed to reach the last index.
*destination: Represents the last index of the array (nums.length - 1).
*current: Represents the current position while traversing the array.
*maxJumps: Represents the farthest position that can be reached from the current position.

2.Base case check:
If the length of the array nums is 1, then the array is already at the last index, and no jumps are needed. In this case, the method returns 0.

3.Iterating through the array:
The code uses a for loop to iterate through the array elements up to the second-to-last index (destination).
Inside the loop, it updates maxJumps to be the maximum of its current value and the sum of the current index (i) and the value at that index (nums[i]).

4.Checking if a jump is needed:
If the current index (i) is equal to the current position, it means that the maximum distance reachable from the current position has been calculated (maxJumps). Now, the current position (current) is updated to maxJumps, and the number of jumps (jumps) is incremented.

5.Checking if the destination is reached:
If the updated maxJumps is greater than or equal to the destination, the method returns the total number of jumps.

6.Returning the result:
If the loop completes without reaching the destination, the method returns the total number of jumps calculated.

*/