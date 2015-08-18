package server;


public class ApplicationThread implements Runnable {
    public ApplicationThread() {
    }

    @Override
    public void run() {
        System.out.println(" Thred run ");
    }

    public static void init() {
        Thread t=new Thread(new ApplicationThread());
        t.start();
        System.out.println("init thread start");
        System.out.println("t.getName()=" + t.getName());


        Thread t2=new Thread(new ApplicationThread());
        t2.start();
        System.out.println("init thread2 start");
        System.out.println("t2.getName()=" + t2.getName());


        Thread t3=new Thread(new ApplicationThread());
        t3.start();
        System.out.println("init thread3 start");
        System.out.println("t3.getName()=" + t3.getName());

        Thread t4=new Thread(new ApplicationThread());
        t4.start();
        System.out.println("init thread4 start");
        System.out.println("t4.getName()="+t4.getName());

        for(int i = 0; i < 10; i++)
        {
            try{
                t2.sleep(10000);		//Приостанавливает поток на 10 секунду
            }catch(InterruptedException e){}

            System.out.println(" курица!   ");
        }


    }

}
