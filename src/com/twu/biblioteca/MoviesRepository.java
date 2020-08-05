package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class MoviesRepository {
    public static List<Movie> movies = new ArrayList<>();

    static {
        movies.add(new Movie("001", "Charlie and the Chocolate Factory", 2005, "Tim Burton", 8.8));
        movies.add(new Movie("002", "The Croods", 2013, "Kirk DeMicco/Chris Sanders", 9.2));
        movies.add(new Movie("003", "Charlotte's Web", 2006, "Gary Winick", 8.6));
        movies.add(new Movie("004", "Forrest Gump", 1994, "Robert Zemeckis", 9.6));
    }
}
