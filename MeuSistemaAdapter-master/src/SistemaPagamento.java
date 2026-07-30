public interface SistemaPagamento {

    void realizarDeposito(double valor);
    void realizarPix(double valor, ContaBancaria destino);
}
