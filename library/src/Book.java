public class Book {
    String title;
    String author;
    Boolean borrowed;
    Patron borrower;

    Book(String t, String a){
        this.title=t;
        this.author=a;
    }

    public static boolean isBorrowed(Book b){
        return b.borrowed;
    }

    public static String getTitle(Book b){
        return b.title;
    }

    public static String getAuthor(Book b){
        return b.author;
    }
}
