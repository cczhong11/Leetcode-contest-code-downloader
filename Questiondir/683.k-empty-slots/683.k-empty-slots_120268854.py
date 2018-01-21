class Solution(object):
    def kEmptySlots(self, flowers, k):
        """
        :type flowers: List[int]
        :type k: int
        :rtype: int
        """
        bucket = {} # id_ to (min_, max_)
        n = len(flowers)
        for i in range(n):
            item = flowers[i]
            id_ = item / (k+1)
            if id_ not in bucket or item <= bucket[id_][0]: # can try with small
                if id_-1 in bucket and item-bucket[id_-1][1] == k+1:
                    return i + 1
            if id_ not in bucket or item >= bucket[id_][1]: # can try with small
                if id_+1 in bucket and bucket[id_+1][0] - item == k+1:
                    return i + 1
            # update bucket
            if id_ in bucket:
                min_, max_ = bucket[id_]
                bucket[id_] = (min(min_, item), max(max_, item))
            else:
                bucket[id_] = (item, item)
        return -1