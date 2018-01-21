class Solution(object):
    def findDerangement(self, n):
        """
        :type n: int
        :rtype: int
        """
    	MOD = 1000000007
    	vm2 = 1
    	vm = 0
    	if n == 0:
    		return 1
    	if n == 1:
    		return 0
    	for i in xrange(2, n+1):
    		val = ((i-1) * (vm + vm2)) % MOD
    		vm, vm2 = val, vm
    	return val