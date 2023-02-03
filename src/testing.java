
public class testing {

    public static void main(String[] args){

        int j;
        int k;
        int[] zipcodeList = {48178, 46393, 48178};
        boolean duplicates = false;

        for (j = 0; j < zipcodeList.length; ++j){
            for (k =0; k < zipcodeList.length; ++k){
                if (j != k){
                    if (zipcodeList[j] == zipcodeList[k]){
                        duplicates = true;
                        break;
                    }
                }

            }

        }



    }

    public static boolean isReverse(int[] array1, int[] array2) {
        int k;
        int temp;

        for (k = 0; k < array1.length / 2; ++k) {
            temp = array1[k];
            array1[k] = array1[((array1.length - k) - 1)];
            array1[((array1.length - k) - 1)] = temp;
        }
        for (int i = 0; i < array1.length; ++i) {
            if (array1[i] != array2[i]) {
                for (k = 0; k < array1.length / 2; ++k) {
                    temp = array1[k];
                    array1[k] = array1[((array1.length - k) - 1)];
                    array1[((array1.length - k) - 1)] = temp;
                }
                return false;
            }
        }
        for (k = 0; k < array1.length / 2; ++k) {
            temp = array1[k];
            array1[k] = array1[((array1.length - k) - 1)];
            array1[((array1.length - k) - 1)] = temp;
        }
        return true;
    }

}
