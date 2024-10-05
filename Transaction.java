import java.time.LocalDate;

public class Transaction {
    private Book book;
    private Borrower borrower;
    private LocalDate issueDate;
    private LocalDate returnDate;

    public Transaction(Book book, Borrower borrower, LocalDate issueDate) {
        this.book = book;
        this.borrower = borrower;
        this.issueDate = issueDate;
        this.returnDate = null; // Book not yet returned
    }

    // Getters and Setters
    public Book getBook() { return book; }
    public Borrower getBorrower() { return borrower; }
    public LocalDate getIssueDate() { return issueDate; }
    public LocalDate getReturnDate() { return returnDate; }
    public void setReturnDate(LocalDate returnDate) { this.returnDate = returnDate; }
}
