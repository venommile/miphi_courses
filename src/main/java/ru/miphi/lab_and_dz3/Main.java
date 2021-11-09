package ru.miphi.lab_and_dz3;

import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Consumer;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        List<Employee> employeeList = Employee.createShortList();
        Consumer<Employee> newYear = employee -> employee.setAge(employee.getAge() + 1);
        Consumer<Employee> wageIndexation = employee -> employee.setSalary(employee.getSalary() * 1.05);
        Function<Employee, String> ruPhoneParse = emloyee -> {
            String phone = emloyee.getPhone();
            if (phone.charAt(0) == '+') {
                return '8' + phone.substring(2);
            } else {
                return phone;
            }
        };

        employeeList.stream().map(ruPhoneParse).forEach(System.out::println);


        employeeList.stream().peek(employee -> System.out.println("before " + ":" + employee.getAge())).forEach(
                employee -> {
                    newYear.accept(employee);
                    System.out.println("after" + ":" + employee.getAge());
                }
        );
        employeeList.stream().peek(employee ->
                System.out.println("before " + ":" + employee.getSalary())).forEach(
                employee -> {
                    wageIndexation.accept(employee);
                    System.out.println("after" + ":" + employee.getSalary());
                }
        );
        System.out.println(employeeList);
        System.out.println(employeeList.stream().filter(employee -> employee.getRole().equals(Role.EXECUTIVE)).
                findFirst().orElseThrow(() -> new RuntimeException("No Executive!")));
        System.out.println(employeeList.stream().filter(employee -> employee.getAge() > 40).
                findFirst().orElseThrow(() -> new RuntimeException("No Executive!")));

        //lazy операции peek,filter,map,  же lazy?
        System.out.println(employeeList.stream().max(
                Comparator.comparingDouble(Employee::getSalary)
        ).orElseThrow(() -> new RuntimeException("No employees!")));
        System.out.println(employeeList.stream().max(
                Comparator.comparingDouble(Employee::getAge)
        ).orElseThrow(() -> new RuntimeException("No employees!")));

        System.out.println(employeeList.stream().min(
                Comparator.comparingDouble(Employee::getAge)
        ).orElseThrow(() -> new RuntimeException("No employees!")));

        double sumSalaries = employeeList.stream().mapToDouble(Employee::getSalary).sum();
        System.out.println(sumSalaries);

        System.out.println(employeeList.stream().filter(employee -> employee.getRole().equals(Role.STAFF))
                .mapToDouble(Employee::getSalary).sum());

        OptionalDouble averageAge = employeeList.stream().mapToInt(Employee::getAge).average(); //2й map,average
        Double middleAge = averageAge.orElseThrow(
                () -> new RuntimeException("No employees!")
        );
        System.out.println(middleAge);


        System.out.println(employeeList.stream().
                mapToDouble(Employee::getSalary).
                average().
                orElseThrow(
                        () -> new RuntimeException("No employees!")
                ));//average salary

    }
}
