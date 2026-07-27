import Contas.ContaBancaria;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

public class Adapters {
    private static ArrayList<ContaBancaria> contas = new ArrayList<>(App.contas);

    static void adapterDeposito(BigInteger numConta , double valorDeposito){
        BigDecimal valor = BigDecimal.valueOf(valorDeposito);
        for(ContaBancaria c : contas){
            if(c.getNumeroConta().equals(numConta)){
                c.depositar(valor);
            }
        }
    }

    static void adapterEnvioPIX(ContaBancaria envio , ContaBancaria recebimento , double valor){
        BigDecimal valorPIX = BigDecimal.valueOf(valor);
        BigDecimal novoSaldo = envio.getSaldo().subtract(valorPIX);
        envio.setSaldo(novoSaldo);
        recebimento.depositar(valorPIX);
    }

}