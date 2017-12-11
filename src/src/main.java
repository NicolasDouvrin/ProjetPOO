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
        System.out.println("2- XOR");
        String type = sc.nextLine();

        if(choix.equals("1") || choix.equals("2")){
            if(type.equals("1")||type.equals("2")){
                if (type.equals("1") && choix.equals("1")){
                    System.out.println("De combien voulez-vous décaler les lettres ?");
                    int decalage = sc.nextInt();
                    String textCrypt = Cesar.crypt(decalage,texte);
                    System.out.println(textCrypt);
                }if(type.equals("1") && choix.equals("2")){
                    System.out.println("De combien ont été décalées les lettres ?");
                    int decalage = sc.nextInt();
                    String textDecrypt = Cesar.decrypt(decalage,texte);
                    System.out.println(textDecrypt);
                }if(type.equals("2") && choix.equals("1")){
                    try {
                        System.out.println("Quelle est la clé ?");
                        String cle = sc.nextLine();
                        byte[] input = texte.getBytes();
                        byte[] key = cle.getBytes();
                        System.out.println(trial.encode(input, key));
                    }catch (Exception e){

                    }
                }if(type.equals("2") && choix.equals("2")){
                    try {
                        System.out.println("Quelle est la clé ?");
                        String cle = sc.nextLine();
                        byte[] key = cle.getBytes();
                        System.out.println(trial.decode(texte, key));
                    }catch (Exception e){

                    }
                }
            }
        }
    }
}