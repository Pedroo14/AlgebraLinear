import java.io.IOException;
import java.util.Scanner;

public class MenuVetores {
    Scanner leitor = new Scanner(System.in);
    Vector Vetor;
    Vector VetorB;
    LinearAlgebra LinearAlgebra;
    int respostaMenuVetor;

    public Vector menuCriarVetor() throws IOException {
        System.out.println();
        System.out.println("=============================== Criar Vetor A ================================");
        System.out.print("Digite a dimensão do seu vetor: ");
        int colunas = leitor.nextInt();

        int elements[] = new int[colunas];

        System.out.println("Digite os elementos do seu vetor (um em cada linha):");
        for(int contador = 0; contador<colunas;contador++) {
            elements[contador] = (leitor.nextInt());
        }

        Vetor = new Vector(colunas,elements);
        LinearAlgebra = new LinearAlgebra();

        System.in.read();
        menuVetor();

        return Vetor;
    }

    public int menuVetor() throws IOException {
        System.out.println("================================ Menu Inicial ================================");
        System.out.println("Para continuar, escolha o próximo passo:");
        System.out.println("1.Conferir algum elemento do vetor A (Classe Vector - Método Get)");
        System.out.println("2.Alterar o valor de algum elemento do vetor A (Classe Vector - Método Set)");
        System.out.println("3.Transpor seu vetor A (Classe LinearAlgebra - Método Transpose)");
        System.out.println("4.Criar vetor B (Necessário para opções 5 a 7");
        System.out.println("5.Somar vetor A e B (Classe LinearAlgebra - Método Sum)");
        System.out.println("6.Multiplicar vetor A por número (Classe LinearAlgebra - Método Times)");
        System.out.println("7. Multiplicar vetor A por vetor B - Elemento por elemento(Classe LinearAlgebra - Metodo Times)");
        System.out.println();
        System.out.print("Sua resposta: ");
        respostaMenuVetor = leitor.nextInt();
        System.out.println();

        menuRespostaVetor();
        return respostaMenuVetor;
    }

    public void menuRespostaVetor() throws IOException {
        if(respostaMenuVetor == 1) {
            System.out.println("================================= Método Get =================================");
            System.out.print("Digite o número da linha em que deseja receber o número: ");
            int linhas = leitor.nextInt();
            System.out.print("Digite o número da coluna em que deseja receber o número: ");
            int colunas = leitor.nextInt();
            Vetor.get(colunas);
        }

        if(respostaMenuVetor == 2) {
            System.out.println("================================= Método Set =================================");
            System.out.print("Digite o número da coluna que deseja trocar o número: ");
            int colunas = leitor.nextInt();

            System.out.print("Digite o novo valor: ");
            int value = leitor.nextInt();

            Vetor.set(colunas,value);
        }

        if(respostaMenuVetor == 3) {
            System.out.println("============================== Método Transpose ==============================");
            System.out.println("Resultado da matriz transposta:");
            LinearAlgebra.transpose(Vetor);
        }

        if(respostaMenuVetor == 4) {
            System.out.println("=============================== Criar Vetor B ================================");
            System.out.print("Digite a dimensão do seu vetor: ");
            int colunas = leitor.nextInt();

            int elements[] = new int[colunas];

            System.out.println("Digite os elementos do seu vetor (um em cada linha):");
            for(int contador = 0; contador<colunas;contador++) {
                elements[contador] = (leitor.nextInt());
            }

            VetorB = new Vector(colunas,elements);
        }

        if(respostaMenuVetor == 5) {
            System.out.println("================================= Método Sum =================================");
            System.out.println("Resultado da soma de vetores:");
            LinearAlgebra.sum(Vetor, VetorB);
        }

        if(respostaMenuVetor == 6) {
            System.out.println("================================ Método Times ================================");
            System.out.print("Digite o número que multiplicará seu vetor:");
            int numero = leitor.nextInt();
            System.out.println("Resultado da multiplicação de um escalar por vetor:");
            LinearAlgebra.times(numero,Vetor);
        }

        if(respostaMenuVetor == 7) {
            System.out.println("================================ Método Times ================================");
            System.out.println("Resultado da multiplicação vetorA*vetorB é:");
            LinearAlgebra.times(Vetor,VetorB);
        }

        System.in.read();
        menuVetor();
    }
}