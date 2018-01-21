class Solution(object):
    def shoppingOffers(self, price, special, needs):
        """
        :type price: List[int]
        :type special: List[List[int]]
        :type needs: List[int]
        :rtype: int
        """
        self.res =  0
        self.n = len(needs)
        for i in range(self.n):
            self.res += needs[i] * price[i]
        
        def dfs(needs, cost, last):
            t =0 
            for i in range(self.n):
                t += needs[i]*price[i]
            self.res = min(t+cost,self.res)
            for i in range(last, len(special)):
                ok = True
                for j in range(self.n):
                    if special[i][j]>needs[j]:
                        ok = False
                        break
                if ok:
                    for j in range(self.n):
                        needs[j] -= special[i][j]
                    dfs(needs,cost+special[i][-1],i)
                    for j in range(self.n):
                        needs[j] += special[i][j]
        dfs(needs,0 ,0)
        return self.res
                    
                    
                