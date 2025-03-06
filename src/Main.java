public class Main {
    public static void main(String[] args) {
        Author author1 = new Author("Федор", "Достоевский");
        Book book1 = new Book("Преступление и наказание", author1, 1866);
        Author author2 = new Author("Александр", "Грибоедов");
        Book book2 = new Book("Горе от ума", author2, 1825);
        System.out.println(book2);
        book2.setYearOfPublication(1826);
        System.out.println();
        System.out.println(book2);
    }
}