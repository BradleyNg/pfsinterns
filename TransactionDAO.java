import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionDAO {
    private List<Transaction> transactionList = new ArrayList<>();
    private int currentId = 1;

    public void addTransaction(Transaction transaction) {
        transaction.setId(currentId++);
        transactionList.add(transaction);
    }

    public List<Transaction> getAllTransactions() {
        return new ArrayList<>(transactionList);
    }

    public void updateTransaction(Transaction transaction) {
        for (int i = 0; i < transactionList.size(); i++) {
            if (transactionList.get(i).getId() == transaction.getId()) {
                transactionList.set(i, transaction);
                return;
            }
        }
    }

    public void deleteTransaction(int id) {
        transactionList.removeIf(transaction -> transaction.getId() == id);
    }
}

