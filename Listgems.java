# Sortingimport java.util.*;
import java.util.Random;

public class Listgems  {

private static int maxN = 10;
private static int n = 0;
private static   gems[] A = new gems[maxN];


public static void displaygems()
{
  for (int i = 0; i < n; i++) {
     System.out.println(i + " " + A[i].getName() + "\t" + A[i].getProfit() + "\t" + A[i].getWeight());
  }
}

public static int randInt(int min, int max) {

    Random rand = new Random();

    int randomNum = rand.nextInt((max - min) + 1) + min;

    return randomNum;
}


public static void shuffle()
{
  for  (int i = 1; i < n; i++) {
     int p = randInt(0, i);
     swap(i, p);
  }    
}
public static void swap(int i, int j)
{
  gems tmp = A[j]; 
  A[j] = A[i];
  A[i] = tmp;
}

public static int findmaxi(int s)
{
  int mx = s;
  for (int i = s; i < n; i++) {
    if (A[i].getProfit() > A[mx].getProfit()) {
      mx = i;
    }
  }
  return mx; 
}

public static int findmini(int s)
{
  int mn = s;
  for (int i = s; i < n; i++) {
    if (A[i].getProfit() < A[mn].getProfit()) {
      mn = i;
    }
  }
  return mn; 
}

public static void selectionsortasc()
{
  for (int i = 0; i < n-1; i++) {
     int mx = findmini(i);
     System.out.println(i + " max index is " + mx);
     swap(i,mx);
  }
  displaygems();
}
public static void selectionsortdes()
{
  for (int i = 0; i < n-1; i++) {
     int mx = findmaxi(i);
     System.out.println(i + " max index is " + mx);
     swap(i,mx);
  }
  displaygems();
}

public static int searchL(int k)
{
  int ix = 0;
   while (A[ix].getProfit() < A[k].getProfit()) {
         ix++;
     }
  return ix;
}
public static void insertintosortL(int k)
{
  gems tmp = A[k]; 
  int ix = searchL(k);
  for (int i = k-1; i >= ix; i--) {
    A[i+1] = A[i];
  }
  
}
public static void insertintosortL2(int k)
{
System.out.println("Homework number 4.1");
}
public static void insertionsort()
{
  for (int i = 1; i < n; i++)  {
     insertintosortL(i);
  }
  displaygems();
}


public static int zoknapsack(int m)
{
  System.out.println("Homework number 5");
  return m;
}

//=================START===================
    /**
     * Sorts the list by weights.
     * @param type 1 for asc, 2 for desc
     */
    public static void sortByWeight(int type){
        //sort the list bu weight and asc order
        for (int i = 0; i < n-1; i++) {
            int mx = i;
            for (int j = i; j < n; j++) {
                if (A[j].getWeight() < A[mx].getWeight()) {
                    mx = j;
                }
            }
            swap(i,mx);
        }
        if(type==2){//if sort by desc order, then swap first with last, second with second to last, and so on
            int num = n/2;
            for(int i=0; i<num; i++){
                swap(i, n-i-1);
            }
        }
    }

    /**
     * Insert an element into an already sorted list by swapping.
     * @param k the index of element to be added
     */
    public static void addtoSortedList(int k){
        if(k>=10){
            System.out.println("Out of range: The max number is: " +maxN);
        }
        /**
         * determine which sorted list is:
         * type=0: order by profit, asc
         * type=1: order by profit, desc
         * type=2: order by weight, asc
         * type=3: order by weight, desc
         * type=-1: not a sorted list
         */
        int type = -1;
        boolean[] flag = new boolean[4];
        for (int i = 0; i < 4; i++) {
            flag[i] = true;
        }
        for (int i = 0; i < n-2; i++) {
            if (A[i].getProfit() > A[i + 1].getProfit()) {
                flag[0] = false;
                break;
            }
        }
        for (int i = 0; i < n-2; i++) {
            if (A[i].getProfit() < A[i + 1].getProfit()) {
                flag[1] = false;
                break;
            }
        }
        for (int i = 0; i < n-2; i++) {
            if (A[i].getWeight() > A[i + 1].getWeight()) {
                flag[2] = false;
                break;
            }
        }
        for (int i = 0; i < n-2; i++) {
            if (A[i].getWeight() < A[i + 1].getWeight()) {
                flag[3] = false;
                break;
            }
        }
        for(int i=0;i<4;i++){
            if(flag[i]){
                type = i;
                break;
            }
        }
        if(type==-1){
            System.out.println("This list is not a sorted list!");
            return;
        }

        switch(type){
            case 0:selectionsortasc();break;
            case 1:selectionsortdes();break;
            case 2:sortByWeight(1);break;
            case 3:sortByWeight(2);break;
            default:
        }
    }
//=================END===================

public static void main(String[] args) {


  A[n] = new gems("sapphire", 5, 7);
  n++;
  A[n] = new gems("amber", 8, 4);
  n++;
  A[n] = new gems("pearl", 12, 8);
  n++;
  A[n] = new gems("emerald", 10, 4);
  n++;
  A[n] = new gems("jade", 3, 3);
  n++;
  A[n] = new gems("opal", 4, 6);
  n++;
  A[n] = new gems("pyrite", 2, 12);
  n++;

  displaygems();
  selectionsortdes();
  A[n] = new gems("diamond", 7, 9);
  n++;
  displaygems();
//  System.out.println(searchL(7));
//  insertintosortL2(7);
//  displaygems();
//  shuffle();
//  displaygems();
//  insertionsort();

    //testing part:
    System.out.println();
    sortByWeight(1);//asc
    displaygems();
    System.out.println();
    sortByWeight(2);//desc
    displaygems();
    System.out.println();
    A[n] = new gems("quartz", 12, 6);
    n++;
    addtoSortedList(8);
    displaygems();
}


}




class gems
{
   private String name;
   private int p;
   private int w;

   public gems(String n, int pr, int wt)
   {
      name = n;
      p = pr;
      w = wt;
   }

   public String getName() {
      return name;
   }
 

   public int getProfit() {
      return p;
   }

   public int getWeight() {
      return w;
   }
}
