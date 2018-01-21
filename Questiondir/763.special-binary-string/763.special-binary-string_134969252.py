class Solution(object):
    def makeLargestSpecial(self, S):
        """
        :type S: str
        :rtype: str
        """
        specials = list()
        specials_index = list()
        start = 0
        while start < len(S):
            this_special, start = self.find_next_special(S, start)
            if this_special is not None:
                specials.append(this_special)
                specials_index.append((start - len(this_special), start))
        specials = map(lambda x: self.makeLargestSpecial(x), specials)
        specials.sort(cmp=self.bigger)
        res = str()
        last = 0
        for start, end in specials_index:
            res += S[last: start]
            res += specials.pop()
            last = end
        res += S[last:]
        return res

    def bigger(self, a, b):
        n = min(len(a), len(b))
        for i in range(n):
            if a[i] > b[i]:
                return 1
            elif a[i] < b[i]:
                return -1
            else:
                continue
        if len(a) > len(b):
            return 1
        else:
            return -1

    def find_next_special(self, s, start):
        num_ones = 0
        num_zeros = 0
        for char in s[start:]:
            if char == '0':
                num_zeros += 1
                if num_zeros > num_ones:
                    return None, start + 1
                if num_zeros == num_ones:
                    if start == 0 and num_zeros + num_ones + start == len(s):
                        return None, start+1
                    else:
                        return s[start: num_zeros + num_ones + start], num_zeros + num_ones + start
            else:
                num_ones += 1
        if start != 0 and num_ones == num_zeros:
            return s[start:], len(s)
        else:
            return None, start + 1