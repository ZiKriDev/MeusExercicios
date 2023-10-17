/* 
 * Sistema que deposita e verifica saldo de uma conta
 * bancária. 
*/

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        //Verificação do saldo atual e instanciação do objeto conta.
        System.out.println("=======================================");
        System.out.println("Olá usuário!");
        Operacoes conta = new Operacoes();
        double saldoDaConta = 30;

        //Pegando último valor salvo no banco de dados de operações que o cliente já executou.
        conta.setSaldo(saldoDaConta);

        int receberOperacao = 0;
        double valorDepositado=0;

        Scanner input = new Scanner(System.in);

        //Informando ao usuário o saldo atual e qual operação deve ser realizada.
        System.out.println("Saldo atual -> "+saldoDaConta);
        System.out.printf("Digite 1 para depositar.\nDigite 2 para verificar o seu saldo atual.\nDigite 3 para cancelar a operação.\n");
        receberOperacao = input.nextInt();

        if(receberOperacao == 1){
            
            //Atribuindo o valor depositado ao saldo e informando ao usuário o atual saldo.
            System.out.println("Informe o valor a ser depositado:");
            valorDepositado = input.nextDouble();
            conta.depositarValor(valorDepositado);
            System.out.println("Valor depositado com sucesso!");
            System.out.println("Saldo atual:");
            conta.verificarSaldo();

        }else if(receberOperacao == 2){
            conta.verificarSaldo();

        }else if(receberOperacao == 3){
            System.out.println("Operação encerrada. Banco do ZiKril, " 
            +"sempre lucrando em cima de você!");
        }

        input.close();
    }
}
