package ictgradschool.industry.io.ex03;

public class Movie {
    
    private String name;
    private int year;
    private int lengthInMinutes;
    private String director;
    
    public Movie(String name, int year, int lengthInMinutes, String director) {
        
        this.name = name;
        this.year = year;
        this.lengthInMinutes = lengthInMinutes;
        this.director = director;
    }
    
    public String toString() {
        return name + " (" + year + "), "
            + lengthInMinutes + " minutes, Director: " + director;
    }
    
    public boolean isOlderThan(Movie other) {
        return year < other.year;
    }
    
    public boolean isMoreRecentThan(Movie other) {
        return year > other.year;
    }
    
    public boolean isShorterThan(Movie other) {
        return lengthInMinutes < other.lengthInMinutes;
    }
    
    public boolean isLongerThan(Movie other) {
        return lengthInMinutes > other.lengthInMinutes;
    }
    
    public boolean equals(Movie other) {
        return name.equals(other.name)
            && year == other.year
            && lengthInMinutes == other.lengthInMinutes
            && director.equals(other.director);
    }
    
    public String getName() {
        return name;
    }
    
    public int getYear() {
        return year;
    }
    
    public int getLengthInMinutes() {
        return lengthInMinutes;
    }
    
    public String getDirector() {
        return director;
    }

}