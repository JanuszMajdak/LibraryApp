package io;

import model.Book;
import model.Magazine;
import model.Publication;

public class ConsolePrinter {

    public void printBooks(Publication[] publications) {
        int counter = 0;

        for (Publication publication : publications) {
            if (publication instanceof Book) {
                printLine(publication.toString());
                counter++;
            }
        }

        if (counter == 0) {
            System.out.println("There aren't any books in the library.");
        }
    }

    public void printMagazines(Publication[] publications) {
        int counter = 0;
        for (Publication publication : publications) {
            if (publication instanceof Magazine) {
                printLine(publication.toString());
                counter++;

            }
        }
        if (counter == 0) {
            printLine("There aren't any magazines in the library.");
        }

    }


    public void printLine(String text) {
        System.out.println(text);
    }

}
