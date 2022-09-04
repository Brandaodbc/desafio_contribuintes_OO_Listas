package entities;

public class TaxPayer {

	private double salaryIncome;
	private double serviceIncome;
	private double capitalIncome;
	private double healthSpending;
	private double educationSpending;
	
	public TaxPayer() {
	}

	public TaxPayer(double salaryIncome, double serviceIncome, double capitalIncome, double healthSpending,
			double educationSpending) {
		this.salaryIncome = salaryIncome;
		this.serviceIncome = serviceIncome;
		this.capitalIncome = capitalIncome;
		this.healthSpending = healthSpending;
		this.educationSpending = educationSpending;
	}

	
	
	public double getSalaryIncome() {
		return salaryIncome;
	}

	public void setSalaryIncome(double salaryIncome) {
		this.salaryIncome = salaryIncome;
	}

	public double getServiceIncome() {
		return serviceIncome;
	}

	public void setServiceIncome(double serviceIncome) {
		this.serviceIncome = serviceIncome;
	}

	public double getCapitalIncome() {
		return capitalIncome;
	}

	public void setCapitalIncome(double capitalIncome) {
		this.capitalIncome = capitalIncome;
	}

	public double getHealthSpending() {
		return healthSpending;
	}

	public void setHealthSpending(double healthSpending) {
		this.healthSpending = healthSpending;
	}

	public double getEducationSpending() {
		return educationSpending;
	}

	public void setEducationSpending(double educationSpending) {
		this.educationSpending = educationSpending;
	}

	public double salaryTax() {
		double salaryMonth = salaryIncome / 12.0;
		double taxValue = 0.0;
		
		
		if (salaryMonth < 3000.0) {
			taxValue  = 0.0;
		}
		else if (salaryMonth < 5000.0) {
			taxValue = salaryMonth * 0.10;
		}
		else {
			taxValue = salaryMonth * 0.20;
		}
		
		return taxValue * 12;
	}
	
	public double servicesTax() {
		double taxService = 0.0;
		
		if (serviceIncome > 0.0) {
			taxService = serviceIncome * 0.15;
		}
		else {
			taxService = 0.0;
		}
		return taxService;
	}
	
	public double capitalTax() {
		double taxCapital = 0.0;
		
		if (capitalIncome > 0.0) {
			taxCapital = capitalIncome * 0.20;
		}
		else {
			taxCapital = 0.0;
		}
		return taxCapital;
	}
	
	public double grossTax() {
		return salaryTax() + servicesTax() + capitalTax();
	}
	
	public double taxRebate() {
		double thirtyOfGross = grossTax() * 0.30;
		double healthAndEduc = healthSpending + educationSpending;
		double rebateTax = 0.0;
		
		if (healthAndEduc < thirtyOfGross) {
			rebateTax = healthAndEduc;
		}
		else {
			rebateTax = thirtyOfGross;
		}
		
		return rebateTax;
	}
	
	public double netTax() {
		return grossTax() - taxRebate();
	}
		
}
