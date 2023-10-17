import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        JCalcFunction resultadoDaFuncao = new JCalcFunction();

        Scanner input = new Scanner(System.in);
        int grau = 0;
        double a = 0f;
        double b = 0f;
        final int n = 10000000;

        System.out.println("Informe o grau da função:");
        grau = input.nextInt();
        System.out.println("Digite o valor do limite inferior:");
        a = input.nextDouble();
        System.out.println("Digite o valor do limite superior:");
        b = input.nextDouble();

        resultadoDaFuncao.storeCoefficients(grau);

        input.close();

        double deltax = 0f;
        deltax = ((b-a)/n);

        double somaQuadrado = 0f;
        double somaTrianguloRetangulo = 0f;
        double somaSemiCircunferencia = 0f;
        double somaTrianguloIsosceles = 0f;
        double somaHexagono = 0f;
        double somaElipse = 0f;
        double somaTrapezio = 0f;

        double resultadoQuadrado = 0f;
        double resultadoTrianguloRetangulo = 0f;
        double resultadoSemiCircunferencia = 0f;
        double resultadoTrianguloIsosceles = 0f;
        double resultadoHexagono = 0f;
        double resultadoElipse = 0f;
        double resultadoTrapezio = 0f;

        for(int i=1; i<n; i++){
            somaQuadrado = (deltax*resultadoDaFuncao.calcFunction(grau, (a+(i-1)*deltax)));
            resultadoQuadrado += somaQuadrado;

            somaTrianguloRetangulo = ((deltax/2)*((resultadoDaFuncao.calcFunction(grau, (a+(i*deltax)))-(resultadoDaFuncao.calcFunction(grau, (a+(i-1)*deltax))))));
            resultadoTrianguloRetangulo += somaTrianguloRetangulo;

            somaSemiCircunferencia = (Math.PI*((Math.pow(deltax, 2))/8));
            resultadoSemiCircunferencia += somaSemiCircunferencia;

            somaTrianguloIsosceles = ((deltax/2)*((resultadoDaFuncao.calcFunction(grau, (a+((i-1)*deltax)+(deltax/2))))-(resultadoDaFuncao.calcFunction(grau, (a+((i-1)*deltax))))));
            resultadoTrianguloIsosceles += somaTrianguloIsosceles;

            somaHexagono = (((resultadoDaFuncao.calcFunction(grau, (a+((i-1)*deltax)+(deltax/4))))-(resultadoDaFuncao.calcFunction(grau, (a+((i-1)*deltax)))))*((3*deltax)/4));
            resultadoHexagono += somaHexagono;

            somaElipse = (((resultadoDaFuncao.calcFunction(grau, (a+((i-1)*deltax)+(deltax/2))))-(resultadoDaFuncao.calcFunction(grau, (a+((i-1)*deltax)))))*(deltax/2)*Math.PI);
            resultadoElipse += somaElipse;

            somaTrapezio = ((deltax/4)*(((resultadoDaFuncao.calcFunction(grau, (a+((i-1)*deltax+(deltax/2)))))-(resultadoDaFuncao.calcFunction(grau, (a+((i-1)*deltax)))))*(deltax/2) + ((resultadoDaFuncao.calcFunction(grau, (a+((i-1)*deltax+(deltax/2)))))-(resultadoDaFuncao.calcFunction(grau, (a+((i-1)*deltax)))))));
            resultadoTrapezio += somaTrapezio;

        }

        //Lista com índice que armazena o resultado de cada método.
        List<Double> comparacao = new ArrayList<>();
        comparacao.add(0, resultadoQuadrado);
        comparacao.add(1, (resultadoQuadrado+resultadoTrianguloRetangulo));
        comparacao.add(2, (resultadoSemiCircunferencia));
        comparacao.add(3, (resultadoQuadrado+resultadoTrianguloIsosceles));
        comparacao.add(4, (resultadoQuadrado+resultadoHexagono));
        comparacao.add(5, (resultadoQuadrado+resultadoElipse));
        comparacao.add(6, (resultadoQuadrado+resultadoTrapezio));
        
        //Variável que retorna o maior valor da lista.
        double maiorValor = Collections.max(comparacao);
        
        //Verificando o melhor método a partir do índice da lista.
        int indiceMaior = -1;

        for(int i = 0; i < comparacao.size(); i++){
            if( (comparacao.get(i) == maiorValor) ){
                indiceMaior = i;
            }
        }
        if(indiceMaior == 0){
            System.out.println("O melhor método é o do Retângulo!");
        }else if(indiceMaior == 1){
            System.out.println("O melhor método é o do Triângulo Retângulo!");   
        }else if(indiceMaior == 2){
            System.out.println("O melhor método é o da Semi Circunferência!");
        }else if(indiceMaior == 3){
            System.out.println("O melhor método é o do Triângulo Isósceles!");
        }
        else if(indiceMaior == 4){
            System.out.println("O melhor método é o do Hexágono!");
        }
        else if(indiceMaior == 5){
            System.out.println("O melhor método é o da Semi Elipse!");
        }
        else if(indiceMaior == 6){
            System.out.println("O melhor método é o do Trapézio!");
        }
        System.out.println("Resultado: "+maiorValor);
    }
}
