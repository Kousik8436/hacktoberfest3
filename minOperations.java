class Solution {
    public int minOperations(int[] arr) {
        // code here
         double sum = 0;
        for (int num : arr) sum += num;
        
        double target = sum / 2.0;
        double currSum = sum;
        int operations = 0;
        
        // Max heap to get the largest element quickly
        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : arr) pq.add((double) num);
        
        // Keep halving the largest element until sum <= target
        while (currSum > target) {
            double largest = pq.poll();
            double half = largest / 2.0;
            
            currSum -= (largest - half);
            pq.add(half);
            operations++;
        }
        
        return operations;
    }
}
