import java.util.ArrayList;
import java.util.List;

public class BorrowerDAO {
    private List<Borrower> borrowerList = new ArrayList<>();
    private int currentId = 1;

    public void addBorrower(Borrower borrower) {
        borrower.setId(currentId++);
        borrowerList.add(borrower);
    }

    public List<Borrower> getAllBorrowers() {
        return new ArrayList<>(borrowerList);
    }

    public void updateBorrower(Borrower borrower) {
        for (int i = 0; i < borrowerList.size(); i++) {
            if (borrowerList.get(i).getId() == borrower.getId()) {
                borrowerList.set(i, borrower);
                return;
            }
        }
    }

    public void deleteBorrower(int id) {
        borrowerList.removeIf(borrower -> borrower.getId() == id);
    }
}

