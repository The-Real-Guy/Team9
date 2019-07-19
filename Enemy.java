import java.util.Scanner;
import java.util.ArrayList;
/**
 * This class creates an Enemy object that has a starting health.
 * Instance variables:
 * col : int
 * row : int
 * startIndex : int
 * endIndex : int
 * enemyHealth : private int
 * enemyList : ArrayList<Enemy>
 */
public class Enemy extends Map{
   int x = 0;
   int y = 2;
   int startXIndex = 0;
   int startYIndex = 2;
   int endIndex = 4;
   private int enemyHealth;
   ArrayList<Enemy> enemyList = new ArrayList<Enemy>();
  /**
   * Constructor
   * @param enemyHealth
   * @param x
   * @param y
   * 
   */
  public Enemy() {
    
  }
  public Enemy(int enemyHealth) {
     this.enemyHealth = enemyHealth;
     this.x = 0;
     this.y = 2;
  }
  /**
   * Copy Constructor
   * @param toCopy
   */
  public Enemy(Enemy toCopy) {
    enemyHealth = toCopy.enemyHealth;
    x = toCopy.x;
    y = toCopy.y;
  }
  /**
   * getter method that returns the x coordinate of the specified enemy.
   * @param grid
   * @param anEnemy
   * @return x: int
   */
  
  public int getXCoord() {
    return x;
  }
  
  /**
   * getter method that returns the y coordinate of the specified enemy.
   * @param grid
   * @param anEnemy
   * @return y: int
   */
  
  public int getYCoord() {
    return y;
  }
  
  /**
   * A getter method that returns the health of specified enemy
   * @return enemyHealth: int
   */
  public int getEnemyHealth() {
    return enemyHealth;
  }

  /**
   * A getter method that returns the list of enemies for a specified wave.
   * @return enemyList: ArrayList<Enemy>
   */
  public ArrayList<Enemy> getEnemyList() {
    ArrayList<Enemy> anEnemyList = new ArrayList<Enemy>();
    for (Enemy anEnemy : enemyList) {
      anEnemyList.add(new Enemy(anEnemy));
    }
    return enemyList;
  }
  /**
   * A method adding enemies into an array list.
   * @param anEnemy
   */
  public void addEnemy(Enemy anEnemy) {
    enemyList.add(new Enemy(anEnemy));
  }
  /**
   * Returns health of specified enemy as a string.
   * @param anEnemy
   * @return health: String
   */
  public String healthToString(Enemy anEnemy) {
    String eHealth = Integer.toString(anEnemy.getEnemyHealth());
    return eHealth;
  }
  /**
   * function takeDamage has enemy take damage from tower.
   * @param damage
   * 
   */
  public void takeDamage(int damage) {
    this.enemyHealth -= damage;
  }
  /**
   * a method that generates a new enemy and places it on a grid
   * @param grid
   * @param anEnemy
   * @return grid : String[][]
   */
  public void generateEnemy(String[][] grid,Enemy anEnemy) {
    System.out.println("ENEMY HAS ARRIVED");
    for (int r = 0; r < grid.length; r++) {
      for (int c = 0; c < grid[r].length; c++) {
        if (grid[startXIndex][2] == "-") {
          grid[x][y] = healthToString(anEnemy);
        }
      }
    }
  }
  /**
   * a single move method for the specified enemy.
   * @param grid
   * @param anEnemy
   */

  public void moveEnemy(String[][] grid,Enemy anEnemy) {
    this.x = this.getXCoord();
    for (int r = 0; r < grid.length; r++) {
      for (int c = 0; c < grid[r].length; c++) {
        if((this.x+1) < 5) {
          grid[this.x+1][2] = healthToString(anEnemy);
          grid[this.x][2] = "-";
        } 
        else if ((x+1) == grid[r].length) {
          grid[x][2] = "-";
          break;
        }
      }
    }
    this.x += 1;
  }
   
  /**
   * using moveEnemy method, this function will take the enemy from
   * startIndex to endIndex
   * @param anEnemy
   * @param aMap
   * @param grid
   * @param input
   * 
   */
  public void enemyWave1(Enemy anEnemy,Map aMap, String[][]grid, Scanner input,Defender aDefense) {
    String enter = input.nextLine();
    System.out.println("W A V E  1");
    while (enter != "no") {
      
      anEnemy.moveEnemy(grid,anEnemy); 
      //aDefense.attack(anEnemy,grid);
      printGrid(grid);
      System.out.println("Press Enter");
      enter = input.nextLine();
    }
  }
}

