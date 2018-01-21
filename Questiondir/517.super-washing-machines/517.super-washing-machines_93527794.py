class Solution(object):
    def findMinMoves(self, machines):
        if len(machines) == 1:
            return 0
        
        """
        :type machines: List[int]
        :rtype: int
        """
        total = sum(machines)
        N = len(machines)
        if total%N != 0:
            return -1
        target = total/N
        
        res = 0
        left = 0
        for i in range(N-1):
            left += machines[i]
            
            lefttarget = (i+1)*target
            
            diff = lefttarget - left
            
            diff = max(diff,-diff)
            
            res = max(res,diff)
            
            
            
        if N >= 3:   
            left = machines[0]
            lefttarget = target
            right = total - machines[0] - machines[1]
            righttarget = target*(N-2)
            for i in range(1,N-1):
                outflowleft = lefttarget - left
                outflowright = righttarget - right
                if outflowleft>0 and outflowright>0:
                    res = max(res, outflowleft+outflowright)
                
                left += machines[i]
                right -= machines[i+1]
                lefttarget += target
                righttarget -= target
        
        return res
        
        