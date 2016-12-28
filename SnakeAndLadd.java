import java.io.*;

class SnakeAndLadd
{
public static void main(String args[])throws Exception
{

  BufferedReader myInput2 = new BufferedReader (new InputStreamReader (System.in));
        // Print the welcome screen and instructions
        System.out.println ("\t\t\t\t\t\tWelcome To Snakes And Ladders\n\n");
        System.out.println ("\t\t\t\t\t\t\tInstructions:");
        System.out.println ("\t\t\t This program will simulate a regular snakes and ladders game, where you will be");
        System.out.println ("\t\t\t facing the computer. You and the computer start at square 1, and the first one to");
        System.out.println ("\t\t\t square 100 wins, however, there will be preset squares which will be the snakes or ladders.");
        System.out.println ("\t\t\t Once you land on top of a snake you go down a few squares, and move up if you land");
        System.out.println ("\t\t\t\t\t\t on the bottom of a ladder. Good Luck and Have FUN!!!");

int counter=-1;
int i=100;

 System.out.println ("-----------------------------------------------------Game Board-----------------------------------------------------------------------------");

for(;i>0;)
{
if(i%10==0 && i!=100)
{
if(counter==-1)
{
i=i-9;
counter=1;
}
else
{
System.out.print(i);
i=i-10;
counter=-1;
}
if(i!=0)
System.out.print("\n"+i+"\t");
}
else
System.out.print(i+"\t");
i=i+counter;
}

System.out.println();
        System.out.println ("----------------------------------------------------------------------------------------------------------------------------------");
        String start="y";
         System.out.print ("Do you want to play? Y or N     >  ");
          start=myInput2.readLine();
          System.out.print ("\n\n\n\n\n\n");
         if (start.equals("y") || start.equals("Y"))
        {
         start=startGame(start); 
        }
        System.out.println ("\n\n\n\n\t\t\t\t\t\tSEE YA!!");
}

public static String startGame(String start)throws Exception
{
BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
int snakelad[]=new int[6];
int userpos=1;
int compos=1;
int dice1=0;
int dice2=0;
int userroll=1;
int comproll=1;
String playagain="y";

        snakelad[0] = 54;
        snakelad[1] = 90;
        snakelad[2] = 99;
        snakelad[3] = 9;
        snakelad[4] = 40;
        snakelad[5] = 67;
        
while(playagain.equals("y") || playagain.equals("Y"))
{
userroll=getDice(dice1,dice2);
comproll=getDice(dice1,dice2);
System.out.println("user rolled="+userroll);
System.out.println("comp rolled="+comproll);
userpos=userpos+userroll;
compos=compos+comproll;

userpos=getp(userpos,userroll,snakelad);
compos=cgetp(compos,comproll,snakelad,userpos);

 System.out.println("\t\t\t*************************************************************************");
            System.out.println ("\t\t\t*\t\tYou are currently on square " + userpos + "\t\t\t*"); // print out the user's current location
            System.out.println ("\t\t\t*\t\tThe Computer is currently on square " + compos + "\t\t*"); // print out the computer's current location
            System.out.println("\t\t\t*************************************************************************");

if(userpos==100 || compos==100)
{
userpos=1;
compos=1;
 System.out.print ("Do you want to play? Y or N     >  ");
                 playagain=input.readLine();
                System.out.print ("\n\n\n\n\n\n\n\n\n\n\n\n");
}
else
{
System.out.print ("Do you want to play? Y or N     >  ");
                 playagain=input.readLine();
}
}
return playagain;
}

public static int getDice(int dice1,int dice2)
{
dice1=(int)(Math.random()*6)+1;
dice2=(int)(Math.random()*6)+1;
int move=dice1+dice2;
return move;
}

public static int getp(int userpos,int userroll,int snakelad[])throws Exception
{

if(userpos==snakelad[0])
{
userpos=19;
System.out.println ("\t\t\t\t~~~~~~~~~~~~~You Got Bit By A Snake, GO DOWN!!!~~~~~~~~~~~~~");
}
else if(userpos==snakelad[1])
{
userpos=48;
System.out.println ("\t\t\t\t~~~~~~~~~~~~~You Got Bit By A Snake, GO DOWN!!!~~~~~~~~~~~~~");
}
else if(userpos==snakelad[2])
{
userpos=77;
 System.out.println ("\t\t\t\t~~~~~~~~~~~~~You Got Bit By A Snake, GO DOWN!!!~~~~~~~~~~~~~");
}
else if(userpos==snakelad[3])
{
userpos=34;
System.out.println ("\t\t\t\t~~~~~~~~~~~~~You Got A Ladder!! GO UP!!!~~~~~~~~~~~~~");
}
else if(userpos==snakelad[4])
{
userpos=64;
System.out.println ("\t\t\t\t~~~~~~~~~~~~~You Got A Ladder!! GO UP!!!~~~~~~~~~~~~~");
}
else if(userpos==snakelad[5])
{
userpos=86;
System.out.println ("\t\t\t\t~~~~~~~~~~~~~You Got A Ladder!! GO UP!!!~~~~~~~~~~~~~");
}
if(userpos==100)
{
System.out.println("well done you won good job.");
}
else if(userpos>100)
{
System.out.println("you can't jump");
userpos=userpos-userroll;
}
return userpos;
}

public static int cgetp(int compos,int comproll,int snakelad[],int userpos)throws Exception
{

if(compos==snakelad[0])
{
compos=19;
System.out.println ("\t\t\t\t~~~~~~~~~~~~~Computer Got Bit By A Snake, HE WENT GO DOWN!!!~~~~~~~~~~~~~");
}
else if(compos==snakelad[1])
{
compos=48;
System.out.println ("\t\t\t\t~~~~~~~~~~~~~Computer Got Bit By A Snake, HE WENT GO DOWN!!!~~~~~~~~~~~~~");
}
else if(compos==snakelad[2])
{
compos=77;
System.out.println ("\t\t\t\t~~~~~~~~~~~~~Computer Got Bit By A Snake, HE WENT GO DOWN!!!~~~~~~~~~~~~~");
}
else if(compos==snakelad[3])
{
compos=34;
 System.out.println ("Computer Got TO A Ladder, HE WENT UP!!!");
}
else if(compos==snakelad[4])
{
compos=64;
 System.out.println ("Computer Got TO A Ladder, HE WENT UP!!!");
}
else if(compos==snakelad[5])
{
compos=86;
 System.out.println ("Computer Got TO A Ladder, HE WENT UP!!!");
}
if(compos==100 && userpos!=100)
{
System.out.println("computer wins.");
}
else if(compos>100)
{
System.out.println("computer can't jump");
compos=compos-comproll;
}
return compos;
}

}
