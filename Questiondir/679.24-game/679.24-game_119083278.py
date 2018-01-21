class Solution(object):
    def judgePoint24(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        
        
        def search(ns):
            n=len(ns)
            if n==1:
                return ns[0]==24
            
            def ops(k,a,b):
                if k==0:
                    return a+b
                elif k==1:
                    return a-b
                elif k==2:
                    return b-a
                elif k==3:
                    return a*b
                elif k==4:
                    return 1.0*a/b if b!=0 else float('inf')
                else:
                    return 1.0*b/a if a!=0 else float('inf')
                    
            
            for i in range(n-1)    :
                for j in range(i+1,n):
                    for m in range(6):
                        temp=ops(m,ns[i],ns[j])
                        if temp<float('inf') and search([temp]+ns[:i]+ns[i+1:j]+ns[j+1:]):
                            return True
            return False
        
        return search(nums)