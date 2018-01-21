class Solution(object):
    def findIntegers(self, num):
        """
        :type num: int
        :rtype: int
        """
        cnts = [2, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155]
        
        def all_num(lenth):
            s = 0
            for i in xrange(lenth):
                s += cnts[i]
            return s
        
        bb = "{0:b}".format(num)
        if len(bb) == 1:
            return 2 if num == 1 else 1
        if bb.startswith('11'):
            return all_num(len(bb))
        t = None
        for i in xrange(1, len(bb)):
            if bb[i] == '1':
                t = i
                break
        left_num = 0 if t is None else int(bb[t:], 2)
        return all_num(len(bb) - 1) + self.findIntegers(left_num)