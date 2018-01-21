class Solution(object):
    def pathSum(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        self.Dic={}
        self.Dic[11]=[21,22]
        self.Dic[21]=[31,32]
        self.Dic[31]=[41,42]
        self.Dic[32]=[43,44]
        self.Dic[22]=[33,34]
        self.Dic[33]=[45,46]
        self.Dic[34]=[47,48]
        
        self.V={}
        for k in nums:
            key=k/10
            value=k%10
            self.V[key]=value
                            
        self.Sum=0
 
        def DFS(n,T_sum):
            
            T_sum+=self.V[n]
            if n not in self.Dic or ((self.Dic[n][0] not in self.V) and (self.Dic[n][1] not in self.V)): ## judge the leave
                self.Sum+=T_sum
                return
            else:
                for item in self.Dic[n]:
                    
                    
                    if item in self.V:
                        DFS(item,T_sum)
                    
        DFS(11,0)
        return self.Sum
        