package Library;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("The Alchemist", "Paulo Coelho", 200);
        Book book2 = new Book("1984", "George Orwell", 328);
        Textbook textbook = new Textbook("Java Programming", "John Smith", 500, "Computer Science", 3);

        book1.displayInfo();
        book1.borrowBook();
        book1.displayInfo();
        book1.returnBook();
        book1.displayInfo();

        System.out.println("-----------");

        book2.displayInfo();
        book2.borrowBook();
        book2.borrowBook(); // try to borrow again

        System.out.println("-----------");

        textbook.displayInfo();
        textbook.borrowBook();
        textbook.returnBook();
    }
}
