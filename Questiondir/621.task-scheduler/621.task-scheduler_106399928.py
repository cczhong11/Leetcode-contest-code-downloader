class Solution(object):
    def leastInterval(self, tasks, n):
        """
        :type tasks: List[str]
        :type n: int
        :rtype: int
        """
        freq = {}
        for task in tasks:
            if task not in freq:
                freq[task] = 0
            freq[task] += 1
        
        m = max(freq.values())
        fm = 0
        for x in freq.values():
            if x == m:
                fm += 1
        ans1 = (m - 1) * (n + 1) + fm
        ans2 = len(tasks)
        return max(ans1, ans2)
        