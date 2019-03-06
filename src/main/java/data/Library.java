package data;

import model.Book;
import model.Magazine;
import model.Publication;

public class Library {

    private static final int MAX_PUBLICATIONS = 2000;
    private int publicationsNumber;
    private Publication[] publications = new Publication[MAX_PUBLICATIONS];


    public void addBook(Book book) {
        if (publicationsNumber < MAX_PUBLICATIONS) {
            publications[publicationsNumber] = book;
            publicationsNumber++;
        } else {
            System.out.println("The max. number of books is in the library. You are not able to add moore.");
        }
    }


    public void printBooks() {
        int countBooks = 0;

        for (int i = 0; i < publicationsNumber; i++) {
            if (publications[i] instanceof Book) {
                System.out.println(publications[i]);
                countBooks++;
            }
        }
        if (countBooks == 0) {
            System.out.println("There aren't any books in the library");

        }
    }


    public void addMagazine(Magazine magazine) {
        if (publicationsNumber < MAX_PUBLICATIONS) {
            publications[publicationsNumber] = magazine;
            publicationsNumber++;
        } else {
            System.out.println("The max. number of magazines is in the library. You are not able to add moore.");
        }

    }


    public void printMagazines() {
        int counMagazines = 0;

        for (int i = 0; i < publicationsNumber; i++) {
            if (publications[i] instanceof Magazine) {
                System.out.println(publications[i]);
                counMagazines++;
            }
        }
        if (counMagazines == 0) {
            System.out.println("There aren't any magazines in the library.");
        }
    }
}



