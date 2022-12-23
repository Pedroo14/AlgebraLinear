import java.io.IOException;
import java.util.Scanner;

public class MenuMatriz {
    Scanner leitor = new Scanner(System.in);
    int respostaMenuMatriz = 0;
    Matrix Matriz;
    Matrix MatrizB;
    LinearAlgebra LinearAlgebra;

    public Matrix menuCriarMatriz() throws IOException {
        int linhas;
        int colunas;
        int[] elements;

        System.out.println();
        System.out.println("=============================== Criar Matriz A ===============================");
        System.out.print("Digite o número de linhas da sua matriz: ");
        linhas = leitor.nextInt();
        System.out.print("Digite o número de colunas da sua matriz: ");
        colunas = leitor.nextInt();

        elements = new int[linhas*colunas];

        System.out.println("Digite os elementos da matriz (um em cada linha):");
        for(int contador = 0; contador<linhas*colunas;contador++) {
            elements[contador] = (leitor.nextInt());
        }

        Matriz = new Matrix(linhas,colunas,elements);
        LinearAlgebra = new LinearAlgebra();


        System.in.read();

        menuMatriz();
        return Matriz;
    }

    public int menuMatriz() throws IOException {
        System.out.println("================================ Menu Inicial ================================");
        System.out.println("Para continuar, escolha o próximo passo:");
        System.out.println("1.Conferir algum elemento da matriz A (Classe Matrix - Método Get)");
        System.out.println("2.Alterar o valor de algum elemento da matriz A (Classe Matrix - Método Set)");
        System.out.println("3.Transpor sua matriz A (Classe LinearAlgebra - Método Transpose)");
        System.out.println("4.Criar matriz B (Necessário para opções 5, 7 e 8)");
        System.out.println("5.Somar matriz A e B (Classe LinearAlgebra - Método Sum)");
        System.out.println("6.Multiplicar matriz A por número (Classe LinearAlgebra - Método Times)");
        System.out.println("7.Multiplicar matriz A por matriz B - Elemento por elemento (Classe LinearAlgebra - Método Times)");
        System.out.println("8.Multiplicar matriz A por matriz B (Classe LinearAlgebra - Método Dot)");
        System.out.println("9.Escalonar matriz A (Classe LinearAlgebra - Método Gauss)");
        System.out.println("0.Resolver sistema da matriz A (Classe LinearAlgebra - Método Solve)");
        System.out.println();
        System.out.print("Sua resposta: ");
        respostaMenuMatriz= leitor.nextInt();
        System.out.println();

        menuRespostaMatriz();
        return respostaMenuMatriz;
    }

    public void menuRespostaMatriz() throws IOException {
        if(respostaMenuMatriz == 1) {
            System.out.println("================================= Método Get =================================");
            System.out.print("Digite o número da linha em que deseja receber o número: ");
            int linhas = leitor.nextInt();
            System.out.print("Digite o número da coluna em que deseja receber o número: ");
            int colunas = leitor.nextInt();
            Matriz.get(linhas,colunas);
        }

        if(respostaMenuMatriz == 2) {
            System.out.println("================================= Método Set =================================");
            System.out.print("Digite o número da linha que deseja trocar o número: ");
            int linhas = leitor.nextInt();
            System.out.print("Digite o número da coluna que deseja trocar o número: ");
            int colunas = leitor.nextInt();


            System.out.print("Digite o novo valor: ");
            int value = leitor.nextInt();


            Matriz.set(linhas,colunas,value);
        }

        if(respostaMenuMatriz == 3) {
            System.out.println("============================== Método Transpose ==============================");
            System.out.println("Resultado da matriz transposta:");
            LinearAlgebra.transpose(Matriz);
        }

        if(respostaMenuMatriz == 4) {
            System.out.println("=============================== Criar Matriz B ===============================");
            System.out.print("Digite o número de linhas da sua matriz: ");
            int linhas = leitor.nextInt();
            System.out.print("Digite o número de colunas da sua matriz: ");
            int colunas = leitor.nextInt();

            int[] elements = new int[linhas*colunas];

            System.out.println("Digite os elementos da matriz (um em cada linha):");
            for(int contador = 0; contador<linhas*colunas;contador++) {
                elements[contador] = (leitor.nextInt());
            }

            MatrizB = new Matrix(linhas,colunas,elements);
        }

        if(respostaMenuMatriz == 5) {
            System.out.println("================================= Método Sum =================================");
            System.out.println("Resultado da soma de matrizes:");
            LinearAlgebra.sum(Matriz, MatrizB);
        }

        if(respostaMenuMatriz == 6) {
            System.out.println("================================ Método Times ================================");
            System.out.print("Digite o número que multiplicará sua matriz:");
            int numero = leitor.nextInt();
            System.out.println("Resultado da multiplicação de um escalar por matriz:");
            LinearAlgebra.times(numero,Matriz);
        }

        if(respostaMenuMatriz == 7) {
            System.out.println("================================ Método Times ================================");
            System.out.println("Resultado da multiplicação da matrizA*MatrizB é:");
            LinearAlgebra.times(Matriz,MatrizB);
        }

        if(respostaMenuMatriz == 8) {
            System.out.println("================================= Método Dot =================================");
            System.out.println("Resultado da multiplicação de matrizes:");
            LinearAlgebra.dot(Matriz,MatrizB);
        }

        if(respostaMenuMatriz == 9) {
            System.out.println("================================ Método Gauss ================================");
            System.out.println("Resultado do escalonamento da matriz:");
            LinearAlgebra.gauss(Matriz);
        }

        if(respostaMenuMatriz == 0) {
            System.out.println("================================= Método Solve =================================");
            System.out.println("Resultado do sistema linear em forma de matriz:");
            LinearAlgebra.solve(Matriz);
        }

        System.in.read();
        menuMatriz();
    }
}