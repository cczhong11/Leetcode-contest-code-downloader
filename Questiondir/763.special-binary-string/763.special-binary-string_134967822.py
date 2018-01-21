class Solution:
    def makeLargestSpecial(self, S):
        """
        :type S: str
        :rtype: str
        """
        # 110100 11110000 111000
        # 1 10 10 0 11110000 111000
        # 11101000 
        
        parts = []
        p = ''
        ones= 0
        for c in S:
            p += c
            ones += 1 if c == '1' else -1
            if ones == 0:
                parts.append(p)
                p = ''
        if len(parts) == 1:
            return '1' + self.makeLargestSpecial(S[1:-1]) + '0'
        else:
            parts = [self.makeLargestSpecial(p) for p in parts]
            parts.sort()
            return ''.join(reversed(parts))