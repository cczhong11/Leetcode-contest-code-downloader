class Solution {
      double[] rs1 = new double[128], rs2 = new double[128], rs3 = new double[128];

    int op(double[] rs, double a, double b) {
        int k = 0;
        rs[k++] = a + b;
        rs[k++] = a - b;
        rs[k++] = a * b;
        if (b != 0) rs[k++] = a / b;
        rs[k++] = b - a;
        if (a != 0) rs[k++] = b / a;
        return k;
    }

    public boolean judgePoint24(int[] nums) {
        int[] ab = new int[2];

        for (int i = 0; i < 3; i++)
            for (int j = i + 1; j < 4; j++) {
                int k = 0;
                for (int z = 0; z < 4; z++)
                    if (z != i && z != j) ab[k++] = nums[z];
                int c1 = op(rs1, nums[i], nums[j]);
                int c2 = op(rs2, ab[0], ab[1]);
                for (int x = 0; x < c1; x++)
                    for (int y = 0; y < c2; y++) {
                        int c3 = op(rs3, rs1[x], rs2[y]);
                        for (int z = 0; z < c3; z++)
                            if (Math.abs(rs3[z] - 24) < 1e-7) {
//                                System.out.println(rs3[z]);
                                return true;
                            }
                    }
                for (int r = 0; r < 2; r++) {
                    for (int x = 0; x < c1; x++) {
                        c2 = op(rs2, rs1[x], ab[0]);
                        for (int y = 0; y < c2; y++) {
                            int c3 = op(rs3, rs2[y], ab[1]);
                            for (int z = 0; z < c3; z++)
                                if (Math.abs(rs3[z] - 24) < 1e-7) {
//                                    System.out.println(rs3[z]);
                                    return true;
                                }
                        }
                    }
                    int t = ab[0];
                    ab[0] = ab[1];
                    ab[1] = t;
                }
            }
        return false;
    }
}