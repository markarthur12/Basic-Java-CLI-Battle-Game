package markGabiana;

import java.util.*;

public class SpaceJam {
	
	//player
	//public static String player;
	//public static String playerType;
	
	public static Player player = new Player();
	
	public static int level;
	public static int life;
	public static int experience;
	public static int damage;

	//enemy
	public static int enemyLevel;
	public static int enemyLife;
	public static int enemyDamage;
	
	public static boolean battling;
	
	public static Scanner input = new Scanner(System.in);
	
	private static void loadPlayer(int Lev, int Lif, int Exp, int Dam)
	{
		level = Lev;
		life = Lif;
		experience = Exp;
		damage = Dam;
		
		System.out.println("Your Level = " + level + " | Life = " + life + " | Experience = " + experience  + " | Damage = " + damage);
	}
	
	private static void loadEnemy(int enemyLev, int enemyLif, int enemyDam)
	{
		enemyLevel = enemyLev;
		enemyLife = enemyLif;
		enemyDamage = enemyDam;
		
		System.out.println("ENEMY - Level = " + enemyLevel + " | Life = " + enemyLife + " | Damage = " + enemyDamage);
	
		switch (enemyLevel) {
		
		case 1:
			System.out.println("Level 1 Enemy");
			battle();
			break;
			
		case 2:
			System.out.println("Level 2 Enemy");
			battle();
			break;
			
		case 3:
			System.out.println("Level 3 Enemy");
			battle();
			break;
			
		 default:
			  System.out.println("No levels.");

			  break;
		}	
	}
	
	private static int random(int max)
	{
		Random rn = new Random();
		int answer = rn.nextInt(max) + 1;
		return answer;
	}
	
	private static void enemyAttack()
	{
		int randomDamage = random(10);
		System.out.println("Enemy attacking with " + randomDamage + " damage");
		if(randomDamage > 3)
		{
            System.out.println("Hit!");
            
            life = life - randomDamage;
            
            System.out.println(player.getPlayer() + " Life = " + life);
            
            if(life <= 0)
            {
                System.out.println("GAME OVER!");
                experience = 0;
                battling = false;
            }
        }
		else
        {
            System.out.println("try again to hit!");
        }
	}
	
	private static void playerAttack()
	{
		int randomDamage = random(10);
		System.out.println(player.getPlayer() + " attacking with " + randomDamage + " damage");
		if(randomDamage > 3)
		{
            System.out.println("Bang! Smash hit!");
            
            enemyLife = enemyLife - randomDamage;
            
            System.out.println("Enemy Life = " + enemyLife);
            
            if(enemyLife <= 0)
            {
                System.out.println("Enemy defeated! " + player.getPlayer() + " you won!");
                experience = experience + 10;
                battling = false;
            }
        }
		else
        {
            System.out.println("try again to hit!");
        }
	}
	
	private static void battle()
	{
		String attack;
		battling = true;
		
		while (battling)
		{
			System.out.println("Press a to attack...");
			attack = input.next();
			
			switch (attack) {
			
			case "a":
				System.out.println("Attacking...");
				playerAttack();
				break;
				
			 default:
				  System.out.println("Unable to attack.");
				  battling = false;
				  break;
			}			
			
			enemyAttack();
			
		}
		
		System.out.println("Battle completed...");
		System.out.println(player.getPlayer() + " you gained experience of " + experience);
		playerLevel();
	}
	
	private static void playerLevel() 
	{
		if(experience >= 10)
		{
			level = 2;
		}
		else if(experience >= 20)
		{
			level = 3;
		}
		else if(experience >= 30)
		{
			level = 4;
		}
		else if(experience >= 40)
		{
			level = 5;
		}
		
		System.out.println("Your Level = " + level + " | Life = " + life + " | Experience = " + experience  + " | Damage = " + damage);
	}
	
	public static void main(String[] args) {
		
		System.out.println("Bam! Welcome to Space Jam!");
		
		System.out.println("Please enter character name: ");
		player.setPlayer(input.next());
		
		System.out.println("Hello! " + player.getPlayer());
		
		System.out.println("Please choose a player type: ");
		System.out.println("Press 1 for BUNNY");
		System.out.println("Press 2 for DUCK");
		System.out.println("Press 3 for CAT ");
		player.setPlayerType(input.next());
		
		switch(player.getPlayerType()) {
		  case "1":
			  System.out.println(player.getPlayer() + " you selected BUNNY character! Whats up doc! ");
			  loadPlayer(0, 100, 0, 10);
			  
		    break;
		  case "2":
			  System.out.println(player.getPlayer() + " you selected DUCK character! quack quack! ");
			  loadPlayer(0, 100, 0, 9);
			  
		    break;		    
		  case "3":
			  System.out.println(player.getPlayer() + " you selected CAT character! Meow! ");
			  loadPlayer(0, 100, 0, 8);
			  
			 break;
			    
		  default:
			  System.out.println(player.getPlayer() + " you did not select the correct choices!");
			  break;
		}
		
		
		System.out.println("\n******Let's start playing! ******");
		System.out.println("\nEnemy approaching!");
		
		loadEnemy(1, 25, 5);
		loadEnemy(2, 35, 8);
		loadEnemy(3, 50, 10);
	}

}
