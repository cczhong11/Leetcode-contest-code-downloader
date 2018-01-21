class Solution(object):
    def checkValidString(self, s):
        """
        :type s: str
        :rtype: bool
        """
        cmin = cmax = 0
        for i in s:
            if i == '(':
                cmax += 1
                cmin += 1
            if i == ')':
                cmax -= 1
                cmin -= 1
            if i == '*':
                cmax += 1
                cmin -= 1
            if cmax == 0:
                cmin = 0
            if cmax < 0: return False
            # print cmax,cmin
        if cmin > 0: return False

        s = s[::-1]
        cmin = cmax = 0
        for i in s:
            if i == ')':
                cmax += 1
                cmin += 1
            if i == '(':
                cmax -= 1
                cmin -= 1
            if i == '*':
                cmax += 1
                cmin -= 1
            if cmax == 0:
                cmin = 0
            if cmax < 0: return False
            # print cmax,cmin
        if cmin > 0: return False
        else: return True