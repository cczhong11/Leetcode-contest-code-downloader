class Solution(object):
    def accountsMerge(self, accounts):
        """
        :type accounts: List[List[str]]
        :rtype: List[List[str]]
        """
        
        a = [[account[0], set(account[1:])] for account in accounts]
        #print(a)
        
        i = 0
        while i < len(a):
            j = i+1
            while j < len(a):
                if a[i][0] == a[j][0] and a[i][1]&a[j][1]:
                    a[i][1] = a[i][1] | a[j][1]
                    del(a[j])
                    j = i+1
                else:
                    j += 1
            i += 1
            #print(a)
        
        a = [[ac[0]] + sorted(list(ac[1])) for ac in a]
        return a
                    