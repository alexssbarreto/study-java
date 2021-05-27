package br.com.abtechi.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import br.com.abtechi.entities.Departament;
import br.com.abtechi.entities.HourContract;
import br.com.abtechi.entities.Worker;
import br.com.abtechi.entities.enums.WorkLevel;

public class ProgramIncome {

	public static void main(String[] args) throws ParseException {
		Scanner scanner = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Entre com o nome do departamento: ");
		String departament = scanner.nextLine();
		
		System.out.println("Dados do empregado:");
		System.out.print("Nome:");
		String workName = scanner.nextLine();
		System.out.print("Nível:");
		String workLevel = scanner.nextLine();
		System.out.print("Base salarial:");
		Double baseSalary = scanner.nextDouble();
				
		Worker worker = new Worker(workName, WorkLevel.valueOf(workLevel), baseSalary, new Departament(departament));
		
		System.out.println("Quantos contratos o funcionário terá?");
		int n = scanner.nextInt();
		
		for (int i = 1; i <= n; i++) {
			System.out.println("Entre com os dados do contrato #" + i);
			System.out.print("Data (DD/MM/YYYY): ");
			
			Date contractDate = sdf.parse(scanner.next());
			
			System.out.print("Valor por hora: ");
			Double valuePerHour = scanner.nextDouble();
			
			System.out.print("Duração (hours): ");
			Integer hours = scanner.nextInt();
			
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			worker.addContract(contract);
		}
		
		System.out.println();
		System.out.println("Informe o mês e o ano para cálculo do valor (MM/YYYY):");
		
		String periodo = scanner.next();
		
		Integer month = Integer.parseInt(periodo.substring(0, 2));
		Integer year = Integer.parseInt(periodo.substring(3));
		
		System.out.println("Nome: " + worker.getName());
		System.out.println("Departamento: " + worker.getDepartament().getName());
		System.out.println("Salário: " + periodo + ": " + String.format("%.2f", worker.income(year, month)));
		
		scanner.close();
	}

}
