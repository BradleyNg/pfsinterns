import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibraryGUI {
    private JFrame frame;
    private JTextField titleField, authorField, publisherField, yearField;
    private JTextField borrowerNameField, borrowerEmailField, borrowerPhoneField;
    private DefaultListModel<String> bookListModel;
    private JList<String> bookList;
    private BookDAO bookDAO;
    private BorrowerDAO borrowerDAO;
    private TransactionDAO transactionDAO;

    public LibraryGUI() {
        bookDAO = new BookDAO();
        borrowerDAO = new BorrowerDAO();
        transactionDAO = new TransactionDAO();
        frame = new JFrame("Library Management System");
        frame.setSize(900, 650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JTabbedPane tabbedPane = new JTabbedPane();

        // Book Panel
        JPanel bookPanel = new JPanel();
        bookPanel.setLayout(new BorderLayout());

        JPanel bookInputPanel = new JPanel();
        bookInputPanel.setLayout(new BoxLayout(bookInputPanel, BoxLayout.Y_AXIS));
        bookInputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Title
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        titlePanel.add(new JLabel("Title:"));
        titleField = new JTextField(20);
        titlePanel.add(titleField);
        bookInputPanel.add(titlePanel);

        // Author
        JPanel authorPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        authorPanel.add(new JLabel("Author:"));
        authorField = new JTextField(20);
        authorPanel.add(authorField);
        bookInputPanel.add(authorPanel);

        // Publisher
        JPanel publisherPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        publisherPanel.add(new JLabel("Publisher:"));
        publisherField = new JTextField(20);
        publisherPanel.add(publisherField);
        bookInputPanel.add(publisherPanel);

        // Year
        JPanel yearPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        yearPanel.add(new JLabel("Year:"));
        yearField = new JTextField(10);
        yearPanel.add(yearField);
        bookInputPanel.add(yearPanel);

        // Add Book Button
        JButton addBookButton = new JButton("Add Book");
        addBookButton.setBackground(Color.GREEN);
        addBookButton.setForeground(Color.WHITE);
        addBookButton.setFocusPainted(false);
        addBookButton.setPreferredSize(new Dimension(150, 30));
        addBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addBook();
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(addBookButton);
        bookInputPanel.add(buttonPanel);

        bookPanel.add(bookInputPanel, BorderLayout.NORTH);

        bookListModel = new DefaultListModel<>();
        bookList = new JList<>(bookListModel);
        JScrollPane scrollPane = new JScrollPane(bookList);
        bookPanel.add(scrollPane, BorderLayout.CENTER);

        tabbedPane.addTab("Books", bookPanel);

        // Borrower Panel
        JPanel borrowerPanel = new JPanel();
        borrowerPanel.setLayout(new BoxLayout(borrowerPanel, BoxLayout.Y_AXIS));
        borrowerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Borrower Name
        JPanel borrowerNamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        borrowerNamePanel.add(new JLabel("Name:"));
        borrowerNameField = new JTextField(20);
        borrowerNamePanel.add(borrowerNameField);
        borrowerPanel.add(borrowerNamePanel);

        // Borrower Email
        JPanel borrowerEmailPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        borrowerEmailPanel.add(new JLabel("Email:"));
        borrowerEmailField = new JTextField(20);
        borrowerEmailPanel.add(borrowerEmailField);
        borrowerPanel.add(borrowerEmailPanel);

        // Borrower Phone
        JPanel borrowerPhonePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        borrowerPhonePanel.add(new JLabel("Phone:"));
        borrowerPhoneField = new JTextField(15);
        borrowerPhonePanel.add(borrowerPhoneField);
        borrowerPanel.add(borrowerPhonePanel);

        // Add Borrower Button
        JButton addBorrowerButton = new JButton("Add Borrower");
        addBorrowerButton.setBackground(Color.BLUE);
        addBorrowerButton.setForeground(Color.WHITE);
        addBorrowerButton.setFocusPainted(false);
        addBorrowerButton.setPreferredSize(new Dimension(150, 30));
        addBorrowerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addBorrower();
            }
        });

        JPanel borrowerButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        borrowerButtonPanel.add(addBorrowerButton);
        borrowerPanel.add(borrowerButtonPanel);

        tabbedPane.addTab("Borrowers", borrowerPanel);

        frame.add(tabbedPane, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private void addBook() {
        String title = titleField.getText();
        String author = authorField.getText();
        String publisher = publisherField.getText();
        int year = Integer.parseInt(yearField.getText());

        Book book = new Book(0, title, author, publisher, year);
        bookDAO.addBook(book);
        bookListModel.addElement(title + " by " + author);
        JOptionPane.showMessageDialog(frame, "Book added successfully!");
    }

    private void addBorrower() {
        String name = borrowerNameField.getText();
        String email = borrowerEmailField.getText();
        String phone = borrowerPhoneField.getText();

        Borrower borrower = new Borrower(0, name, email, phone);
        borrowerDAO.addBorrower(borrower);
        JOptionPane.showMessageDialog(frame, "Borrower added successfully!");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LibraryGUI();
            }
        });
    }
}

