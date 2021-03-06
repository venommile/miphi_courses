package ru.miphi.lab_and_dz3;


import java.util.ArrayList;
import java.util.Locale;

public class Employee {
    private Employee(EmployeeBuilder Builder) {
        this.givenName = Builder.givenName;
        this.surName = Builder.surName;
        this.age = Builder.age;
        this.gender = Builder.gender;
        this.role = Builder.role;
        this.dept = Builder.dept;
        this.eMail = Builder.eMail;
        this.phone = Builder.phone;
        this.address = Builder.address;
        this.city = Builder.city;
        this.state = Builder.state;
        this.code = Builder.code;
        this.salary = Builder.salary;

    }

    private String givenName;
    private String surName;
    private Integer age;


    private Gender gender;


    private Role role;

    private String dept;
    private String eMail;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String code;

    private Double salary;

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
                "salary" + salary + " " +
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
                .salary(1000.0)
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
                .salary(500.0)
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
                .salary(2000.0)
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
                .salary(700.0)
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
                .salary(400.0)
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
                .salary(540.0)
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
                .salary(3000.0)
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
                .salary(700.0)
                .build()
        );


        return employees;
    }

    public static class EmployeeBuilder {
        private String givenName = "";
        private String surName = "";
        private Integer age = null;


        private Gender gender;

        private Role role;

        private String dept = "";
        private String eMail = "";
        private String phone = "";
        private String address = "";
        private String city = "";
        private String state = "";
        private String code = "";

        private Double salary;

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

        public EmployeeBuilder age(Integer age) {

            this.age = age;
            return this;
        }

        public EmployeeBuilder gender(String gender) {
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
            }
            return this;
        }

        public EmployeeBuilder role(String role) {
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

        public EmployeeBuilder salary(Double salary) {
            this.salary = salary;
            return this;
        }

        public Employee build() {

            if (this.age < 0) {
                throw new IllegalArgumentException("Age have to be more than zero");
            }
            if (this.role == null) {
                throw new IllegalArgumentException("Not correct role,expected \"STAFF\" or \"MANAGER\" or \"EXECUTIVE\"");

            }
            if (this.gender == null) {
                throw new IllegalArgumentException("Not correct gender,expected \"male\" or \"female\"");
            }


            return new Employee(this);

        }


    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getSalary() {
        return this.salary;
    }
}
