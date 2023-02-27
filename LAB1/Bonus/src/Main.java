public class Main {
    public static void main(String[] args) {
        Main exercitii = new Main();
        exercitii.ex1(args);
        //exercitii.ex2(args);
    }

    void ex1(String[] args) {
        if (args.length > 1) {
            System.out.println("PREA MULTE ARGUMENTE");
            System.exit(0);
        }

        if (args.length < 1) {
            System.out.println("PREA PUTINE ARGUMENTE");
            System.exit(0);
        }

        try {
            Integer.parseInt(args[0]);
            System.out.println(args[0] + " is a valid integer number");
        } catch (NumberFormatException e) {
            System.out.println(args[0] + " is not a valid integer number");
            System.exit(0);
        }
        int n = Integer.parseInt(args[0]);

        int[][] CycleGraph = new int[n + 1][n + 1]; // matricea initiala
        int[][] A = new int[n + 1][n + 1]; // aici memoram matricea A la putere
        int[][] B = new int[n + 1][n + 1]; // o folosim pentru a memora temporar noua matrice

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                CycleGraph[i][j] = 0;
                if (j == i + 1)
                    CycleGraph[i][j] = 1;
            }
            CycleGraph[n][1] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                A[i][j] = CycleGraph[i][j];
            }
        }

        for (int q = 1; q <= n; q++) {

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    B[i][j] = 0;
                    for (int x = 1; x <= n; x++) {
                        B[i][j] += A[i][x] * CycleGraph[x][j]; // calculam A la puterea n
                    }
                }
            }

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    A[i][j] = B[i][j];
                }
            }
        }
        for (int i = 1; i <= n; i++) { // testam daca matricea initila A este egala cu matricea A la puterea n
            for (int j = 1; j <= n; j++) {
                if(A[i][j]!=CycleGraph[i][j])
                {
                    System.out.println("IDK");
                    System.exit(0);
                }
            }
        }
        System.out.println("Matricea A la puterea n este egala cu matricea initiala A :))");
    }
    void ex2(String[] args) {
    // IN LUCRU
    }
}
