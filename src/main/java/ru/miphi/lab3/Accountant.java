package ru.miphi.lab3;

public class Accountant {
    public static void paySalary(Employee employee) {
        String sum = "";
        switch (employee.role.toString()) {
            case "EXECUTIVE":
                sum = "10000$";

                break;
            case "MANAGER":
                sum = "2000$";
                break;
            case "STAFF":
                sum = "300$";

                break;
        }
        System.out.println("Pay salary to " +
                employee.givenName + " " +
                employee.surName + " " +
                sum
        );
    }

    public static void payPremium(Employee employee) {
        int sum = 0;
        switch (employee.role.toString()) {
            case "EXECUTIVE":
                sum = 10000;

                break;
            case "MANAGER":
                sum = 2000;
                break;
            case "STAFF":
                sum = 300;

                break;
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
