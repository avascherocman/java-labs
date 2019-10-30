public class Patron {
    static Book[] booksBorrowed = new Book[3];
    static int numBooks;
    String name;

    Patron() {
        numBooks = 0;
    }

    Patron(String n){
        this.name = n;
    }

    public static void borrowBook(Book b, Patron p) {
        if (b.borrowed == false){
            if (numBooks <= 3) {
                b.borrower = p;
                b.borrowed = true;
                booksBorrowed[numBooks] = b;
                numBooks++;
                System.out.println(p.name + " has borrowed " +b.title);
            } else {
                System.out.println(p.name + " has borrowed too many books. Please have them return a book before borrowing another.");

            }
        } else {
            System.out.println("This book is already being borrowed by another patron.");
        }



    }

    public static void returnBook(Book b, Patron p) {
        boolean r = false;
        for (int i = 0; i <= 2; i++) {
            if (booksBorrowed[i].title == b.title) {
                b.borrower = null;
                b.borrowed = false;
                booksBorrowed[numBooks] = null;
                for (int j = 0; j < numBooks; j++) {
                    booksBorrowed[j] = booksBorrowed[j + 1];
                }
                r = true;
                System.out.println(p.name+" has returned " + b.title);
                break;
            }
        }
        if (r == false) {
            System.out.println( p.name+ "has not borrowed this book.");
        }

    }

    public static void viewBook(Book b){
        System.out.println(b.title);
        System.out.println(b.author);
    }
}
