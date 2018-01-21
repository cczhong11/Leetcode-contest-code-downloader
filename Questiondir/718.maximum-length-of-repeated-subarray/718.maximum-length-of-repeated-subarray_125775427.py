class Solution:
    def findLength(self, a, b):
        """
        :type A: List[int]
        :type B: List[int]
        :rtype: int
        """
        ans = 0
        n,m = len(a),len(b)
        pre = [0]*(m+1)
        for i in range(1,n+1):
            cur = [0]
            for j in range(1,m+1):
                val = 0
                if a[i-1]==b[j-1]:
                    val = pre[j-1]+1
                cur.append(val)
                ans=max(ans,cur[-1])
            pre = cur
        return ans