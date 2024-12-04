public class RecursiveArray {
    public Integer[] array;

    public RecursiveArray() {
        this.array = new Integer[0];
    }

    public RecursiveArray(String input) {
        if (input.isEmpty()) {
            this.array = new Integer[0]; // Empty array
        } else {
            String[] values = input.split(",");
            this.array = new Integer[values.length];
            fillArray(values, 0);
        }
    }

    // RecursiveArray HELPER
    private void fillArray(String[] values, int index) {
        if (index < values.length) {
            this.array[index] = Integer.parseInt(values[index]);
            fillArray(values, index + 1); // Recursive call for next index
        }
    }

    @Override
    public String toString() {
        return toStringHelper(array, 0);
    }

    // toString HELPER
    private String toStringHelper(Integer[] array, int index) {
        if (array.length == 0) {
            return "Empty Array";
        }
        if (index >= array.length) {
            return "]";
        }
        if (index == 0) {
            return "[" + array[index] + toStringHelper(array, index + 1);
        }
        return "," + array[index] + toStringHelper(array, index + 1);
    }

    public void append(Integer value) {
        Integer[] newArray = new Integer[array.length + 1];
        appendHelper(array, newArray, value, 0);
    }

    // append HELPER
    private void appendHelper(Integer[] oldArray, Integer[] newArray, Integer value, int index) {
        if (index < oldArray.length) {
            newArray[index] = oldArray[index];
            appendHelper(oldArray, newArray, value, index + 1); // Recursive call for next index
        } else {
            newArray[index] = value; // Append the new value at the end
            array = newArray;
        }
    }

    public void prepend(Integer value) {
        Integer[] newArray = new Integer[array.length + 1];
        prependHelper(array, newArray, value, 0);
    }

    // prepend HELPER
    private void prependHelper(Integer[] oldArray, Integer[] newArray, Integer value, int index) {
        if (index < oldArray.length) {
            newArray[index + 1] = oldArray[index];
            prependHelper(oldArray, newArray, value, index + 1); // Recursive call for next index
        } else {
            newArray[0] = value; // Prepend the new value at the beginning
            array = newArray;
        }
    }

    public boolean contains(Integer value) {
        return containsHelper(array, value, 0);
    }

    // contains HELPER
    private boolean containsHelper(Integer[] array, Integer value, int index) {
        if (index >= array.length) {
            return false; // Reached end of array without finding the value
        }
        if (array[index].equals(value)) {
            return true; // Value found
        }
        return containsHelper(array, value, index + 1); // Recursive call to check the next element
    }

    public boolean isAscending() {
        return isAscendingHelper(array, 0);
    }

    // isAscending HELPER
    private boolean isAscendingHelper(Integer[] array, int index) {
        if (index >= array.length - 1) {
            return true; // Reached the end of the array
        }
        if (array[index] > array[index + 1]) {
            return false; // Current element is greater than the next element
        }
        return isAscendingHelper(array, index + 1); // Recursive call to check the next element
    }

    public boolean isDescending() {
        return isDescendingHelper(array, 0);
    }

    // isDescending HELPER
    private boolean isDescendingHelper(Integer[] array, int index) {
        if (index >= array.length - 1) {
            return true; // Reached the end of the array
        }
        if (array[index] < array[index + 1]) {
            return false; // Current element is less than the next element
        }
        return isDescendingHelper(array, index + 1); // Recursive call to check the next element
    }
    
    

//SORT ASCENDING  ------------------------------------------------------------------------------------------------------
    
    
    public void sortAscending() {
        if (array.length > 1) {
            mergeSort(0, array.length - 1);
        }
    }

    private void mergeSort(int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(left, mid); // Sort left half
            mergeSort(mid + 1, right); // Sort right half
            merge(left, mid, right); // Merge the sorted halves
        }
    }

    private void merge(int left, int mid, int right, int i, int j, int k, Integer[] L, Integer[] R) {
        if (i < L.length && j < R.length) {
            if (L[i] <= R[j]) {
                array[k++] = L[i++];
            } else {
                array[k++] = R[j++];
            }
            merge(left, mid, right, i, j, k, L, R);
        } else if (i < L.length) {
            array[k++] = L[i++];
            merge(left, mid, right, i, j, k, L, R);
        } else if (j < R.length) {
            array[k++] = R[j++];
            merge(left, mid, right, i, j, k, L, R);
        }
    }

    private void merge(int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temporary arrays
        Integer[] L = new Integer[n1];
        Integer[] R = new Integer[n2];

        // Copy data to temporary arrays L[] and R[]
        copyArray(array, L, left, 0, n1);
        copyArray(array, R, mid + 1, 0, n2);

        // Merge the temporary arrays back into array[left..right]
        merge(left, mid, right, 0, 0, left, L, R);
    }

    private void copyArray(Integer[] source, Integer[] destination, int sourceStart, int destStart, int length) {
        if (length >= 0) {
            System.arraycopy(source, sourceStart, destination, destStart, length);
        }
    }






//SORT DESCENDING-----------------------------------------------------------------------------------------------------
    public void sortDescending() {
        if (array.length > 1) {
            mergeSortDescending(0, array.length - 1);
        }
    }

    private void mergeSortDescending(int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSortDescending(left, mid); // Sort left half
            mergeSortDescending(mid + 1, right); // Sort right half
            mergeDescending(left, mid, right); // Merge the sorted halves
        }
    }

    private void mergeDescending(int left, int mid, int right, int i, int j, int k, Integer[] L, Integer[] R) {
        if (i < L.length && j < R.length) {
            if (L[i] >= R[j]) {
                array[k++] = L[i++];
            } else {
                array[k++] = R[j++];
            }
            mergeDescending(left, mid, right, i, j, k, L, R);
        } else if (i < L.length) {
            array[k++] = L[i++];
            mergeDescending(left, mid, right, i, j, k, L, R);
        } else if (j < R.length) {
            array[k++] = R[j++];
            mergeDescending(left, mid, right, i, j, k, L, R);
        }
    }

    private void mergeDescending(int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temporary arrays
        Integer[] L = new Integer[n1];
        Integer[] R = new Integer[n2];

        // Copy data to temporary arrays L[] and R[]
        copyArray2(array, L, left, 0, n1);
        copyArray2(array, R, mid + 1, 0, n2);

        // Merge the temporary arrays back into array[left..right]
        mergeDescending(left, mid, right, 0, 0, left, L, R);
    }

    private void copyArray2(Integer[] source, Integer[] destination, int sourceStart, int destStart, int length) {
        if (length >= 0) {
            System.arraycopy(source, sourceStart, destination, destStart, length);
        }
    }
}

//---------------------------------------------------------------------------------------------------------



