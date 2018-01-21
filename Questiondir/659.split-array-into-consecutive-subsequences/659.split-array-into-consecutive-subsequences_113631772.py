class Solution(object):
    def isPossible(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        end2subseq = dict()
        n_lessThan3 = 0
        for num in nums:
            if num - 1 in end2subseq and end2subseq[num - 1]:
                length = heapq.heappop(end2subseq[num - 1])
                if length < 3:
                    n_lessThan3 -= 1
            else:
                length = 0
                
            if length < 2:
                n_lessThan3 += 1            
            if num in end2subseq:
                heapq.heappush(end2subseq[num], length + 1)
            else:
                end2subseq[num] = [length + 1]
        #print end2subseq
        return n_lessThan3 == 0