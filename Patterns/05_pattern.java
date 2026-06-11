class App {
    public static void main(String[] args) {
        print(5);
    }

    static public void print(int m) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m - i; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
