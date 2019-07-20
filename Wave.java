import java.util.Scanner;

public class Wave{
  
  public Wave() {
    
  }
  
//////////////ENEMY WAVE METHODS //////////////////
  
  public void enemyWave(Enemy anEnemy,Player aPlayer, Map aMap, String[][]grid,Scanner input, String enter,Defender aDefense) {
    while (anEnemy.getXCoord() != 6) {
      anEnemy.moveRight(grid,anEnemy); 
      anEnemy.attack(aMap, aPlayer, anEnemy);

      aDefense.attack(aPlayer,anEnemy,grid);
      aMap.printGrid(grid);
      
      
      aPlayer.checkIfPlayerKilled();
      if(aDefense.selection(input).equals("P")) {
        aDefense.generateTower(grid);
      } else {
        continue;
      }
      enter = input.nextLine();
    }
  }
  /**
  * Enemy wave function
  * @param anEnemy
  * @param aMap
  * @param grid
  * @param input
  * @param aDefense
  * 
  */
  public void wave1(Player aPlayer, Map aMap, String[][]grid,Defender aDefense,Scanner input) {
    System.out.println("\n\nW A V E  1\n\n");
    Enemy e1 = new Enemy(10,1,10);
    e1.generateEnemy(grid, e1);
    aMap.printGrid(grid);
    String enter = input.nextLine();
    enemyWave(e1,aPlayer,aMap,grid,input,enter,aDefense);
    System.out.println("\nE N D  O F  W A V E  1\n\n");
  }
  /**
  * Enemy wave function
  * @param Player
  * @param aMap
  * @param grid
  * @param input
  * @param aDefense
  * 
  */
  public void wave2(Player aPlayer, Map aMap, String[][]grid,Defender aDefense,Scanner input) {
    System.out.println("\n\nW A V E  2\n\n");
    Enemy e1 = new Enemy(10,1,10);
    e1.generateEnemy(grid,e1);
    aMap.printGrid(grid);
    String enter = input.nextLine();
    enemyWave(e1,aPlayer,aMap,grid,input,enter,aDefense);
    Enemy e2 = new Enemy(5,1,10);
    e2.generateEnemy(grid,e2);
    enemyWave(e2,aPlayer,aMap,grid,input,enter,aDefense);
    System.out.println("\nE N D  O F  W A V E  2\n\n");
  }
  /**
  * Enemy wave function
  * @param Player
  * @param aMap
  * @param grid
  * @param input
  * @param aDefense
  * 
  */
  public void wave3(Player aPlayer, Map aMap, String[][]grid,Defender aDefense,Scanner input) {
    System.out.println("\n\nW A V E  3\n\n");
    Enemy e1 = new Enemy(10,1,10);
    e1.generateEnemy(grid,e1);
    aMap.printGrid(grid);
    String enter = input.nextLine();
    enemyWave(e1,aPlayer,aMap,grid,input,enter,aDefense);
    Enemy e2 = new Enemy(10,1,10);
    e2.generateEnemy(grid,e2);
    enemyWave(e2,aPlayer,aMap,grid,input,enter,aDefense);
    Enemy e3 = new Enemy(10,1,10);
    e3.generateEnemy(grid,e3);
    enemyWave(e3,aPlayer,aMap,grid,input,enter,aDefense);
    System.out.println("\nE N D  O F  W A V E  3\n\n");
  }
}