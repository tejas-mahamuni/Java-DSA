class App {
    public static void main(String[] args) {
        print(5);
    }

    static public void print(int m) {
        for (int i = 0; i < 2 * m - 1; i++) {
            for (int j = 0; j < 2 * m - 1; j++) {
                int top = i;
                int left = j;
                int right = (2 * m - 2 - j);
                int bottom = (2 * m - 2 - i);

                int k = Math.min(Math.min(top, left), Math.min(right, bottom));
                System.out.print(m - k + " ");
            }
            System.out.println();
        }
    }
}
