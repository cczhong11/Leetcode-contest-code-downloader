from collections import Counter

class Solution:
    def reorganizeString(self, S):
        """
        :type S: str
        :rtype: str
        """
        
        N = len(S)
        cnt = Counter(S)
        
        if N <= 1:
            return S
        
        if len(cnt) == 1 and N > 1:
            return ""
        
        prev = ""
        result = ""
        for _ in range(N):
            l = cnt.most_common(2)
            
            #print (l)
            
            if l[0][0] != prev:
                prev = l[0][0]
                cnt[prev] -= 1
                result += prev
            else:
                if len(cnt) == 1 or not cnt[l[1][0]]:
                    return ""
                prev = l[1][0]
                cnt[prev] -= 1
                result += prev
        
        return result

        