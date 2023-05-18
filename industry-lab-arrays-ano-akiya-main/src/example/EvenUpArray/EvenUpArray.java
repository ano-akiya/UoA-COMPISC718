package example.EvenUpArray;

public class EvenUpArray {
    public void start(){

        int[] nums = {3, 8, 4, 9, 5, 5, 23, 14};
        // Write codes here
        System.out.print("Original number array: ");
        // TODO: Print original array to the console


        // TODO: Modify the array


        System.out.println();
        System.out.print("New number array: ");
        // TODO: Print new array


    }

    private int[] evenUp(int[] values){
        // Write codes here

        return null;
    }

    private void printArray(int[] values){
        for(int i = 0; i < values.length; i++){
            if(i == values.length -1){
                System.out.println(values[i] );
            } else {
                System.out.print(values[i] + ", ");
            }
        }


    }

    public static void main(String[] args) {
        EvenUpArray p = new EvenUpArray();
        p.start();
    }
}
