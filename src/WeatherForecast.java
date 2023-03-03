public class WeatherForecast {

    private String skies = "";
    private int high = 0;
    private int low = 0;


    public void setSkies(String skies1){
        skies = skies1;
    }
    public void setHigh(int hi){
        high = hi;
    }
    public void setLow(int lo){
        low = lo;
    }


    public String getSkies(){
        return skies;
    }
    public int getHigh(){
        return high;
    }
    public int getLow(){
        return low;
    }



}
