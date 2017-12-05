
public class DependentTask extends Task 
{
	private Task prereqTask;
	private boolean hasPreReq;
	private boolean canStart;
	private boolean inProgress;
	
	public boolean setDateCompleted(DateTime dt)
	{
		if (canStart)
		{
			dateCompleted = new DateTime(dt);
			inProgress = false;
			isCompleted = true;
			return true;
		}
		return false;
	}
	
	public void setDateStarted(DateTime dt)
	{
		checkStatus();
		if (canStart)
		{
			dateStarted = new DateTime(dt);
			canStart = true;
			inProgress = true;
		}
		
	}

	public boolean checkProgress()
	{
		if (inProgress)
			return true;
		else
			return false;
	}
	
	public void checkStatus()
	{
		if (hasPreReq && prereqTask.isFinished())
			canStart = true;
		else if (hasPreReq == false)
			canStart = true;
	}

	public boolean getStartStatus()
	{
		return canStart;
	}

	public Task getPreReq()
	{
		return prereqTask;
	}

	public void addPreReq(DependentTask t1)
	{
		prereqTask = t1;
		hasPreReq = true;
		canStart = false;
		inProgress = false;
		dateStarted = null;
	}
	
	public void clearPreReq(DateTime dt)
	{
		prereqTask = null;
		hasPreReq = false;
		canStart = true;
		
	}

	
	public DependentTask()
	{
		taskName = "blank";
		taskID = " 00 ";
		isCompleted = false;
		dateStarted = null;
		dateCompleted = null;
		hasPreReq = false;
		canStart = true;
		inProgress = false;
	}
	public DependentTask(DateTime dt)
	{
		taskName = "blank";
		taskID = " 00 ";
		isCompleted = false;
		dateCompleted = null;
		hasPreReq = false;
		canStart = true;
		inProgress = true;
		dateStarted = new DateTime(dt);
		
	}

	public DependentTask(DateTime dt, String name, String ID)
	{
		taskName = name;
		taskID = ID;
		isCompleted = false;
		dateCompleted = null;
		hasPreReq = false;
		canStart = true;
		inProgress = true;
		dateStarted = new DateTime(dt);
	}
	
	public DependentTask(DateTime dt, DependentTask t1)
	{
		taskName = "blank";
		taskID = " 00 ";
		isCompleted = false;
		dateCompleted = null;
		hasPreReq = true;
		prereqTask = t1;
		setDateStarted(dt);
		
	}
	public DependentTask(DateTime dt, DependentTask t1, String name, String ID)
	{
		taskName = name;
		taskID =  ID;
		isCompleted = false;
		dateCompleted = null;
		hasPreReq = true;
		prereqTask = t1;
		setDateStarted(dt);
	}
	public DependentTask(DependentTask t1)
	{
		
		isCompleted = false;
		dateCompleted = null;
		prereqTask = t1.getPreReq();
		setDateStarted(t1.getStartDate());
		taskName = t1.getTaskName();
		taskID = t1.getTaskID();
		
		
		
	}

}
