package application;

import entities.Cliente;
import entities.Conta;

import java.util.*;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Cliente> list = new ArrayList<>();

        Cliente c1 = new Cliente("Jurandir", "rua das flores,321", "jurandir@gmail.com", "12312345645", new Conta(123, 500, 1000));
        Cliente c2 = new Cliente("Maria", "rua das aves,789", "maria@gmail.com", "32132165465", new Conta(321, 700, 1500));
        list.add(c1);
        list.add(c2);

        System.out.print("Digite seu CPF:");
        String cpfVerificar = sc.next();

        Optional<Cliente> clienteTitular = list.stream()
                .filter(cliente -> cliente.getCpf().equals(cpfVerificar))
                .findFirst();

        if (clienteTitular.isPresent()) {
            System.out.println("Bem Vindo, " + clienteTitular.get().getNome());

            System.out.println("Quanto vc deseja depositar ?");
            double valorDeposito = sc.nextDouble();
            Cliente cliente = clienteTitular.get();
            Conta conta = cliente.getConta();
            conta.depositar(valorDeposito);
            System.out.println("Deposito realizado no valor de R$" + valorDeposito +
                    "\nSaldo atual: R$" + conta.getSaldo());

            System.out.println("Quanto vc gostaria de sacar ?");
            double valorsacar = sc.nextDouble();
            cliente = clienteTitular.get();
            conta = cliente.getConta();
            conta.saca(valorsacar);
            System.out.println("Saque realizado no valor de R$" + valorsacar +
                    "\nSaldo atual: R$" + conta.getSaldo());

            char confirma = 0;
            while (confirma !='y') {
                System.out.println("Para Transferencia, digite o CPF da conta de Destino:");
                String cpfDestino = sc.next();

                Optional<Cliente> clienteDestino = list.stream()
                        .filter(x -> x.getCpf().equals(cpfDestino))
                        .findFirst();

                System.out.println("Confirme os dados da transferencia: " +
                        "\nDestinatario(a): " + clienteDestino.get().getNome() +
                        "\nCPF: " + clienteDestino.get().getCpf() +
                        "\nConta: " + clienteDestino.get().getConta().getNumero());

                System.out.println("\nDestinatario esta correto? (y/n)");
                confirma = sc.next().charAt(0);

                System.out.println("Digite o valor a ser transferido:");
                double valorTransferencia = sc.nextDouble();

                if (clienteDestino.isPresent()) {
                    clienteTitular.get().getConta();
                    conta.transfere(clienteDestino.get().getConta(), valorTransferencia);
                    System.out.println("Transferencia de R$ " + valorTransferencia + " realizada com sucesso!");
                }
            }
        } else {
            System.out.println("CPF nao cadastrado");
        }

        for(Cliente cliente: list){
            System.out.println(cliente.getConta().getSaldo());
        }
    }
}




