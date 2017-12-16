import java.util.Arrays;

public class Ascii implements Mode {
    private String s;
    static String[] alphabet1 = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"," "};
    static String[] ascii = {"01100001","01100010","01100011","01100100","01100101","01100110","01100111","01101000","01101001","01101010","01101011","01101100","01101101","01101110","01101111","01110000","01110001","01110010","01110011","01110100","01110101","01110110","01110111","01111000","01111001","01111010","00000000"};

    public Ascii(String s) {
        this.s = s;  //constructeur
    }

    @Override
    public String crypt() {
        char[] charSIn = this.s.toCharArray();
        String[] charSOut = new String[charSIn.length]; // création d'un char de sortie pour mettre le message codé

        for (int i = 0; i < charSIn.length; i++) {

            int j = Arrays.asList(alphabet1).indexOf(String.valueOf(charSIn[i])); //correspondance entre la lettre et son pendant en ascii
            charSOut[i] = ascii[j];
        }
        return toString(charSOut);//retour du tableau sous forme de String
    }

    @Override
    public String decrypt() {
        char[] charSIn = this.s.toCharArray();
        String[] charSOut = new String[(charSIn.length)/8];

        for (int i=0;i<(charSIn.length)/8;i++){ // division du string obtenu pour faire correspondre au groupe de 8 vis à vis du code ascii
            String pate = new String();
            for (int j=0;j<8;j++){
                pate=pate+String.valueOf(charSIn[i*8+j]);
            }
            int k = Arrays.asList(ascii).indexOf(pate); //correspondance entre la lettre et son pendant en ascii
            charSOut[i] = alphabet1[k];
        }
        return toString(charSOut);
    }

    private static String toString(String[] tableau){ // permet de mettre en string le tableau de char final pour l'afficher
        String texte = new String();
        for (int i=0;i<tableau.length;i++){
            texte=texte+tableau[i];
        }
        return texte;
    }
}
