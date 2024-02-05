/*
228. Summary Ranges

You are given a sorted unique integer array nums.
A range [a,b] is the set of all integers from a to b (inclusive).

Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is 
covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.

Each range [a,b] in the list should be output as:

"a->b" if a != b
"a" if a == b
 

Example 1:

Input: nums = [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: The ranges are:
[0,2] --> "0->2"
[4,5] --> "4->5"
[7,7] --> "7"
*/


//Solution:

public List<String> summaryRanges(int[] nums) {

        List<String> nList = new ArrayList<>();

        if(nums.length == 0)
        return nList;

        int start = nums[0];

        for(int i=1 ; i<=nums.length ; i++){
            if(i == nums.length || nums[i] != nums[i -1] + 1){
                
                if(start == nums[i-1]){
                    nList.add(Integer.toString(start));
                }
                else{
                    nList.add(start+ "->" + nums[i - 1]);
                }

                if(i < nums.length){
                    start=nums[i];
                }
            }
        }
        return nList;
    }
}

//Explanation:
/*
	The above code efficiently iterates through the input array, identifies consecutive sequences, and adds 	
	summary ranges to the list. The resulting list is then returned as the output of the method.

*/