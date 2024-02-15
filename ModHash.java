/**
 * username1 - ohadsapir
*id1      - 212937817
*name1    - Ohad Sapir
*username2 - eithankatz
*id2      - 213452311
*name2    - Eithan Katz
**/
import java.util.concurrent.ThreadLocalRandom;

public class ModHash 
{
	
	private int m;
	private long p;
	private long a;
	private long b;
	
	public ModHash(int m, long p, long a, long b) 
	{
		this.m = m;
		this.p = p;	
		this.a = a;
		this.b = b;
	}
	
	public static ModHash GetFunc(int m, long p) 
	{
		long a = ThreadLocalRandom.current().nextLong(1, p);
		long b = ThreadLocalRandom.current().nextLong(0, p);
		return new ModHash(m, p, a, b);
	}
	
	public int Hash(long key) 
	{
		return (int) (((a*key + b)%p)%m);
	}
	
}
