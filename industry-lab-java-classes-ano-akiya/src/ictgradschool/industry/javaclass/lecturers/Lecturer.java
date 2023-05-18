package ictgradschool.industry.javaclass.lecturers;

public class Lecturer {

    // instance variables
    private String name;
    private int staffId;
    private String[] papers;
    private boolean onLeave;
    
    public Lecturer(String name, int staffId, String[] papers, boolean onLeave)
    {
        // TODO Complete this constructor method
        this.name = name;
        this.staffId = staffId;
        this.papers = papers;
        this.onLeave = onLeave;
    }
    
    // TODO Insert getName() method here
    public String getName()
    {
        return name;
    }
    
    // TODO Insert setName() method here
    public void setName(String name)
    {
        this.name = name;
    }
    
    // TODO Insert getStaffId() method here
    public int getStaffId()
    {
        return staffId;
    }
    
    // TODO Insert setStaffId() method here
    public void setStaffId(int staffId)
    {
        this.staffId = staffId;
    }

    // TODO Insert getPapers() method here
    public String[] getPapers()
    {
        return papers;
    }

    // TODO Insert setPapers() method here
    public  void setPapers(String[] papers)
    {
        this.papers = papers;
    }
    
    // TODO Insert isOnLeave() method here
    public boolean isOnLeave()
    {
        return onLeave;
    }
    
    // TODO Insert setOnLeave() method here
    public void setOnLeave(boolean onLeave)
    {
        this.onLeave = onLeave;
    }

    // TODO Insert toString() method here
    public String toString()
    {
        String output = "";
        output = "id: " + String.valueOf(staffId) + " " + name + " is teaching " + String.valueOf(papers.length) + " papers";

        return output;
    }
    
    // TODO Insert teachesMorePapersThan() method here
    public boolean teachesMorePapersThan(Lecturer other)
    {
        if (this.papers.length > other.papers.length)
        {
            return true;
        }
        else
            return false;
    }

}


