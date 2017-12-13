import java.util.Arrays;

public class Ascii {
    static String[] alphabet1 = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"," "};
    static String[] ascii = {"01100001","01100010","01100011","01100100","01100101","01100110","01100111","01101000","01101001","01101010","01101011","01101100","01101101","01101110","01101111","01110000","01110001","01110010","01110011","01110100","01110101","01110110","01110111","01111000","01111001","01111010","00000000"};

    public static String[] crypt(String s) {

        char[] charSIn = s.toCharArray();
        String[] charSOut = new String[charSIn.length];

        for (int i = 0; i < charSIn.length; i++) {

            int j = Arrays.asList(alphabet1).indexOf(String.valueOf(charSIn[i]));
            charSOut[i] = ascii[j];

        }
        return charSOut;
    }

    public static String[] decrypt(String s) {

        char[] charSIn = s.toCharArray();
        String[] charSOut = new String[(charSIn.length)/8];

        for (int i=0;i<(charSIn.length)/8;i++){
            String pate = new String();
            for (int j=0;j<8;j++){
                pate=pate+String.valueOf(charSIn[i*8+j]);
            }
            int k = Arrays.asList(ascii).indexOf(pate);
            charSOut[i] = alphabet1[k];
        }
        return charSOut;
    }

    public static String toString(String[] tableau){
        String texte = new String();
        for (int i=0;i<tableau.length;i++){
            texte=texte+tableau[i];
        }
        return texte;
    }
}
