public class Solution {
  private static String makeA(String w, int n) {
    int len = w.length();
    String num = Integer.toString(len-n-1);
    if (num.length() + n + 1 >= len) return w;

    return w.substring(0, n) + num + w.charAt(len-1);
  }

  private static void handle(List<String> conflicting, int shift, HashMap<String, String> res) {
    final int n = conflicting.size();
    if (n == 0) return;
    if (n == 1) {
      res.put(conflicting.get(0), makeA(conflicting.get(0), shift));
      return;
    }

    int i = 0;
    while (i < n) {
      String si = conflicting.get(i);
      if (si.length() == shift) {
        res.put(si, si);
        i++;
        continue;
      }

      final char c = si.charAt(shift);
      int j = i+1;
      while (j < n && conflicting.get(j).charAt(shift) == c) {
        j++;
      }
      handle(conflicting.subList(i, j), shift+1, res);
      i = j;
    }
  }

  public List<String> wordsAbbreviation(List<String> dict) {
    HashMap<String, String> res = new HashMap<>(dict.size());

    HashMap<String, List<String>> abrv = new HashMap<>(dict.size());
    for (String w : dict) {
      if (w.length() <= 3) {
        res.put(w, w);
      } else {
        String ab = makeA(w, 1);
        List<String> list = abrv.get(ab);
        if (list == null) {
          list = new ArrayList<>();
          abrv.put(ab, list);
        }
        list.add(w);
      }
    }

    for (Map.Entry<String, List<String>> entry : abrv.entrySet()) {
      if (entry.getValue().size() == 1) {
        res.put(entry.getValue().get(0), entry.getKey());
      } else {
        List<String> value = entry.getValue();
        Collections.sort(value);
        handle(value, 1, res);
      }
    }

    ArrayList<String> ans = new ArrayList<>(res.size());
    for (String w : dict) {
      ans.add(res.get(w));
    }
    return ans;
  }
}