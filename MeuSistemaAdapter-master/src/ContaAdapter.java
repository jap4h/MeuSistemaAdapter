public class ContaAdapter implements SistemaPagamento {

    private ContaBancaria conta;

    public ContaAdapter(ContaBancaria conta) {
        this.conta = conta;
    }

    @Override
    public void realizarDeposito(double valor) {
        conta.depositar(valor);
    }

    @Override
    public void realizarPix(double valor, ContaBancaria destino) {

        if (conta.getSaldo() >= valor) {

            conta.sacar(valor);
            destino.depositar(valor);
            System.out.println("PIX realizado com sucesso.");
        } else {

            System.out.println("Saldo insuficiente.");
        }
    }
}