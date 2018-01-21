import java.util.ArrayList;
import java.util.List;

class Solution {
    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }


    private static class Rational {
        int a, b;

        public Rational(int a, int b) {
            if (b == 0) {
                throw new RuntimeException();
            }
            int g = gcd(Math.abs(a), Math.abs(b));
            a /= g;
            b /= g;
            if (b < 0) {
                a = -a;
                b = -b;
            }
            this.a = a;
            this.b = b;
        }

        public Rational add(Rational that) {
            return new Rational(a * that.b + b * that.a, b * that.b);
        }

        public Rational minus(Rational that) {
            return new Rational(a * that.b - b * that.a, b * that.b);
        }

        public Rational times(Rational that) {
            return new Rational(a * that.a, b * that.b);
        }

        public Rational div(Rational that) {
            return new Rational(a * that.b, b * that.a);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Rational rational = (Rational) o;

            if (a != rational.a) return false;
            return b == rational.b;
        }

        @Override
        public int hashCode() {
            int result = a;
            result = 31 * result + b;
            return result;
        }

        public boolean isZero() {
            return a == 0;
        }
    }


    public boolean judgePoint24(int[] nums) {
        List<Rational> numbers = new ArrayList<>();
        for (int num : nums) {
            numbers.add(new Rational(num, 1));
        }
        return can(numbers);
    }

    private boolean can(List<Rational> numbers) {
        if (numbers.size() == 1) {
            return numbers.get(0).equals(new Rational(24, 1));
        }
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                List<Rational> newList = new ArrayList<>();
                for (int k = 0; k < numbers.size(); k++) {
                    if (k != i && k != j) {
                        newList.add(numbers.get(k));
                    }
                }
                Rational a = numbers.get(i);
                Rational b = numbers.get(j);
                newList.add(a.add(b));
                if (can(newList)) {
                    return true;
                }
                newList.remove(newList.size() - 1);
                newList.add(a.minus(b));
                if (can(newList)) {
                    return true;
                }
                newList.remove(newList.size() - 1);
                newList.add(b.minus(a));
                if (can(newList)) {
                    return true;
                }
                newList.remove(newList.size() - 1);
                newList.add(a.times(b));
                if (can(newList)) {
                    return true;
                }
                newList.remove(newList.size() - 1);
                if (!b.isZero()) {
                    newList.add(a.div(b));
                    if (can(newList)) {
                        return true;
                    }
                    newList.remove(newList.size() - 1);
                }
                if (!a.isZero()) {
                    newList.add(b.div(a));
                    if (can(newList)) {
                        return true;
                    }
                    newList.remove(newList.size() - 1);
                }

            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().judgePoint24(new int[]{4, 1, 8, 7}));
    }
}