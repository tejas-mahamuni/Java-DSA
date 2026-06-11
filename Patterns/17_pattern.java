class App {
    public static void main(String[] args) {
        print(5);
    }

    static public void print(int rows) {
        for (int i = 0; i < rows; i++) {
            char k = 65;
            for (int j = 0; j < rows - i - 1; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i + 1; j++) {
                System.out.print(k++);
            }
            k--;
            for (int j = 0; j < i; j++) {
                System.out.print(--k);
            }
            System.out.println();
        }
    }
}
