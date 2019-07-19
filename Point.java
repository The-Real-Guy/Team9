public class Point{
  private int xCoord;
  private int yCoord;

  public Point(int xPos, int yPos){
    xCoord = xPos;
    yCoord = yPos;
  }
  
  public int getXCoord() {
    return xCoord;
  }
  
  public int getYCoord() {
    return yCoord;
  }
  
  public double getDistance(Point other) {
    int otherX = other.getXCoord();
    int otherY = other.getYCoord();
    double deltaXsquared = Math.pow((double)(xcoord - otherX), 2.0);
    double deltaYsquared = Math.pow((double)(ycoord - otherY), 2.0);
    return Math.sqrt(deltaXsquared + deltaYsquared);
  }
  
}
