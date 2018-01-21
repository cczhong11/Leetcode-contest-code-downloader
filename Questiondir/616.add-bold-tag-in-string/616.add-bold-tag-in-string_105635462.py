class Solution(object):
    def addBoldTag(self, s, dict):
        """
        :type s: str
        :type dict: List[str]
        :rtype: str
        """
        res = ""
        i = 0
        while i < len(s):
            first = i
            last = i
            j = i
            while j <= last:
                for d in dict:
                    if s[j:j+len(d)] == d:
                        last = max(j+len(d), last)
                j += 1
            if last > first:
                res += "<b>" + s[first:last] + "</b>"
                i = last
            else:
                res += s[i]
                i += 1
        return res
