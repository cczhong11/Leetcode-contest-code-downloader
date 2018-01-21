class Solution(object):
	def maxSumOfThreeSubarrays(self, nums, k):
		n = len(nums)

		csum = [0] * (n + 1)
		for i in range(1, n+1):
			csum[i] = csum[i-1] + nums[i-1]

		cur1, max1, idx1 = [0] * n, [0] * n, [0] * n
		cur2, max2, idx2 = [0] * n, [0] * n, [0] * n
		cur3, max3, idx3 = [0] * n, [0] * n, [0] * n
		for i in range(k-1, n):
			cur1[i] = csum[i+1] - csum[i+1-k]
			if cur1[i] > max1[i-1]:
				max1[i] = cur1[i]
				idx1[i] = i
			else:
				max1[i] = max1[i-1]
				idx1[i] = idx1[i-1]

			if i >= k:
				cur2[i] = max1[i-k] + cur1[i]
				if cur2[i] > max2[i-1]:
					max2[i] = cur2[i]
					idx2[i] = i
				else:
					max2[i] = max2[i-1]
					idx2[i] = idx2[i-1]

			if i >= 2*k:
				cur3[i] = max2[i-k] + cur1[i]
				if cur3[i] > max3[i-1]:
					max3[i] = cur3[i]
					idx3[i] = i
				else:
					max3[i] = max3[i-1]
					idx3[i] = idx3[i-1]

		i3 = idx3[-1]
		i2 = idx2[i3 - k]
		i1 = idx1[i2 - k]
		return [i1 - k + 1, i2 - k + 1, i3 - k + 1]