from collections import Counter

class Solution(object):
    def reorganizeString(self, S):
        """
        :type S: str
        :rtype: str
        """
        count = Counter(S)
        count = [(val, key) for key, val in count.iteritems()]
        count.sort(reverse = True)
        ans = []
        curLetter = None
        for i in range(len(S)):
            success = False
            for j in range(len(count)):
                if count[j][0] == 0:
                    # fail
                    return ""
                if count[j][1] == curLetter:
                    continue
                # found now
                count[j] = (count[j][0]-1, count[j][1])
                curLetter = count[j][1]
                ans.append(curLetter)
                success = True
                break
            if not success:
                return ""
            count.sort(reverse = True)
        ans = "".join(ans)
        return ans
