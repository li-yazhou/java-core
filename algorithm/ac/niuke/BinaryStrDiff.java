package ac.niuke;

/**
 * Created by liyazhou on 2017/2/23.
 */
public class BinaryStrDiff {
    public static void main(String[] args){
        BinaryStrDiff.countBitDiff2(16807, 282475249);
    }


    private static int countBitDiff2(int m, int n){
        String str = Integer.toBinaryString(m^n);
        str = str.replaceAll("0", "");
        return str.length();
    }

    //python code is,  f = lambda a,b: str(bin(a^b)).count("1")
}
