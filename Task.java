
public abstract class Task {
	
	protected DateTime dateStarted = null;
	protected DateTime dateCompleted = null;
	protected DateTime current = new DateTime(1,1,1900,1,1,59);
	protected boolean isCompleted = false;
	protected boolean inProgress = false;
	protected DateTime startDate;
	protected DateTime finishDate;
	protected String taskName;
	protected int taskID;
	protected boolean timeDependent = false;
	
	public DateTime getStartDate()
	{
		return dateStarted;
	}
	public DateTime getFinishDate()
	{
		return dateCompleted;
	}
	public boolean isFinished()
	{
		if (isCompleted == true)
			return true;
		else
			return false;
	}
	public void setTaskName(String name)
	{
		taskName = name;
	}
	

	
	public DateTime getStartingDate()
	{
		return startDate;
	}
	
	public void setStartDate(DateTime dt)
	{
		startDate = dt;
	}
	
	public DateTime getFinish()
	{
		return finishDate;
	}
	
	
	public void setTaskID(int ID)
	{
		taskID = ID;
	}
	
	public String getTaskName()
	{
		return taskName;
	}
	public int getTaskID()
	{
		return taskID;
	}
	
	public DateTime getCurrent()
	{
		return current;
	}

	public abstract boolean setDateCompleted(DateTime dt);
	public abstract void setCurrentDate(DateTime t);
	public abstract String toString();
	public abstract boolean hasEndTime();
	//public abstract void addPreReq(Task t1);
	//public abstract void setDateStarted(DateTime dt);

	
}