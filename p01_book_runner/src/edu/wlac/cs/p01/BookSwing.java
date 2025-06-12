package edu.wlac.cs.p01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.time.Year;

public class BookSwing {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(BookSwing::createAndShow);
    }

    private static void createAndShow() {
        // Model with initial values 
        Book book1 = new Book();
        book1.setTitle("Effective Java (3rd Edition)");
        book1.setPublisher("Addison-Wesley");
        book1.setAuthor("Joshua Bloch");
        book1.setISBN("978-0134685991");
        book1.setYear(2018);

        JFrame frame = new JFrame("Book (Swing app)");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField titleText = new JTextField(40);
        JTextField publisherText = new JTextField(40);
        JTextField authorText = new JTextField(40);
        JTextField isbnText = new JTextField(40);
        JTextField yearText = new JTextField(10);
        JTextArea outputArea = new JTextArea(12, 60);
        outputArea.setEditable(false);

        // Seed fields from model
        titleText.setText(book1.getTitle());
        publisherText.setText(book1.getPublisher());
        authorText.setText(book1.getAuthor());
        isbnText.setText(book1.getISBN());
        yearText.setText(Integer.toString(book1.getYear()));

        JButton updateBtn = new JButton("Update");

        ActionListener pushToModel = e -> {
            book1.setTitle(titleText.getText());
            book1.setPublisher(publisherText.getText());
            book1.setAuthor(authorText.getText());
            book1.setISBN(isbnText.getText());
            try {
                book1.setYear(Integer.parseInt(yearText.getText().trim()));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Year must be an integer.", "Input error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            render(book1, outputArea);
        };

        // Enter key in any field will update too
        titleText.addActionListener(pushToModel);
        publisherText.addActionListener(pushToModel);
        authorText.addActionListener(pushToModel);
        isbnText.addActionListener(pushToModel);
        yearText.addActionListener(pushToModel);
        updateBtn.addActionListener(pushToModel);

        JPanel form = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(4, 4, 4, 4);
        c.anchor = GridBagConstraints.WEST;

        c.gridx = 0; c.gridy = 0; form.add(new JLabel("Book title"), c);
        c.gridx = 1; form.add(titleText, c);
        c.gridx = 0; c.gridy++; form.add(new JLabel("Publisher"), c);
        c.gridx = 1; form.add(publisherText, c);
        c.gridx = 0; c.gridy++; form.add(new JLabel("Author"), c);
        c.gridx = 1; form.add(authorText, c);
        c.gridx = 0; c.gridy++; form.add(new JLabel("ISBN"), c);
        c.gridx = 1; form.add(isbnText, c);
        c.gridx = 0; c.gridy++; form.add(new JLabel("Year"), c);
        c.gridx = 1; form.add(yearText, c);
        c.gridx = 1; c.gridy++; form.add(updateBtn, c);

        render(book1, outputArea);

        frame.getContentPane().add(new JLabel("Type book info and press Enter or Update:"), BorderLayout.NORTH);
        frame.getContentPane().add(form, BorderLayout.CENTER);
        frame.getContentPane().add(new JScrollPane(outputArea), BorderLayout.SOUTH);

        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    private static void render(Book b, JTextArea out) {
        int currentYear = Year.now().getValue();
        out.setText(
            "The information of the book is:\n\n" +
            b.reportInfo() +
            "\n\nYears ago published: " + b.yearsAgoPublished(currentYear) +
            "\nOld (>3 years)? " + (b.isOld(currentYear) ? "Yes" : "No") +
            "\n"
        );
    }
}

