class App {
    public static void main(String[] args) {
        print(5);
    }

    static public void print(int m) {
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= m - i + 1; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
