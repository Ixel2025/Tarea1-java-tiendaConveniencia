
import java.util.Scanner;

public class TiendaConvenience {
    public static void main(String[] args) {

        //Arrays con la descripcion y precio
       String[] productos ={"Cocacola","Hersheys","Agua","Zambos","Galleta Oreo"};

       double[] precios ={30.00,45.50,15.20,39.70,25.20};

       //Arreglo para almacenar las compras en el carrito

        int[] carrito=new int [productos.length];
        int itemsEnCarrito=0;

        Scanner scanner=new Scanner (System.in);
        int opcion;
        boolean salir=false;

        //Menu principal de la tienda

        do {
            System.out.println("\n******TIENDA DE CONVENIENCIA******");
            System.out.println("1.Producto Disponile");
            System.out.println("2.Agregar al carrito de compra");
            System.out.println("3.Ver carrito y total a pagar");
            System.out.println("4.Salir");
            System.out.println("Seleccione una opcion: ");

            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    // En la primera opcion se muestran los productos disponibles
                    System.out.println("\nProductos disponibles:");
                    for (int i = 0; i < productos.length; i++) {
                        System.out.printf("%d. %s - $%.2f%n",
                                (i+1), productos[i], precios[i]);
                    }
                    break;

                case 2:
                    // En la segunda opcion pueden seleccionar uno de los productos y agregarlos al carrito
                    System.out.println("\nSeleccione un producto (número):");
                    for (int i = 0; i < productos.length; i++) {
                        System.out.printf("%d. %s - $%.2f%n",
                                (i+1), productos[i], precios[i]);
                    }
                    System.out.print("Opción: ");
                    int seleccion = scanner.nextInt();


                    if (seleccion >= 1 && seleccion <= productos.length) {
                        carrito[itemsEnCarrito] = seleccion - 1;
                        itemsEnCarrito++;
                        System.out.println("Producto agregado al carrito.");
                    } else {
                        System.out.println("Selección inválida.");
                    }
                    break;

                case 3:
                    // En este se muestra lo que agregamos al carrito y el total a pagar
                    if (itemsEnCarrito == 0) {
                        System.out.println("\nEl carrito está vacío.");
                    } else {
                        double total = 0;
                        System.out.println("\n--- CARRITO DE COMPRAS ---");
                        for (int i = 0; i < itemsEnCarrito; i++) {
                            int productoIndex = carrito[i];
                            System.out.printf("%s - $%.2f%n",
                                    productos[productoIndex], precios[productoIndex]);
                            total += precios[productoIndex];
                        }
                        System.out.printf("TOTAL A PAGAR: $%.2f%n", total);
                    }
                    break;

                case 4:
                    // Salir del sistema
                    salir = true;
                    System.out.println("Ha sido un gusto atenderle. Le esperamos pronto :)");
                    break;

                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }

        } while (!salir); //Mientras el usuario no seleccione salir el programa se repetira


    }
}
