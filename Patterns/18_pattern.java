class App {
    public static void main(String[] args) {
        print(5);
    }

    static public void print(int rows) {
        for (int i = 0; i < rows; i++) {
            for (char k = (char) ('E' - i); k <= 'E'; k++) {
                System.out.print(k + " ");
            }
            System.out.println();
        }
    }
}
