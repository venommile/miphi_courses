package ru.miphi.lab_and_dz3;

public class Accountant {
    public static void paySalary(Employee employee) {
        String sum = "";
        sum = employee.getSalary().toString() +"$";
        System.out.println("Pay salary to " +
                employee.getGivenName() + " " +
                employee.getSurName() + " " +
                sum
        );
    }

    public static void payPremium(Employee employee) {
        double sum = 0;
        sum = employee.getSalary();
        System.out.println("Pay" + " " +
                sum * (double) employee.getRole().getPercentPremium() / 100 +
                "$ " +
                "premium" + " to " +
                employee.getSurName() + " " +
                employee.getSurName()
        );


    }
}
