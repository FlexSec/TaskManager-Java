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
		else if (start.getYear() == year && start.getMonth() == month && start.getDay() == day && start.getHours() < hours)
			return true;
		else if (start.getYear() == year && start.getMonth() == month && start.getDay() == day && start.getHours() == hours && start.getMinutes() < minutes)
			return true;
		else if (start.getYear() == year && start.getMonth() == month && start.getDay() == day && start.getHours() == hours && start.getMinutes() == minutes && start.getSeconds() < seconds)
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
		else if (start.getYear() == year && start.getMonth() == month && start.getDay() == day && start.getHours() > hours)
			return true;
		else if (start.getYear() == year && start.getMonth() == month && start.getDay() == day && start.getHours() == hours && start.getMinutes() > minutes)
			return true;
		else if (start.getYear() == year && start.getMonth() == month && start.getDay() == day && start.getHours() == hours && start.getMinutes() == minutes && start.getSeconds() > seconds)
			return true;
		else
			return false;
	}
	
	public int toSeconds()
	{
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
		{
			return ( (day-1 * 86400) + (month-1 * (31 * 86400) ) + ((year-1 - 1900) * ((365 * 86400)) + (hours-1 * 3600) + (minutes-1 * 60) + seconds)) ;
		}
		else if (month == 4 || month == 6 || month == 9 || month == 11)
		{
			return ( (day-1 * 86400) + (month-1 * (30 * 86400) ) + ((year-1 - 1900) * (365 * 86400)) + (hours-1 * 3600) + (minutes-1 * 60) + seconds) ;
		}
		else if (month == 2 && year % 400 == 0)
		{
			return ( (day-1 * 86400) + (month-1 * (29 * 86400) ) + ((year-1 - 1900) * (365 * 86400)) + (hours-1 * 3600) + (minutes * 60) + seconds) ;
		}
		else
		{
			return ( (day-1 * 86400) + (month-1 * (28 * 86400) ) + ((year-1 - 1900) * (365 * 86400)) + (hours-1 * 3600) + (minutes-1 * 60) + seconds) ;
		}
	}
	
	public boolean isLeapYear()
	{
		if (year % 400 == 0)
		{
			return true;
		}
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
	
	public String toString()
	{
		return "\n\n Date: " + month + " / " + day + " / " + year + "\n Time: " + hours + " : " + minutes + " : " + seconds;
	}
	

}