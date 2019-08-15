import java.util.ArrayList;
import java.awt.Point;
import java.util.Map;
import java.util.HashMap;

class Main {
  static public final Map<Double, String> Statuses = new HashMap<Double, String>()
  {
    {
        put(-1.,"notTouched");
        put(0.5,"damaged");
        put(1., "sunk");
    }
  };
  
  private static class Ship {
    
    private int shipNo;
    private int shipCondition;
    private ArrayList<Point> loc = new ArrayList<Point>();
    private ArrayList<Point> hits = new ArrayList<Point>();
    public Ship(int n){
      this.shipNo = n;
    }
    public void setLocPoint(int xx, int yy){
      loc.add(new Point(xx, yy));
    }
    public void setHit(int xx, int yy){
      hits.add(new Point(xx, yy));
    }
    public int getShipNo(){
      return this.shipNo;
    }
    public double getShipStatus(){
      int status = 0; 
      for(Point pt : this.loc){
        if (this.hits.contains(pt)) status += 1;
      }
      if ( status == 0 ) return -1.;
      if ( status > 0 && status < this.loc.size()) return 0.5;
      return 1.;
    }
  }
  
  public static void main(String[] args) {
    int[][] attacks = new int[][] 
            {new int[] {2,1},new int[] {2,2},new int[] {3,2},new int[] {3,3}};
            
    int[][] board   = new int[][] {new int[] {3, 0, 1},
                                   new int[] {3, 0, 1},
                                   new int[] {0, 2, 1},
                                   new int[] {0, 2, 0}};
    int shipCounter = 0;
    for(int yy = board.length-1; yy >= 0; yy--){
      for(int xx = board[yy].length - 1; xx >= 0 ; xx--){
        shipCounter = Math.max(board[yy][xx], shipCounter);
      }
    }
    
    Ship[] ships = new Ship[shipCounter];
    for(int ss = 0; ss < ships.length; ss++){
      ships[ss] = new Ship(ss+1);
    }
    
    for(int yy = board.length-1; yy >= 0; yy--){
      for(int xx =board[yy].length - 1; xx >= 0 ; xx--){
        for(Ship sh : ships){
          if(board[yy][xx] == sh.getShipNo()) 
              sh.setLocPoint(xx+1, board.length - yy); //x is normal and y is upside-down
        }
      }
    }
    
    for(int atkn = 0; atkn < attacks.length; atkn++){
        for(Ship sh : ships){
          sh.setHit(attacks[atkn][0], attacks[atkn][1]);
        }
    }
    
    Map<String,Double> expected = new HashMap<String,Double>();
    for(Map.Entry<Double, String> entry : Statuses.entrySet()) {
      Double status = entry.getKey();
      String descr = entry.getValue();
      Double statusCounter = 0.;
      for(Ship sh : ships){
        if (status == sh.getShipStatus()) statusCounter+=1.;
      }
      expected.put(descr, statusCounter);
    }
    
    
  
    double points = 0.;
    for(Ship sh : ships){
      points += sh.getShipStatus();
    }
    expected.put("points", points);
    
    System.out.println(expected.toString());
    
  }
}