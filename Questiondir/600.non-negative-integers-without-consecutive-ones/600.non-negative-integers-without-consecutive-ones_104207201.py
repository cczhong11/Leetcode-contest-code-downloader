class Solution(object):
	def findIntegers(self, num):
		res_dict={0:1,1:2,2:3}
		if num in res_dict:
			return res_dict[num]
		bitnum=1
		while num>=(1<<bitnum):
			bitnum+=1
		good1={0:0,1:1}
		good0={0:0,1:1}
		for i in xrange(2, bitnum):
			good1[i]=good0[i-1]
			good0[i]=good0[i-1]+good1[i-1]

		res=0
		while num not in res_dict:
			if num&(1<<bitnum):
				res+=good1[bitnum]+good0[bitnum]
				num-=(1<<bitnum)
				if bitnum>0 and num&(1<<(bitnum-1)):
					num=1<<(bitnum-1)
					res-=1
			bitnum-=1

		return res+res_dict[num]