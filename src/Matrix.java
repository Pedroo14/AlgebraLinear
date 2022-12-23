public final class Matrix {
    private int rows;
    private int cols;

    private int contadorLinha;
    private int contadorColuna;

    private int[] elements;
    private int aux = 0;
    private int[][] matriz;

    public Matrix(int rows, int cols, int[] elements) {
        this.rows = rows;
        this.cols = cols;
        this.elements = elements;
        organizarMatriz();
    }

    public void get(int contadorLinha,int contadorColuna) {
        int number;
        number = matriz[contadorLinha-1][contadorColuna-1];

        System.out.println("O número retornado é: "+number);
    }

    public void set(int contadorLinha,int contadorColuna, int number) {
        matriz[contadorLinha-1][contadorColuna-1] = number;

        printMatriz();
    }


    public void printMatriz() {
        for (contadorLinha = 0; contadorLinha < matriz.length; contadorLinha++) {
            for (contadorColuna = 0; contadorColuna < matriz[contadorLinha].length; contadorColuna++) {
                System.out.print(matriz[contadorLinha][contadorColuna] + " ");
            }
            System.out.println();
        }
    }

    public int[][] organizarMatriz() {
        matriz = new int[rows][cols];

        for(contadorLinha = 0; contadorLinha<rows;contadorLinha++){
            for(contadorColuna = 0; contadorColuna<cols;contadorColuna++) {
                matriz[contadorLinha][contadorColuna] = elements[aux];
                aux++;
            }
        }

        System.out.println();
        System.out.println("Matriz criada!");
        printMatriz();
        return matriz;
    }

    public int[][] getMatriz() {
        return matriz;
    }
}
