/**
 * username1 - ohadsapir
*id1      - 212937817
*name1    - Ohad Sapir
*username2 - eithankatz
*id2      - 213452311
*name2    - Eithan Katz
**/
import java.util.Random;

public class LPHashTable extends OAHashTable {
	
	private final ModHash func;
	
	public LPHashTable(int m, long p) {
		super(m);
		func = ModHash.GetFunc(m, p);
	}
	
	@Override
	public int Hash(long x, int i) {
		int index = (int) ((func.Hash(x) + i) % m);
		return index<0 ? index+m : index;
	}
	
}
