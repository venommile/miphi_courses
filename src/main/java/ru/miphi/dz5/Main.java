package ru.miphi.dz5;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

import static java.time.temporal.ChronoUnit.DAYS;

public class Main {
    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
    public static final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("MMMM d h:ma yyyy", Locale.ENGLISH);
    public static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("h:ma d MMMM");
    public static final DateTimeFormatter flightFormatter = DateTimeFormatter.ofPattern("h:m a M d, yyyy");
    public static final ZoneId SanFrancisco = ZoneId.of("America/Los_Angeles");
    public static final ZoneId Boston = ZoneId.of("America/New_York");
    public static final ZoneId Bengaluru = ZoneId.of("Asia/Calcutta");

    public static void main(String[] args) {
        taskOne1();
        System.out.println("-----------");
        taskOne2();
        System.out.println("-----------");
        taskOne3();
        System.out.println("-----------");
        taskOne4();
        System.out.println("-----------");
        taskOne5();
        System.out.println("-----------");
        taskOne6();
        System.out.println("-----------");
        taskTwo1();
        System.out.println("-----------");
        taskTwo2();
        System.out.println("-----------");
        taskTwo3();


    }

    public static void taskOne1() {
        var birthDate = LocalDate.parse("February 12, 1809", formatter);
        var deathDate = LocalDate.parse("April 15, 1855", formatter);
        Period between = Period.between(birthDate, deathDate);
        var years = between.getYears();
        System.out.println("He was " + years + " when hi died.(");


        var days = DAYS.between(birthDate, deathDate);
        System.out.println("He lived " + days + " days");

    }

    public static void taskOne2() {
        var birthDate = LocalDate.parse("July 19, 1976", formatter);
        System.out.println(birthDate.isLeapYear() ? "Yes,it is a leap year" : "No,it is not a leap year");
        System.out.println(birthDate.isLeapYear() ? "366" : "365");
        System.out.println("He is " + Period.between(birthDate, LocalDate.now()).getYears() / 10 + " decades old");//LocalDateTime.until
        System.out.println(birthDate.plusYears(21).getDayOfWeek());
    }

    public static void taskOne3() {
        // Нет разницы между Бостоном и Нью Йорком,поэтому можем просто сделать LocalTime
        var departTime = LocalTime.of(13, 45);
        var arrivalTime = LocalTime.of(19, 25);
        System.out.println(ChronoUnit.MINUTES.between(departTime, arrivalTime));
        System.out.println(arrivalTime.plusHours(1).plusMinutes(19));

    }

    public static void taskOne4() {
        var departTime = ZonedDateTime.of(LocalDateTime.parse("March 24 9:15PM 2000", timeFormatter),
                ZoneId.of("America/New_York"));
        var arriveTime = departTime.plusHours(4).plusMinutes(15);


        System.out.println(arriveTime.format(dtf));
        System.out.println(arriveTime.plusHours(4).plusMinutes(27).format(dtf));


    }

    public static void taskOne5() {
        var startSchool = LocalDate.of(2021, 9, 1).
                with(TemporalAdjusters.firstInMonth(DayOfWeek.TUESDAY)).
                with(TemporalAdjusters.next(DayOfWeek.TUESDAY));
        System.out.println(startSchool);

        var endSchool = LocalDate.of(2022, 6, 22);

        long workWeeks = ChronoUnit.WEEKS.between(startSchool, endSchool) - 4;
        long days = workWeeks * 5; //в каждой недели ровно 5 рабочих дней тут 180

        //p.s. может быть нам надо прибавить последнюю неделю.
        days += endSchool.getDayOfWeek().ordinal();//если
        if (endSchool.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
            days--; //если сейчас воскресенье,вычитаем выходную субботу
        }
        System.out.println(days);

    }

    //taskOne
    public static void taskOne6() {
        if (LocalDateTime.now().isBefore(
                LocalDateTime.now().
                        with(TemporalAdjusters.nextOrSame(DayOfWeek.TUESDAY)).
                        withHour(13).
                        withMinute(30)
        )) {
            System.out.println(LocalDateTime.now().
                    with(TemporalAdjusters.nextOrSame(DayOfWeek.TUESDAY)).
                    withHour(13).
                    withMinute(30));

        } else {
            System.out.println(LocalDateTime.now().
                    with(TemporalAdjusters.next(DayOfWeek.TUESDAY)).
                    withHour(13).
                    withMinute(30).format(dtf));
        }


    }

    public static void taskTwo1() {

        var departTime = LocalDateTime.parse("10:30 PM 6 13, 2014", flightFormatter).atZone(SanFrancisco);

        System.out.println(departTime.toOffsetDateTime().atZoneSameInstant(Boston).format(dtf));

        var arriveTime = departTime.plusHours(5).plusMinutes(30).toOffsetDateTime().atZoneSameInstant(Boston);
        System.out.println(arriveTime.format(dtf));
        System.out.println(arriveTime.toOffsetDateTime().atZoneSameInstant(SanFrancisco).format(dtf));
    }

    public static void taskTwo2() {
        var departTime = LocalDateTime.parse("10:30 PM 6 28, 2014", flightFormatter).atZone(SanFrancisco);
        var arriveTime = departTime.plusHours(22);
        System.out.println(arriveTime.toOffsetDateTime().atZoneSameInstant(Bengaluru).
                isBefore(LocalDateTime.parse("9:0 AM 6 29, 2014", flightFormatter).atZone(Bengaluru)) ?
                "Yes" : "No"
        );
        if (arriveTime.getHour() > 7 && arriveTime.getHour() < 23) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public static void taskTwo3() {
        var departTime = LocalDateTime.parse("10:30 PM 11 1, 2014", flightFormatter).atZone(SanFrancisco);
        var arriveTime = departTime.plusHours(5).plusMinutes(30);
        System.out.println(arriveTime.toOffsetDateTime().atZoneSameInstant(Boston).format(dtf));
        System.out.println("What happened?)");
    }
}
