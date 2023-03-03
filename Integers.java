public class Integers {
    private int V;
    private boolean isEmpty;

    public Integers(){
        //int store is initially false
        isEmpty = true;
        
    }
    

    public synchronized void pushInt(int i, boolean running){

        if (!running){
            isEmpty = false;
            notify();
            return;
        }

        V = i;
        isEmpty = false;
        notify();

        try{
            while(!isEmpty){
                wait();
            }

        }catch(InterruptedException ex){
            System.out.println("System Interrupted");
        }

    }
    

    public synchronized void pullint(boolean running){

        if (!running){
            isEmpty = true;
            notify();
            return;
        }

        System.out.println("Value of int store is: " + V);
        isEmpty = true;
        notify();


        try{
            while(isEmpty){
                wait();
            }

        }catch(InterruptedException ex){
            System.out.println("System Interrupted");
        }

    }
}
