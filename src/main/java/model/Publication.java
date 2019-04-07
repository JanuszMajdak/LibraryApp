package model;

import java.io.Serializable;
import java.time.Year;
import java.util.Objects;

public abstract class Publication implements Serializable, CsvConvertible {
    private Year year;
    private String title;
    private String publisher;


    public Publication( String title, String publisher, int year) {

        this.title = title;
        this.publisher = publisher;
        this.year = Year.of(year);
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Publication{" +
                "year=" + year +
                ", title='" + title + '\'' +
                ", publisher='" + publisher + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Publication)) return false;
        Publication that = (Publication) o;
        return getYear().equals(that.getYear()) &&
                getTitle().equals(that.getTitle()) &&
                getPublisher().equals(that.getPublisher());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getYear(), getTitle(), getPublisher());
    }

    public int compareTo(Publication p) {
        return title.compareToIgnoreCase(p.title);
    }
}
