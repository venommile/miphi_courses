package ru.miphi.lab_and_dz3;

public class Accountant {
    public static void paySalary(Employee employee) {
        String sum = "";
        if (employee.getRole().equals(Role.EXECUTIVE)) {
            sum = "10000$";

        } else if (employee.getRole().equals(Role.MANAGER)) {
            sum = "2000$";
        } else if (employee.getRole().equals(Role.STAFF)) {
            sum = "300$";

        }
        System.out.println("Pay salary to " +
                employee.getGivenName() + " " +
                employee.getSurName() + " " +
                sum
        );
    }

    public static void payPremium(Employee employee) {
        int sum = 0;
        if (employee.getRole().equals(Role.EXECUTIVE)) {
            sum = 10000;
        } else if (employee.getRole().equals(Role.MANAGER)) {
            sum = 2000;
        } else if (employee.getRole().equals(Role.STAFF)) {
            sum = 300;
        }
        System.out.println("Pay" + " " +
                sum * (double) employee.getRole().getPercentPremium() / 100 +
                "$ " +
                "premium" + " to " +
                employee.getSurName() + " " +
                employee.getSurName()
        );


    }
}
