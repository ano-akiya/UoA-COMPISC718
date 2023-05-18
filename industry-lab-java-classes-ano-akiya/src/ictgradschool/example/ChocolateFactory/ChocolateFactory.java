package ictgradschool.example.ChocolateFactory;

public class ChocolateFactory {
    public static void main(String[] args) {
        ChocolateFactory cf = new ChocolateFactory();
        cf.start();

    }

    private void start() {

        Chocolate moroBar = new Chocolate(1, "Moro bar", 1.50);
        Chocolate snickerBar = new Chocolate(1, "Snickers", 1.80);

        System.out.println();

        snickerBar.print();

        moroBar.print();
        moroBar.setDescription("Moro Bar Delight");
        moroBar.print();

        if(!moroBar.equals(snickerBar)){
            System.out.println(moroBar);
        }
    }
}
