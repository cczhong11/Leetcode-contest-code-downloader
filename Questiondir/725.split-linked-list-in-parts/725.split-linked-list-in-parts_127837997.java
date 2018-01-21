import java.util.*;
import java.math.*;
import java.util.stream.*;

class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();

        {

        }
    }

    public ListNode[] splitListToParts(ListNode root, int k) {
        List<ListNode> res = new ArrayList<>();
        int len = 0, m = k;
        for (ListNode i = root; i != null; i = i.next)
            len++;
        for (int i = 0; i < k; i++) {
            int each = (len + m - 1) / m;

            res.add(root);
            ListNode h = root;
            for (int j = 0; j < each - 1; j++)
                if (h != null)
                    h = h.next;
            if (h != null) {
                root = h.next;
                h.next = null;
            }

            len -= each;
            m--;
        }

        return res.stream().toArray(ListNode[]::new);
    }


}
