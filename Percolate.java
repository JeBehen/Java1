// Percolate.Java
// J.Behen

public class Percolate {
  public static void main(String[] args) {
    int[] dataSeq = {8, 4, 6, 2, 1};
    
    // Write array before prcolation
    printIntArray(dataSeq);
    
    //Percolate
    for (int index = 1; index < dataSeq[index]; ++index)
      if (dataSeq[index-1] > dataSeq[index])
        swap(dataSeq, index-1, index);
        
        //Write array after percolation
        printIntArray(dataSeq);
  }
  public static void swap(int[] intArray, int i, int j) {
    int tmp = intArray[i]; intArray[i] = intArray[j]; intArray[j] = tmp;    
  }
  
  public static void swap(int v1, int v2) {  
    int tmp = v1; v1 = v2; v2 = tmp;  
  }
  
  public static void printIntArray(int[] array) {
    for (int value : array)
      System.out.println(" " + array);
    System.out.println();  
  }
  
}