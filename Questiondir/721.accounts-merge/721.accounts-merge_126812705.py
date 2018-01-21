class Solution:
    def accountsMerge(self, accounts):
        """
        :type accounts: List[List[str]]
        :rtype: List[List[str]]
        """
        
        mails = {}
        for ai in range(len(accounts)):
            a = accounts[ai]
            for m in a[1:]:
                if not m in mails:
                    mails[m] = set()
                mails[m].add(ai)
                
        classes = [None for _ in accounts]
        for cs in mails.values():
            for c in cs:
                if not classes[c]:
                    classes[c] = set()
                classes[c] |= cs
        #print(classes)
        
        merged_sets = []
        totake = set(range(len(accounts)))
        while totake:
            t = totake.pop()
            frontier = {t}
            core = set()
            
            while True:
                new_core = core | frontier
                new_frontier = set()
                for f in frontier:
                    new_frontier |= classes[f]
                new_frontier -= new_core
                
                core, frontier = new_core, new_frontier
                if not frontier:
                    break
            #print(core)
            merged_sets.append(core)
            totake -= core
        
        merged_accounts = []
        for ms in merged_sets:
            account = [accounts[list(ms)[0]][0] ]
            mails = set()
            for m in ms:
                mails |= set(accounts[m][1:])
            account += sorted(list(mails))
            merged_accounts.append(account)
        return merged_accounts
        