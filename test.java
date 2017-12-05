
public class test
{
	
public static void main(String[] args)
{
	DateTime time = new DateTime(12,1,2017,11,51,20);
	DateTime t2 = new DateTime(12,4,2017,18,9,23);
	DependentTask dt1 = new DependentTask(time, "Test1", "001");
	DependentTask dt2 = new DependentTask(time, "Test2", "002");
	DependentTask dt3 = new DependentTask();
	
	dt2.addPreReq(dt3);
	dt1.addPreReq(dt2);
	
	if (dt1.setDateCompleted(t2))
	{
		System.out.printf("\n Task Is now Finished");
	}
	else
		System.out.printf("\n Unable to Complete. Check Prerequisities");
	
	if (dt2.setDateCompleted(t2))
	{
		System.out.printf("\n Task is now Finished");
	}
	else
		System.out.printf("\n Unable to Complete Check prerequisites");
	
	if (dt3.setDateCompleted(t2))
	{
		dt2.clearPreReq(t2);
		System.out.printf("\n Task is now Finished");
		
	}
	else
		System.out.printf("\n UNable to Complete, Check prerequisites");
	
	if (dt2.setDateCompleted(t2))
	{
		dt1.clearPreReq(t2);
		System.out.printf("\n Task is now Finished");
	}
	else
		System.out.printf("\n Unable to Complete Check prerequisites");
	
	if (dt1.setDateCompleted(t2))
	{
		System.out.printf("\n Task Is now Finished");
	}
	else
		System.out.printf("\n Unable to Complete. Check Prerequisities");
	
	
	
	Task tasks[] = new Task[10];
	
	tasks[0] = dt1;
	
	
}

}