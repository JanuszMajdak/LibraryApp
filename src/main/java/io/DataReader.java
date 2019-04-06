package io;

import data.Library;
import model.Book;
import model.LibraryUser;
import model.Magazine;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DataReader {
    private Scanner scanner = new Scanner(System.in);
    private ConsolePrinter printer;

    public DataReader(ConsolePrinter printer) {
        this.printer = printer;
    }

    public void close() {
        scanner.close();
    }


    public int getInt() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw e;
        } finally {
            scanner.nextLine();
        }
    }


    public Book readAndCreateBook() {
        printer.printLine("Title:");
        String title = scanner.nextLine();

        printer.printLine("Author:");
        String author = scanner.nextLine();

        printer.printLine("Release date:");
        int releaseDate = getInt();

        printer.printLine("Pages number:");
        int pagesNumber = getInt();

        printer.printLine("The publisher name:");
        String publisherName = scanner.nextLine();

        printer.printLine("ISBN: ");
        String isbn = scanner.nextLine();

        return new Book(title, author, releaseDate, pagesNumber, publisherName, isbn);
    }


    public Magazine readAndCreateMagazine() {
        printer.printLine("Title:");
        String title = scanner.nextLine();

        printer.printLine("Publisher:");
        String publisher = scanner.nextLine();

        printer.printLine("Language:");
        String language = scanner.nextLine();

        printer.printLine("Release year:");
        int year = getInt();

        printer.printLine("Release month:");
        int month = getInt();

        printer.printLine("Release day:");
        int day = getInt();

        return new Magazine(title, publisher, language, year, month, day);
    }

    public String getString() {
        return scanner.nextLine();
    }

    public LibraryUser createLibraryUser() {
        printer.printLine("Name");
        String firstName = scanner.nextLine();
        printer.printLine("Surname");
        String lastName = scanner.nextLine();
        printer.printLine("Pesel");
        String pesel = scanner.nextLine();
        return new LibraryUser(firstName, lastName, pesel);
    }

}


