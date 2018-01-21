class Solution(object):
    def accountsMerge(self, accounts):
        """
        :type accounts: List[List[str]]
        :rtype: List[List[str]]
        """
        import collections
        accountdic = collections.defaultdict(list)
        res = []
        for account in accounts:
            accountdic[account[0]].append(set(account[1:]))
        for name,emails in accountdic.iteritems():
            while emails:
                curemailset = emails.pop()
                oldsize=len(curemailset)
                for es in emails:
                    if es&curemailset:
                        curemailset|=es
                while oldsize!=len(curemailset):
                    oldsize = len(curemailset)
                    for es in emails:
                        if es&curemailset:
                            curemailset|=es
                emails = [es for es in emails if not es&curemailset]
                res.append([name]+sorted(list(curemailset)))
        return sorted(res)