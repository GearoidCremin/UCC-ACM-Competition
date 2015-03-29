import java.util.Scanner;
public class P2 {
	public static boolean checkPrime(int n)
	{
		if(n==2) return true;
		else if(n==1) return false;
		else if(n%2==0) return false;
		for(int i=3;i<n;i++)
		{
			if(n%i==0) return false;
		}
		return true;
	}
	public static void ppp(int lower, int upper, int order)
	{
		int contingency=0;
		int[][]superset=new int[order+1][upper-lower+1];
		int counter=0;
		int counter2=0;
		for(int i=0;i<superset[0].length;i++)
		{
			if(checkPrime(lower+i)==true) 
			{
				superset[0][counter2]=lower+i;
				counter2++;
			}
		}
		boolean swept=false;
		for(int j=0;j<order;j++)
		{
			for(int i=0;i<superset[j].length;i++)
			{
				if(superset[j][0]==0&&swept ==false) 
					{
						contingency =superset[j-1][0];
						swept =true;
					}
				else if(checkPrime(superset[j][i])==true&&checkPrime(i+1)==true){
					 superset[j+1][counter]=superset[j][i];
					 counter++;
				 }
				 else superset[j+1][i]=0;
			}
			counter=0;
		}
		boolean done =false;
		for(int i=0;i<superset[order].length;i++)
		{
			if(superset[order][i]!=0&&contingency==0){
				System.out.printf("%5d",superset[order][i]);
			}
			else if(done==false && contingency !=0){
				System.out.printf("%5d",contingency);
				done = true;
			}
		}
		System.out.println();
	}
	public static void main(String[] args) throws java.io.IOException
	{
		Scanner s1 = new Scanner(System.in);
		int lower = 0;
		int upper = 0;
		int order = 0;
	    int ch =0;
	    int k=0;
	    while(k<3){
	    	ch=s1.nextInt();
	    	switch(k){
	    	case 0: lower=ch; break;
	    	case 1: upper=ch; break;
	    	case 2: order =ch; break;
	    	}
	    	k++;
	    }
	    ppp(lower,upper,order);
	}
}