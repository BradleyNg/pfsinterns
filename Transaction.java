import java.util.Date;

public class Transaction {
    private int id;
    private int bookRefId;
    private int borrowerRefId;
    private Date issuedOn;
    private Date returnedOn;

    public Transaction(int id, int bookRefId, int borrowerRefId, Date issuedOn, Date returnedOn) {
        this.id = id;
        this.bookRefId = bookRefId;
        this.borrowerRefId = borrowerRefId;
        this.issuedOn = issuedOn;
        this.returnedOn = returnedOn;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookRefId() {
        return bookRefId;
    }

    public void setBookRefId(int bookRefId) {
        this.bookRefId = bookRefId;
    }

    public int getBorrowerRefId() {
        return borrowerRefId;
    }

    public void setBorrowerRefId(int borrowerRefId) {
        this.borrowerRefId = borrowerRefId;
    }

    public Date getIssuedOn() {
        return issuedOn;
    }

    public void setIssuedOn(Date issuedOn) {
        this.issuedOn = issuedOn;
    }

    public Date getReturnedOn() {
        return returnedOn;
    }

    public void setReturnedOn(Date returnedOn) {
        this.returnedOn = returnedOn;
    }
}

