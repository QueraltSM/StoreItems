import org.junit.*;

import static org.junit.Assert.*;

/**
 * Author: Queralt Sosa Mompel
 * Date: 11/ 06/2017
 *
 * */

public class PruebasJUnit {
    private Tienda t;
    private Articulo a1;
    private Articulo a2;
    private Articulo a3;
    private Articulo a4;

    @Before
    public void inicializa(){
        t = new Tienda("Tienda de Pablo");
        a1 = new Articulo("Lápices rojos", 10, 2.2);
        a2 = new Articulo("Armario blanco", 3, 20.5);
        a3 = new Articulo("Dibujo de paisaje", 1, 50.0);
        a4 = new Articulo("Salmón" , 3, 3.7);

    }

    @After
    public void finaliza(){
        System.out.print("Test finalizado correctamente.");
    }

    /**
     * Prueba de la clase: Artículo
     */

    @Test
    public void pruebaVendeArticulo() {
        assertTrue(6 == a1.vende(4));
        assertTrue(3 == a2.vende(10));
        assertTrue(1 == a3.vende(-1));
        assertTrue(0 == a3.vende(1));
    }



    /**
     * Prueba de la clase: Tienda
     */

    @Test
    public void pruebaInserta(){
        assertTrue(t.todosArticulos().size()==0);
        t.inserta(a1);
        assertEquals("[" + a1.toString() + "]", t.todosArticulos().toString());
        t.inserta(a1);
        assertEquals("[" + a1.toString() + "]", t.todosArticulos().toString());
        t.inserta(a3);
        assertEquals("[" + a3.toString() + ", " + a1.toString() + "]", t.todosArticulos().toString());
    }

    @Test
    public void pruebaBuscar(){
        assertFalse(a4 == t.busca(a4.getNombre()));
    }


}
