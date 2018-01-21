class Solution(object):
    def countBinarySubstrings(self, s):
        """
        :type s: str
        :rtype: int
        """
        i=0
        n=len(s)
        org=[]
        while i<n:
            j=i
            while j<n and s[j]==s[i]  :
                j+=1
            org.append(j-i)
            i=j
        ans=0
        for i in range(1,len(org)):
            ans+=min(org[i-1],org[i])
        return ans
        