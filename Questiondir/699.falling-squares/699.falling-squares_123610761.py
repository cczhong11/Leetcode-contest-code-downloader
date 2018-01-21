class Solution(object):
    def fallingSquares(self, positions):
        """
        :type positions: List[List[int]]
        :rtype: List[int]
        """
        records = []
        res = []
        for pos in positions:
            if not records:
                records.append((pos[0], pos[0] + pos[1], pos[1]))
                res = [pos[1]]
            else:
                max_high = pos[1]
                for rec in records:
                    if pos[0] < rec[1] and pos[0] + pos[1] > rec[0]:
                        max_high = max(max_high, rec[2] + pos[1])
                records.append((pos[0], pos[0] + pos[1], max_high))
                res.append(max(res[-1], max_high))
        return res
                        
                        
        