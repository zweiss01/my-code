/**
 * 
 * @author Zach Weiss
 * 
 * This is the class definition for a node <br>
 *
 */
public class NodeWeiss 
{
	private ItemWeiss myData;
	private NodeWeiss myNext;
	
	public NodeWeiss(ItemWeiss newMyData)
	{
		myData = newMyData;
		myNext = null;
	}//NodeWeiss
	
	public ItemWeiss getData()
	{
		return myData;
	}//getData
	
	public void setData(ItemWeiss newMyData)
	{
		myData = newMyData;
	}//setData
	
	public NodeWeiss getNext()
	{
		return myNext;
	}//getNext
	
	public void setNext(NodeWeiss newMyNext)
	{
		myNext = newMyNext;
	}//setNext
}//NodeWeiss
