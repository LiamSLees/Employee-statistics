import java.util.Scanner;

public class Main {

    public static class Employee {
        private String name;
        private int employeeID;
        private String position;
        private double salary;

        public Employee(String name, int employeeID, String position, double salary) {
            this.name = name;
            this.employeeID = employeeID;
            this.position = position;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getEmployeeID() {
            return employeeID;
        }

        public void setEmployeeID(int employeeID) {
            this.employeeID = employeeID;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        public void displayEmployeeInfo() {
            System.out.printf("Name: %s, Employee ID: %d, Position: %s, Salary: $%.2f%n",
                    name, employeeID, position, salary);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int empcount = 10;
        Employee[] employees = new Employee[empcount];


        for (int i = 0; i < empcount; i++) {
            System.out.println("Enter details for employee " + (i + 1) + ":");

            System.out.print("Name: ");
            String name = scanner.nextLine();

            int employeeID = i + 1;

            System.out.print("Position: ");
            String position = scanner.nextLine();

            System.out.print("Salary: ");
            double salary = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            employees[i] = new Employee(name, employeeID, position, salary);
        }



        for (int i = 0; i < empcount; i++) {
            employees[i].displayEmployeeInfo();
        }



        double totalSalary = 0;
        double maxSalary = Double.MIN_VALUE;
        double minSalary = Double.MAX_VALUE;

        for (int i = 0; i < empcount; i++) {
            double salary = employees[i].getSalary();
            totalSalary += salary;
            if (salary > maxSalary) {
                maxSalary = salary;
            }
            if (salary < minSalary) {
                minSalary = salary;
            }
        }

        double averageSalary = totalSalary / empcount;


        System.out.printf("%nTotal Salary: $%,.2f%n", totalSalary);
        System.out.printf("Average Salary: $%,.2f%n", averageSalary);
        System.out.printf("Salary Range: $%,.2f - $%,.2f%n", minSalary, maxSalary);

        scanner.close();
    }
}
