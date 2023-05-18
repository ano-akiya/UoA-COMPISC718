package ictgradschool.industry.javaclass.mobilephones;

public class DisplayMobilePrices {

    public void start() {
        MobilePhone jonathansPhone = new MobilePhone("Apple", "iPhone 4", 899.95);
        MobilePhone annsPhone = new MobilePhone("LG", "Optimus-P970",699.95);
        MobilePhone adrianasPhone = new MobilePhone("Nokia", "N97", 599.55);
        MobilePhone alastairsPhone = new MobilePhone("Sumsung", "Galaxy", 599.95);
        
        printDescriptions(jonathansPhone, annsPhone, adrianasPhone, alastairsPhone);

        // TODO Uncomment these lines once you've implemented the corresponding MobilePhone methods.
        alastairsPhone.setBrand(new String ("Apple"));
        alastairsPhone.setModel(new String ("iPhone 4"));
        alastairsPhone.setPrice(899.95);
        
        printNewPurchase("Alastair", alastairsPhone);
        
        comparePhones(jonathansPhone, annsPhone, adrianasPhone, alastairsPhone);
    }
    
    private void printDescriptions(MobilePhone jonathansPhone, MobilePhone annsPhone,
                                   MobilePhone adrianasPhone, MobilePhone alastairsPhone) {
        System.out.println("Jonathan has an " + jonathansPhone.toString());
        System.out.println("Ann has an " + annsPhone.toString());
        System.out.println("Adriana has a " + adrianasPhone.toString());
        System.out.println("Alastair has a " + alastairsPhone.toString());
    }
    
    private void printNewPurchase(String name, MobilePhone phone) {
        // TODO Uncomment this line once you've implemented the corresponding MobilePhone methods.
         System.out.println(name + " has now purchased a new " + phone.getBrand() + " " + phone.getModel() + " for $" + phone.getPrice());
    }
    
    private void comparePhones(MobilePhone jonathansPhone, MobilePhone annsPhone,
                               MobilePhone adrianasPhone, MobilePhone alastairsPhone) {
        
        if (alastairsPhone.equals(annsPhone)) {
            System.out.println("Alastair has the same type as Ann");
        }
        if (annsPhone.equals(adrianasPhone)) {
            System.out.println("Adriana has the same type as Ann");
        }
        if (alastairsPhone.equals(jonathansPhone)) {
            System.out.println("Alastair has the same type as Jonathan");
        }

        // TODO Uncomment these lines once you've implemented the corresponding MobilePhone methods.
        if (annsPhone.isCheaperThan(adrianasPhone)) {
            System.out.println("Ann wants a new phone");
        } else {
           System.out.println("Adriana wants a new phone");
        }
    }

    public static void main(String[] args) {
        DisplayMobilePrices dmp = new DisplayMobilePrices();
        dmp.start();
    }
}
