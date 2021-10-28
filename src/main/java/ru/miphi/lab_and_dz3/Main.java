package ru.miphi.lab_and_dz3;

import java.util.ArrayList;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        ArrayList<Employee> employeeList = Employee.createShortList();


        employeeList.stream().filter(p -> p.getGender().equals(Gender.FEMALE)).forEach(Accountant::payPremium);

        employeeList.stream().filter(p -> p.getDept().equals("finance")).forEach(Accountant::paySalary);

        employeeList.stream().filter(p -> p.getDept().equals("finance")).filter(p -> p.getAge() > 30).forEach(Accountant::payPremium);

        employeeList.stream().filter(p -> p.getRole().equals(Role.MANAGER)).forEach(Accountant::paySalary);

        employeeList.stream().filter(p -> p.getRole().equals(Role.STAFF)).forEach(Accountant::paySalary);

        Consumer<Employee> shortInfo =
                p -> System.out.println("{ "
                        + p.getGivenName() + "| "
                        + p.getSurName() + "| "
                        + p.getDept() + "| "
                        + p.getRole().toString() + "| "
                        + p.getAge().toString()
                        + " }");
        employeeList.forEach(shortInfo);


        Function<Employee, Integer> workDayLength = p -> Math.toIntExact(Math.round(p.getAge() / 10d * 1.5));
        employeeList.stream().map(workDayLength).forEach(System.out::println);


        Supplier<Employee> randomEmployee = () -> {
            int value = (int) (Math.random() * employeeList.size());
            return employeeList.get(value);
        };
        System.out.println(randomEmployee.get());

        BiPredicate<Employee, Employee> isOlder = (p1, p2) -> p1.getAge() > p2.getAge();
        Employee human1 = randomEmployee.get();
        Employee human2 = randomEmployee.get();
        shortInfo.accept(human1);
        shortInfo.accept(human2);

        System.out.println(isOlder.test(human1, human2));

    }
}
