public class Test
{
	
public static void main(String[] args)
{
	DateTime time = new DateTime(1,12,2017,11,51,20);
	DateTime t2 = new DateTime(4,12,2017,18,9,23);
	DateTime someDeadline = new DateTime (12,12,2017,11,59,59);
	DateTime someStartTime = new DateTime(10,12,2017,5,32,59);
	
	
	DependentTask dt1 = new DependentTask(time, "Test1", "001");
	DependentTask dt2 = new DependentTask(time, "Test2", "002");
	DependentTask dt3 = new DependentTask();
	TimeConstrainedTask tct1 = new TimeConstrainedTask("TCT-01", "Time-Task 1",someStartTime, someDeadline );
	IndependentTask idt2 = new IndependentTask("IDT Test", "0x01" ,someStartTime, t2);
	
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
	tasks[1] = idt2;
	tasks[2] = tct1;
	
	int numberTasks = 3;
	
	for (int c = 0; c < numberTasks; c++)
	{
		tasks[c].setCurrentDate(someStartTime);
	}
	
	numberTasks = 0;
	
	
}

}
