package example.EvenUpArray;

public class EvenUpArraySolution {
    public void start(){

        int[] nums = {3, 8, 4, 9, 5, 5, 23, 14};

        // TODO: Print original array to the console
        System.out.print("Original number array: {");
        printArray(nums);
        System.out.println("}");

        // TODO: Modify the array
        nums = evenUp(nums);

        // TODO: Print new array
        System.out.print("New number array: {");
        printArray(nums);
        System.out.println("}");

    }

    /* This method will take an integer array as the input and print each element of the array.
     * It does not return any value.
     */
    private void printArray(int[] values){
        for (int i = 0; i <values.length ; i++) {
            System.out.print(values[i]);
            if(i!=values.length-1){
                System.out.print(", ");
            }
        }

    }

    /* This method will  take an integer array as the input.
     * It will iterate through each element of the array and change all odd values to an even number by adding 1 to the value.
     * It will return the modified array with all even number elements.
     */
    private int[] evenUp(int[] values){
        for (int i = 0; i < values.length; i++) {
            if(values[i]%2 == 1){
                values[i]++;
            }
        }
        return values;
    }

    public static void main(String[] args) {
        EvenUpArraySolution p = new EvenUpArraySolution();
        p.start();
    }
}
