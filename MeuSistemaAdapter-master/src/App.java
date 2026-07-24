
import Contas.ContaBancaria;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class App{
    static Scanner sc = new Scanner(System.in);
    static ArrayList<ContaBancaria> contas = new ArrayList<>();

    // Cadastrar conta
    public static  void cadastroConta(){
        System.out.println("Digite o nome do titular: ");
        String nomeTitular = sc.nextLine();
        System.out.println("Digite o numero da conta: ");
        BigInteger numeroConta = sc.nextBigInteger();
        sc.nextLine();
        ContaBancaria criaConta = new ContaBancaria(nomeTitular, numeroConta);
        contas.add(criaConta); 
    }

    public static  void depositar(){
        System.out.println("Digite o valor do deposito: ");
        double valor = sc.nextDouble();
        System.out.println("Digite o numero da conta sua conta: ");
        BigInteger numConta = sc.nextBigInteger();
        sc.nextLine();
       Adapters.adapterDeposito(numConta , valor);
    }

    public static  void enviarPIX(){
        System.out.println("Digite o numero da sua conta: ");
        BigInteger numConta = sc.nextBigInteger();
        sc.nextLine();
        for(ContaBancaria c : contas ){
            if(c.getNumeroConta().equals(numConta)){
                System.out.println("Numero da conta de envio do pix: ");
                BigInteger numContaEnvio = sc.nextBigInteger();
                sc.nextLine();
                for(ContaBancaria cc : contas){
                    if(cc.getNumeroConta().equals(numContaEnvio)){
                        System.out.println("Digite o valor do pix: ");
                        double valorEnvio = sc.nextDouble();
                        Adapters.adapterEnvioPIX(c, cc, valorEnvio);
                    }
                }
            }
        }
    }

    public static void Menu(){
        int pergunta = -1;
        while(pergunta != 0 ){
            System.out.println("Menu: \n 1 - Cadastrar conta \n2 - Depositar \n 3 - Enviar PIX \n4 - Mostra conta\n 0 - Sair");
            pergunta = sc.nextInt();
            sc.nextLine();
            switch(pergunta){
                case 0 :
                    System.out.println("Encerrando...");

                case 1 :
                    cadastroConta();
                    break;

                case 2 :
                    depositar();
                    break;

                case 3:
                    enviarPIX();
                    break;

                case 4:
                    System.out.println("Digite o numero da sua conta: ");
                    BigInteger numConta = sc.nextBigInteger();
                    for(ContaBancaria c : contas){
                        if(c.getNumeroConta().equals(numConta)){
                            System.out.println("Titular " + c.getTitular() + "\nNumero da conta " + c.getNumeroConta() + "\nSaldo " + c.getSaldo());
                        }
                    }
                    break;
            }
        }
    }

    public static void main(String[] args) {
        Menu();
    }

}
