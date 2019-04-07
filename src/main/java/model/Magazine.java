package model;

import java.time.MonthDay;
import java.time.Year;
import java.util.Objects;

public class Magazine extends Publication {

    public static final String TYPE = "Magazine";


    private MonthDay monthDay;
    private String language;

    public Magazine(String title, String publisher, String language, int year, int month, int day) {
        super(title, publisher, year);
              this.language = language;
        this.monthDay = monthDay.of(month, day);
    }

    public static String getTYPE() {
        return TYPE;
    }

    public MonthDay getMonthDay() {
        return monthDay;
    }

    public void setMonthDay(MonthDay monthDay) {
        this.monthDay = monthDay;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return super.toString() + "," + monthDay.getMonthValue() + "," + monthDay.getDayOfMonth() + "," + language;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Magazine)) return false;
        if (!super.equals(o)) return false;
        Magazine magazine = (Magazine) o;
        return getMonthDay().equals(magazine.getMonthDay()) &&
                getLanguage().equals(magazine.getLanguage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getMonthDay(), getLanguage());
    }

    @Override
    public String toCsv() {
        return (TYPE + ";") + getTitle() + ";" + getPublisher() + ";" + getYear() + ";" + monthDay.getMonthValue() + ";" + monthDay.getDayOfMonth() + ";" + language + "";
    }
}
