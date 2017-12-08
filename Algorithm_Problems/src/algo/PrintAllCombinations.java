package algo;


/**
 * write a code which prints all combinations of string array
 * @author ajinkyab
 *
 */
public class PrintAllCombinations

{

	public static void main(String[] args)
	{
		
		char [] in = new char[3];
		in[0]='A';
		in[1]='B';
		in[2]='C';
		
		char [] out = new char[in.length];
		findAllPaths(0, in,out);
		System.out.print("\n");
		//findAllPaths( in);
	}

	private static void findAllPaths(int depth , char[] in, char[] out)
	{
		if(depth == in.length)
		{
			System.out.println(out);
			return;
		}
		for(int i = 0 ; i<in.length ; i ++)
		{
			out[depth] = in[i];
			findAllPaths(depth + 1 , in, out);
		}
		
	}

	private static void findAllPaths( char[] in)
	{
		for(int i = 0 ; i< in.length ; i++)
		{
			for(int j=0 ; j< in.length ; j++)
			{
				for(int k=0 ; k<in.length ; k++)
				{
					System.out.println(in[i] + ""+ in[j]+""+ in[k]);
				}
			}
	}
	}
	
}
