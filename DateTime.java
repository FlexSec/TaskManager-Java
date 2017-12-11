public class DateTime {
	
	private int day;
	private int month;
	private int year;
	
	private int hours;
	private int minutes;
	private int seconds;
	
	public int getDay()
	{
		return day;
	}
	public int getMonth()
	{
		return month;
	}
	public int getYear()
	{
		return year;
	}
	public void setDay(int nday)
	{
		day = nday;
	}
	public void setMonth(int nmonth)
	{
		month = nmonth;
	}
	public void setYear(int nyear)
	{
		year = nyear;
	}
	
	public int getHours()
	{
		return hours;
	}
	public int getMinutes()
	{
		return minutes;
	}
	public int getSeconds()
	{
		return seconds;
	}
	public void setHours(int nhours)
	{
		hours = nhours;
	}
	public void setMinutes(int nminutes)
	{
		minutes = nminutes;
	}
	public void setSeconds(int nseconds)
	{
		seconds = nseconds;
	}
	
	public boolean isAfter(DateTime start)
	{
		if (start.getYear() < year)
			return true;
		else if (start.getYear() == year && start.getMonth() < month)
			return true;
		else if (start.getYear() == year && start.getMonth() == month && start.getDay() < day)
			return true;
		else
			return false;
	}
	
	public boolean isBefore(DateTime start)
	{
		if (start.getYear() > year)
			return true;
		else if (start.getYear() == year && start.getMonth() > month)
			return true;
		else if (start.getYear() == year && start.getMonth() == month && start.getDay() > day)
			return true;
		else
			return false;
	}
	
	public DateTime()
	{
		day = 1;
		month = 1;
		year = 1900;
		hours = 11;
		minutes = 59;
		seconds = 59;
	}
	
	public DateTime(int nday, int nmonth, int nyear, int nhours, int nminutes, int nseconds)
	{
		day = nday;
		month = nmonth;
		year = nyear;
		hours = nhours;
		minutes = nminutes;
		seconds = nseconds;
	}
	
	public DateTime(int nday, int nmonth, int nyear)
	{
		day = nday;
		month = nmonth;
		year = nyear;
		hours = 11;
		minutes = 59;
		seconds = 59;
	}
	
	public DateTime(DateTime dt)
	{
		day = dt.getDay();
		month = dt.getMonth();
		year = dt.getYear();
		hours = dt.getHours();
		minutes = dt.getMinutes();
		seconds = dt.getSeconds();
	}
	
	

}