class Solution(object):
    def canPartitionKSubsets(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: bool
        """
        avg, s = sum(nums) / k, {(0,) * k}
        if avg * k != sum(nums) or avg < max(nums):
            return False
        for n in sorted(nums, reverse=True):
            s, s_ = set(), s
            for t in s_:
                t = list(t)
                for i in xrange(len(t)):
                    t[i] += n
                    if t[i] <= avg:
                        s.add(tuple(sorted(t)))
                    t[i] -= n
        return (avg,) * k in s