/*
56. MERGE INTERVALS

Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, 
and return an array of the non-overlapping intervals that cover all the intervals in the input.

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
*/

//SOLUTION:

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
		ArrayList<int[]> list=new ArrayList<>();
        int s=0;
        int m=0;
        int e=1;
        while(e<intervals.length) {
        	if(intervals[m][1]>=intervals[e][0]) {
        		if(intervals[m][1]>=intervals[e][1]){
					e++;
				}else {
	        		e++;
	        		m=e-1;
				}
        	}else {
        		list.add(new int[]{intervals[s][0],intervals[m][1]});
        		e++;
        		m=e-1;
        		s=m;
        	}
        }
        list.add(new int[]{intervals[s][0],intervals[m][1]});
        
        return list.toArray(new int[list.size()][]);
    }
}

/*
EXPLANATION:

1.Sort Intervals: The Arrays.sort method is used to sort the intervals array based on the first 
		  element of each interval in ascending order.

2.Initialize Variables: Variables s (start), m (merge), and e (end) are used to keep track of 
	     		indices while iterating through the sorted intervals. An ArrayList named list is 
			initialized to store the merged intervals.

3.Merge Overlapping Intervals: The while loop iterates through the sorted intervals. 
			       If two intervals overlap, the loop updates the merge index (m) and end 
			       index (e) accordingly. If there is no overlap, it adds the merged interval 
			       to the ArrayList and updates indices.

4.Convert to Array: After the loop, the last merged interval is added to the ArrayList. 
	            Finally, the ArrayList is converted to a 2D array, and the result is returned.
*/