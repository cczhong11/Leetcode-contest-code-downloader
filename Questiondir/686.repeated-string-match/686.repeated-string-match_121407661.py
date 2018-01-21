class Solution(object):
	def repeatedStringMatch(self, A, B):
		n, m = len(A), len(B)
		C = (m / n + 2) * A

		i = 0
		while i < n:
			if B == C[i:i+m]:
				if (i+m) % n == 0:
					return (i+m)/n
				return (i+m)/n+1
			i += 1

		return -1