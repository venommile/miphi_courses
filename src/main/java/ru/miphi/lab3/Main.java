package ru.miphi.lab3;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Employee> employeeList = Employee.createShortList();
        employeeList.forEach(Accountant::paySalary);
        employeeList.forEach(Accountant::payPremium);


    }
}
