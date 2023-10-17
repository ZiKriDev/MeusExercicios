/*
 * Autor: Cláudio Zicri
 * Questão 8 Lista Fluxogramas
 */

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("INÍCIO!");

        Scanner input = new Scanner(System.in);
        int a,b,c = 0;
        double delta = 0.0;

        System.out.println("Informe o valor de A:");
        a = input.nextInt();

        System.out.println("Informe o valor de B:");
        b = input.nextInt();

        System.out.println("Informe o valor de C:");
        c = input.nextInt();

        if( (a == 0) && (b == 0) && (c == 0) ){
            System.out.println("Encerrando o programa...");
        }else{
            while( (a != 0) && (b != 0) && (c != 0) ){           
                delta = (Math.pow(b, 2))-4*a*c;
                
                if(delta < 0){
                System.out.println("Não existe raiz real!");
                }else{
                    double x1,x2=0.0;
                    x1 = (-b + Math.sqrt(delta))/(2*a);
                    x2 = (-b - Math.sqrt(delta))/(2*a);
                    System.out.printf("Valor das raízes: x1 = %.2f | x2 = %.2f%n",x1,x2);
                
                    if( (x1 > 5) && (x2 > 5) ){
                        double s1=0;
                        s1 = x1+x2;
                        System.out.println("Soma das raízes: "+s1);
                
                    }else if( (x1 < 2) && (x2 < 2) ){
                        double p1=0;
                        p1 = x1*x2;
                        System.out.println("Produto das raízes: "+p1);
                    }
                    System.out.println("Informe o valor de A:");
                    a = input.nextInt();

                    System.out.println("Informe o valor de B:");
                    b = input.nextInt();    
                    
                    System.out.println("Informe o valor de C:");
                    c = input.nextInt();
                }
            }
            System.out.println("Encerrando o programa...");
        }
        
        System.out.println("FIM!");
        input.close();
    }
}
