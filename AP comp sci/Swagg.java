//Sunil Narayan
//Period D

//WARNING
//Some monolouges may require the terminal window to be expanded to encompas the full speech
//Keeping the terminal window at roughly 1/2 the size of your moniter should be large enough
//If you die, you must recompile the program before restarting (otherwise your health will remain 0)
//I strongly advise reading all of the text that pops up in the terminal window (espeicaly the monolouges/story development!)
//I WOULD ALSO ADVISE TRYING TO FIND ALL 3 ENDINGS!! (Recompile after each wingame)
import javax.swing.JOptionPane;

public class Swagg {
    //These variables are used throughout the entire program. As you can see, many of them are booleans. This is because fo the contidions that must chance to accomidate the changing conditions of quests, and other intermethod variables.
    static String weapon = "hands";
    static String pickup;
    static double maxHealth = 200;
    static double health = 200;
    static String opponent;
    static boolean champion = false;
    static boolean wina = false;
    static boolean winb = false;
    static boolean winc = false;
    static double attack;
    static double pattack;
    static double tattack;
    static double defence;
    static double ap;
    static double opattack;
    static double oppattack;
    static double optattack;
    static double opdefence;
    static double ophealth;
    static boolean kingdead = false;
    static boolean guarddead = false;
    static boolean darkquest = false;
    static boolean Bajajdead = false;
    static int potions = 3;
    /**
     * This is a helper method so I don't have to type JOptionPane all the time.
     */
    public static String q(String m) {
        String s = JOptionPane.showInputDialog(m);
        return s;
    }

    /**
     * This helper method shortens showMessageDialog a bit
     */
    public static void m(String s) {
        JOptionPane.showMessageDialog(null, s);
    }
    //This is where the journy starts, and some hints on how to play
    public static void start() {
        String choice = q("Hello, and welcome to the Quest of Unrelenting Brightness Ordained (QUBO)\nBefore you start, here are some tips...\n1. If you die or win, and want to play again, you MUST rcompile the program\n" +
                "2. When fighting, standard attacks beat counter-attacks, power attacks beat standard attacks, and counter-attacks beat power attacks (your opponent also has all 3 types of attacks, so try to beat their attack when possible, however, they can get critical hits too!)\n" +
                "3. If you win, I encourage you to try again with diffrent choices, to discover more of the story\n4. If you are hit while healing, it does twice as much damage, so healing is a big gamble\n5. Think before you enter a fight, as you can not flee after the fight has begun\n 6. You may need to expand the terminal window to fit some of the text\nGood Luck!\nPress 'a' then enter to continue...\n");
        if (choice.equals("a")) {
            poststart ();
        }
    }

    /**
     *Here is where you choose your weapon and get a small amount of backstory
     * 
     */
    public static void poststart() {
        String choice = q("You are in the kingdom of Kulkarni\n"+
                "The kingdom has been peaceful for years, but now many have sensed a dark presence growing in the kingdom of Kulkarni\n"+
                "select a weapon to use" + "\na) Sword, a standard weapon useful for battling other humanoids (Attack 45, defence 7, armor penetration 0)" + "\nb) Axe, used to rip through armor (Attack 50, defence 1, armor penetration 15)" + 
                "\nc) Spear, which can stab at a distance (Attack 35, defence 5, armor penetration 11)\nd) BE HARDCORE and use your hands (Attack 35, defence 0, armor penetration 0)\n");
        if (choice.equals("a")) {
            weapon = "sword"; place();
        } else if (choice.equals("b")) {
            weapon = "axe"; place();
        } else if (choice.equals("c")) {
            weapon = "spear"; place();
        }  else if (choice.equals("d")) {
            place();
        }
    }
    //This is the main hub, where the player returns after most actions/battles
    //These are the 3 main areas. Visiting all of these is nessasary for getting even one of the 3 endings
    public static void place() {
        String choice = q("Where would you like to go?\na) The forest\nb) The castle\nc) The tournament of warriors!\n");
        if (choice.equals("a")) {
            forest();
        } else if (choice.equals("b")) {
            castle();
        } else if (choice.equals("c")) {
            tournament ();
        }
    }

