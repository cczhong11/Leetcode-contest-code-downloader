class Solution(object):
    def accountsMerge(self, accounts):
        """
        :type accounts: List[List[str]]
        :rtype: List[List[str]]
        """
        def find(uf,x):
            if uf[x]!=x:
                uf[x]=find(uf,uf[x])
            return uf[x]
        
        def union(uf,x1,x2):
            r1,r2=find(uf,x1),find(uf,x2)
            if r1==r2:
                return False
            uf[r1]=r2
            return True
        
        uf={}
        for account in accounts:
            name=account[0]
            prev=None
            for i in range(1,len(account)):
                node=(name,account[i])
                if node not in uf:
                    uf[node]=node
                if prev is not None:
                    union(uf,node,prev)
                prev=node
        
        table=collections.defaultdict(list)
        for key,val in uf.items():
            root=find(uf,key)
            table[root].append(key[1])

        return [[key[0]]+sorted(val) for key,val in table.items()]
        
        
            