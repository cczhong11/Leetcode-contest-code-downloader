class Solution(object):
    def findShortestSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0
        d={}        
        dgr=1
        ans=float('inf')
        for i,j in enumerate(nums):
            if j not in d:
                d[j]=[1,i,i]
            else:
                d[j][0]+=1
                d[j][2]=i
                if d[j][0]>dgr:
                    dgr=d[j][0]
        for i in d:
            if d[i][0]==dgr:
                ans=min(ans,d[i][2]-d[i][1]+1)
        return ans
                