    /**
     * The forest is not very important, the only main encounters are with the skeleton and Bajaj
     */
    public static void forest() {
        String choice = q("The forest is dark and gloomy\nSuddenly, a skeleton warrior growls at you and starts to charge in your direction\n" +
                " Do you\na) fight the skeleton\nb) run away\nc) try to talk to him\n");
        if (choice.equals("a")) {
            opponent = "skeleton"; fight();
        } else if (choice.equals("b")) {
            place ();
        } else if (choice.equals("c")) {
            health = health - 20;
            System.out.println ("you lose 20 health, your health is now " + health + "\n");
            place ();
        }
    }
    //aside from the centeral hub, the castle is the most important area, with 3 options for exploration
    public static void castle() {
        String choice = q("In the castle, you can...\na) go to the blacksmith\nb) enter the dungeon\nc) enter the queens chambers\nd) go to the hospital");
        if (choice.equals("a")) {
            System.out.println ("The blacksmith offers you a weapon\n"); pickup = "forged spear"; pickup();
        } else if (choice.equals("b")) {
            System.out.println("GUARD: 'You are not to enter the dungeons, for it is not safe'\n"); castle ();
        } else if (choice.equals("c")) {
            if (kingdead == false ) {
                chamber();
            }
            else {
                health = health - 50;
                System.out.println ("you find the queen weeping over her dead husband\nyou are thrown out by the mourning guards and lose 50 health\nyour health is now " + health);
                place();
            }
        } else if (choice.equals("d")) {
            if (potions > 0) {
                System.out.println ("You heal up with a magic potion\n");
                int x = 0;
                while (x < 30 && health < maxHealth) {
                    health++;
                    x++;
                }
                potions--;
                System.out.println ("The hospital has " + potions + " potions left\n");
                System.out.println ("You now have " + health + " health\n");
                place();
            } else {
                System.out.println("The hospital is out of potions\n");
                place();
            }
        }
    }
    //This is the pickup mechanic. You can only carry one weapon at a time
    public static void pickup() {
        String choice = q("You have recived " + pickup + ", do you take it?\na) yes \nb) no\n");
        if (choice.equals("a")) {
            System.out.println("you have dropped " + weapon + "\n");
            weapon = pickup; pickup = null; 
            System.out.println("you have equipped " + weapon + "\n");
            place ();
        } else if (choice.equals("b")) {
            System.out.println("you have dropped " + pickup + "\n");
            pickup = null;
            place ();
        }
    }
    //the chamber is where you meet the king, who is the most important charecter in the game
    public static void chamber() {
        String choice = q("In the queens chamber, you find the both the queen and the KING HIMSELF!!!!\nKING: 'what you are doing here?' \nhow do you respond?" +
                " \na) I'm sorry, sir, I didn't realise which door this was  \nb) I'd like a quest  \nc) I'M HERE TO KILL YOU!\n");
        if (choice.equals("a")) {
            System.out.println("KING: 'get out'\nyou leave\n"); place ();
        } else if (choice.equals("b")) {
            if (winc == false){ System.out.println("KING: 'You may not have a quest unless you have proven yorself worthy'\n"); place();
            } else { System.out.println("KING: 'There is an evil demon roaming the forest.\nYears ago, I fought with him and won. However, despite my apparent victory,\nI could not vanquish his evil completly.\nI, the knights in my company, and even the powerful mages traveling with me could only banish him from the land.\nFor many years he has stayed hidden, fading into obscurity.\nMany consider the existence of this demon to be a myth, and more still have forgotten this myth entirely.\nHowever, I have felt this darkness growing, and I am sure of his imminent return.\nMy companions and I are too old to rise up against this foe, and other warriors will not take this task\nfor they think the demon is a myth.\nI need you to wipe this darkness from the land forever, and save Kulkarni.'\nHe moves to a chest near the bed, unlocks it, and takes out a golden sword\nso perfect it glowes, bathing the room wiht it's warm light.\nKING: 'this is the sword of ranvier, used by the legendary aincent hero, Rohan\nit is an immensely powerful blade. Go to the forest, fight your way throught the skeletons, and kill him.\nI leave you with one warning: he is a master of dark magic and manipulation...\n\nDo not let his lies fool you'\n");
                pickup = "sword of ranvier";
                champion = true;
                pickup (); }
        } else if (choice.equals("c")) {
            System.out.println("The kings guards attack!\n"); opponent = "guard"; fight();
        }
    }
    //the tournament is 3 easy fights which allow you to gain better weaponry and unlock better quests
    public static void tournament() {
        String choice = q("The tournment consists of 3 rounds, the winner of the tournament will win glory, honor, and the kings blade\na) enter\nb) leave\n");
        if (choice.equals("a")) {
            if (wina == false) {
                System.out.println("your first round is against a normal warrior\n"); opponent = "smallman"; fight();
            } else if (winb == false) {   
                System.out.println("your second round is against a normal warrior, who is slightly stronger\n"); opponent = "bigman"; fight();
            } else if (winc == false) {
                System.out.println("your third fight is against a mighty warrior, a servant of the king!!\n"); opponent = "jenkins"; fight();
            } else if (winc = true) {
                System.out.println("you have already won the tournament\n"); place();        
            }
        } else if (choice.equals("b")){
            place (); 
        }
    }
    //this is the directory of weapons. The fighting mechanic runs through this before every fight to determine your stats
    public static void fight() {
        if (weapon == "sword") {
            attack = 55;
            pattack = 40;
            tattack = 65;
            defence = 7;
            ap = 0;
        } else if (weapon == "axe") {
            attack = 60;
            pattack = 75;
            tattack = 50;
            defence = 1;
            ap = 15;
        } else if (weapon == "spear") {
            attack = 55;
            pattack = 45;
            tattack = 45;
            defence = 5;
            ap = 11;
        } else if (weapon == "forged spear") {
            attack = 65;
            pattack = 50;
            tattack = 50;
            defence = 5;
            ap = 15;
        } else if (weapon == "kings blade") {
            attack = 75;
            pattack = 55;
            tattack = 65;
            defence = 7;
            ap = 10;
        } else if (weapon == "sword of ranvier") {
            attack = 115;
            pattack = 105;
            tattack = 105;
            defence = 12;
            ap = 30;
        } else if (weapon == "soulcrusher") {
            attack = 90;
            pattack = 80;
            tattack = 120;
            defence = 20;
            ap = 25;
        } else if (weapon == "hands") {
            attack = 35;
            pattack = 20;
            tattack = 50;
            defence = 0;
            ap = 0;
        }
        enemy ();
    }
    //this is the directory of enemies. The fighting mechanic runs through this before every fight to determine your enemy's stats
    public static void enemy() {
        if (opponent == "skeleton") {
            if (weapon == "soulcrusher" || weapon == "sword of ranvier"){
                opattack = 65; }
            else { 
                opattack = 40; }
            oppattack = 35;
            optattack = 35;
            opdefence = 5;
            ophealth = 100;
        } else if (opponent == "smallman") {
            opattack = 40;
            oppattack = 35;
            optattack = 45;
            opdefence = 5;
            ophealth = 80;
        } else if (opponent == "bigman") {
            opattack = 30;
            oppattack = 35;
            optattack = 25;
            opdefence = 5;
            ophealth = 200;
        } else if (opponent == "jenkins") {
            opattack = 40;
            oppattack = 35;
            optattack = 60;
            opdefence = 10;
            ophealth = 100;
        } else if (opponent == "guard") {
            opattack = 50;
            oppattack = 35;
            optattack = 45;
            opdefence = 15;
            ophealth = 140;
        } else if (opponent == "king") {
            opattack = 95;
            oppattack = 75;
            optattack = 85;
            opdefence = 20;
            ophealth = 500;
        } else if (opponent == "Bajaj") {
            opattack = 75;
            oppattack = 65;
            optattack = 100;
            opdefence = 30;
            ophealth = 500;
        } 
        actualfight ();
    }
    //this is the fight mechanic. this is where the actual fighting happens, influenced by the player's choices and strategy. This is also the only place where you can die
    //the use of large decimals, as well as the imperfect sentence structure (for example: you are about to fight skeleton) are there to give the game a more "RPG-like" feel
    public static void actualfight() {
        System.out.println ("you are about to fight " + opponent + "\n");   
        while (health > 0 && ophealth > 0) {
            String choice = q("Your health is " + health + " your enemy's health is " + ophealth +
                    "\ndo you\na) use a standard attack\nb) use a power attack\nc) wait for him to attack and attempt a counter-attack\nd) attempt to heal" );
            double mod = Math.random ();
            double opmod = Math.random (); 
            double decider = Math.random (); 
            if (choice.equals("a")) {
                if (0 < (attack * mod) - opdefence) {
                    if (0 < opdefence - ap){
                        if (decider <= 0.666 && decider >=0.333){
                            ophealth = (ophealth - ((((attack * mod) - (opdefence - ap))) * 2));
                            System.out.println ("you have CRITICALLY hit " + opponent + " for " + (((attack * mod) - (opdefence - ap)) * 2) + " damage\n");
                        }
                        else {
                            ophealth = (ophealth - ((attack * mod) - (opdefence - ap)));
                            System.out.println ("you have hit " + opponent + " for " + ((attack * mod) - (opdefence - ap)) + " damage\n");
                        }
                    } else {
                        if (decider <= 0.666 && decider >=0.333){ 
                            ophealth = (ophealth - ((attack * mod) * 2));
                            System.out.println ("you have CRITICALLY hit " + opponent + " for " + ((attack * mod) - (opdefence - ap) * 2) + " damage\n");
                        } else {
                            ophealth = (ophealth - (attack * mod));
                            System.out.println ("you have hit " + opponent + " for " + ((attack * mod) - (opdefence - ap)) + " damage\n");
                        }                    
                    }  
                } else {
                    ophealth = ophealth;
                    System.out.println (opponent + " dodged your attack\n");                                                          
                }
            }

            else if (choice.equals("b")) {
                if (0 < (pattack * mod) - opdefence) {
                    if (0 < opdefence - ap){
                        if (decider <= 0.333 ){
                            ophealth = (ophealth - (((pattack * mod) - (opdefence - ap)) * 2));
                            System.out.println ("you have CRITICALLY hit " + opponent + " for " + (((pattack * mod) - (opdefence - ap)) * 2) + " damage\n");
                        }
                        else {
                            ophealth = (ophealth - ((pattack * mod) - (opdefence - ap)));
                            System.out.println ("you have hit " + opponent + " for " + ((pattack * mod) - (opdefence - ap)) + " damage\n");
                        }
                    } else {
                        if (decider <= 0.333){ 
                            ophealth = (ophealth - ((pattack * mod) * 2));
                            System.out.println ("you have CRITICALLY hit " + opponent + " for " + ((pattack * mod) - (opdefence - ap) * 2) + " damage\n");
                        } else {
                            ophealth = (ophealth - (pattack * mod));
                            System.out.println ("you have hit " + opponent + " for " + ((pattack * mod) - (opdefence - ap)) + " damage\n");
                        }                    
                    }  
                } else {
                    ophealth = ophealth;
                    System.out.println ("you missed " + opponent + " \n");                                                          
                }
            }

            else if (choice.equals("c")) {
                if (0 < (tattack * mod) - opdefence) {
                    if (0 < opdefence - ap){
                        if (decider >= 0.666 ){
                            ophealth = (ophealth - (((tattack * mod) - (opdefence - ap))) * 2);
                            System.out.println ("you have CRITICALLY hit " + opponent + " for " + (((tattack * mod) - (opdefence - ap)) * 2) + " damage\n");
                        }
                        else {
                            ophealth = (ophealth - ((tattack * mod) - (opdefence - ap)));
                            System.out.println ("you have hit " + opponent + " for " + ((tattack * mod) - (opdefence - ap)) + " damage\n");
                        }
                    } else {
                        if (decider >= 0.666){ 
                            ophealth = (ophealth - ((tattack * mod) * 2));
                            System.out.println ("you have CRITICALLY hit " + opponent + " for " + ((tattack * mod) - (opdefence - ap) * 2) + " damage\n");
                        } else {
                            ophealth = (ophealth - (tattack * mod));
                            System.out.println ("you have hit " + opponent + " for " + ((tattack * mod) - (opdefence - ap)) + " damage\n");
                        }                    
                    }  
                } else {
                    ophealth = ophealth;
                    System.out.println (opponent + " blocked your attack\n");                                                          
                }
            }
            else if (choice.equals ("d")) {
                if (decider <= 0.5){
                    health = health + (defence * 12.5 * mod);
                    System.out.println("you healed " + (defence * 12.5 * mod) + " health\n");
                } else {
                    health = health - (opattack * opmod * 2);
                    System.out.println("you have failed to heal, " + opponent + " has attacked you for " + (opattack * opmod * 2) + " damage\n");
                }
            }
            if (choice.equals ("d")){
            } else {
                if (decider <= 0.333){
                    if (0 < (opattack * opmod) - defence){
                        if (choice.equals("c")) {
                            health = (health - (((opattack * opmod) - defence)) * 2);
                            System.out.println (opponent + " CRITICALLY attacked you for " + (((opattack * opmod) - defence) * 2) + " damage\n"); 
                        } else {
                            health = (health - ((opattack * opmod) - defence));
                            System.out.println (opponent + " attacked you for " + ((opattack * opmod) - defence) + " damage\n"); 
                        }                            
                    } else {
                        System.out.println("you dodged " + opponent + "'s attack\n"); 
                    }
                }
                else if (decider >= 0.666) {
                    if (0 < (oppattack * opmod) - defence){
                        if (choice.equals("a")) {
                            health = (health - (((oppattack * opmod) - defence)) * 2); 
                            System.out.println (opponent + " used a power attack, CRITICALLY dealing " + (((oppattack * opmod) - defence) * 2) + " damage\n");
                        } else {
                            health = (health - ((oppattack * opmod) - defence));
                            System.out.println (opponent + " used a power attack, dealing " + ((oppattack * opmod) - defence) + " damage\n");
                        }                        
                    } else {
                        System.out.println(opponent + " missed\n"); 
                    }
                }

                else {
                    if (0 < (optattack * opmod) - defence) {
                        if (choice.equals("b")) {
                            health = (health - (((optattack * opmod) - defence)) * 2); 
                            System.out.println ( opponent +  " countered your attack with a CRITICAL strike for " + (((optattack * opmod) - defence) * 2) + " damage\n");
                        } else { 
                            health = (health - ((optattack * opmod) - defence));
                            System.out.println ( opponent +  " countered your attack for " + ((optattack * opmod) - defence) + " damage\n");
                        }                    
                    }   else {
                        System.out.println("you blocked  " + opponent + "'s attack\n");
                    }
                }  
            }
        }

        if (health > 0) {
            postfight ();
        }
        else 
        { System.out.println ("you have been killed by " + opponent + ", game over\n");
        }
    }

