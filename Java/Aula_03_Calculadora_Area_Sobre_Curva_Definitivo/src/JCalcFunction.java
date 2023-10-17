import java.util.Scanner;

public class JCalcFunction {
    
    public int grau = 0;
    public double[] coefficients = new double[grau];
    public double c = 0f;
    public final double erro = 0.0001;
    
    public void storeCoefficients(int grau){
        Scanner input = new Scanner(System.in);
        this.coefficients = new double[grau];

        for(int i=0; i<grau; i++){
            System.out.println("Digite o valor do "+(i+1)+"° coeficiente:");
            coefficients[i] = input.nextDouble();
        }
        
        System.out.println("Digite o valor do coeficiente sem incógnita:");
        c = input.nextDouble();

        input.close();
    }
    
    public double calcFunction(int grau, double x){
        double resultado = 0f;

        for(int i=grau; i>0; i--){
            resultado += (coefficients[((i-grau)*(-1))]*Math.pow(x, i));
        }

        resultado += c;

        return resultado;
    }
    
}
