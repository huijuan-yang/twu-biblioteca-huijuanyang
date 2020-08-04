package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.*;


public class ExampleTest {

    Account account = new Account();
    User user = new User("huijuan", "huijuanyang@thoughtworks.com", 123456789);

    @Test
    public void should_Print_Welcome_Message_Test() {
        assertEquals("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!", account.printWelcomeMessage());
    }

    @Test
    public void should_Show_All_Books_Test() {
        assertNotNull(user.showAllBooks());
        assertEquals("Name: Effective Java | Author: Joshua Bloch | Published Year: 2001\n" +
                "Name: Clean Code | Author: Robert C. Martin | Published Year: 2009\n" +
                "Name: Head First Design Patterns | Author: Eric Freeman | Published Year: 2015\n" +
                "Name: Spring in Action | Author: Craig Walls | Published Year: 2005\n", user.showAllBooks());
    }

    @Test
    public void should_Check_Out_Book_By_Isbn_Test() {
        user.checkOutBook("9780321356680");
        assertFalse(user.getBooks().stream().filter(element -> element.getIsbn() == "9780321356680").allMatch(Book::getAvailable));
    }

    @Test
    public void should_Return_Message_When_Check_Out_Successful_Test() {
        String successfulResult = user.checkOutBook("9780321356680");
        assertEquals("Thank you! Enjoy the book!", successfulResult);
    }

    @Test
    public void should_Return_Error_Message_When_Check_Out_Failed_Test() {
        String failedRusult = user.checkOutBook("abcdefg");
        assertEquals("Sorry, that book is not available.", failedRusult);
    }

    @Test
    public void should_Return_Book_By_Isbn_Test() {
        user.returnBook("9780321356680");
        assertTrue(user.getBooks().stream().filter(element -> element.getIsbn() == "9780321356680").allMatch(Book::getAvailable));
    }

    @Test
    public void should_Return_Message_When_Return_Successful_Test() {
        String successfulResult = user.returnBook("9780321356680");
        assertEquals("Thank you for returning the book!", successfulResult);
    }

    @Test
    public void should_Return_Error_Message_When_Return_Failed_Test() {
        String failedResult = user.returnBook("abcdefg");
        assertEquals("That is not a valid book to return.", failedResult);
    }

    @Test
    public void should_Show_All_Available_Movies_Test() {
        assertNotNull(user.showAllAvailableMovies());
    }

    @Test
    public  void should_Check_Out_Movie_By_Name_Test() {
        user.checkOutMovie("The Croods");
        assertFalse(user.getMovies().stream().filter(element -> element.getName() == "The Croods").allMatch(Movie::getStatus));
    }
}
