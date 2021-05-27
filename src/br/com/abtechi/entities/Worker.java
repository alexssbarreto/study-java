package br.com.abtechi.entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.abtechi.entities.enums.WorkLevel;

public class Worker {
	
	private String name;
	private WorkLevel level;
	private Double baseSalary;

	private Departament departament;
	private List<HourContract> contracts = new ArrayList<HourContract>();
	
	public Worker () {
	}

	public Worker(String name, WorkLevel level, Double baseSalary, Departament departament) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.departament = departament;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkLevel getLevel() {
		return level;
	}

	public void setLevel(WorkLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Departament getDepartament() {
		return departament;
	}

	public void setDepartament(Departament departament) {
		this.departament = departament;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}
	
	public void addContract (HourContract contract) {
		this.contracts.add(contract);
	}
	
	public void removeContract (HourContract contract) {
		this.contracts.remove(contract);
	}
	
	public Double income (Integer year, Integer month) {
		Double sum = this.baseSalary;
		Calendar cal = Calendar.getInstance();
		
		for (HourContract contract : this.contracts) {
			cal.setTime(contract.getDate());
			int cYear = cal.get(Calendar.YEAR);
			int cMonth = 1 + cal.get(Calendar.MONTH);
						
			if (year == cYear && month == cMonth) {
				sum += contract.totalValue();
			}
		}
		
		return sum;
	}
}
