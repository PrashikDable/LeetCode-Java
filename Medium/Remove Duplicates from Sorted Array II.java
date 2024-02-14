/*
80. Remove Duplicates from Sorted Array II

Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice. The relative order of the elements should be kept the same.

Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.

Return k after placing the final result in the first k slots of nums.

Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.

Custom Judge:

The judge will test your solution with the following code:

int[] nums = [...]; // Input array
int[] expectedNums = [...]; // The expected answer with correct length

int k = removeDuplicates(nums); // Calls your implementation

assert k == expectedNums.length;
for (int i = 0; i < k; i++) {
    assert nums[i] == expectedNums[i];
}
If all assertions pass, then your solution will be accepted.
*/

//Solution:

class Solution {
    public int removeDuplicates(int[] nums) {
        int index=0;
        for(int i : nums){
            if( index < 2 || i > nums[index-2]){
                nums[index++] = i;
            }
        }
    return index;
    }
}

//Explanation:
/*

1. The code defines a class named `Solution`.
2. Inside the class, there's a method named `removeDuplicates` that takes an array of integers (`nums`) as input and returns an integer.
3. It initializes an integer variable `index` to keep track of the position where the next non-duplicate element will be placed.
4. The method then iterates through the array `nums` using an enhanced for loop, which iterates over each element (`i`) in the array.
5. Inside the loop, it checks if either of the two conditions is true:
   - If `index` is less than 2, which means the current element is the first or second element in the array, or
   - If the current element `i` is greater than the element at position `index - 2`.
6. If any of the conditions above are true, it means the current element is not a duplicate or it's the first or second occurrence of the duplicate. In this case, it assigns the current element `i` to the position indicated by `index` in the `nums` array, and then increments `index`.
7. After processing all elements in the array, the method returns the value of `index`, which represents the length of the modified array with duplicates removed.

*/