import java.util.Scanner;

public class LibraryTester {
    public static void main(String args[]){
        Patron[] patrons = new Patron[5];
        int numPatrons = 0;
        Book[] books = new Book[10];
        int numBooks = 0;

        Scanner s = new Scanner(System.in);
        int ans = 0;
        do{
            System.out.println("Welcome to library. Please select a menu option.");
            System.out.println("1 Create a new Patron   2 Create a new book  3 View book");
            System.out.println("4 Tell patron to borrow book   5 Tell patron to return book   6 Check if book is borrowed");
            System.out.println("7 Return all patrons & borrowed books   8 Exit");
            ans = s.nextInt();
            if (ans==1){
                System.out.println("What would you like the name of your patron to be?");
                String n = s.next();
                patrons[numPatrons] = new Patron(n);
                System.out.println("New patron " + patrons[numPatrons].name + " created");
                numPatrons++;
            } else if (ans==2){
                System.out.println("What is the title of your book?");
                String t=s.next();
                System.out.println("Who is the author of your book");
                String a = s.next();
                books[numBooks] = new Book(t, a);
                System.out.println("New book " +  books[numBooks].title + " created");
                numBooks++;
            } else if (ans==3){
                System.out.println("What is the title of the book you would like to view?");
                String t = s.next();
                for (int i = 0; i < numBooks; i++) {
                    if (books[i].title.equals(t)) {
                        System.out.println(books[i].title);
                        System.out.println(books[i].author);
                    }
                }
            } else if (ans==4){
                System.out.println("Which patron would you like to tell to borrow a book?");
                String p = s.next();
                System.out.println("Which book would you like the patron to borrow?");
                String b = s.next();
                boolean bb = false;
                boolean pf = false;
                for (int j=1;j<=numBooks;j++){
                    if (b.equals(books[j].title)){
                        bb=true;
                        for (int i =1;i<=numPatrons;i++){
                            if (patrons[i].name.equals(p)){
                                patrons[i].borrowBook(books[j], patrons[i]);
                                pf = true;
                            }
                        }
                    }
                }
                if (!bb){
                    System.out.println("Book not found.");
                }
                if (!pf){
                    System.out.println("Patron not found.");
                }

            } else if (ans==5){

            } else if (ans==6){

            } else if (ans==7) {

            }else if (ans==8){
                System.exit(0);
            } else {
                System.out.println("Invalid input.");
            }

        } while(ans!=8);



    }
}
