import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        
        //priorityqueue == heap orderd binary tree
        //use a min quueu and a max queue
        //max queue is left half, min is right half
        
        //if queues are equal size
            //add to either queue and resort 
       
        
        //if queues are not equal
            //add ot smaller and resort
            //if add ot max and maxQueue head > minQueue head, swap heads and resort
        //invert too
            //now invariat should be left tree always has smaller half of numbers and right tree has larger half
        
        //if queues are uneven for a median
            //median is top node of larger heap
        //if even
            //avergae top from each
        
        int maxSize =5;
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(maxSize,Collections.reverseOrder());
        
        Integer num = 2;
        
        
        //apick a heap if same size
        if(minHeap.size() == maxHeap.size()){
            minHeap.add(num);
            System.out.println((Float)minHeap.peek());
        }
        else{
            //add to smaller heap
            if(minHeap.size() < maxHeap.size()){
                minHeap.add(num); //does this sort? looks like it
  
            }
            else{
                maxHeap.add(num);
            }
            
            //rebalance if we added to wrong side, minheap (larger half) should always have large number than max heap (smaller half)
            if(minHeap.peek() < maxHeap.peek()){
                Integer minHead = minHeap.poll();
                Integer maxHead = maxHeap.poll();
                
                maxHeap.add(minHead);
                minHeap.add(maxHead);
                //swap, largest lesthand element bigger than smallest right hand, menaing it should be moved ot the right
            }
            
            Float median = 0.0;
            median = (minHeap.peek() + maxHeap.peek()) / 2.0
            System.out.println(median);
        }
    //   4  5 added to min, min heap
      //  7  6
        
    }

    public void PrintMedian(minHeap,maxHeap){
        //if min heap greater print that
        
        //else sizes are equal since we add to min heap first, average top two and print
    }                          
    
    
    public void AddNumber(minHeap,MaxHeap){
        //funciton above
    }
                               
    
    
    

}
