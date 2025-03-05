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

    public void printBook() {
        System.out.println("Название книги: " + title);
        System.out.println("Автор книги: " + author.getFirstName() + " " + author.getLastName());
        System.out.println("Год публикации: " + yearOfPublication);
    }
}
