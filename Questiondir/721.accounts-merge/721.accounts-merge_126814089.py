class Solution(object):
    def accountsMerge(self, accounts):
        """
        :type accounts: List[List[str]]
        :rtype: List[List[str]]
        """
        edges = collections.defaultdict(set)
        for i, a in enumerate(accounts):
            for item in a:
                edges[item].add(i)
        ret = []
        visited = set()
        def dfs(account, save):
            for item in account[1:]:
                save.add(item)
                for i in edges.get(item, []):
                    if i in visited:
                        continue
                    visited.add(i)
                    dfs(accounts[i], save)
                
        for i, a in enumerate(accounts):
            if i in visited:
                continue
            visited.add(i)
            cur = set()
            dfs(a, cur)
            cur = [a[0]] + sorted(list(cur))
            
            ret.append(cur)
        return ret
            