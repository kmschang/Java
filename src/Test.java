public class Test{

      int chanel = 1;
      int volume = 1;
      boolean status = false;


    Test()
    {}

    Test(int vol, int chal, boolean stat)
    {
        chanel = chal;
        volume = vol;
        status = stat;
    }


    public void turnOn(){
        status = true;
    }
    public void turnOff(){
        status = false;
    }



    public void channelUp(){
        if (status) ++ chanel;
    }
    public void chanelDown(){
       if (status) -- chanel;
    }
    public void setChanel(int chal){
        if (status) chanel = chal;
    }



    public void volumeUp(){
       if (status) ++ volume;
    }
    public void volumeDown(){
       if (status) -- volume;
    }
    public void setVolume(int vol){
        if (status) volume = vol;
    }


    public static void main(String[] args){


        Test TV1 = new Test(1,1,false);
        System.out.println("Chanel: "+TV1.chanel);
        System.out.println("Volume: "+TV1.volume);
        System.out.println("Status: "+TV1.status);

        TV1.turnOn();
        System.out.println("Status: "+TV1.status);


        TV1.channelUp();
        System.out.println("Chanel: "+TV1.chanel);


        Parameters nums = new Parameters(22,34);
        System.out.println("Base: " + nums.base);
        System.out.println("Height: " + nums.height);

        System.out.println(Area.circleArea(nums.radius));



    }

}

class Area{

    static double pi = 3.1415926;

    public static double sqr(double num){
        return num * num;
    }

    public static double rectangleArea(double height, double width){
        return height * width;
    }

    public static double circleArea(double radius){
        return radius * radius * pi;
    }

    public static double squareArea(double width){
        return Area.sqr(width);
    }

    public static double triangleArea(double base, double height){
        return base * height * .5;
    }


}




class Parameters{

     double height = 0;
     double width = 0;
     double radius = 0;
     double base = 0;

     Parameters(){}

    Parameters(double radius_width){
         radius = radius_width;
         width = radius_width;
    }

    Parameters(double base_width_radius, double height_){
         width = base_width_radius;
         base = base_width_radius;
         radius = base_width_radius;
         height = height_;
    }


}



class Circle1{

    private final int radius;

    Circle1(){
        radius = 1;
    }

    Circle1(int r1){
        radius = r1;
    }


    double getArea(int rad){
        return rad * rad * Math.PI;
    }

    double getPerimeter(int rad){
        return 2 * Math.PI * rad;
    }












}