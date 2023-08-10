package compras;

import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		Scanner leitura = new Scanner(System.in);

		CartaoDeCredito cartao = new CartaoDeCredito(2000);

		int sair = 1;
		while (sair != 0) {
			try {
				System.out.println("Digite o item da sua compra: ");
				String descricao = leitura.next().toUpperCase();
				
				System.out.println("Digite o valor da sua compra: ");
				double valor = leitura.nextDouble();

				Compra compra = new Compra(descricao, valor);
				boolean compraRealizada = cartao.lancaCompra(compra);

				if (compraRealizada) {
					System.out.println("\nCompra efetuada!\n");
					
					System.out.println("\n ******************\n");
					
					System.out.println("Digite 0 para sair ou 1 para continuar a sua compra: ");
					sair = leitura.nextInt();
				
				} else {
					System.out.println("Saldo insuficiente!");
					sair = 0;
				}
			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				System.out.println("Caractere inválido!");
				leitura.nextLine();

			}

			System.out.println("\n ******************\n");
		    System.out.println("COMPRA EFETUADA:");
			Collections.sort(cartao.getCompras());

			for (Compra c : cartao.getCompras()) {
				System.out.println( c.toString());

			}

			System.out.println("\n" + cartao.toString());
			
		
			

		}

	}
}
