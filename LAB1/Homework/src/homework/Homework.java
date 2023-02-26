
package homework;

/**
 *
 * @author Dascalu Rares-Vasilica A5
 */
public class Homework {

public static void main(String[] args){

long start = System.currentTimeMillis();
    
if(args.length>1) 
{
    System.out.println("PREA MULTE ARGUMENTE");
    System.exit(0);
}
    
if(args.length<1) 
{
    System.out.println("PREA PUTINE ARGUMENTE");
    System.exit(0);
}

try {
    Integer.parseInt(args[0]);
    System.out.println(args[0] + " is a valid integer number");
    }
catch (NumberFormatException e) {
    System.out.println(args[0] + " is not a valid integer number");
    System.exit(0);
    }

int n = Integer.parseInt(args[0]);
int k = 1;
String matrice;

int[][] LSquare = new int[n+1][n+1];



for(int i=1;i<=n;i++)
{
    for(int j=1;j<=n;j++)
    {
        if(k==n+1) k=1;
        LSquare[i][j]=k;
        k++;
    }
    k=LSquare[i][n];
}
for(int i=1;i<=n;i++)
{   
    matrice="";
    for(int j=1;j<=n;j++)
    {
    matrice=matrice+LSquare[i][j];
    }
    if(n<=30_000)
        System.out.println(matrice);
}
for(int i=1;i<=n;i++)
{   
    matrice="";
    for(int j=1;j<=n;j++)
    {
    matrice=matrice+LSquare[j][i];
    }
    if(n<=30_000)
        System.out.println(matrice);
}
long end = System.currentTimeMillis();
if(n>30_000)
    System.out.println("Elapsed Time in milliseconds: "+ (end-start));
}
}
