public class Book {
    private String title;
    private Author author;
    private int yearOfPublication;

    Book(String title, Author author, int year) {
        this.title = title.trim();
        this.author = author;
        yearOfPublication = year;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public String toString() {
        return "Название книги: " + title + "\nАвтор книги: " + author.toString() +
                "\nГод публикации: " + yearOfPublication;
    }

    public int hashCode() {
        int result = title == null ? 0 : title.hashCode();
        result = result * 31 + (author.toString() == null ? 0 : author.toString().hashCode());
        return result * 31 + yearOfPublication;
    }
}
