import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        MenuMatriz menuMatriz = new MenuMatriz();
        MenuVetores menuVetores = new MenuVetores();
        Scanner leitor = new Scanner(System.in);
        int respostaInicial = 0;

        System.out.println("Que tipo de representação você deseja utilizar?");
        System.out.println("1.Matrizes");
        System.out.println("2.Vetores");
        System.out.println();
        System.out.print("Sua resposta: ");
        respostaInicial= leitor.nextInt();
        System.out.println();

        if(respostaInicial == 1) {
            menuMatriz.menuCriarMatriz();
        }

        if(respostaInicial == 2) {
            menuVetores.menuCriarVetor();
        }
    }
}