package ru.miphi.lab_and_dz3;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Locale;

@Getter
@Setter
public class Employee {
    Employee(String givenName, String surName, Integer age, Gender gender, Role role, String dept,
             String eMail, String phone, String address, String city, String state, String code) {
        this.givenName = givenName;
        this.surName = surName;
        this.age = age;
        this.gender = gender;
        this.role = role;
        this.dept = dept;
        this.eMail = eMail;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.state = state;
        this.code = code;


    }

    protected String givenName;
    protected String surName;
    protected Integer age;


    protected enum Gender {MALE, FEMALE}

    protected Gender gender;


    protected enum Role {
        STAFF(10), MANAGER(20), EXECUTIVE(30);
        int percentPremium;

        Role(int percentPremium) {
            this.percentPremium = percentPremium;
        }

        int getPercentPremium() {
            return percentPremium;
        }
    }


    protected Role role;

    protected String dept;
    protected String eMail;
    protected String phone;
    protected String address;
    protected String city;
    protected String state;
    protected String code;

    @Override
    public String toString() {
        return "Employee{" +
                "name:" + "'" + givenName + "' " +
                "surName:" + "'" + surName + "' " +
                "age:" + "'" + age + "' " +
                "gender:" + gender + " " +
                "role:" + role + " " +
                "dept:" + dept + " " +
                "eMail:" + eMail + " " +
                "phone:" + phone + " " +
                "address:" + address + " " +
                "city:" + city + " " +
                "state:" + state + " " +
                "code:" + code + " " +
                "}";

    }

    public static ArrayList<Employee> createShortList() {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new EmployeeBuilder()
                .givenName("Alex")
                .surName("Alexandrov")
                .age(20)
                .gender("m")
                .role("staff")
                .dept("Develop")
                .eMail("alexandr.alex@yandex.ru")
                .phone("8(888)888-88-88")
                .address("New Arbat Ave, 29, Moscow, Russia 173568")
                .city("Moscow")
                .state("Moscow")
                .code("77")
                .build()
        );
        employees.add(new EmployeeBuilder()
                .givenName("Ivan")
                .surName("Ivanov")
                .age(40)
                .gender("m")
                .role("manager")
                .dept("QA")
                .eMail("ivan_ivanov@.gmail.com")
                .phone("8(011)223-38-54")
                .address("Malyy Cherkasskiy Pereulok, 40, Moscow, Russia 125117")
                .city("Moscow")
                .state("Moscow")
                .code("77")
                .build()
        );
        employees.add(new EmployeeBuilder()
                .givenName("Lev")
                .surName("Tolstoy")
                .age(60)
                .gender("m")
                .role("EXECUTIVE")
                .dept("finance")
                .eMail("tolstoy@mail.ru")
                .phone("8(321)495-15-56 ")
                .address("Tula, Klara Tsetkin str.Russia 173338")
                .city("Tula")
                .state("Tula state")
                .code("71")
                .build()
        );
        employees.add(new EmployeeBuilder()
                .givenName("Fedor")
                .surName("Dostoevsky")
                .age(26)
                .gender("m")
                .role("manager")
                .dept("finance")
                .eMail("dostoevsky@vk.com")
                .phone("+7 (975) 254-94-70")
                .address("Kultury Pr., bld. 26/11, appt. 3107")
                .city("Sankt-Peterburg")
                .state("Leningradskaya oblast")
                .code("812")
                .build()
        );
        employees.add(new EmployeeBuilder()
                .givenName("Gabriel")
                .surName("Guselnikov")
                .age(35)
                .gender("m")
                .role("staff")
                .dept("finance")
                .eMail("gavriil8832@rambler.ru")
                .phone("+7 (975) 254-94-70")
                .address("Russia, Korolev, Embankment str., 3 sq. 158")
                .city("Korolev")
                .state("Moscow oblast")
                .code("812")
                .build()
        );
        employees.add(new EmployeeBuilder()
                .givenName("Olga")
                .surName("Gribanova")
                .age(25)
                .gender("f")
                .role("manager")
                .dept("finance")
                .eMail("gavriil8832@rambler.ru")
                .phone("+7 (992) 327-61-85")
                .address("Russia, Tomsk, Kolkhozny lane, 9 sq. 68")
                .city("Tomsk")
                .state("Tomsky oblast")
                .code("70")
                .build()
        );
        employees.add(new EmployeeBuilder()
                .givenName("Taisiya")
                .surName("Zherdeva")
                .age(44)
                .gender("f")
                .role("EXECUTIVE")
                .dept("QA")
                .eMail("taisiya5217@ya.ru")
                .phone("+7 (978) 227-87-33")
                .address("Russia, Kostroma, Trudovaya str., 8 sq. 136")
                .city("Kostroma")
                .state("Kostromsky oblast")
                .code("4492")
                .build()
        );
        employees.add(new EmployeeBuilder()
                .givenName("Yaroslava")
                .surName("Novikova")
                .age(20)
                .gender("f")
                .role("staff")
                .dept("Develop")
                .eMail("yaroslava5040@outlook.com")
                .phone("+7 (974) 970-43-17")
                .address("Russia, Tver, Pushkina str., 1 sq. 30")
                .city("Tver")
                .state("Tverkoy oblast")
                .code("169")
                .build()
        );


