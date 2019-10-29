package api;

import java.util.*;
import java.util.stream.Collectors;

public class StringUtils {
    public static List<String> topKFrequent(String text, int k) {
        if (text == null) {
            throw new RuntimeException("Text cannot be null");
        }
        if (k < 1) {
            throw new RuntimeException("K should be greater then 0");
        }

        List<String> words = Arrays.stream(text.split(" |\n")).filter(w -> w.length() > 3).collect(Collectors.toList());
        Map<String, Integer> count = new HashMap<>();
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> heap = new PriorityQueue<String>(
                (w1, w2) -> count.get(w1).equals(count.get(w2)) ?
                        w2.compareTo(w1) : count.get(w1) - count.get(w2));

        for (String word : count.keySet()) {
            heap.offer(word);
            if (heap.size() > k) heap.poll();
        }

        List<String> ans = new ArrayList<>();
        while (!heap.isEmpty()) ans.add(heap.poll());
        Collections.reverse(ans);
        return ans;
    }

    public static List<String> leastKFrequent(String text, int k) {
        if (text == null) {
            throw new RuntimeException("Text cannot be null");
        }
        if (k < 1) {
            throw new RuntimeException("K should be greater then 0");
        }

        List<String> words = Arrays.stream(text.split(" |\n")).filter(w -> w.length() > 3).collect(Collectors.toList());
        Map<String, Integer> count = new HashMap<>();
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> heap = new PriorityQueue<String>(
                (w1, w2) -> count.get(w1).equals(count.get(w2)) ?
                        -w2.compareTo(w1) : -(count.get(w1) - count.get(w2)));

        for (String word : count.keySet()) {
            heap.offer(word);
            if (heap.size() > k) heap.poll();
        }

        List<String> ans = new ArrayList<>();
        while (!heap.isEmpty()) ans.add(heap.poll());
        Collections.reverse(ans);
        return ans;
    }
}
