public class MyHeap{

  private static void swap(int[]data, int a, int b) {
  int x = data[a];
  data[a] = data[b];
  data[b] = x;
}

  //We discussed these 2 methods already:
  private static void pushDown(int[]data,int size,int index){
    int c1 = (2*index) +1;
    int c2 = (2*index) +2;
    if (c1 > size){
      return;
    }

    int bigC = c1;
    if (c2 <= size){
      if (data[c1] <= data[c2]){
        bigC = c2;
      }
    }                  //sets bigC to the index of the bigger child

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

  public static void heapify(int[]){  
  }

/*


  //We will discuss this today:

      - convert the array into a valid heap. [ should be O(n) ]

  public static void heapsort(int[])
      - sort the array by converting it into a heap then removing the largest value n-1 times. [ should be O(nlogn) ]

*/

}
