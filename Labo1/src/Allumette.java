import java.util.Scanner;

/**
 * Created by BelSi1731422 on 2018-01-15.
 */
public class Allumette {
    public static void main(String[] args) {
        //valeur
        int coups[][] = new int[2][50];
        int tours = 0;
        int nbAllu = 0;
        int enlever = 0;
        char rejouer = 'o';//n,o
        String nom1 = "oui";
        String nom2 = "non";
        String joueur[] = new String[2];
        int nbRandom = 0;
        int gagnant = 0;
        boolean fini = false;
        int nbPartie = 1;

        Scanner sc = new Scanner(System.in);

        System.out.println("Bienvenue au jeu des allumettes");

        while(rejouer == 'o'){
            System.out.println("====================");
            System.out.println("     Partie "+nbPartie);
            System.out.println("====================");

            System.out.println("Quel est le nom du joueur 1?");
            nom1 = sc.next();
            System.out.println("Quel est le nom du joueur 2?");
            nom2 = sc.next();
            nbAllu = (int)(Math.random()*80+20);
            nbRandom = (int)(Math.random()*2);
            System.out.println("Il y a "+nbAllu+" allumettes");

            if (nbRandom==0){
                joueur[0] = nom1;
                joueur[1] = nom2;
            }
            else if (nbRandom==1){
                joueur[1] = nom1;
                joueur[0] = nom2;
            }
            while(nbAllu>0){
                for (int i=0;i<2;i++){
                    gagnant=i;
                    System.out.println(joueur[i]+", combien d'allumette veut tu enlever? ");
                    enlever = sc.nextInt();
                    if (enlever>=1&&enlever<=3){
                        nbAllu = nbAllu-enlever;
                        coups[i][tours] = enlever;
                        System.out.println("Il reste "+nbAllu+" Allumettes!");
                    }
                    else{
                        System.out.println("Erreur");
                        i--;
                    }
                }
                if (gagnant==0){
                    System.out.println("Le gagnant est... "+ joueur[1]+"!!!");
                }
                else if (gagnant==1) {
                    System.out.println("Le gagnant est... " + joueur[0] + "!!!");
                }
                tours++;
            }
            System.out.println("Voici les résultats : ");
            System.out.print(joueur[0]);
            for (int y=0;y<50;y++){
                if (coups[0][y]==0){
                    y=50;
                }
                else if (coups[0][y]!=0){
                    System.out.print("  Tour "+(y+1)+" : "+coups[0][y]);
                    System.out.println("");
                }
            }
            System.out.print(joueur[1]);
            for (int y=0;y<50;y++){
                if (coups[1][y]==0){
                    y=50;
                }
                else if (coups[1][y]!=0){
                    System.out.print("  Tour "+(y+1)+" : "+coups[1][y]);
                    System.out.println("");
                }
            }
            System.out.println("Voulez-vous continuez(o/u)");
            rejouer=sc.next().toLowerCase().charAt(0);
            nbPartie =nbPartie+1;
            System.out.println("");

        }
        System.exit(0);
    }
}
