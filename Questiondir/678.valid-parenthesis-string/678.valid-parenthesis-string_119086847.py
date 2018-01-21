class Solution(object):
    def checkValidString(self, s):
        """
        :type s: str
        :rtype: bool
        """
        def check(s, l='(', r=')'):
            left, right, star = 0, 0, 0
            for i in s:
                if i == l:
                    left += 1
                elif i == r:
                    right += 1
                elif i == '*':
                    star += 1
                if left < right:
                    if star:
                        star -= 1
                        left += 1
                    else:
                        return False
            if left == right:
                return True
            elif left > right:
                return left <= right + star
        return check(s) and check(s[::-1], ')', '(')
                
        