from collections import defaultdict


class Solution(object):

    def wordsAbbreviation(self, dict):
        """
        :type dict: List[str]
        :rtype: List[str]
        """
        n = len(dict)
        ans = [''] * n
        visited = [False] * n
        k = 1
        while n > 0:
            tmp = defaultdict(list)
            for i, w in enumerate(dict):
                if visited[i]:
                    continue
                if k + 2 >= len(w):
                    ans[i] = w
                    n -= 1
                    visited[i] = True
                else:
                    tmp[w[:k]+str(len(w)-k-1)+w[-1]].append(i)
            for t, v in tmp.items():
                if len(v) == 1:
                    ans[v[0]] = t
                    visited[v[0]] = True
                    n -= 1
            k += 1
        return ans
