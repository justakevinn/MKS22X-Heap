import java.util.*;

//Thanks to Jackson Zou for catching me up
public class MyHeap{

  private static void swap(int[]data, int a, int b) {
  int x = data[a];
  data[a] = data[b];
  data[b] = x;
}

  //We discussed these 2 methods already:
  private static void pushDown(int[]data,int size,int index){
    //System.out.println("Index: "+ index);
    //System.out.println("Size: " + size);
    int c1 = (2*index) +1;
    int c2 = (2*index) +2;
    if (c1 >= size){
      return;
    }

    int bigC = c1;
    if (c2 < size){
      if (data[c1] <= data[c2]){
        bigC = c2;
      }
    }                  //sets bigC to the index of the bigger child
  //  System.out.println("bigC: " + bigC);
    if (data[index] > data[bigC]){
      return;
    }
    else{
      swap(data, bigC, index);
      pushDown(data, size, bigC);
    }
  }
  private static void pushUp(int[]data,int index){
    int p = (index-1)/2;
    if (data[p] > data[index] || index == 0 ){
      return;
    }
    else{
      swap(data, p, index);
      pushUp(data, p);
    }
  }

  public static void heapify(int[] data){
     for (int x = data.length/2; x >= 0; x--){
       pushDown(data, data.length, x);
     }
  }



  public static void heapsort(int[] data) {
      int size = data.length;
      heapify(data);
    //  System.out.println(Arrays.toString(data));
      while (size > 0) {
        int large = data[0];
        data[0] = data[size - 1];
        data[size - 1] = large;
        size--;
        pushDown(data,size,0);
      //  System.out.println(Arrays.toString(data));
      }
    }


  public static void main(String[] args){
    int[] ary = {1, 2, 5, 2, 7, 31, 7, 12, 6, 1, 6};
    heapify(ary);
    System.out.println(ary);
    heapsort(ary);
    System.out.println(ary);
  }
/*


  //We will discuss this today:

      - convert the array into a valid heap. [ should be O(n) ]


      - sort the array by converting it into a heap then removing the largest value n-1 times. [ should be O(nlogn) ]

*/

}
