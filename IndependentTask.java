public class IndependentTask extends Task
{
	private DateTime startDate;
	
	
	public DateTime getStartingDate()
	{
		return startDate;
	}
	
	public void setStartDate(DateTime dt)
	{
		startDate = dt;
	}
	
	public DateTime getCurrentDate()
	{
		return current;
	}
	public void setCurrentDate(DateTime dt)
	{
		current = dt;
		start();
	}
	
	
	public boolean setDateCompleted(DateTime dt)
	{
		if(inProgress)
		{
		dateCompleted = dt;
		isCompleted = true;
		return true;
		}
		else
			return false;
	}
	
	public boolean start()
	{
		if (current.isAfter(startDate))
		{
			inProgress = true;
			dateStarted = current;
			return true;
		}
		else 
			return false;		
	}
	
	
	public IndependentTask()
	{
		taskID = "001";
		taskName = "default";
		dateStarted = null;
		dateCompleted = null;
		startDate = null;
		current = null;
	}
	
	public IndependentTask(DateTime start)
	{
		startDate = start;
		taskID = "001";
		taskName = "default";
		dateStarted = null;
		dateCompleted = null;
		current = null;
		
	}
	public IndependentTask(DateTime start, DateTime ncurrent)
	{
		startDate = start;
		current = ncurrent;
		taskID = "001";
		taskName = "default";
		start();
		
	}
	
	public IndependentTask(String name, String id)
	{
		taskID = id;
		taskName = name;
		dateStarted = null;
		dateCompleted = null;
		startDate = null;
		current = null;
	
	}
	public IndependentTask(String name, String id, DateTime start, DateTime ncurrent)
	{
		startDate = start;
		current = ncurrent;
		taskID = id;
		taskName = name;
		if(start())
			inProgress = true;
	}
	public IndependentTask(IndependentTask idt)
	{
		startDate = idt.getStartDate();
		current = idt.getCurrentDate();
		taskID = idt.getTaskID();
		taskName = idt.getTaskName();
		if (idt.inProgress)
		{
			dateStarted = idt.getStartDate();
			inProgress = true;
		}
		else if(idt.isFinished())
		{
			dateCompleted = idt.getFinishDate();
			isCompleted = true;
		}
		
			
	}
}