public class Main {
    public static void main(String[] args) {
        Author author1 = new Author("Федор Достоевский");
        Book book1 = new Book("Преступление и наказание", author1, 1866);
        Author author2 = new Author("Александр Грибоедов");
        Book book2 = new Book("Горе от ума", author2, 1825);
        book2.printBook();
        book2.setYearOfPublication(1826);
        System.out.println();
        book2.printBook();
    }
}

class Book {
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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void printBook() {
        System.out.println("Название книги: " + title);
        System.out.println("Автор книги: " + author.getFirstName() + " " + author.getLastName());
        System.out.println("Год публикации: " + yearOfPublication);
    }
}

class Author {
    private String firstName;
    private String lastName;

    Author(String fullName) {
        fullName = fullName.trim();
        String[] name = fullName.split(" ");
        if (name.length != 2) {
            throw new RuntimeException("Некорректно указано имя автора");
        }
        firstName = name[0];
        lastName = name[1];
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}