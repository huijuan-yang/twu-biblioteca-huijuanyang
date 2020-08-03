package com.twu.biblioteca;


import org.junit.Test;

import java.util.List;

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
    }

    @Test
    public void should_Check_Out_Book_By_Isbn_Test() {
        user.checkOutBook("00000");
        assertEquals(user.showAllBooks().size() - 1, user.showAllAvailableBooks().size());
    }

    @Test
    public void should_Return_Message_When_Check_Out_Successful_Test() {
        String successfulResult = user.checkOutBook("00000");
        assertEquals("Thank you! Enjoy the book!", successfulResult);
    }

    @Test
    public void should_Return_Error_Message_When_Check_Out_Failed_Test() {
        String failedRusult = user.checkOutBook("abcdefg");
        assertEquals("Sorry, that book is not available.", failedRusult);
    }

    @Test
    public void should_Return_Book_By_Isbn_Test() {
        user.returnBook("00000");
        assertEquals(user.showAllBooks().size(), user.showAllAvailableBooks().size());
    }

    @Test
    public void should_Return_Message_When_Return_Successful_Test() {
        String successfulResult = user.returnBook("00000");
        assertEquals("Thank you for returning the book!", successfulResult);
    }

    @Test
    public void should_Return_Error_Message_When_Return_Failed_Test() {
        String failedResult = user.returnBook("abcdefg");
        assertEquals("That is not a valid book to return.", failedResult);
    }

    @Test
    public void should_Show_All_Available_Movies_Test() {
        List<Movie> availableMoviesList = user.showAllAvailableMovies();
        assertNotNull(user.showAllAvailableMovies());
        assertTrue(availableMoviesList.stream().allMatch(Movie::getStatus));
    }

    @Test
    public  void should_Check_Out_Movie_By_Name_Test() {
        user.checkOutMovie("The Croods");
        assertEquals(3, user.showAllAvailableMovies().size());
    }
}
