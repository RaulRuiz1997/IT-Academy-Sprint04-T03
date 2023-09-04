import exercici1.*;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner lector = new Scanner(System.in);

    public static void main(String[] args) {

        /*
        Crear Floristeria.
        Afegir Arbre.
        Afegir Flor.
        Afegir Decoració.
        Stock: Imprimeix per pantalla tots els arbres, flors i decoració que té la floristeria.
        Retirar arbre.
        Retirar flor.
        Retirar decoració.
        Printar per pantalla stock amb quantitats.
        Printar per pantalla valor total de la floristeria.
        Crear tickets de compra amb múltiples objectes.
        Mostrar una llista de compres antigues.
        Visualitzar el total de diners guanyats amb totes les vendes.
        */

        String opcio = "0";
        List<Floristeria> floristerias = new ArrayList<>();
        List<Arbre> arbres = new ArrayList<>();
        List<Flor> flors = new ArrayList<>();
        List<Decoracio> decoracions = new ArrayList<>();
        String nomFloristeria = "";
        String nomArbre = "";
        String nomFlor = "";
        String colorFlor = "";
        Arbre arbre;
        Flor flor;
        Decoracio decoracio;
        TipusMaterial tipusMaterial = TipusMaterial.FUSTA;
        double alcadaArbre = 0;
        double preuArbre = 0;
        double preuFlor = 0;
        double preuDecoracio = 0;

        while (!opcio.equals("14")) {

            System.out.println("Introdueix una opció:\n" +
                    "        1. Crear Floristeria.\n" +
                    "        2. Afegir Arbre.\n" +
                    "        3. Afegir Flor.\n" +
                    "        4. Afegir Decoració.\n" +
                    "        5. Stock: Imprimeix per pantalla tots els arbres, flors i decoració que té la floristeria.\n" +
                    "        6. Retirar arbre.\n" +
                    "        7. Retirar flor.\n" +
                    "        8. Retirar decoració.\n" +
                    "        9. Printar per pantalla stock amb quantitats.\n" +
                    "        10. Printar per pantalla valor total de la floristeria.\n" +
                    "        11. Crear tickets de compra amb múltiples objectes.\n" +
                    "        12. Mostrar una llista de compres antigues.\n" +
                    "        13. Visualitzar el total de diners guanyats amb totes les vendes.\n" +
                    "        14. Sortir");

            opcio = lector.nextLine();

            switch (opcio) {
                case "1":

                    System.out.println("Crear Floristeria:");
                    System.out.println("Introdueix el nom de la floristeria");
                    nomFloristeria = lector.nextLine();

                    System.out.println("Introdueix els arbres. Mínim ha de haber-hi 1 arbre, escriu 'stop' per parar de afegir arbres");
                    while (true) {

                        System.out.println("Nom arbre número " + (arbres.size() + 1) + ":");

                        nomArbre = lector.nextLine();

                        if (nomArbre.equals("stop") && arbres.size() > 0) {
                            break;
                        } else {
                            System.out.println("Ha de haber-hi mínim 1 arbre!");
                        }

                        arbres.add(crearArbre(arbres, nomArbre));

                        System.out.println("Arbre afegit!");

                    }

                    System.out.println("Introdueix les flors. Mínim ha de haber-hi 1 flor, escriu 'stop' per parar de afegir flors");
                    while (!nomFlor.equals("stop") && flors.size() > 0) {

                        flors.add(crearFlor(flors));

                        System.out.println("Flor afegida!");

                    }

                    System.out.println("Introdueix les decoracions. Mínim ha de haber-hi 1 decoració, escriu 'stop' per parar de afegir decoracions");
                    while (!tipusMaterial.toString().equals("stop") && decoracions.size() > 0) {

                        decoracions.add(crearDecoracio(decoracions));

                        System.out.println("Arbre afegit!");

                    }

                    // String nom, List<Arbre> arbres, List<Flor> flors, List<Decoracio> decoracio
                    floristerias.add(new Floristeria(nomFloristeria, arbres, flors, decoracions));

                    System.out.println("Floristeria creada!");

                    break;

                case "2":

                    System.out.println("Crear arbre:");

                    crearArbre(arbres, nomArbre);

                    System.out.println("Arbre creat!");

                    break;

                case "3":

                    // Crear flor

                    System.out.println("Crear flor:");

                    crearFlor(flors);

                    System.out.println("Flor creada!");

                    break;

                case "4":

                    // Crear decoració

                    System.out.println("Crear decoració:");

                    crearDecoracio(decoracions);

                    System.out.println("Decoració creada!");

                    break;

                case "5":

                    break;
                case "6":

                    break;
                case "7":

                    break;
                case "8":

                    break;
                case "9":

                    break;
                case "10":

                    break;
                case "11":

                    break;
                case "12":

                    break;
                case "13":

                    break;
                case "14":
                    System.out.println("Sortint de la aplicació");
                    break;
                default:
                    System.out.println("introdueix una opció correcte!");
            }
        }

    }

    public static Arbre crearArbre(List<Arbre> arbres, String nomArbre) {

        Scanner lector = new Scanner(System.in);
        double alcadaArbre;
        double preuArbre;

        System.out.println("Alçada:");

        while (true) {

            if (!lector.hasNextDouble()) {
                System.out.println("Introdueix un valor vàlid!");
                lector.next();
            } else {
                alcadaArbre = lector.nextDouble();
                break;
            }

        }

        System.out.println("Preu:");

        while (true) {

            if (!lector.hasNextDouble()) {
                System.out.println("Introdueix un valor vàlid!");
                lector.next();
            } else {
                preuArbre = lector.nextDouble();
                break;
            }

        }

        return new Arbre(nomArbre, alcadaArbre, preuArbre);

    }

    public static Flor crearFlor(List<Flor> flors) {

        Scanner lector = new Scanner(System.in);
        String nomFlor;
        String color;
        double preuFlor;

        System.out.println("Nom flor número " + (flors.size() + 1) + ":");

        while (true) {

            nomFlor = lector.nextLine();

            // Comprobamos que el usuario introduzca al menos 1 nombre válido de árbol
            if (nomFlor.equals("stop") && flors.size() > 0) {
                return null;
            } else if (nomFlor.equals("stop")) {
                System.out.println("Introdueix un nom vàlid!");
            } else {
                break;
            }

        }

        System.out.println("Color:");

        color = lector.nextLine();

        System.out.println("Preu:");

        while (true) {

            if (!lector.hasNextDouble()) {
                System.out.println("Introdueix un valor vàlid!");
                lector.next();
            } else {
                preuFlor = lector.nextDouble();
                break;
            }

        }

        return new Flor(nomFlor, color, preuFlor);

    }

    public static Decoracio crearDecoracio(List<Decoracio> decoracions) {

        Scanner lector = new Scanner(System.in);
        TipusMaterial tipusMaterial;
        double preuDecoracio;

        System.out.println("Nom decoració número " + (decoracions.size() + 1) + ":");

        System.out.println("Tipus material (1 - fusta, 2 - plàstic):");

        while (true) {

            if (lector.nextLine().equals("1")) {
                tipusMaterial = TipusMaterial.FUSTA;
                break;
            } else if (lector.nextLine().equals("2")) {
                tipusMaterial = TipusMaterial.PLASTIC;
                break;
            } else {
                System.err.println("Introdueix una opció correcta!");
                lector.next();
            }

        }

        System.out.println("Preu:");

        while (true) {

            if (!lector.hasNextDouble()) {
                System.out.println("Introdueix un valor vàlid!");
                lector.next();
            } else {
                preuDecoracio = lector.nextDouble();
                break;
            }

        }

        return new Decoracio(tipusMaterial, preuDecoracio);

    }

}