    //each opponents have special properties and unlockables(such as a win, a new quest, another opponent, etc.). This is where the program determines what happens after a fight.
    public static void postfight() {
        if (opponent == "skeleton") {
            System.out.println ("you killed a skeleton and gained 40 health\n");
            health = health + 40;
            System.out.println ("you now have " + health + " health\n");
            if (champion == false) {
                place(); }
            else { 
                String choice = q("You hear a noise from behind a tree, do you follow it?\na) yes\nb) no\n");
                if (choice.equals("a")) {
                    Bajaj();
                }else if (choice.equals("b")) { 
                    System.out.println("you run away\n");
                    place(); }
            }} else if (opponent == "smallman") {
            wina = true;
            System.out.println ("you won the match and gained 40 health\n");
            health = health + 40;
            System.out.println ("you now have " + health + " health\n");
            tournament();
        } else if (opponent == "bigman") {
            winb = true;
            System.out.println ("you won the match and gained 50 health\n");
            health = health + 50;
            System.out.println ("you now have " + health + " health\n");
            tournament();
        } else if (opponent == "jenkins") {
            winc = true;
            System.out.println ("you won the match and gained 60 health\n");
            health = health + 60;
            System.out.println ("you now have " + health + " health\n");
            System.out.println ("the people are impressed with your bravery and skill. You are rewarded with the kings blade\n");
            pickup = "kings blade";
            pickup ();
        } else if (opponent == "guard") {
            System.out.println ("you killed the guard gained 40 health\n");
            health = health + 60;
            System.out.println ("you now have " + health + " health\n");
            if (guarddead == false) {
                System.out.println ("the kings other guard attacks you\n");
                guarddead = true;
                fight ();
            }
            else {
                System.out.println ("the king draws himself up to full height, grabs a sword out from beside him, and charges you\n");
                opponent = "king";
                fight ();
            }
        } else if (opponent == "king") {
            if (darkquest == true){
                System.out.println("with the king gone, the kingdom and it's armies fell into disarray.\nBajaj used his demonic powers to corrupt the minds remaining generals and leaders of Kulkarni.\nWith all of the remaining leaders of Kulkarni at each others throats, the kingdom soon crumbled.\nIn recognition of your loyalty, Bajaj gives you control of the dying kingdom,\nand allows you to reunite all of the kingdom once more.\nYou become a hero, and the new king, while Bajaj rules from the shadows. All is peaceful in Kulkarni again.\nStill, some speculate as to what is realy going on.....\n");
                System.out.println("The End\n");
            } else {
                System.out.println("The king is dead, yet for some reason the kingdom remains prosperous........" );
                System.out.println ("The End\n");
            }
        } else if (opponent == "Bajaj") {
            System.out.println("The demon is dead, and the kings quest is fulfilled.\nThe king holds a triumph in your honor, and you become the most honored warrior in the kingdom.\nHowever, not everything is perfect in the kingdom, and you can feel that the darkness has not completly left the land.\nYou wonder.....\n");
            System.out.println("The End\n");
        } 
    }
    //this encounter is an unlockable, but was too large to fit in the privious method
    public static void Bajaj (){
        String choice = q("At first you see nothing, but, from seemingly out of nowhere, a man walks up to you\nyou feel a cold shiver as he approaches\nMAN: 'I am the demon that you are searching for.\nmy name is Bajaj, and I fought your king long ago.\nI am not evil, for it is your king who is corrupt, and is spreading this darkness across Kulkarni.\nSlay him, and I will reward you handsomely.'\na) I will join you  \nb) I will never turn against the king!!\n");
        if (choice.equals ("a")) {
            System.out.println("Bajaj slmiles\nHe reaches out and a blade, black as night, materializes in his hand\nHe gives it to you\n");
            pickup = "soulcrusher";
            darkquest = true;
            pickup();
        } 
        else { 
            System.out.println("Bajaj: 'so be it'\n");
            opponent = "Bajaj";
            fight(); }
    }
}