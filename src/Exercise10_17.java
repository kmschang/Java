import java.lang.*;
import java.math.BigInteger;

public class Exercise10_17
{
    public static void main (String[] args) throws java.lang.Exception
    {
        long num = (long)Math.sqrt(Long.MAX_VALUE);
        BigInteger nums=BigInteger.valueOf(num);
        for(int i=1;i<=10;i++)
        {
            BigInteger value=BigInteger.valueOf(1);
            nums=nums.add(value);
            value=nums.multiply(nums);
            System.out.println(value);
        }

    }
}