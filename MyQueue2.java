
public class MyQueue2<T>
{
	private Object[] array;
	private int size;//number of objects in queue
	private int first;//first item (index) in queue
	private int last;//last item (index) in queue
	
	MyQueue2()
	{
		this(10);
	}
	
	MyQueue2(int size)
	{
		this.array = new Object[size];
		this.size = 0;
		this.first = 0;
		this.last = 0;
	}
	
	//Adds an item to the back of the queue
	public void enqueue(T element)
	{
		if (size == 0)
		{
			array[first] = array[last] = element;
		}
		else if (size == array.length)
		{
			expandArray();
			array[++last] = element;
		}
		else if (size < array.length && last == array.length - 1)
		{
			last = 0;
			array[last] = element;
		}
		else
		{
			array[++last] = element;
		}
		
		size++;
	}
	
	//Removes and returns the first item in the queue
	public T dequeue()
	{
		T temp = (T)array[first];
		
		if (size < 1)
		{
			System.out.println("The queue is empty.");
			size++;
		}
		else if (size == 1)
		{
			array[first] = array[last] = null;
		}
		else if (first == array.length - 1 && size > 1)
		{
			array[first] = null;
			first = 0;
		}
		else
		{
			array[first++] = null;
		}
		
		size--;
		return temp;
	}
	
	//Expands the underlying arraying of the queue while
	//keeping its contents in place
	private void expandArray()
	{
		int newsize = (array.length*3+2) / 2;
        Object[] biggerArray = new Object[newsize];
		int biggerArrayLength = biggerArray.length - 1;
		
        if (first != 0)
        {
        	for (int i = array.length-1; i >= first; i--)
        		biggerArray[biggerArrayLength--] = array[i];
        	first = biggerArray.length - 1 - (array.length - 1 - first);
        }
        for (int i = 0; i <= last; i++)
        	biggerArray[i] = array[i];
        
        array = biggerArray;
	}
	
	//Returns the first item in the queue
	public T peek()
	{
		return (T)array[first];
	}
	
	//Prints out the contents of the queue
	//Primarily for testing purposes
	public String toString()
	{
		String string = "";
		
		for (int i = 0; i < array.length; i++)
		{
			string = string + i + ". " + array[i];
			if (i != array.length - 1)
			{
				string = string + ", ";
			}
		}
		
		return string;
	}
	
	public boolean isEmpty() {
		
		if (size == 0)
			return true;
		else
			return false;
	}
}
