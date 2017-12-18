import java.util.Scanner;
import java.util.InputMismatchException;
public class Test
{
    public static void main(String[] args) {



        Task[] t = new Task[10];
        int numberoftasks = 0;
        Scanner input = new Scanner(System.in);
        //Setting default time
        int choice = 0;
        DateTime cdt = new DateTime();
        //finals for each of the tasks
        final int ADD_NEW_TASK = 1;
        final int UPDATE_TIME = 2;
        final int MARK_TASK_COMPLETE = 3;
        final int TASK_REPORT = 4;
        final int EXIT = 5;
        final int TIMED_TASK = 1;
        final int INDEPENDENT_TASK = 2;
        final int DEPENDENT_TASK = 3;
        //Assigning task id



        do {
            System.out.println("\nWelcome to the Task Management Window");
            System.out.println("The time is Date and Time is currently: " + cdt);
            System.out.println("\n1: Add a new task");
            System.out.println("2: Update the current date/time");
            System.out.println("3: Mark a task as completed");
            System.out.println("4: Get task report");
            System.out.println("5: Exit");
            System.out.print("Which would you like to do today?\n");

            try
            {
                choice = input.nextInt();
            switch (choice) {
                    case ADD_NEW_TASK: {
                        System.out.println("Task Creation Menu\n");
                        System.out.printf("New Task ID: %d\n", numberoftasks + 1);
                        System.out.println("Please enter a description");
                        input.nextLine();
                        String d = input.nextLine();
                        System.out.println("What time does the task start?\n");
                        System.out.println("Please enter the Month: For example 1 for January");
                        int M = input.nextInt();
                        System.out.println("\nPlease enter the Day");
                        int D = input.nextInt();
                        if(D > 31 || M >= 13)
                        {
                            System.out.println("Invalid Date, please try again");
                            break;
                        }
                        System.out.println("Please enter the Year");
                        int Y = input.nextInt();
                        System.out.println("Please enter the Hour");
                        int h = input.nextInt();
                        System.out.println("Please enter the Minute");
                        int m = input.nextInt();
                        System.out.println("Please enter the seconds");
                        int s = input.nextInt();
                        
                        if (h > 24 || m > 59 || s > 59)
                        {
                        	System.out.println("Invalid Time, please try again");
                            break;
                        }
                        DateTime sdt = new DateTime(D, M, Y, h, m, s);
                        if(M == 2 && sdt.isLeapYear() && D > 29)
                        {
                            System.out.println("This date is in invalid");
                            break;
                        }
                        if(M == 2 && D >= 29 && sdt.isLeapYear() == false)
                        {
                            System.out.println("This date is in invalid because it either doesn't exist or it's not a Leap Year");
                            break;
                        }
                        if(M == 4 || M == 6 || M == 9 || M== 11 && D >= 31)
                        {
                            System.out.println("This date is invalid; doesn't exist");
                            break;
                        }
                        
                        System.out.println("Which task would you like to create?\n");
                        System.out.println("1: Timed Task");
                        System.out.println("2: Independent Task");
                        System.out.println("3: Dependent Task");
                        int option = input.nextInt();
                        switch (option) {
                            case TIMED_TASK: {
                                System.out.println("What time does the task end?\n");
                                System.out.println("Please enter the Month: For example 1 for January");
                                int endM = input.nextInt();
                                if(endM <1 || endM>12)
                                {
                                    System.out.println("Oops! Please make sure the values for the month are between 1 and 12");
                                    break;
                                }
                                System.out.println("\nPlease enter the Day");
                                int endD = input.nextInt();
                                System.out.println("Please enter the Year");
                                int endY = input.nextInt();
                                System.out.println("Please enter the Hour");
                                int endh = input.nextInt();
                                System.out.println("Please enter the Minute");
                                int endm = input.nextInt();
                                System.out.println("Please enter the seconds");
                                int ends = input.nextInt();
                                DateTime edt = new DateTime(endD, endM, endY, endh, endm, ends);
                                if(edt.isBefore(sdt))
                                {
                                    System.out.println("oops! An issue has come up, the end date and time is before the start date and time. Please check your dates and make sure you have entered them correctly.");
                                    break;
                                }
                                for(int c =0; c<numberoftasks; c++)
                               {
                                   if(t[c].hasEndTime())
                                    {
                                        if(sdt.isBefore(t[c].getFinish()))
                                       {
                                            System.out.println("Oops! There seems to be another task already taking place during that time, please try another time");
                                            break;
                                        }
                                       else if(edt.isAfter(t[c].getStartingDate()))
                                        {
                                            System.out.println("Oops! There seems to be another task already taking place during that time, please try another time");
                                            break;
                                        }
                                    }
                                }
                                t[numberoftasks] = new TimeConstrainedTask(numberoftasks + 1, d, sdt, edt);
                                numberoftasks++;
                                System.out.println("Task: " + numberoftasks + "Created: " + d);
                                break;

                            }
                            case INDEPENDENT_TASK:
                                t[numberoftasks] = new IndependentTask(d, numberoftasks + 1, sdt, cdt);
                                numberoftasks++;
                                System.out.println("Task: " + numberoftasks + " Created: " + d);
                                break;
                            case DEPENDENT_TASK:
                                //show list of tasks for user to select from
                                System.out.println("Task Report\n");
                                for (int c = 0; c < numberoftasks; c++) {
                                    System.out.println(t[c]);
                                    System.out.println(t[c].getTaskID());
                                }
                                System.out.println("Which task is the new task dependent on?");
                                int depTask = input.nextInt();
                                DependentTask temp = new DependentTask(sdt, d, numberoftasks + 1);

                                temp.addPreReq(t[depTask - 1]);
                                t[numberoftasks] = temp;
                                numberoftasks++;

                                System.out.println("Task: " + numberoftasks + "Created: " + d);
                                break;
                            default:
                                System.out.println("Invalid Task Option");
                                t = null;
                                break;
                        }
                        break;

                    }
                    case UPDATE_TIME: {
                        System.out.println("Update Date and Time\n");
                        System.out.println("Please enter the Month: For example 1 for January");
                        int cM = input.nextInt();
                        System.out.println("Please enter the Day");
                        int cD = input.nextInt();
                        System.out.println("Please enter the Year");
                        int cY = input.nextInt();
                        System.out.println("Please enter the Hour");
                        int ch = input.nextInt();
                        System.out.println("Please enter the Minute");
                        int cm = input.nextInt();
                        System.out.println("Please enter the seconds");
                        int cs = input.nextInt();
                        cdt = new DateTime(cD, cM, cY, ch, cm, cs);
                        //code to show any tasks that have started
                        for (int c = 0; c < numberoftasks; c++) {
                            t[c].setCurrentDate(cdt);
                            System.out.println(t[c]);
                        }
                        break;
                    }
                    case MARK_TASK_COMPLETE: {
                        System.out.println("Mark a task as completed\n");
                        System.out.println("Task Report\n");
                        for (int c = 0; c < numberoftasks; c++) {
                            System.out.println(t[c].toString());

                        }
                        System.out.println("Which task would you like to mark as completed?");
                        int taskNum = input.nextInt();
                        System.out.println("Task Report\n");
                        for (int c = 0; c < numberoftasks; c++) {
                            if (t[c].getTaskID() == taskNum) {
                                t[c].setDateCompleted(cdt);
                            }

                        }
                        //searches array for the task with that ID number
                        //marks it as completed
                        //prints out the remaining tasks
                        break;
                    }
                    case TASK_REPORT: {
                        System.out.println("Task Report\n");
                        for (int c = 0; c < numberoftasks; c++) {
                            System.out.println(t[c].toString());
                        }
                        break;
                    }
                    case EXIT: {
                        System.out.println("Have a nice day!");
                        break;
                    }
                }
            }
            catch(InputMismatchException e)
            {
                System.out.println("Oops!, something happened. Please make sure to use only integers");
                input.nextLine();
            }

        } while (choice != EXIT);
        input.close();
    }

}