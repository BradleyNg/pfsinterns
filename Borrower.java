public class Borrower {
    private String borrowerId;
    private String name;
    private String contactInfo;

    public Borrower(String borrowerId, String name, String contactInfo) {
        this.borrowerId = borrowerId;
        this.name = name;
        this.contactInfo = contactInfo;
    }

    // Getters and Setters for borrower details
    public String getBorrowerId() { return borrowerId; }
    public String getName() { return name; }
    public String getContactInfo() { return contactInfo; }
}
