public class Operacoes extends App{
    private Double saldo;

    public void setSaldo(Double saldo){
        this.saldo = saldo;
    }

    public Double getSaldo(){
        return saldo;
    }

    public void depositarValor(Double valor){
        saldo += valor;
    }

    public void verificarSaldo(){
        System.out.println("Valor do saldo: "+getSaldo());
    }
}
