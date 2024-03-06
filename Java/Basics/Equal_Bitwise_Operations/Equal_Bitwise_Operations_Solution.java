import java.util.Scanner;

class BeautifulSubsequences {

    public static void main(String args[]) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }

        int result = countBeautifulSubsequences(A);
        System.out.println(result);

        scanner.close();
    }

    private static int countBeautifulSubsequences(int[] A) {
        int mod = (int) (1e9 + 7);
        int N = A.length;
        int count = 0;

        for (int i = 0; i < (1 << N); i++) {
            int and = -1, or = 0, xor = 0;

            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) > 0) {
                    and &= A[j];
                    or |= A[j];
                    xor ^= A[j];
                }
            }

            if (and == or && or == xor) {
                count = (count + 1) % mod;
            }
        }

        return count;
    }
}
