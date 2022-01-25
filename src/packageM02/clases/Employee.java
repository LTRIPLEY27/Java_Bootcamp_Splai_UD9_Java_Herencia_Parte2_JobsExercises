package packageM02.clases;

import packageM02.Interfaces.Valida;

public class Employee implements Valida{
	private final double REDUCE = 0.15;//REDUCCION DEL 15% SOLO A EMPLEADOS
	protected String name;
	protected int pagas;
	protected double salary;
	protected double salaryTotal;//NETO MENSUAL
	protected double salaryYear;//NETO ANUAL
	protected double rawYearSalary;//BRUTO ANUAL
	protected double salaryPlusPlantilla;
	protected double plusSalaryByCategory;//SALARIO + PLUS SEG�N QU� CATEGORIA
	
	public Employee() {//POR DEFECTO
		this.name = "";
		this.salary = 0.0;
		this.salaryTotal = 0.0;
		this.salaryYear = 0.0;
		this.rawYearSalary = 0.0;
		this.salaryPlusPlantilla = 0.0;
		this.plusSalaryByCategory = 0.0;
	}
	
	public Employee(String name) {//CONSTRUCTOR DE 1 PAR�METRO PARA VOLUNTARY
		this.name = name;
	}

	public Employee(String name, double salary, int pagas) {//CONSTRUCTOR POR DEFECTO PARA LAS CLASES HEREDADAS
		this.name = name;
		this.salary = salary;
		this.pagas = pagas;
	}

	public int getPagas() {
		return pagas;
	}

	public void setPagas(int pagas) {
		this.pagas = pagas;
	}
	public double getPlusSalaryByCategory() {
		return plusSalaryByCategory;
	}
	
	public void setPlusSalaryByCategory(double salary, double reduce) {//M�TODO ASIGNA LA REDUCCION �NICAMENTE A LOS QUE SON "TRABAJADORES" RECIBE 2 PAR�METROS
		this.plusSalaryByCategory = this.salary - this.salary * reduce;
	}

	//SOBRECARGA DE M�TODOS
	public void setPlusSalaryByCategory(double category) {//M�TODO ASIGNA EL PLUS SEG�N LA CATEGORIA TRABAJADOR
		this.plusSalaryByCategory = this.salary + this.salary * category;
	}

	// LOS MODIFICADORES DE ACCESO AL SER DE UNA SUPERCLASE DEBEN DE INCIIALIZARSE PARA UE CADA CLASE QUE HEREDE ACTUALIZE SUS ATRIBUTOS
	public double getSalaryTotal() {
		return salaryTotal;
	}

	public void setSalaryTotal(double irpf) {// RECIBE 2 PAR�METROS = 1 PARA EQUIPARAR SALARIO Y EL OTRO SEG�N CADA IRPF U CATEGOR�A
		this.salaryTotal = this.plusSalaryByCategory - this.plusSalaryByCategory * irpf;
	}

	public double getSalaryYear() {
		return salaryYear;
	}

	public void setSalaryYear() {// SALARIO NETO CON IRPF ANUAL
		this.salaryYear = this.salaryTotal * this.pagas;
	}

	public double getRawYearSalary() {//SALARIO BRUTO (SIN IRPF)
		return rawYearSalary;
	}

	public void setRawYearSalary() {
		this.rawYearSalary = this.plusSalaryByCategory * this.pagas;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public double getSalaryPlusPlantilla() {
		return salaryPlusPlantilla;
	}

	public void setSalaryPlusPlantilla() {//SALARIO NETO + EL PLUS PLANTILLA DEFINIDO COMO UNA CONSTANTE DE LA INTERFACE (NO ES NECESARIO PERO ERA PARA EXPERIMENTAR)
		this.salaryPlusPlantilla = this.salaryYear + this.salaryYear * PLUS_PLANTILLA;
	}

	public String toString() {
		return "";
	}

	public void validaSueldo() throws Throwable {}//M�TODO QUE IMPLEMENTAR�N CADA CLASE HIJA SOBREESCRIBIENDO Y VALIDANDO SEG�N LA CATEGOR�A
}
