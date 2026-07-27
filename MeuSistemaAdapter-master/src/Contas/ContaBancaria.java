package Contas;

import java.math.BigDecimal;
import java.math.BigInteger;

public class ContaBancaria {
    private String titular;
    private BigInteger numeroConta;
    private BigDecimal saldo = new BigDecimal(0);

    public ContaBancaria(String titular , BigInteger numeroConta ){
        setTitular(titular);
        setNumeroConta(numeroConta);   
        setSaldo(saldo);
    }

    public void depositar(BigDecimal valor){
        this.saldo = this.saldo.add(valor);
    }   

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public BigInteger getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(BigInteger numeroConta) {
        this.numeroConta = numeroConta;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
    
}