import java.util.*;

public class Proveedor {
    private int id;
    private String nombre;
    private static int idMax = 0;
    private ArrayList<Articulo> articulos = new ArrayList<>();

    public Proveedor(String nombre) {
        this.nombre = nombre;
        id = idMax;
        idMax++;
    }

    public int getId(){
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void addArticulo(Articulo i){
        articulos.add(i);
    }

    public ArrayList<Articulo> todosArticuloVendidos() {
        return articulos;
    }


    public void proveer(Articulo i) {
        addArticulo(i);
        Tienda.getProveedores().add(this);
        Tienda.getLista().add(i);
    }

}
