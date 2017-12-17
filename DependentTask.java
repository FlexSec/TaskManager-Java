public class DependentTask extends Task 
{
	private Task prereqTask;
	private boolean hasPreReq;
	private boolean canStart;
	
	
	
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
	public void addPreReq(IndependentTask t1)
	{
		prereqTask = t1;
		hasPreReq = true;
		canStart = false;
		inProgress = false;
		dateStarted = null;
	}
	public void addPreReq(Task t1)
	{
		prereqTask = t1;
		prereqTask = t1;
		hasPreReq = true;
		canStart = false;
		inProgress = false;
		dateStarted = null;
		
	}
	
	public void clearPreReq()
	{
		prereqTask = null;
		hasPreReq = false;
		canStart = true;
		
	}
	public void setCurrentDate(DateTime dt)
	{
		current = dt;
		if (dt == startDate || dt.isAfter(startDate))
		{
			setDateStarted(dt);
		}
	}

	
	public DependentTask()
	{
		taskName = "blank";
		taskID = 0;
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
		taskID = 0;
		isCompleted = false;
		dateCompleted = null;
		hasPreReq = false;
		canStart = true;
		inProgress = true;
		dateStarted = new DateTime(dt);
		
	}

	public DependentTask(DateTime dt, String name, int ID)
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
	
	public DependentTask(DateTime dt, int ID)
	{
		taskName = "blank";
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
		taskID = 0;
		isCompleted = false;
		dateCompleted = null;
		hasPreReq = true;
		prereqTask = t1;
		setDateStarted(dt);
		
	}
	public DependentTask(DateTime dt, DependentTask t1, String name, int ID)
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

	
	public String toString()
	{
		
		
		if (inProgress)
		{
		return " \n\n Dependent Task Info: ... " + "\n Task Name: " + taskName + "\n Task ID: " + taskID  +
				"\n Current Date:----- " + current.toString() + "\n Status: In Progress....";
		}
		else if (isCompleted)
		{
			return " \n\n Dependent Task Info: ...  " + "\n Task Name: " + taskName + "\n Task ID: " + taskID +
					"\n Current Date:----- " + current.toString() + "\n Status: Completed ! ";
		}
		else
		{
			if (hasPreReq)
			{
			return " \n\n Dependent Task Info: ...  " + "\n Task Name: " + taskName + "\n Task ID: " + taskID +
					"\n Current Date:----- " + current.toString() + "\n Status: Waiting on Prerequisite Task...." + "\n Prerequisite Task Info:" + prereqTask.toString();
			}
			else
				return " \n\n Dependent Task Info: ...  " + "\n Task Name: " + taskName + "\n Task ID: " + taskID +
				"\n Current Date:----- " + current.toString() + "\n Status: Not Yet Started....";
		}
		
		
	}

	
}