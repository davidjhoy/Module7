public class Balloon {

    //lets make our own exception 
    private int MAX_PRESSURE = 200;
    private int pressure;

    public Balloon(){
        pressure = 0;
    }
    

    public void inflate() throws MaxInflationException{
        System.out.println("Attempting to inflate balloon by 10 units");

        if (pressure + 10 > MAX_PRESSURE){
            throw new MaxInflationException("POP!");
        }
        pressure += 10;
        System.out.println("Sucessfully inflated balloon to pressure: " + pressure);
    }

    public int getPressure(){
        return pressure;
    }

    public String toString(){
        return "Max Pressure: " + MAX_PRESSURE;
    }

    public static void main(String[] args){

        Balloon b1 = new Balloon();
        System.out.println(b1);

        for(int i = 0; i < 21; i++){
            try
            {
                b1.inflate();
            }
            catch(MaxInflationException ex)
            {
                System.out.println(ex);

            }
        }
    }


    
}
