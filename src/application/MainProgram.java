package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.TaxPayer;

public class MainProgram {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Quantos contribuintes você vai digitar? ");
		int N = sc.nextInt();
		
		List<TaxPayer> listPayer = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			
			System.out.println();
			System.out.printf("Digite os dados do %do contribuinte:%n", i+1);
			System.out.print("Renda anual com salário: ");
			double salaryIncome = sc.nextDouble();
			System.out.print("Renda anual com prestação de serviço: ");
			double serviceIncome = sc.nextDouble();
			System.out.print("Renda anual com ganho de capital: ");
			double capitalIncome = sc.nextDouble();
			System.out.print("Gastos médicos: ");
			double healthSpending = sc.nextDouble();
			System.out.print("Gastos educacionais: ");
			double educationSpending = sc.nextDouble();
			TaxPayer taxpayer = new TaxPayer(salaryIncome, serviceIncome, capitalIncome, healthSpending, educationSpending);
			
			listPayer.add(taxpayer);
	
		}
		
		for (int i = 0; i < N; i++) {
			
			System.out.println();
			System.out.printf("Resumo do %do contribuinte: %n", i+1);
			System.out.printf("Imposto bruto total: %.2f%n", listPayer.get(i).grossTax());
			System.out.printf("Abatimeto: %.2f%n", listPayer.get(i).taxRebate());
			System.out.printf("Imposto devido: %.2f%n", listPayer.get(i).netTax());
			
			
		}
				
		sc.close();
	}

}
