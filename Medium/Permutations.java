/*
46. Permutations

Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]
*/

//Solution:

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(result, new ArrayList<>(), nums);

        return result;
    }

    private void backtrack(List<List<Integer>> result, ArrayList<Integer> temp, int[] nums){
        if(temp.size() == nums.length){
            result.add(new ArrayList<Integer>(temp));
            return;
        }
        
        for(int number : nums ){
            if(temp.contains(number)){
                continue;
            }
            
            temp.add(number);

            backtrack(result, temp, nums);

            temp.remove(temp.size()-1);
        }
    }
}


//Explanation:

/*
Sure, let's break down the provided Java code.

```java
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(result, new ArrayList<>(), nums);

        return result;
    }

    private void backtrack(List<List<Integer>> result, ArrayList<Integer> temp, int[] nums){
        if(temp.size() == nums.length){
            result.add(new ArrayList<Integer>(temp));
            return;
        }
        
        for(int number : nums ){
            if(temp.contains(number)){
                continue;
            }
            
            temp.add(number);

            backtrack(result, temp, nums);

            temp.remove(temp.size()-1);
        }
    }
}
```

This code generates all possible permutations of a given array of integers `nums`.

1. `permute` method:
    - This method is public and returns a list of lists of integers.
    - It initializes an empty list called `result` which will store all permutations.
    - It calls the `backtrack` method to generate permutations, starting with an empty temporary list.

2. `backtrack` method:
    - This is a recursive helper method responsible for generating permutations.
    - It takes three parameters:
        - `result`: the list to store all permutations.
        - `temp`: the temporary list to hold the current permutation being generated.
        - `nums`: the array of integers to generate permutations from.
    - The base case checks if the size of the temporary list `temp` is equal to the length of the input array `nums`. If so, it means we have formed a complete permutation, so it adds a copy of `temp` to the `result` list.
    - Inside the method, it iterates through each number in the input array `nums`.
    - For each number, it checks if it's already present in the temporary list `temp`. If it is, it skips to the next number using `continue`.
    - If the number is not already in `temp`, it adds it to `temp`, then recursively calls `backtrack` with the updated `temp` list.
    - After the recursive call returns, it removes the last added element from `temp` to backtrack and try the next number.

This process of adding, exploring, and removing elements from the temporary list continues recursively until all permutations are generated.

Finally, the `permute` method returns the `result` list containing all permutations of the input array `nums`.
*/