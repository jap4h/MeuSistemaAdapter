import java.util.ArrayList;
import java.util.Scanner;

public class App {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<ContaBancaria> contas = new ArrayList<>();

    public static void main(String[] args) {

        int opcao;
        do {
            System.out.println("\n===== BANCO =====");
            System.out.println("1 - Criar Conta");
            System.out.println("2 - Depositar");
            System.out.println("3 - PIX");
            System.out.println("4 - Listar Contas");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();

            switch (opcao) {

                case 1:
                    criarConta();
                    break;

                case 2:
                    depositar();
                    break;

                case 3:
                    pix();
                    break;

                case 4:
                    listarContas();
                    break;

                case 0:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida.");

            }
        } while (opcao != 0);
    }

    static void criarConta() {

        sc.nextLine();
        System.out.print("Titular: ");
        String nome = sc.nextLine();
        ContaBancaria conta = new ContaBancaria(nome, 0);
        contas.add(conta);
        System.out.println("Conta criada!");
    }

    static void listarContas() {

        for (int cont = 0; cont < contas.size(); cont++) {

            ContaBancaria c = contas.get(cont);
            System.out.println(cont + " - " + c.getTitular() + " | Saldo: R$ " + c.getSaldo());
        }
    }

    static void depositar() {

        listarContas();
        System.out.print("Conta: ");
        int indice = sc.nextInt();
        System.out.print("Valor: ");
        double valor = sc.nextDouble();
        SistemaPagamento sistema = new ContaAdapter(contas.get(indice));
        sistema.realizarDeposito(valor);
    }

    static void pix() {
        listarContas();
        System.out.print("Conta origem: ");
        int origem = sc.nextInt();
        System.out.print("Conta destino: ");
        int destino = sc.nextInt();
        System.out.print("Valor: ");
        double valor = sc.nextDouble();
        SistemaPagamento sistema = new ContaAdapter(contas.get(origem));
        sistema.realizarPix(valor, contas.get(destino));

    }

}