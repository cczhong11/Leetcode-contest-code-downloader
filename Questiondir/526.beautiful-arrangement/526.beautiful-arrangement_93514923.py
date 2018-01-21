class Solution(object):
    def countArrangement(self, N):
        """
        :type N: int
        :rtype: int
        """
        def search(i, l, ans):
            if len(l) == 0:
                ans[0] += 1
                return
            for j in range(len(l)):
                if l[j] % i == 0 or i % l[j] == 0:
                    k = l[j]
                    l.remove(l[j])
                    search(i + 1, l, ans)
                    l.insert(j, k)
        if N <= 0:
            return 0
        a = [i for i in range(1, N + 1)]
        ans = [0]
        search(1, a, ans)
        return ans[0]