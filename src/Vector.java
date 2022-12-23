public class Vector {
    private int dim;
    private int[][] vector;
    private int[] elements;
    private int contador;


    public Vector(int dim, int[] elements) {
        this.dim = dim;
        this.elements = elements;
        organizarVetor();
    }

    public void get(int contadorLinha) {
        int number;
        number = vector[contadorLinha-1][0];

        System.out.println("O número retornado é: "+number);
    }

    public void set(int contadorLinha, int number) {
        vector[contadorLinha-1][0] = number;
        printVector();
    }

    public int[][] organizarVetor() {
        int aux = 0;
        vector = new int[dim][1];

        for(int contadorLinha = 0; contadorLinha<dim;contadorLinha++){
            for(int contadorColuna = 0; contadorColuna<1;contadorColuna++) {
                vector[contadorLinha][contadorColuna] = elements[aux];
                aux++;
            }
        }
        System.out.println();
        System.out.println("Vetor criado!");
        printVector();
        return vector;
    }

    public void printVector() {
        for (int contadorLinha = 0; contadorLinha < vector.length; contadorLinha++) {
            for (int contadorColuna = 0; contadorColuna < vector[contadorLinha].length; contadorColuna++) {
                System.out.print(vector[contadorLinha][contadorColuna] + " ");
            }
            System.out.println();
        }
    }

    public int[][] getVector() {
        return vector;
    } //ok
}
