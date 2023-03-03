public class IntThreads implements Runnable{
    Thread thrd;
    Integers inObj;

    public IntThreads(String name,  Integers intsObj){
        thrd = new Thread(this, name);
        inObj = intsObj;
    }


    public static IntThreads startAndRun(String name, Integers insObj){
        IntThreads th = new IntThreads(name, insObj);
        th.thrd.start();
        return th;

        
    }


    public void run(){
       
        if (thrd.getName().compareTo("Pusher") == 0){
            
            for (int i = 1; i <11; i++){
                inObj.pushInt(i, true);
            }
            inObj.pushInt(0, false);
        }else{
            for(int i = 0; i < 10; i++){
                inObj.pullint(true);
            }
            inObj.pullint(false);
        }
    }

    public static void main(String[] args){
        //Create an Integers obj
        Integers inObj = new Integers();

        IntThreads thr1 = IntThreads.startAndRun("Pusher", inObj);
        IntThreads thr2 = IntThreads.startAndRun("Puller", inObj);

        try{
            thr1.thrd.join();
            thr2.thrd.join();
        }catch(InterruptedException ex){
            System.out.println("System interrupted: " + ex);
        }
    }
}
