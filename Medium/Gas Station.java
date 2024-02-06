/*
134. Gas Station

There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].\
You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station. 
You begin the journey with an empty tank at one of the gas stations.

Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the circuit once in the clockwise direction, 
otherwise return -1. If there exists a solution, it is guaranteed to be unique

 

Example 1:

Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
Output: 3
Explanation:
Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
Travel to station 4. Your tank = 4 - 1 + 5 = 8
Travel to station 0. Your tank = 8 - 2 + 1 = 7
Travel to station 1. Your tank = 7 - 3 + 2 = 6
Travel to station 2. Your tank = 6 - 4 + 3 = 5
Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
Therefore, return 3 as the starting index.
*/

//solution:

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalFuel=0;
        int totalCost=0;

        for(int i=0 ; i<gas.length ; i++){
            totalCost+=cost[i];
            totalFuel+=gas[i];
        }

        if(totalFuel < totalCost){
            return -1;
        }

        int startIndex=0;
        int currentFuel=0;

        for(int i=0 ; i<gas.length ; i++){
            if(currentFuel < 0){
                startIndex = i;
                currentFuel=0;
            }
            currentFuel+= gas[i] - cost[i];
        }

        return startIndex;
    }
}

//Explanation:
/*

-The code defines a class named Solution which contains a method named canCompleteCircuit.
-This method takes two arrays of integers gas and cost as input parameters.
-The method aims to find the starting gas station index from where a circular tour can be completed.
-It initializes two variables totalFuel and totalCost to 0. These variables will accumulate the total gas and total cost respectively.
-It then iterates through the gas and cost arrays and sums up the total fuel and total cost respectively.
-After calculating the total fuel and total cost, it checks if totalFuel is less than totalCost. If it is, it means there is not enough fuel 
 to cover the total cost, so it returns -1 indicating that it is impossible to complete the circuit.
-If there is enough fuel, it proceeds to find the starting index from where the circular tour can be completed.
-It initializes startIndex to 0, which represents the index of the starting gas station.
-It also initializes currentFuel to 0, which represents the remaining fuel at each station.
-It then iterates through the gas and cost arrays again.
-At each station, it calculates the remaining fuel currentFuel after refueling and subtracting the cost to travel to the next station.
-If currentFuel becomes negative at any point, it means that the tour cannot be completed starting from the current index, so it updates 
 startIndex to the next station index and resets currentFuel to 0.
-Finally, it returns the startIndex which represents the starting index of the gas station from where the circular tour can be completed.



*/