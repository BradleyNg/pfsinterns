import java.util.ArrayList;
import java.util.HashMap;

public class LibraryManager {
    private ArrayList<Book> books;
    private ArrayList<Borrower> borrowers;
    private ArrayList<Transaction> transactions;

    public LibraryManager() {
        books = new ArrayList<>();
        borrowers = new ArrayList<>();
        transactions = new ArrayList<>();
    }

    // Book Management
    public void addBook(Book book) { books.add(book); }
    public void removeBook(String isbn) { books.removeIf(book -> book.getIsbn().equals(isbn)); }
    public Book searchBookByISBN(String isbn) {
        return books.stream().filter(book -> book.getIsbn().equals(isbn)).findFirst().orElse(null);
    }

    // Borrower Management
    public void addBorrower(Borrower borrower) { borrowers.add(borrower); }
    public void removeBorrower(String borrowerId) {
        borrowers.removeIf(borrower -> borrower.getBorrowerId().equals(borrowerId));
    }

    // Issue Book
    public boolean issueBook(String isbn, String borrowerId) {
        Book book = searchBookByISBN(isbn);
        Borrower borrower = searchBorrowerById(borrowerId);
        if (book != null && borrower != null && book.getAvailableCopies() > 0) {
            book.setAvailableCopies(book.getAvailableCopies() - 1);
            transactions.add(new Transaction(book, borrower, java.time.LocalDate.now()));
            return true;
        }
        return false;
    }

    // Return Book
    public boolean returnBook(String isbn, String borrowerId) {
        for (Transaction t : transactions) {
            if (t.getBook().getIsbn().equals(isbn) && t.getBorrower().getBorrowerId().equals(borrowerId) && t.getReturnDate() == null) {
                t.setReturnDate(java.time.LocalDate.now());
                t.getBook().setAvailableCopies(t.getBook().getAvailableCopies() + 1);
                return true;
            }
        }
        return false;
    }

    // Borrower Lookup
    private Borrower searchBorrowerById(String borrowerId) {
        return borrowers.stream().filter(borrower -> borrower.getBorrowerId().equals(borrowerId)).findFirst().orElse(null);
    }

    // Generate Report (Transactions List)
    public ArrayList<Transaction> generateReport() { return transactions; }
}
