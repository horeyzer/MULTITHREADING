public class MyThreadVer3 implements Runnable
{
    Thread thread;
    //...
    MyThreadVer3(String name)
    {
        thread = new Thread(this, name); //at the moment of creating a thread   get a name
    }
    //a manufacturing method that creates and starts the thread
    public static MyThreadVer3 createAndStart(String name)
    {
        MyThreadVer3 myThreadVer3 = new MyThreadVer3(name);
        myThreadVer3.thread.start();
        return myThreadVer3;
    }
    //starts executing a new thread
    public void run()
    {
        System.out.println(thread.getName() + " starts to operate");
        try
        {
            for (int count = 0; count < 10; count++) {
                Thread.sleep(100);
                System.out.println(thread.getName() + " is executed. the counter value:" + count);
            }
        }
        catch (InterruptedException e)
        {
            System.out.println(thread.getName() + " has been interrupted");
        }
        System.out.println(thread.getName() + " finishes running.");
    }
}

class JoinThreads
{
    public static void main(String[] args)
    {
        System.out.println("The main thread starts running.");
        MyThreadVer3 myThread1 = MyThreadVer3.createAndStart("Child thread # 1");
        MyThreadVer3 myThread2 = MyThreadVer3.createAndStart("Child thread # 2");
        MyThreadVer3 myThread3 = MyThreadVer3.createAndStart("Child thread # 3");
        try
        {
            myThread1.thread.join(); //waits for the specified thread to finish
            System.out.println("Child thread # 1 terminated");
            myThread2.thread.join(); //waits for the specified thread to finish
            System.out.println("Child thread # 2 terminated");
            myThread3.thread.join(); //waits for the specified thread to finish
            System.out.println("Child thread # 3 terminated");
        }
        catch (InterruptedException e)
        {
            System.out.println("The main thread has been terminated");
        }
        System.out.println("The main thread is exiting");
    }
}
class MoreThreads2
{
    public void main(String[] args)
    {
        System.out.println("The main thread starts running.");
        //...
        MyThreadVer3 myThread1 = MyThreadVer3.createAndStart("Child thread # 1");
        MyThreadVer3 myThread2 = MyThreadVer3.createAndStart("Child thread # 2");
        MyThreadVer3 myThread3 = MyThreadVer3.createAndStart("Child thread # 3");
        do
        {
            System.out.print(".");
            try
            {
                Thread.sleep(100);
            }
            catch (InterruptedException e)
            {
                System.out.println("The main thread has been terminated");
            }
        }
        while (myThread1.thread.isAlive() || myThread2.thread.isAlive() || myThread3.thread.isAlive());
        System.out.println("The main thread is exiting");
    }
}