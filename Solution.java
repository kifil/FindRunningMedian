import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);
        Integer numberOfInputs = (int)in.nextInt(); // number of ints
        
        //min heap will hold the larger half of the numbers and max heap the smaller half
        //the median will be the average of the top of both halves or whichever heap is larger
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(numberOfInputs,Collections.reverseOrder());
        
        for(int i = 0; i < numberOfInputs; i++){
            Integer num = (int)in.nextInt(); //read in input string
            AddNumberAndPrintMedian(minHeap, maxHeap, num);
        }
    }
    
    public static void AddNumberAndPrintMedian(PriorityQueue<Integer> minHeap,PriorityQueue<Integer> maxHeap, Integer num){
        if(minHeap.size() == maxHeap.size()){
             minHeap.add(num);

             RebalanceTrees(minHeap,maxHeap);
            //min heap is larger so the middle number is just the top of it
             System.out.println((double)minHeap.peek());
        }
        else{
            //add to smaller heap
            if(minHeap.size() < maxHeap.size()){
                minHeap.add(num); 
            }
            else{
                maxHeap.add(num);
            }


            RebalanceTrees(minHeap,maxHeap);
            
            //trees are equal size so average the tops
            double median = (minHeap.peek() + maxHeap.peek()) / 2.0;
            System.out.println(median);
        }
          
    }

    public static void RebalanceTrees(PriorityQueue<Integer> minHeap,PriorityQueue<Integer> maxHeap){
        //rebalance if we added to wrong side, minheap (larger half) should always have larger number than max heap (smaller half)
        if(minHeap.peek() != null && maxHeap.peek() != null &&  minHeap.peek() < maxHeap.peek()){
            Integer minHead = minHeap.poll();
            Integer maxHead = maxHeap.poll();

            maxHeap.add(minHead);
            minHeap.add(maxHead);
        }
    }                          
    
}
