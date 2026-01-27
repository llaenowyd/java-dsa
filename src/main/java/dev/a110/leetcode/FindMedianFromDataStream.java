package dev.a110.leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {
  private final PriorityQueue<Integer> minHeap;
  private final PriorityQueue<Integer> maxHeap;

  public FindMedianFromDataStream() {
    minHeap = new PriorityQueue<>();
    maxHeap = new PriorityQueue<>(Collections.reverseOrder());
  }

  public void addNum(int num) {
    maxHeap.add(num);
    minHeap.add(maxHeap.poll());
    if (minHeap.size() > maxHeap.size()) {
      maxHeap.add(minHeap.poll());
    }
  }

  public double findMedian() {
    if (maxHeap.size() > minHeap.size()) {
      return maxHeap.peek();
    }

    return (maxHeap.peek() + minHeap.peek()) / 2.0;
  }
}
