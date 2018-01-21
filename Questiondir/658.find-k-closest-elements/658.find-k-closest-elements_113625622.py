class Solution(object):
    def findClosestElements(self, A, K, X):
        A.sort(key = lambda x: (abs(x-X), x))
        return sorted(A[:K])