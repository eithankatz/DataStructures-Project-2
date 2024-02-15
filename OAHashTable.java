/**
 * username1 - ohadsapir
*id1      - 212937817
*name1    - Ohad Sapir
*username2 - eithankatz
*id2      - 213452311
*name2    - Eithan Katz
**/
public abstract class OAHashTable implements IHashTable 
{
	public static final HashTableElement DELETED = new HashTableElement(-1,-1);
	HashTableElement [] table;
	int m;
	
	public OAHashTable(int m) 
	{
		this.table = new HashTableElement[m];
		this.m = m;
	}
	
	
	@Override
	public HashTableElement Find(long key) 
	{
		for(int i=0; i<m; i++)
		{
			int j = Hash(key, i);
			if(this.table[j] == null)
			{
				return null;
			}
			else if(this.table[j].GetKey() == key)
			{
				return this.table[j];
			}
		}
		return null;
	}
	
	public void FindDeleted(long key, int i, HashTableElement hte) throws KeyAlreadyExistsException 
	{
		for(; i<m; i++)
		{
			int j = Hash(key, i);
			if(this.table[j] == null)
			{
				return;
			}
			else if(this.table[j].GetKey() == key)
			{
				throw new KeyAlreadyExistsException(hte);
			}
		}
	}
	
	@Override
	public void Insert(HashTableElement hte) throws TableIsFullException,KeyAlreadyExistsException 
	{
		/**
		if(Find(hte.GetKey()) != null)
		{
			throw new KeyAlreadyExistsException(hte);
		}
		**/
		for(int i=0; i<m; i++)
		{
			int j = Hash(hte.GetKey(), i);
			if(this.table[j] == null || isDeleted(this.table[j]))
			{
				if(this.table[j] != null)
				{
					FindDeleted(hte.GetKey(), i, hte);
				}
				this.table[j] = hte;
				return;
			}
			
			else if(this.table[j].GetKey() == hte.GetKey())
			{
				throw new KeyAlreadyExistsException(hte);
			}
			
		}
		throw new TableIsFullException(hte);
	}
	
	@Override
	public void Delete(long key) throws KeyDoesntExistException 
	{
		for(int i=0; i<m; i++)
		{
			int j = Hash(key, i);
			if(this.table[j] == null)
			{
				throw new KeyDoesntExistException(key);
			}
			else if(this.table[j].GetKey() == key)
			{
				this.table[j] = DELETED;
				return;
			}
		}
		throw new KeyDoesntExistException(key);
	}
	
	/**
	 * 
	 * @param x - the key to hash
	 * @param i - the index in the probing sequence
	 * @return the index into the hash table to place the key x
	 */
	public abstract int Hash(long x, int i);
	
	private boolean isDeleted(HashTableElement hte)
	{
		return hte.GetKey()==DELETED.GetKey() && hte.GetValue()==DELETED.GetValue();
	}
}
