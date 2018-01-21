
public class Solution {
  private static class Dist implements Comparable<Dist> {
    private final int d;
    private final int x;

    private Dist(int d, int x) {
      this.d = d;
      this.x = x;
    }

    @Override
    public int compareTo(Dist o) {
      if (d > o.d) {
        return 1;
      }
      if (d < o.d) {
        return -1;
      }
      if (x > o.x) {
        return 1;
      }
      if (x < o.x) {
        return -1;
      }
      return 0;
    }
  }

  public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
    PriorityQueue<Dist> pq = new PriorityQueue<>();
    for (int a : arr) {
      pq.add(new Dist(Math.abs(a - x), a));
    }
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < k; i++) {
      result.add(pq.poll().x);
    }
    result.sort(Integer::compare);
    return result;
  }
}
