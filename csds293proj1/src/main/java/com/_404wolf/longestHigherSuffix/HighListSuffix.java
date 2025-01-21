package com._404wolf.longestHigherSuffix;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Hello world!
 */
public class HighListSuffix {
  /**
   * Return as many elements from the back of a for where the corresponding
   * elements in b are lesser.
   *
   * @param a list of elements
   * @param b list of elements
   *
   * @return the longest suffix of a where the corresponding elements in b are
   *         lesser
   */
  public static <T extends Comparable<? super T>> List<T> longestHigherSuffix(List<T> a, List<T> b, Comparator<T> cmp) {
    return IntStream.range(1, a.size() + 1)
        .takeWhile(
            i -> i <= b.size() && cmp.compare(a.get(a.size() - i), b.get(b.size() - i)) >= 0)
        .mapToObj(i -> a.get(a.size() - i))
        .collect(LinkedList::new, LinkedList::addFirst, LinkedList::addAll);
  }
}
