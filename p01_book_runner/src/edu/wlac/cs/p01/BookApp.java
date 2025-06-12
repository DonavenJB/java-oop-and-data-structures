package edu.wlac.cs.p01;

import java.time.Year;

public class BookApp {
    public static void main(String[] args) {
        // Create two course books (no keyboard input; per assignment)
        Book b1 = new Book();
        b1.setTitle("Effective Java (3rd Edition)");
        b1.setPublisher("Addison-Wesley");
        b1.setAuthor("Joshua Bloch");
        b1.setISBN("978-0134685991");
        b1.setYear(2018);

        Book b2 = new Book();
        b2.setTitle("Introduction to Algorithms (4th Edition)");
        b2.setPublisher("MIT Press");
        b2.setAuthor("Cormen, Leiserson, Rivest, Stein");
        b2.setISBN("978-0262046305");
        b2.setYear(2022);

        int currentYear = Year.now().getValue();
        int oldCount = (b1.isOld(currentYear) ? 1 : 0) + (b2.isOld(currentYear) ? 1 : 0);

        System.out.println("The books used in this course are:\n");

        System.out.println(b1.reportInfo());
        System.out.println("Years ago published: " + b1.yearsAgoPublished(currentYear) + "\n");

        System.out.println(b2.reportInfo());
        System.out.println("Years ago published: " + b2.yearsAgoPublished(currentYear) + "\n");

        System.out.println(oldCount + " of these books are old");
    }
}

