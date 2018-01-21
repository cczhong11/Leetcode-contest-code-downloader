class Solution(object):
    def triangleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        m=max(nums)
        co=[0 for i in range(m+1)]
        cul=[0 for i in range(m+1)]
        for i in nums:
            co[i]+=1
        tot=0
        
        def s2(n):
            return n*(n-1)//2
        
        def s3(n):
            return n*(n-1)*(n-2)//6
        
        
        for i in range(1,m+1):
            cul[i]=cul[i-1]+co[i]
            
        for i in range(1,m+1):
            if co[i]<1:
                continue
            if co[i]>=2:
                if co[i]>=3:
                    tot+=s3(co[i])
                tot+=s2(co[i])*((cul[2*i-1] if 2*i-1<=m else cul[-1])-cul[i])
            for j in range(i+1,m+1):
                if co[j]>=2:
                    tot+=co[i]*s2(co[j])
                tot+=co[i]*co[j]*((cul[(i+j-1)] if i+j-1<=m else cul[-1])-cul[j])
        return tot