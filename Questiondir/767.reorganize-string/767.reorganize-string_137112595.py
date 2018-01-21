from collections import Counter
class Solution:
    def reorganizeString(self, S):
        """
        :type S: str
        :rtype: str
        """
        N = len(S)
        cnt = Counter(S)
        l = cnt.most_common(1)[0][1]
        # print(cnt)
        if l > (N+1)//2:
            return ""
        c = cnt.most_common(1)[0][0]
        cnt[c] -= 1
        sList = [c]
        for i in range(1, N):
            mc = cnt.most_common(2)
            if c != mc[0][0]:
                c = mc[0][0]
                cnt[c] -= 1
                sList.append(c)
            else:
                c = mc[1][0]
                cnt[c] -= 1
                sList.append(c)

        return ''.join(sList)