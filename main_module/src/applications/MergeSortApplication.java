package applications;

public class MergeSortApplication {

    public static void main(String[] args) {

        int[] inputArray = new int[]{8, 1, 10, 2};
        System.out.println("Before Sort");
        printArray(inputArray);

        mergeSort(inputArray);
        System.out.println("After Sort");
        printArray(inputArray);
    }
    public static void mergeSort(int[] inputArray){
        int inputLength = inputArray.length;
        if(inputLength < 2){
            return;
        }
        int midIndex = inputLength / 2;

        int[] rightHalf = new int[midIndex];
        int[] leftHalf = new int[inputLength - midIndex];

        // initialize rightHalf array
        for(int i=0; i<midIndex; i++){
            rightHalf[i] = inputArray[i];
        }

        // initialize leftHalf array
        for(int j=midIndex; j<inputLength; j++){
            int leftHalfIndex = j - midIndex;
            leftHalf[leftHalfIndex] = inputArray[j];
        }

        mergeSort(rightHalf);
        mergeSort(leftHalf);

        merge(inputArray, leftHalf, rightHalf);
    }

    private static void merge(int[] inputArray, int[] leftHalf, int[] rightHalf){
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;

        int i=0;
        int j=0;
        int k=0;
        while (i<leftSize && j<rightSize){
            int leftElement = leftHalf[i];
            int rightElement = rightHalf[j];
            if(leftElement <= rightElement){
                inputArray[k] = leftElement;
                i = i + 1;
            }
            else{
                inputArray[k] = rightElement;
                j = j + 1;
            }
            k = k + 1;
        }

        while (i < leftSize){
            inputArray[k] = leftHalf[i];
            i = i + 1;
            k = k + 1;
        }

        while (j < rightSize){
            inputArray[k] = rightHalf[j];
            j = j + 1;
            k = k + 1;
        }
    }

    private static void printArray(int[] array){
        for(int i=0; i<array.length; i++){
            System.out.println(array[i]);
        }
    }
}
