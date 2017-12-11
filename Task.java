
public abstract class Task {
	
	protected DateTime dateStarted = null;
	protected DateTime dateCompleted = null;
	protected DateTime current = null;
	protected boolean isCompleted = false;
	protected boolean inProgress = false;
	protected String taskName;
	protected String taskID;
	
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
	
	public void setTaskID(String ID)
	{
		taskID = ID;
	}
	
	public String getTaskName()
	{
		return taskName;
	}
	public String getTaskID()
	{
		return taskID;
	}
	
	public DateTime getCurrent()
	{
		return current;
	}

	public abstract boolean setDateCompleted(DateTime dt);
	public abstract void setCurrentDate(DateTime t);
	//public abstract void setDateStarted(DateTime dt);

	
}