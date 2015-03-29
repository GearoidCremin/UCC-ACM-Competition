import java.util.Scanner;
public class P3 {
	public static void main(String[]args)
	{
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		input.nextLine();
		for(int i=0;i<n;i++)
		{
			String stringRead =input.nextLine();
			char[] charRead=stringRead.toCharArray();
			int[]answerHolder=new int[Integer.parseInt(String.valueOf(charRead[0]))];
			int answerCount=0;
			for(int j=2;j<charRead.length;j+=2)
			{
				switch(charRead[j])
				{
				case ' ': break;
				case 'A': answerHolder[answerCount-2]=answerHolder[answerCount-2]&answerHolder[answerCount-1]; answerCount--; break;
				case 'X': answerHolder[answerCount-2]=answerHolder[answerCount-2]^answerHolder[answerCount-1]; answerCount--; break;
				case 'R': answerHolder[answerCount-2]=answerHolder[answerCount-2]|answerHolder[answerCount-1]; answerCount--; break;
				case 'N': if(answerHolder[answerCount-1]==1) answerHolder[answerCount-1]=0;else answerHolder[answerCount-1]=1; break;
				case '0': answerHolder[answerCount]=0; answerCount++; break;
				case '1': answerHolder[answerCount]=1; answerCount++; break;
				default: System.out.printf("YOU GAVE AN INVALID INPUT! WTF\n");
				
				}
				
			}
			System.out.printf("%d\n",answerHolder[answerCount-1]);
		}
	}
}
