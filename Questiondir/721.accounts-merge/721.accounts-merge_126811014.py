class Solution(object):
    def accountsMerge(self, accounts):
        """
        :type accounts: List[List[str]]
        :rtype: List[List[str]]
        """
        from numpy import arange,array
        a=arange(len(accounts))+1
        emaildict={}
        for i in range(len(accounts)):
            for j in range(1,len(accounts[i])):
                emaildict[accounts[i][j]]=emaildict.get(accounts[i][j],[])+[i]
        n=max(a)+1
        for i in emaildict:
            if len(emaildict[i])>1:
                for j in emaildict[i]:
                    a[a==a[j]]=n
                n+=1
        mergeid=set(a)
        result=[]
        for i in sorted(mergeid):
            name=accounts[(a==i).nonzero()[0][0]][0]
            emails=[]
            for j in (a==i).nonzero()[0]:
                emails+=accounts[j][1:]
            emails=sorted(list(set(emails)))
            result.append([name]+emails)
        return result