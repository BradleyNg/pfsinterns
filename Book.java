public class Book {
    private int id;
    private String name;
    private String writer;
    private String press;
    private int publicationYear;

    public Book(int id, String name, String writer, String press, int publicationYear) {
        this.id = id;
        this.name = name;
        this.writer = writer;
        this.press = press;
        this.publicationYear = publicationYear;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }
}
