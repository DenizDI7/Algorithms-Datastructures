import java.util.Scanner;

public class Assignment1 {
    public static boolean canJump(int s, int maxJumps, int[] pillars) {
        int i = 0;
        int jumps = 0;
        while (i < pillars.length - 1) {
            int j = Math.min(pillars.length - 1, i + s);
            boolean jumped = false;
            while (j > i) {
                if (pillars[j] <= pillars[i] + s) {
                    jumped = true;
                    i = j;
                    break;
                }
                j--;
            }
            if (!jumped) return false;
            jumps++;
            if (jumps > maxJumps) return false;
        }
        return true;
    }

    public static int getMinStrength(int j, int[] pillars) {
        int s = 1;
        while (!canJump(s, j, pillars)) {
            s++;
        }
        return s;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int nPillars = s.nextInt();
        int nJumps = s.nextInt();

        int[] pillars = new int[nPillars];

        for (int i = 0; i < pillars.length; i++) {
            pillars[i] = s.nextInt();
        }

        System.out.println(getMinStrength(nJumps, pillars));
    }
}
