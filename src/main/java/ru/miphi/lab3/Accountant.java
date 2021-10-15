package ru.miphi.lab3;

public class Accountant {
    public static void paySalary(Employee employee) {
        String sum = "";
        if (employee.role.equals(Employee.Role.EXECUTIVE)) {
            sum = "10000$";

        } else if (employee.role.equals(Employee.Role.MANAGER)) {
            sum = "2000$";
        } else if (employee.role.equals(Employee.Role.STAFF)) {
            sum = "300$";

        }
        System.out.println("Pay salary to " +
                employee.givenName + " " +
                employee.surName + " " +
                sum
        );
    }

    public static void payPremium(Employee employee) {
        int sum = 0;
        if (employee.role.equals(Employee.Role.EXECUTIVE)) {
            sum = 10000;
        } else if (employee.role.equals(Employee.Role.MANAGER)) {
            sum = 2000;
        } else if (employee.role.equals(Employee.Role.STAFF)) {
            sum = 300;
        }
        System.out.println("Pay" + " " +
                sum * (double) employee.role.getPercentPremium() / 100 +
                "$ " +
                "premium" + " to " +
                employee.givenName + " " +
                employee.surName
        );


    }
}
