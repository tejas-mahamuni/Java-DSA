class App {
    public static void main(String[] args) {
        print(5);
    }

    static public void print(int rows) {
        char k = 65;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(k + " ");
            }
            k++;
            System.out.println();
        }
    }
}
