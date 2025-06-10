package edu.wlac.cs.p01;

/*
 * Book model used by Swing to demo.
 * Includes the 10 required accessors/mutators and a few helpers.
 */
public class Book {
    private String title;
    private String publisher;
    private String author;
    private String isbn;
    private int year;

    // Mutators
    public void setPublisher(String newPublisher) { publisher = newPublisher; }
    public void setTitle(String newTitle) { title = newTitle; }
    public void setAuthor(String newAuthor) { author = newAuthor; }
    public void setISBN(String newIsbn) { isbn = newIsbn; }
    public void setYear(int newYear) { year = newYear; }

    // Accessors
    public String getPublisher() { return publisher; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getISBN() { return isbn; }
    public int getYear() { return year; }

    // Helpers
    public String reportInfo() {
        return "Title: " + safe(title) +
               "\nPublisher: " + safe(publisher) +
               "\nAuthor: " + safe(author) +
               "\nISBN: " + safe(isbn) +
               "\nYear: " + year;
    }
    public int yearsAgoPublished(int currentYear) {
        int diff = currentYear - year;
        return diff < 0 ? 0 : diff;
    }
    public boolean isOld(int currentYear) { return yearsAgoPublished(currentYear) > 3; }
    private static String safe(String s) { return s == null ? "" : s; }
}
