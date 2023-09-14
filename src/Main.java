import exercici1.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner lector = new Scanner(System.in);
    private static List<Arbre> arbres = new ArrayList<>();
    private static List<Flor> flors = new ArrayList<>();
    private static List<Decoracio> decoracions = new ArrayList<>();
    private static List<Ticket> llistaDeCompres = new ArrayList<>();
    private static double dinersGuanyats = 0;
    private static File floristeriaFile = new File("floristeria.txt");
    private static int contadorTickets = 1;

    public static void main(String[] args) throws IOException {

        String opcio = "0";
        Floristeria floristeria = null;
        int opcioABorrar;

        while (!opcio.equals("14")) {

            System.out.println("\nIntrodueix una opció:\n" +
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
                        floristeria.addFlor(crearFlor());
                    }

                    System.out.println("Flor creada!");

                    break;

                // Crear decoració
                case "4":

                    if (floristeria == null) {
                        floristeria = crearFloristeria();
                    } else {
                        floristeria.addDecoracio(crearDecoracio());
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

                // Printar stock amb quantitats
                case "9":

                    printarStockAmbQuantitats();

                    break;

                // Printar per pantalla valor total de la floristeria
                case "10":

                    printarValorTotalFloristeria();

                    break;

                // Crear tickets de compra amb múltiples objectes
                case "11":

                    llistaDeCompres.add(crearTicketDeCompra());

                    System.out.println("Ticket de compra nº " + llistaDeCompres.size() + " creat!");

                    break;

                // Mostrar una llista de compres antigues
                case "12":

                    imprimirLlistaDeCompresAntigues();

                    break;

                // Visualitzar el total de diners guanyats amb totes les vendes
                case "13":

                    dinersGuanyats();

                    break;

                // Sortir
                case "14":

                    System.out.println("Sortint de la aplicació");

                    break;

                default:
                    System.out.println("introdueix una opció correcte!");

            }

        }

    }

    private static void dinersGuanyats() {

        if (llistaDeCompres.size() > 0) {

            System.out.println("Diners guanyats: " + dinersGuanyats);

        } else {

            System.out.println("Encara no hi ha agut ventes!");

        }

    }

    private static void imprimirLlistaDeCompresAntigues() {

        if (llistaDeCompres.size() > 0) {

            System.out.println(llistaDeCompres);

        } else {

            System.out.println("Encara no hi ha agut ventes!");

        }

    }

    private static Ticket crearTicketDeCompra() throws IOException {

        Scanner lector = new Scanner(System.in);
        String opcio = "";
        List<Arbre> arbresTicket = new ArrayList<>();
        List<Flor> florsTicket = new ArrayList<>();
        List<Decoracio> decoracionsTicket = new ArrayList<>();
        double dinersTicket = 0;
        FileWriter fw;

        try {
            fw = new FileWriter(floristeriaFile, true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Per a crear un ticket de compra tens que escollir el objectes imprimits per pantalla." +
                "S'aniran imprimint per ordre y has d'escollir els objectes que vulguis\n");

        System.out.println("Introdueix aquí el número del objecte o escriu 'skip' per a pasar a la següent secció");

        // Escribimos en el fichero los datos importantes
        fw.write("Ticket nº " + contadorTickets);
        contadorTickets++;
        fw.write("\nArbres:");

        while (true) {

            System.out.println("ARBRES:");

            for (int i = 0; i < arbres.size(); i++) {
                System.out.println(i + " - " + arbres.get(i));
            }

            opcio = lector.nextLine();

            if (opcio.equals("skip")) {

                break;

            } else {

                if (Integer.parseInt(opcio) >= 0 && Integer.parseInt(opcio) < arbres.size()) {

                    // Añadimos el arbol que queremos poner en el ticket al arraylist
                    arbresTicket.add(arbres.remove(Integer.parseInt(opcio)));

                    // Guardamos la ganancia para otro método
                    dinersGuanyats = dinersGuanyats + arbresTicket.get(arbresTicket.size() - 1).getPreu();

                    dinersTicket = arbresTicket.get(arbresTicket.size() - 1).getPreu();

                    fw.write("\n   " + arbresTicket.get(arbresTicket.size() - 1).toString());

                    System.out.println(arbresTicket.get(arbresTicket.size() - 1) + " - afegit al ticket");

                } else {
                    System.out.println("Index introduït incorrecte");
                }

            }

        }

        fw.write("\nFlors:");

        while (true) {

            System.out.println("FLORS:");

            for (int i = 0; i < flors.size(); i++) {
                System.out.println(i + " - " + flors.get(i));
            }

            opcio = lector.nextLine();

            if (opcio.equals("skip")) {

                break;

            } else {

                if (Integer.parseInt(opcio) >= 0 && Integer.parseInt(opcio) < flors.size()) {

                    // Añadimos la flor que queremos poner en el ticket al arraylist
                    florsTicket.add(flors.remove(Integer.parseInt(opcio)));

                    // Guardamos la ganancia para otro método
                    dinersGuanyats = dinersGuanyats + florsTicket.get(florsTicket.size() - 1).getPreu();

                    dinersTicket = dinersTicket + florsTicket.get(florsTicket.size() - 1).getPreu();

                    fw.write("\n   " + florsTicket.get(florsTicket.size() - 1).toString());

                    System.out.println(florsTicket.get(florsTicket.size() - 1) + " - afegit al ticket");

                } else {
                    System.out.println("Index introduït incorrecte");
                }

            }

        }

        fw.write("\nDecoració:");

        while (true) {

            System.out.println("DECORACIÓ:");

            for (int i = 0; i < decoracions.size(); i++) {
                System.out.println(i + " - " + decoracions.get(i));
            }

            opcio = lector.nextLine();

            if (opcio.equals("skip")) {

                break;

            } else {

                if (Integer.parseInt(opcio) >= 0 && Integer.parseInt(opcio) < decoracions.size()) {

                    // Añadimos el arbol que queremos poner en el ticket al arraylist
                    decoracionsTicket.add(decoracions.remove(Integer.parseInt(opcio)));

                    // Guardamos la ganancia para otro método
                    dinersGuanyats = dinersGuanyats + decoracionsTicket.get(decoracionsTicket.size() - 1).getPreu();

                    dinersTicket = dinersTicket + decoracionsTicket.get(decoracionsTicket.size() - 1).getPreu();

                    fw.write("\n   " + decoracionsTicket.get(decoracionsTicket.size() - 1).toString());

                    System.out.println(decoracionsTicket.get(decoracionsTicket.size() - 1) + " - afegit al ticket");

                } else {
                    System.out.println("Index introduït incorrecte");
                }

            }

        }

        fw.write("\nTotal: " + dinersTicket + "€\n\n");

        fw.close();

        return new Ticket(arbresTicket, florsTicket, decoracionsTicket);

    }

    // Método para sumar el valor total de la floristeria usando stream
    private static void printarValorTotalFloristeria() {

        double valorTotal = 0;

        valorTotal = arbres.stream().mapToDouble(Arbre::getPreu).sum();

        valorTotal = valorTotal + flors.stream().mapToDouble(Flor::getPreu).sum();

        valorTotal = valorTotal + decoracions.stream().mapToDouble(Decoracio::getPreu).sum();

        System.out.println("Valor total de la floristeria: " + valorTotal);

    }

    // Método para printar por pantalla todos los stocks con sus cantidades
    private static void printarStockAmbQuantitats() {

        HashMap<String, Integer> nameAndCount = new HashMap<>();

        System.out.print("STOCK FLORISTERIA AMB QUANTITATS:" +
                "\n\tARBRES:\n");

        for (Arbre arbre : arbres) {

            Integer count = nameAndCount.get(arbre.getNom());

            if (count == null) {
                nameAndCount.put(arbre.getNom(), 1);
            } else {
                nameAndCount.put(arbre.getNom(), ++count);
            }

        }

        System.out.println(nameAndCount);

        nameAndCount = new HashMap<>();

        for (Flor flor : flors) {

            Integer count = nameAndCount.get(flor.getNom());

            if (count == null) {
                nameAndCount.put(flor.getNom(), 1);
            } else {
                nameAndCount.put(flor.getNom(), ++count);
            }

        }

        System.out.println("\tFLORS:\n" + nameAndCount);

        nameAndCount = new HashMap<>();

        for (Decoracio decoracio : decoracions) {

            Integer count = nameAndCount.get(decoracio.getTipusMaterial().name());

            if (count == null) {
                nameAndCount.put(decoracio.getTipusMaterial().name(), 1);
            } else {
                nameAndCount.put(decoracio.getTipusMaterial().name(), ++count);
            }

        }

        System.out.println("\tDECORACIÓ:\n" + nameAndCount);

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