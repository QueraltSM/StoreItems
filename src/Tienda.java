import java.util.*;

public class Tienda {
    public ArrayList<Articulo> articulos = new ArrayList<Articulo>();
    private String nombre;

    public Tienda (String nombre) {
        this.nombre = nombre;
    }

    public boolean inserta(Articulo a){
        if (articulos.contains(a)) return false;
        articulos.add(a);
        return true;
    }

    public Articulo busca(String nombre) {
        for (Articulo i : articulos) {
            if (i.getNombre().equals(nombre)) {
                return i;
            }
        }
        return null;
    }

    public boolean vende(String nombre, int num) {
        if (busca(nombre)==null) return false;
         ((Articulo)busca(nombre)).vende(num);
        return true;
    }

    public List<Articulo> todosArticulos(){
        Collections.sort(articulos);
        return articulos;
    }


}
