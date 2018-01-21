# import networkx as nx
# import matplotlib.pyplot as plt
#
# g = nx.DiGraph()
# g.add_nodes_from(range(1, 51, 1))
# edges = [[37,30],[21,34],[10,40],[8,36],[18,10],[50,11],[13,6],[40,7],[14,38],[41,24],[32,17],[31,15],[6,27],[45,3],[30,42],[43,26],[9,4],[4,31],[1,29],[5,23],[44,19],[15,44],[49,20],[26,5],[23,50],[48,41],[47,22],[3,46],[11,16],[12,35],[33,50],[34,45],[38,2],[2,32],[24,49],[35,37],[29,13],[46,48],[28,12],[7,21],[27,18],[17,39],[42,14],[20,47],[36,1],[22,9],[25,8],[39,25],[16,28],[19,43]]
# for edge in edges:
#     g.add_edge(*edge)
#
# nx.draw(g,with_labels=True)
# plt.draw()
# plt.show()




"""
Cite: https://en.wikipedia.org/wiki/De_Bruijn_sequence
"""


def de_bruijn(k, n):
    a = [0] * k * n
    sequence = []

    def db(t, p):
        if t > n:
            if n % p == 0:
                sequence.extend(a[1:p + 1])
        else:
            a[t] = a[t - p]
            db(t + 1, p)
            for j in range(a[t - p] + 1, k):
                a[t] = j
                db(t + 1, t)

    db(1, 1)
    return "".join(str(i) for i in sequence)


class Solution:
    def crackSafe(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: str
        """
        if k == 1:
            return ''.join('0' * n)

        list = de_bruijn(k, n)
        cand = set()

        a = [0] * n

        def dfs(t):
            if t >= n:
                cand.add(''.join(str(i) for i in a))
            else:
                for j in range(k):
                    a[t] = j
                    dfs(t + 1)

        dfs(0)
        res = ''
        i = 0

        while len(cand) > 0:
            res += list[i]
            i = (i + 1) % len(list)
            if len(res) >= n:
                # print(res[len(res) - n:len(res)])
                cand.remove(res[len(res) - n: len(res)])

        return res


sol = Solution()
print(sol.crackSafe(2, 2))
print(sol.crackSafe(1, 2))
print(sol.crackSafe(4, 10))
print(sol.crackSafe(1, 1))
print(sol.crackSafe(2, 1))
