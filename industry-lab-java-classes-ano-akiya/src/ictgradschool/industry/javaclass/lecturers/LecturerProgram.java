package ictgradschool.industry.javaclass.lecturers;

public class LecturerProgram {

    public void start() {
        Lecturer[] lecturers = createLecturersArray();
        printLecturers(lecturers);
        printOnLeaveList(lecturers);
        updateLecturerDetails(lecturers[1]);
        printNewLecturerDetails(lecturers[1], 1);
        Lecturer lecturerWithMostPapers = getLecturerWithMostPapers(lecturers);
        printLecturerWithMostPapers(lecturerWithMostPapers);
    }
    
    private Lecturer[] createLecturersArray() {
        String[] noPapers = {};
        String[] introductoryPapers = {"CompSci101", "CompSci111"};
        String[] coreStage1Papers = {"CompSci101", "CompSci105"};
        String[] allStageOnePapers = {"CompSci111", "CompSci101", "CompSci105"};
        String[] stageTwoPapers = {"CompSci210", "CompSci220", "CompSci225", "CompSci230"};
        Lecturer[] lecturers = new Lecturer[6];
        lecturers[0] = new Lecturer("Sad Sack", 86302, introductoryPapers, false);
        lecturers[1] = new Lecturer("Ali Katt", 49123, introductoryPapers, false);
        lecturers[2] = new Lecturer("Earl Lee Riser", 40879, allStageOnePapers, true);
        lecturers[3] = new Lecturer("Candy Kane", 50876, stageTwoPapers, false);
        lecturers[4] = new Lecturer("Tom Katt", 30869, noPapers, false);
        lecturers[5] = new Lecturer("Carrie Oakey", 30987, coreStage1Papers, true);
        return lecturers;
        
    }
    
    private void printLecturers(Lecturer[] lecturers) {
        System.out.println("Current Lecturers");
        System.out.println("-----------------");
        for (int i = 0; i < lecturers.length; i++) {
            System.out.print(i + 1 + ".  ");
            System.out.println(lecturers[i].toString());
        }
    }
    
    private void printOnLeaveList(Lecturer[] lecturers) {
        System.out.println();
        System.out.println("Lecturers Currently on Leave");
        System.out.println("----------------------------");
        for (int i = 0; i < lecturers.length; i++) {
            // TODO Uncomment these lines once you've implemented the corresponding Lecturer methods.
            if (lecturers[i].isOnLeave() == true) {
                System.out.println(lecturers[i].getName());
            }
        }
    }
    

    private void updateLecturerDetails(Lecturer lecturer) {
        // TODO Uncomment these lines once you've implemented the corresponding Lecturer methods.
        lecturer.setName("Crystal Ball");
        lecturer.setStaffId(23456);
        String[] coreStage1Papers = {"CompSci101", "CompSci105"};
        lecturer.setPapers(coreStage1Papers);
        lecturer.setOnLeave(true);
    }
    
    private void printNewLecturerDetails(Lecturer lecturer, int number) {
        System.out.println();
        System.out.println("Updated details for changed lecturer number " + (number + 1));
        System.out.println("---------------------------------------------");
        // TODO Uncomment these lines once you've implemented the corresponding Lecturer methods.
        System.out.println("Name: " + lecturer.getName());
        System.out.println("Id: " + lecturer.getStaffId());
        String[] papers = lecturer.getPapers();
        System.out.print("Papers: ");
        if (papers.length > 0) {
            for (int i = 0; i < papers.length; i++) {
                System.out.print(papers[i] + " ");
            }
        } else {
            System.out.print("None");
        }
        System.out.println();
        if (lecturer.isOnLeave()) {
            System.out.println("Currently on leave");
        }
    }
    
    private Lecturer getLecturerWithMostPapers(Lecturer[] lecturers) {
        Lecturer lecturerWithMostPapersSoFar = lecturers[0];
        for (int i = 0; i < lecturers.length; i++) {
            // TODO Uncomment these lines once you've implemented the corresponding Lecturer methods.
            if (lecturers[i].teachesMorePapersThan(lecturerWithMostPapersSoFar)) {
                lecturerWithMostPapersSoFar = lecturers[i];
            }
        }
        return lecturerWithMostPapersSoFar;
    }
    
    private void printLecturerWithMostPapers(Lecturer lecturerWithMostPapers) {
        System.out.println();
        System.out.println("Most papers");
        System.out.println("-----------");
        // TODO Uncomment these lines once you've implemented the corresponding Lecturer methods.
        System.out.println(lecturerWithMostPapers.getName() + " teaches more papers than any other lecturer.");
    }

    public static void main(String[] args) {
        new LecturerProgram().start();
    }

}
