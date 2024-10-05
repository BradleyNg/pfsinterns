import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibraryGUI extends JFrame {
    private LibraryManager libraryManager;

    // GUI Components
    private JTextField isbnField, titleField, authorField, borrowerIdField, nameField, contactField;

    public LibraryGUI() {
        libraryManager = new LibraryManager();
        setTitle("Library Management System");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Add Books Panel
        JPanel bookPanel = new JPanel();
        bookPanel.setLayout(new GridLayout(5, 2));

        bookPanel.add(new JLabel("ISBN:"));
        isbnField = new JTextField();
        bookPanel.add(isbnField);

        bookPanel.add(new JLabel("Title:"));
        titleField = new JTextField();
        bookPanel.add(titleField);

        bookPanel.add(new JLabel("Author:"));
        authorField = new JTextField();
        bookPanel.add(authorField);

        JButton addBookButton = new JButton("Add Book");
        addBookButton.addActionListener(new AddBookListener());
        bookPanel.add(addBookButton);

        add(bookPanel, BorderLayout.NORTH);

        // Add Borrowers Panel (could be similar to book panel)
        JPanel borrowerPanel = new JPanel();
        borrowerPanel.setLayout(new GridLayout(4, 2));

        borrowerPanel.add(new JLabel("Borrower ID:"));
        borrowerIdField = new JTextField();
        borrowerPanel.add(borrowerIdField);

        borrowerPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        borrowerPanel.add(nameField);

        borrowerPanel.add(new JLabel("Contact Info:"));
        contactField = new JTextField();
        borrowerPanel.add(contactField);

        JButton addBorrowerButton = new JButton("Add Borrower");
        addBorrowerButton.addActionListener(new AddBorrowerListener());
        borrowerPanel.add(addBorrowerButton);

        add(borrowerPanel, BorderLayout.CENTER);

        // Issue/Return Panel, etc. (similar idea)

        setVisible(true);
    }

    // Action Listeners for Buttons
    class AddBookListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String isbn = isbnField.getText();
            String title = titleField.getText();
            String author = authorField.getText();
            libraryManager.addBook(new Book(isbn, title, author, 5));
            JOptionPane.showMessageDialog(null, "Book added successfully!");
        }
    }

    class AddBorrowerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String borrowerId = borrowerIdField.getText();
            String name = nameField.getText();
            String contact = contactField.getText();
            libraryManager.addBorrower(new Borrower(borrowerId, name, contact));
            JOptionPane.showMessageDialog(null, "Borrower added successfully!");
        }
    }

    // Other GUI actions for issuing books, returning books, etc.

    public static void main(String[] args) {
        new LibraryGUI();
    }
}
