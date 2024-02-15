/**
 * username1 - ohadsapir
*id1      - 212937817
*name1    - Ohad Sapir
*username2 - eithankatz
*id2      - 213452311
*name2    - Eithan Katz
**/
public class AQPHashTable extends OAHashTable {
	
	private final ModHash func;
	
	public AQPHashTable(int m, long p) {
		super(m);
		func = ModHash.GetFunc(m, p);
	}
	
	@Override
	public int Hash(long x, int i) {
		double square;
		if (i%2 == 0) // (-1)^i = 1
			square = (Math.pow(i,2));
		else          // (-1)^i = -1
			square = - (Math.pow(i,2));
		
		int index = (int) ((func.Hash(x) + square)%m);
		if (index < 0) 
			index += m;
	    return index;
	}
}
