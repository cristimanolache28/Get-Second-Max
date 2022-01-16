import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SecondMax {
    public static Scanner scanner = new Scanner(System.in);
    public static final int MAX_INTEGER = Integer.MAX_VALUE;
    public static final int MIN_INTEGER = Integer.MIN_VALUE;

    public static void main(String[] args) {
        boolean isRunning = true;
        System.out.print("Input the number of elements for array: ");
        while (isRunning) {
            try {
                int arrayLength = scanner.nextInt();
                setArrayLength(arrayLength);
                isRunning = false;
            } catch (InputMismatchException e) {
                System.out.println("Try again. The array range is between [2 - " + MAX_INTEGER + "] " +
                        "and the value must be of Integer type.");
                scanner.nextLine();
            }
        }
    }

    public static void setArrayLength(int arrayLength) {
        boolean isRunning = true;
        int[] myArray;
        while (isRunning) {
            if (arrayLength > 1) {
                myArray = createArray(arrayLength);
                displayArray(myArray);
               getSecondMax(myArray);
//                System.out.println(getSecondMax(myArray));
                isRunning = false;
            } else {
                System.out.println("The minimum number of elements for array is 2." +
                        "\nPlease, enter a number of element bigger than 1.");
                arrayLength = scanner.nextInt();
            }
        }
    }


    public static int[] createArray(int number) {
        int[] element = new int[number];
        int counter = 0;
        do {
            try {
                System.out.print("Array[" + counter + "] = ");
                element[counter] = scanner.nextInt();
//                if (element[counter] != 0) {
                    counter++;
//                } else {
//                    System.out.println("Zero is a null value. Please, input a value bigger than 0.");
//                    scanner.nextLine();
//                }
            } catch (InputMismatchException e) {
                System.out.println("The number entered is too large!" +
                        "\nPlease enter other number in the range [" + MIN_INTEGER + " and " + MAX_INTEGER + "]");
                scanner.nextLine();
            }
        } while (counter < element.length);
        return element;
    }

    public static void getSecondMax(int[] array) {
        int firstMax = array[0];
        int secondMax = 0;
        int temp;

        Arrays.sort(array);
        System.out.print("\nArray sort is: " + Arrays.toString(array));

        for (int i = 1; i < array.length - 1; i++) {
            if (array[i] > firstMax) {
                secondMax = firstMax;
                firstMax = array[i];

            } else if (array[i] > secondMax) {
                secondMax = array[i];
            }
        }

        System.out.print("\nSECOND MAX: " + secondMax);
    }


    public static int[] displayArray(int[] array) {
        int[] elementsFromArray = array;
        System.out.print("Input: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        return elementsFromArray;
    }

}

//    public static void getSecondMax(int[] array) {
//        int secondMax = 0;
//        boolean isSecondMax  = true;
//
////        int[] sortedArray = sortArray(array);
//        Arrays.sort(array);
//        System.out.print("\nArray sort is: " + Arrays.toString(array));
//
//        for (int i = 0; i < array.length; i++) {
//            for (int k =  0; k < array.length; k++) {
//                if (array[i] > array[k]) {
//                  secondMax = array[k];
//                  isSecondMax = true;
//                }
//            }
//        }
//
//        for (int i = 1; i < array.length; i++){
//            if (array[0] == (array[i]))
//            {
//                isSecondMax = false;
//            }
//        }
//
//        if (isSecondMax) {
//            System.out.println("\nThe second max value is: " + secondMax);
//        } else if (!isSecondMax){
//            System.out.println("\nNo second max value found.");
//        }
//    }



//    public static int[] sortArray(int[] array){
//        int[] sortedArray = new int[array.length];
//        for (int i = 0; i < array.length; i++){
//            sortedArray[i] = array[i];
//        }
//        boolean running = true;
//        int temp;
//        while (running){
//            running = false;
//            for(int i = 0; i < sortedArray.length - 1; i++){
//                if(sortedArray[i] > sortedArray[i + 1]){
//                    temp = sortedArray[i];
//                    sortedArray[i] = sortedArray[i + 1];
//                    sortedArray[i + 1] = temp;
//                    running = true;
//                }
//            }
//        }
//        return sortedArray;
//    }











