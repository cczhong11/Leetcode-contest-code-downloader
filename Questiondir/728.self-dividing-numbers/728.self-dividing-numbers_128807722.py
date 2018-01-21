class Solution(object):
    def selfDividingNumbers(self, left, right):
    	res = []
    	for num in range(left, right + 1):
    		s = str(num)
    		if s.count('0'): 
    			continue

    		flag = True
    		for ch in s:
    			if num % int(ch):
    				flag = False
    				break

    		if flag:
    			res.append(num)

    	return res