        return employees;
    }

    public static class EmployeeBuilder {
        protected String givenName = "";
        protected String surName = "";
        protected Integer age = null;


        protected Employee.Gender gender;

        protected Employee.Role role;

        protected String dept = "";
        protected String eMail = "";
        protected String phone = "";
        protected String address = "";
        protected String city = "";
        protected String state = "";
        protected String code = "";

        public EmployeeBuilder() {
            super();
        }

        public EmployeeBuilder givenName(String name) {
            this.givenName = name;
            return this;
        }

        public EmployeeBuilder surName(String surName) {
            this.surName = surName;
            return this;
        }

        public EmployeeBuilder age(Integer age) throws IllegalArgumentException {
            if (age < 0) {
                throw new IllegalArgumentException("Number have to be more than zero");
            }
            this.age = age;
            return this;
        }

        public EmployeeBuilder gender(String gender) throws IllegalArgumentException {
            if (gender.toLowerCase(Locale.ROOT).equals("w") ||
                    gender.toLowerCase(Locale.ROOT).equals("woman") ||
                    gender.toLowerCase(Locale.ROOT).equals("f") ||
                    gender.toLowerCase(Locale.ROOT).equals("female")
            ) {
                this.gender = Gender.FEMALE;
            } else if (gender.toLowerCase(Locale.ROOT).equals("m") ||
                    gender.toLowerCase(Locale.ROOT).equals("man") ||
                    gender.toLowerCase(Locale.ROOT).equals("male")
            ) {
                this.gender = Gender.MALE;
            } else {
                throw new IllegalArgumentException("Not correct gender,expected \"male\" or \"female\"");
            }
            return this;
        }

        public EmployeeBuilder role(String role) throws IllegalArgumentException {
            switch (role.toLowerCase(Locale.ROOT)) {
                case "staff":
                    this.role = Role.STAFF;
                    break;
                case "manager":
                    this.role = Role.MANAGER;
                    break;
                case "executive":
                    this.role = Role.EXECUTIVE;
                    break;
                default:
                    throw new IllegalArgumentException("Not correct role,expected \"STAFF\" or \"MANAGER\" or \"EXECUTIVE\"");
            }
            return this;
        }

        public EmployeeBuilder dept(String dept) {
            this.dept = dept;
            return this;
        }

        public EmployeeBuilder eMail(String eMail) {
            this.eMail = eMail;
            return this;
        }

        public EmployeeBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public EmployeeBuilder address(String address) {
            this.address = address;
            return this;
        }

        public EmployeeBuilder city(String city) {
            this.city = city;
            return this;
        }

        public EmployeeBuilder state(String state) {
            this.state = state;
            return this;
        }

        public EmployeeBuilder code(String code) {
            this.code = code;
            return this;
        }

        public Employee build() {
            return new Employee(givenName, surName, age, gender, role, dept, eMail, phone, address, city, state, code);

        }


    }


}
