import java.util.Scanner;

public class main {

    public static void main (String[] args){
        Scanner sc = new Scanner (System.in);

        System.out.println("Voulez-vous crypter ou décrypter un texte ?");
        System.out.println("1- Crypter");
        System.out.println("2- Decrypter");
        String choix = sc.nextLine();

        System.out.println("Bonjour, veuillez entrer votre texte à crypter.");
        String texte1 = sc.nextLine();
        String texte = texte1.toLowerCase();

        System.out.println("Quel système de cryptage voulez-vous utiliser ?");
        System.out.println("1- César");
        System.out.println("2- ASCII");
        String type = sc.nextLine();

        if (type.equals("1") && choix.equals("1")){
            System.out.println("De combien voulez-vous décaler les lettres ?");
            int decalage = sc.nextInt();
            Cesar cesar = new Cesar(texte,decalage);
            System.out.println(cesar.crypt());
        }if(type.equals("1") && choix.equals("2")){
            System.out.println("De combien ont été décalées les lettres ?");
            int decalage = sc.nextInt();
            Cesar cesar = new Cesar(texte,decalage);
            System.out.println(cesar.decrypt());
        }if(type.equals("2") && choix.equals("1")){
            Ascii ascii = new Ascii(texte);
            System.out.println(ascii.crypt());
        }if(type.equals("2") && choix.equals("2")){
            Ascii ascii = new Ascii(texte);
            System.out.println(ascii.decrypt());
        }
    }
}