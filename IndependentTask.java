public class IndependentTask extends Task
{
	public boolean hasEndTime()
	{
		return false;
	}
	
	public DateTime getCurrentDate()
	{
		return current;
	}
	public void setCurrentDate(DateTime dt)
	{
		current = dt;
		if (isCompleted == false)
		start();
	}
	
	
	public boolean setDateCompleted(DateTime dt)
	{
		if(inProgress)
		{
		dateCompleted = dt;
		inProgress = false;
		isCompleted = true;
		return true;
		}
		else
			return false;
	}
	
	public boolean start()
	{
		if (current.isAfter(startDate) || current == startDate)
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
		taskID = 0;
		taskName = "default";
		dateStarted = null;
		dateCompleted = null;
		startDate = null;
		current = null;
	}
	
	public IndependentTask(DateTime start)
	{
		startDate = start;
		taskID = 0;
		taskName = "default";
		dateStarted = null;
		dateCompleted = null;
		current = null;
		
	}
	public IndependentTask(DateTime start, DateTime ncurrent)
	{
		startDate = start;
		current = ncurrent;
		taskID = 0;
		taskName = "default";
		start();
		
	}
	
	public IndependentTask(String name, int id)
	{
		taskID = id;
		taskName = name;
		dateStarted = null;
		dateCompleted = null;
		startDate = null;
		current = null;
	
	}
	public IndependentTask(String name, int id, DateTime start, DateTime ncurrent)
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

	public String toString()
	{
		if (inProgress)
		{
		return " \n\n Independent Task Info: ... " + "\n Task Name: " + taskName + "\n Task ID: " + taskID + "\n Start Date:------ " + startDate.toString() +
				"\n Current Date:----- " + current.toString() + "\n Status: In Progress....";
		}
		else if (isCompleted)
		{
			return " \n\n Independent Task Info: ...  " + "\n Task Name: " + taskName + "\n Task ID: " + taskID + "\n Start Date:----- " + startDate.toString() +
					"\n Current Date:----- " + current.toString() + "\n Status: Completed ! ";
		}
		else
		{
			return " \n\n Independent Task Info: ...  " + "\n Task Name: " + taskName + "\n Task ID: " + taskID + "\n Start Date:----- " + startDate.toString()  +
			"\n Current Date:----- " + current.toString() + "\n Status: Not Started....";
		}
	}

}