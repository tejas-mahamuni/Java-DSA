class App {
    public static void main(String[] args) {
        print(5, 5);
    }

    static public void print(int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}