public class TimeConstrainedTask extends Task
{
	private DateTime startTime;
	private DateTime deadline;
	
	public boolean hasEndTime()
	{
		return true;
	}
	
	public void setStartTime(DateTime dt)
	{
		startTime = dt;
	}
	public void setDeadline(DateTime dt)
	{
		deadline = dt;
	}
	public DateTime getStartTime()
	{
		return startTime;
	}
	public DateTime getDeadline()
	{
		return deadline;
	}
	public void setCurrentDate(DateTime dt)
	{
		current = dt;
		if (current == deadline || current.isAfter(deadline))
		{
			dateCompleted = current;
			isCompleted = true;
			inProgress = false;
		}
		else if (current == startTime || current.isAfter(startTime))
		{
			dateStarted = current;
			inProgress = true;
		}
	}
	public boolean setDateCompleted(DateTime dt)
	{
		
		if (inProgress)
		{
			dateCompleted = dt;
			isCompleted = true;
			inProgress = false;
			return true;
		}
		else
			return false;
			
	}
	
	public TimeConstrainedTask()
	{
		taskID = 0;
		taskName = "default";
		startTime = null;
		deadline = null;
	}
	
	public TimeConstrainedTask(int id, String name, DateTime st, DateTime dl)
	{
		taskID = id;
		taskName = name;
		startTime = st;
		startDate = st;
		finishDate = dl;
		deadline = dl;
	}
	
	public TimeConstrainedTask(int id, String name, DateTime st, DateTime dl, DateTime ncurrent)
	{
		taskID = id;
		taskName = name;
		startTime = st;
		deadline = dl;
		finishDate = dl;
		startDate = st;
		setCurrentDate(ncurrent);
	}
	
	public TimeConstrainedTask(TimeConstrainedTask tct)
	{
		taskID = tct.getTaskID();
		taskName = tct.getTaskName();
		startTime = tct.getStartTime();
		deadline = tct.getDeadline();
		startDate = tct.getStartingDate();
		finishDate = tct.getFinish();
		setCurrentDate(tct.getCurrent());
	}
	
	public String toString()
	{
		if (inProgress)
		{
		return "\n\n Time Constrained Task Info: ... " + "\n Task Name: " + taskName + "\n Task ID: " + taskID + "\n Start Time:----- " + startTime.toString() + "\n Deadline:----- " + deadline.toString() +
				"\n Current Date:----- " + current.toString() + "\n Status: In Progress....";
		}
		else if (isCompleted)
		{
			return "\n\n Time Constrained Task Info: ... " + "\n Task Name: " + taskName + "\n Task ID: " + taskID + "\n Start Time:----- " + startTime.toString() + "\n Deadline:----- " + deadline.toString() +
					"\n Current Date:----- " + current.toString() + "\n Status: Completed ! ";
		}
		else
		{
			return "\n\n Time Constrained Task Info: ... " + "\n Task Name: " + taskName + "\n Task ID: " + taskID + "\n Start Time:----- " + startTime + "\n Deadline:----- " + deadline.toString() +
			"\n Current Date:----- " + current.toString() + "\n Status: Not Started....";
		}
		
	}
}