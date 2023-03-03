public class IntThreads implements Runnable{
    Thread thrd;
    Integers inObj;

    public IntThreads(String name){
        thrd = new Thread(name);
    }


    public void startAndRun(String name, Integers intsObj){
        IntThreads th = new IntThreads(name);
        th.thrd.start();

        inObj = intsObj;
    }


    public void run(){
        if (thrd.getName().compareTo("Pusher") == 0){
            for (int i = 1; i <11; i++){
                inObj.pushInt();
            }
        }else{
            for(int i = 1; i < 11; i++){
                inObj.pullint();
            }
        }
    }

    public static void main(String[] args){
        
    }
}
