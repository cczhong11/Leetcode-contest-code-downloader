class Solution:
    def crackSafe(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: str
        """
        
        def gen_all(n, k):
            if n == 1:
                return set(map(str, range(k)))
            tmp = gen_all(n - 1, k)
            res = {str(i) + t for t in tmp for i in range(k)}
            return res
        
        def dfs(tmp, pos, n, k):
            # print(tmp)
            if not pos:
                return True
            s = "".join(tmp[-n + 1:]) if n > 1 else ''
            for i in range(k):
                t = s + str(i)
                if t not in pos: continue
                pos.remove(t)
                tmp.append(str(i))
                if dfs(tmp, pos, n, k):
                    return True
                tmp.pop()
                pos.add(t)
            return False

        pos = gen_all(n, k)
        # print(pos)
        
        res = ["0" for _ in range(n)]
        pos.remove("".join(res))
        dfs(res, pos, n, k)
        return "".join(res)
        