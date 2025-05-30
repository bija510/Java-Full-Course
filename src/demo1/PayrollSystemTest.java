package com.demo1;

//Employee hierarchy test program.
public class PayrollSystemTest {
	public static void main(String[] args) {
		// create subclass objects
		SalariedEmployee salariedEmployee = new SalariedEmployee("John", "Smith", "111-11-1111", 800.00);
		HourlyEmployee hourlyEmployee = new HourlyEmployee("Karen", "Price", "222-22-2222", 16.75, 40);
		CommissionEmployee commissionEmployee = new CommissionEmployee("Sue", "Jones", "333-33-3333", 10000, 0.06);
		BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee("Bob", "Lewis","444-44-4444", 5000, 0.04, 300);
		TemporaryPieceWorker tempWorker = new TemporaryPieceWorker("Alexandar", "Lee", "123-44-6466", 6.1, 200);

		// create array
		Employee[] employees = new Employee[5];

		// initialize array
		employees[0] = salariedEmployee;
		employees[1] = hourlyEmployee;
		employees[2] = commissionEmployee;
		employees[3] = basePlusCommissionEmployee;
		employees[4] = tempWorker;

		System.out.println("Employees processed polymorphically:\n");

		for (Employee currentEmployee : employees) {
			System.out.println(currentEmployee); // invokes toString
			if (currentEmployee instanceof BasePlusCommissionEmployee) {
				BasePlusCommissionEmployee employee = (BasePlusCommissionEmployee) currentEmployee;
				employee.setBaseSalary(1.10 * employee.getBaseSalary());
				System.out.printf("new base salary with 10%% increase is: %.2f%n", employee.getBaseSalary());
			}
			System.out.printf("earned: %.2f%n%n", currentEmployee.earnings());
		}

		// get type name of each object
		for (int j = 0; j < employees.length; j++) {
			System.out.printf("Employee %d is a %s%n", j, employees[j].getClass().getName());
		}
	}
}
