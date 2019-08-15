import java.util.*;

class Main {
  public static void main(String[] args) {
    long[] arr = step(6,0,100);
    System.out.println(arr[0]);
    System.out.println(arr[1]);
  }

    public static long[] step(int g, long m, long n) {
        ArrayList <Long> list = new ArrayList<Long>();
        long[] res  = {0, 0};
        for(long num = m; num <= n; num++){
          if (primeTest(num)) list.add(num);
        }
       // System.out.println(list.size());
        for(int i = 0; i < list.size()-1; i++){
          for(int j = 1; j < list.size() - i; j++){
           // System.out.println(j);
            if (list.get(i+j) - list.get(i) == g) {
             res[0] = list.get(i);
             res[1] = list.get(i+j);
             return res;
            }
          }
        }
        return res;
    }
    
    public static boolean primeTest(long num){
      long n = Math.abs(num);
      if (n == 0 || n == 1){
          return false;
      }
      long e = n % 10;
      if (e == 2 || e == 4 || e == 5 || e == 6 || e == 8 || e == 0){
          return false;
      } 
      double rt = Math.sqrt(n);
      int i = 3;
      while(i <= (int)rt){
           if (n % i == 0 ) {
              return false;
          }
          i+=2;
      }
      return true;
    }
}
