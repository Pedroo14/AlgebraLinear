public class LinearAlgebra {
    public int[][] transpose(Matrix matriz) {
        int[][] transposta = new int[matriz.getMatriz()[0].length][matriz.getMatriz().length];

        for (int linha = 0; linha < transposta.length; linha++) {
            for (int coluna = 0; coluna < transposta[0].length; coluna++) {
                transposta[linha][coluna] = matriz.getMatriz()[coluna][linha];
            }
        }

        printMatriz(transposta);
        return transposta;
    }

    public int[][] transpose(Vector vetor) {
        int[][] transposta = new int[vetor.getVector()[0].length][vetor.getVector().length];

        for (int linha = 0; linha < transposta.length; linha++) {
            for (int coluna = 0; coluna < transposta[0].length; coluna++) {
                transposta[linha][coluna] = vetor.getVector()[coluna][linha];
            }
        }

        printMatriz(transposta);
        return transposta;
    }

    public int[][] sum(Matrix matrizA, Matrix matrizB) {
        int[][] soma = new int[matrizB.getMatriz().length][matrizB.getMatriz()[0].length];

        for (int linha = 0; linha < soma.length; linha++) {
            for (int coluna = 0; coluna < soma[0].length; coluna++) {
                soma[linha][coluna] = matrizA.getMatriz()[linha][coluna] + matrizB.getMatriz()[linha][coluna];
            }
        }

        printMatriz(soma);
        return soma;
    }

    public int[][] sum(Vector vetorA, Vector vetorB) {
        int[][] soma = new int[vetorB.getVector().length][vetorA.getVector()[0].length];

        for (int linha = 0; linha < soma.length; linha++) {
            for (int coluna = 0; coluna < soma[0].length; coluna++) {
                soma[linha][coluna] = vetorA.getVector()[linha][coluna] + vetorB.getVector()[linha][coluna];
            }
        }

        printMatriz(soma);
        return soma;
    }

    public int[][] times(int multiplicador, Matrix matriz) {
        int[][] mult = new int[matriz.getMatriz().length][matriz.getMatriz()[0].length];

        for (int linha = 0; linha < mult.length; linha++) {
            for (int coluna = 0; coluna < mult[0].length; coluna++) {
                mult[linha][coluna] = matriz.getMatriz()[linha][coluna] * multiplicador;
            }
        }

        printMatriz(mult);
        return mult;
    }

    public int[][] times(int multiplicador,Vector vetor) {
        int[][] mult = new int[vetor.getVector().length][vetor.getVector()[0].length];

        for (int linha = 0; linha < mult.length; linha++) {
            for (int coluna = 0; coluna < mult[0].length; coluna++) {
                mult[linha][coluna] = vetor.getVector()[linha][coluna] * multiplicador;
            }
        }

        printMatriz(mult);
        return mult;
    }

    public int[][] times(Matrix matrizA, Matrix matrizB) {
        int[][] mult = new int[matrizB.getMatriz().length][matrizB.getMatriz()[0].length];

        for (int linha = 0; linha < mult.length; linha++) {
            for (int coluna = 0; coluna < mult[0].length; coluna++) {
                mult[linha][coluna] = matrizA.getMatriz()[linha][coluna] * matrizB.getMatriz()[linha][coluna];
            }
        }

        printMatriz(mult);
        return mult;
    }

    public int[][] times(Vector vetorA, Vector vetorB) {
        int[][] mult = new int[vetorB.getVector().length][vetorA.getVector()[0].length];

        for (int linha = 0; linha < mult.length; linha++) {
            for (int coluna = 0; coluna < mult[0].length; coluna++) {
                mult[linha][coluna] = vetorA.getVector()[linha][coluna] + vetorB.getVector()[linha][coluna];
            }
        }

        printMatriz(mult);
        return mult;
    }

    public int[][] dot(Matrix matrizA, Matrix matrizB) {
        int[][] matrizAB = new int[matrizA.getMatriz().length][matrizB.getMatriz()[0].length];

        for(int i=0; i<matrizAB.length; i++){
            for(int j=0; j<matrizAB[i].length; j++){
                for(int k=0; k<matrizA.getMatriz()[i].length; k++){
                    matrizAB[i][j] += matrizA.getMatriz()[i][k] * matrizB.getMatriz()[k][j];
                }
            }
        }


        printMatriz(matrizAB);
        return matrizAB;
    }

    public double[][] gauss(Matrix matriz) {
        double[][] VMatriz = converterDouble(matriz.getMatriz());
        double VNumero;

        for(int i=0; i<=VMatriz.length-1; i++) {
            VNumero = VMatriz[i][i];

            for(int j=0;j<=VMatriz[0].length-1;j++) {
                VMatriz[i][j] = VMatriz[i][j]/VNumero;
            }

            if(i<=VMatriz.length-2) {
                for(int j=i+1; j<=VMatriz.length-1;j++) {
                    VNumero = VMatriz[j][i];
                    for(int k=0; k<=VMatriz[0].length-1;k++) {
                        VMatriz[j][k] = (VMatriz[j][k]-(VNumero*VMatriz[i][k]));
                    }
                }
            }
        }

        verificarSistema(VMatriz);
        return VMatriz;
    }

    public double[][] solve(Matrix matriz) {
        double[][] VMatriz = converterDouble(matriz.getMatriz());
        double VNumero;

        for(int i=0; i<=VMatriz.length-1; i++) {
            VNumero = VMatriz[i][i];

            for(int j=0;j<=VMatriz[0].length-1;j++) {
                VMatriz[i][j] = VMatriz[i][j]/VNumero;
            }

            if(i<=VMatriz.length-2) {
                for(int j=i+1; j<=VMatriz.length-1;j++) {
                    VNumero = VMatriz[j][i];
                    for(int k=0; k<=VMatriz[0].length-1;k++) {
                        VMatriz[j][k] = (VMatriz[j][k]-(VNumero*VMatriz[i][k]));
                    }
                }
            }
        }

        for(int i = VMatriz.length-1; i>=1;i--) {
            for(int j=i-1; j>=0;j--) {
                VNumero = VMatriz[j][i];
                for(int k= VMatriz[0].length-1;k>=0;k--) {
                    VMatriz[j][k] = (VMatriz[j][k]-(VNumero*VMatriz[i][k]));
                }
            }
        }

        verificarSistema(VMatriz);
        return VMatriz;
    }

    public double[][] converterDouble(int[][] matriz) {
        double[][] matrizDouble = new double[matriz.length][matriz[0].length];

        for(int contadorLinha = 0; contadorLinha< matriz.length;contadorLinha++){
            for(int contadorColuna = 0; contadorColuna<matriz[0].length;contadorColuna++) {
                matrizDouble[contadorLinha][contadorColuna] = (double) matriz[contadorLinha][contadorColuna];

            }
        }

        return matrizDouble;
    }

    public void printMatriz(double[][] matriz) {
        for (int contadorLinha = 0; contadorLinha < matriz.length; contadorLinha++) {
            for (int contadorColuna = 0; contadorColuna < matriz[contadorLinha].length; contadorColuna++) {
                System.out.print(matriz[contadorLinha][contadorColuna] + " ");
            }
            System.out.println();
        }
    }

    public void printMatriz(int[][] matriz) {
        for (int contadorLinha = 0; contadorLinha < matriz.length; contadorLinha++) {
            for (int contadorColuna = 0; contadorColuna < matriz[contadorLinha].length; contadorColuna++) {
                System.out.print(matriz[contadorLinha][contadorColuna] + " ");
            }
            System.out.println();
        }
    }

    public void verificarSistema(double[][] matriz) {
        double NaN = 2.1 % 0;
        boolean verif = true;

        for (int contadorLinha = 0; contadorLinha < matriz.length; contadorLinha++) {
            for (int contadorColuna = 0; contadorColuna < matriz[contadorLinha].length; contadorColuna++) {
                if(Double.isNaN(matriz[contadorLinha][contadorColuna])) verif = false;
            }
        }

        if(verif == true) printMatriz(matriz);
        if(verif == false) System.out.println("Sistema possivel indeterminado ou impossivel");
    }
}