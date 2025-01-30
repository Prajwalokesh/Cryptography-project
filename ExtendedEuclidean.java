import java.util.Scanner;

class ExtendedEuclidean{
    public static void extendedEuclidean(int a, int b) {
        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s\n", "q", "r1", "r2", "r", "t1", "t2", "t");
        System.out.println("-----------------------------------------------------------");
        int r1 = a, r2 = b;
        int t1 = 1, t2 = 0;
        int t = 0;
        while (r2 > 0) {
            int q = r1 / r2;
            int r = r1 % r2;
            t = t1 - q * t2;
            System.out.printf("%-10d %-10d %-10d %-10d %-10d %-10d\n", q, r1, r2, r, t1, t2);
            r1 = r2;
            r2 = r;
            t1 = t2;
            t2 = t;
        }
        System.out.println("-----------------------------------------------------------");
        System.out.println("GCD: " + r1);
        System.out.println("Multiplicative Inverse: " + (t1 < 0 ? t1 + b : t1));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter two integers (a and b) to compute the GCD and modular inverse:");
        int a = sc.nextInt();
        int b = sc.nextInt();
        extendedEuclidean(a, b);
        sc.close();
    }
}
