
import Contas.ContaBancaria;
import java.math.BigDecimal;
import java.math.BigInteger;

public class Adapters {
    public static  void adapterDeposito(BigInteger numConta , double valorDeposito){
        BigDecimal valor = BigDecimal.valueOf(valorDeposito);
        for(ContaBancaria c : App.contas){
            if(c.getNumeroConta().equals(numConta)){
                c.depositar(valor);
            }
        }
    }

    public static void adapterEnvioPIX(ContaBancaria envio , ContaBancaria recebimento , double valor){
        BigDecimal valorPIX = BigDecimal.valueOf(valor);
        BigDecimal novoSaldo = envio.getSaldo().subtract(valorPIX);
        envio.setSaldo(novoSaldo);
        recebimento.depositar(valorPIX);
    }
}
