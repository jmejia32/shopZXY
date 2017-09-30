package co.jamesfl.apps.shopzxy;

/**
 * Created by javie on 30/09/2017.
 */

public class Metodos {
    private static int[][][] precios = new int[][][] {
            { //Hombre
                    {120000, 140000, 130000}, //Zapatillas (Nike, Adidas, Puma)
                    {50000, 80000, 100000}, //Clásicos (Nike, Adidas, Puma)
            },
            { //Mujer
                    {100000, 130000, 110000}, //Zapatillas (Nike, Adidas, Puma)
                    {60000, 70000, 120000}, //Clásicos (Nike, Adidas, Puma)
            }
    };

    public static int calcularTotal(int sexo, int tipo, int marca, int cantidad) {
        return precios[sexo][tipo][marca] * cantidad;
    }
}
