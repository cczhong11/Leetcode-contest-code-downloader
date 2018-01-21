class Solution(object):
    def anagramMappings(self, A, B):
        """
        :type A: List[int]
        :type B: List[int]
        :rtype: List[int]
        """
        table = collections.defaultdict(list)
        for i, num in enumerate(B):
            table[num].append(i)
            
        res = []
        for num in A:
            res.append(table[num].pop())
            
        return res