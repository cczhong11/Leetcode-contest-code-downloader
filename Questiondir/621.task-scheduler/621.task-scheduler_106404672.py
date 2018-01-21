class Solution(object):
    def leastInterval(self, tasks, n):
        """
        :type tasks: List[str]
        :type n: int
        :rtype: int
        """
        chars = list('ABCDEFGHIJKLMNOPQRSTUVWXYZ')
        counts = [tasks.count(c) for c in chars]
        max_char = max(counts)
        maximizers = counts.count(max_char)
        return max((n + 1) * (max_char - 1) + maximizers, len(tasks))
        