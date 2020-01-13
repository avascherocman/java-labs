public class AbstractEmployeeTester {
    public static void main(String args[]){
        //initialize array of employees
        Object employees[] = new Object[5];
        employees[0] = new FullTimeEmployee("Ava Scherocman",12.00, 42, 1000);
        employees[1] = new FullTimeEmployee("Jack Margeson", 14.50, 38, 1001);
        employees[2] = new FullTimeEmployee("Landon Holland", 11.50, 40, 1002);
        employees[3] = new PartTimeEmployee("Chris Lee", 10.50, 16, 1003);
        employees[4] = new PartTimeEmployee("Gregg Kummer", 11.50, 22, 1004);

        //loop through array of employees
        Double ptTotal=0.0;
        Double ftTotal=0.0;
        Double totalPaid=0.0;

        for (Object emp : employees) {
            //print information about each employee
            System.out.println(emp);
            //check which kind of employee and output
            if (emp instanceof PartTimeEmployee){
                System.out.println("Part Time\n");
                PartTimeEmployee e = (PartTimeEmployee)emp;
                ptTotal += e.getPay();
                totalPaid+=e.getPay();

            } else if (emp instanceof FullTimeEmployee){
                System.out.println("Full Time\n");
                FullTimeEmployee e = (FullTimeEmployee) emp;
                ftTotal += e.getPay();
                totalPaid+=e.getPay();
            }
        }

        //output total payments to employees based on type and total
    System.out.println("Total paid to part time employees: $" + ptTotal);
        System.out.println("Total paid to full time employees: $" + ftTotal);
    System.out.println("Total paid to all employees: $" + totalPaid);



    }
}
