import exercici1.*;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner lector = new Scanner(System.in);
    private static List<Arbre> arbres = new ArrayList<>();
    private static List<Flor> flors = new ArrayList<>();
    private static List<Decoracio> decoracions = new ArrayList<>();

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
        Floristeria floristeria = null;
        String nomFloristeria = "";
        String nomArbre = "";
        String nomFlor = "";
        String colorFlor = "";
        int opcioABorrar;
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

                // Crear floristeria
                case "1":

                    if (floristeria == null) {

                        floristeria = crearFloristeria();
                        System.out.println("Floristeria creada!");

                    } else {

                        System.out.println("Floristeria ja creada!");

                    }

                    break;

                // Crear arbre
                case "2":

                    if (floristeria == null) {
                        floristeria = crearFloristeria();
                    } else {
                        floristeria.addArbre(crearArbre());
                    }

                    System.out.println("Arbre creat!");

                    break;

                // Crear flor
                case "3":

                    if (floristeria == null) {
                        floristeria = crearFloristeria();
                    } else {
                        crearFlor();
                    }

                    System.out.println("Flor creada!");

                    break;

                // Crear decoració
                case "4":

                    if (floristeria == null) {
                        floristeria = crearFloristeria();
                    } else {
                        crearDecoracio();
                    }

                    System.out.println("Decoració creada!");

                    break;

                // Imprimir per pantalla el stock de la floristeria
                case "5":

                    if (floristeria == null) {
                        floristeria = crearFloristeria();
                    }

                    imprimirStock();

                    break;

                // Retirar arbre
                case "6":

                    if (floristeria == null || arbres.size() == 0) {
                        System.out.println("No hi ha cap arbre que retirar!");
                    } else {

                        System.out.println("Introdueix el index del arbre que vols eliminar: ");
                        for (int i = 0; i < arbres.size(); i++) {
                            System.out.println(i + "- " + arbres.get(i));
                        }

                        while (true) {

                            if (!lector.hasNextInt()) {
                                System.out.println("Introdueix un valor vàlid!");
                                lector.next();
                            } else {
                                opcioABorrar = lector.nextInt();
                                if (opcioABorrar >= arbres.size() || opcioABorrar < 0) {
                                    System.out.println("Introdueix un valor vàlid!");
                                    lector.next();
                                } else {
                                    break;
                                }
                            }
                        }

                        arbres.remove(opcioABorrar);

                        System.out.println("Arbre amb index: " + opcioABorrar + " borrat!");

                    }

                    break;

                // Retirar flor
                case "7":

                    if (floristeria == null || flors.size() == 0) {
                        System.out.println("No hi ha cap flor que retirar!");
                    } else {

                        System.out.println("Introdueix el index de la flor que vols eliminar: ");
                        for (int i = 0; i < flors.size(); i++) {
                            System.out.println(i + "- " + flors.get(i));
                        }

                        while (true) {

                            if (!lector.hasNextInt()) {
                                System.out.println("Introdueix un valor vàlid!");
                                lector.next();
                            } else {
                                opcioABorrar = lector.nextInt();
                                if (opcioABorrar >= flors.size() || opcioABorrar < 0) {
                                    System.out.println("Introdueix un valor vàlid!");
                                    lector.next();
                                } else {
                                    break;
                                }
                            }
                        }

                        flors.remove(opcioABorrar);

                        System.out.println("Flor amb index: " + opcioABorrar + " borrat!");

                    }

                    break;

                // Retirar decoració
                case "8":

                    if (floristeria == null || decoracions.size() == 0) {
                        System.out.println("No hi ha cap decoració que retirar!");
                    } else {

                        System.out.println("Introdueix el index de la decoració que vols eliminar: ");
                        for (int i = 0; i < decoracions.size(); i++) {
                            System.out.println(i + "- " + decoracions.get(i));
                        }

                        while (true) {

                            if (!lector.hasNextInt()) {
                                System.out.println("Introdueix un valor vàlid!");
                                lector.next();
                            } else {
                                opcioABorrar = lector.nextInt();
                                if (opcioABorrar >= decoracions.size() || opcioABorrar < 0) {
                                    System.out.println("Introdueix un valor vàlid!");
                                    lector.next();
                                } else {
                                    break;
                                }
                            }
                        }

                        decoracions.remove(opcioABorrar);

                        System.out.println("Decoració amb index: " + opcioABorrar + " borrat!");

                    }

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

    private static void imprimirStock() {

        System.out.print("STOCK FLORISTERIA:" +
                "\n\tARBRES:\n");

        arbres.forEach(System.out::println);

        System.out.println("\tFLORS:");

        flors.forEach(System.out::println);

        System.out.println("\tDECORACIÓ:");

        decoracions.forEach(System.out::println);

    }

    private static Floristeria crearFloristeria() {

        String nomFloristeria = "";

        System.out.println("Crear Floristeria:");
        System.out.println("Introdueix el nom de la floristeria");
        nomFloristeria = lector.nextLine();

        arbres.add(crearArbre());

        System.out.println("Arbre afegit!");

        flors.add(crearFlor());

        System.out.println("Flor afegida!");

        decoracions.add(crearDecoracio());

        System.out.println("Decoració afegida!");
        // Creamos una floristeria con al menos 1 de stock mínimo de cada uno de los productos
        return new Floristeria(nomFloristeria, arbres, flors, decoracions);

    }

    public static Arbre crearArbre() {

        Scanner lector = new Scanner(System.in);
        String nomArbre = "";
        double alcadaArbre;
        double preuArbre;

        System.out.println("Crear arbre:");
        System.out.println("Nom arbre:");

        nomArbre = lector.nextLine();

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

    public static Flor crearFlor() {

        Scanner lector = new Scanner(System.in);
        String nomFlor;
        String color;
        double preuFlor;

        System.out.println("Crear flor:");
        System.out.println("Nom flor:");

        nomFlor = lector.nextLine();

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

    public static Decoracio crearDecoracio() {

        Scanner lector = new Scanner(System.in);
        TipusMaterial tipusMaterial;
        double preuDecoracio;
        String opcio = "";

        System.out.println("Crear decoració:");
        System.out.println("Tipus material (1 - fusta, 2 - plàstic):");

        // Bucle para que el usuario seleccione la opción correcta
        while (true) {

            opcio = lector.nextLine();

            if (opcio.equals("1")) {
                tipusMaterial = TipusMaterial.FUSTA;
                break;
            } else if (opcio.equals("2")) {
                tipusMaterial = TipusMaterial.PLASTIC;
                break;
            } else {
                System.err.println("Introdueix una opció correcta!");
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