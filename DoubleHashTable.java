/**
 * username1 - ohadsapir
*id1      - 212937817
*name1    - Ohad Sapir
*username2 - eithankatz
*id2      - 213452311
*name2    - Eithan Katz
**/
import java.util.Random;

public class DoubleHashTable extends OAHashTable {
	
	private final ModHash func1;	//func1:   0 - m
	private final ModHash func2;	//func2:   0 - m-2
									//func2+1: 1 - m-1
	public DoubleHashTable(int m, long p) {
		super(m);
		func1 = ModHash.GetFunc(m, p);
		func2 = ModHash.GetFunc(m-2, p);
	}
	
	@Override
	public int Hash(long x, int i) {
		int index = (int) ((func1.Hash(x) + i*(func2.Hash(x)+1)) % m);
		return index<0 ? index+m : index;
	}
	
}
