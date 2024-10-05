import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private List<Book> bookCollection = new ArrayList<>();
    private int currentId = 1;

    public void addBook(Book book) {
        book.setId(currentId++);
        bookCollection.add(book);
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(bookCollection);
    }

    public void updateBook(Book book) {
        for (int i = 0; i < bookCollection.size(); i++) {
            if (bookCollection.get(i).getId() == book.getId()) {
                bookCollection.set(i, book);
                return;
            }
        }
    }

    public void deleteBook(int id) {
        bookCollection.removeIf(book -> book.getId() == id);
    }
}

