class Solution:
    def pyramidTransition(self, bottom, allowed):
        """
        :type bottom: str
        :type allowed: List[str]
        :rtype: bool
        """
        d = {}
        for triple in allowed:
            key = triple[0:2]
            val = triple[-1]
            if key not in d:
                d[key] = []
            d[key].append(val)
        # print(d)
        def dfs(b, u):
            # print(b, u)
            if len(b) == 1:
                return True
            if len(u) + 1 == len(b):
                return dfs(u, '')
            ind = len(u)
            base = b[ind:ind+2]
            if base not in d:
                return False
            for val in d[base]:
                if dfs(b, u+val):
                    return True
            return False
            
        return dfs(bottom, '')