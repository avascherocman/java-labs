public class Patron {
    static Book[] booksBorrowed = new Book[10];
    static int numBooks;

    Patron(){
        numBooks=0;
    }

    public static void borrowBook(Book b, Patron p){
        if(numBooks<=10){
            b.borrower =p;
            b.borrowed=true;
            booksBorrowed[numBooks]=b;
            numBooks++;
        } else {
            System.out.println("You've borrowed too many books. Please return a book before borrowing another. You're stealing from our public libraries.");

        }



    }

    public static void returnBook(Book b){

    }

}
