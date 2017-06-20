import java.awt.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.List;

public class Tienda {
    private static ArrayList<Articulo> articulos = new ArrayList<Articulo>();
    private static ArrayList<Proveedor> proveedores = new ArrayList<>();

    private String nombre;

    public Tienda (String nombre) {
        this.nombre = nombre;
    }


    public static ArrayList<Proveedor> getProveedores(){
        return proveedores;
    }

    public static ArrayList<Articulo> getLista() {
        return articulos;
    }

    public Articulo busca(String nombre) {
        for (Articulo i : articulos) {
            if (i.getNombre().equals(nombre)) {
                return i;
            }
        }
        return null;
    }


    public boolean inserta(Articulo i) {
        if (articulos.contains(i)) return false;
        articulos.add(i);
        return true;
    }

    public List<Articulo> todosArticulos(){
        List<Articulo> result = new LinkedList<Articulo>();
        Collections.sort(articulos);

        for (Articulo i : articulos) {
            if (!result.contains(i)) {
                result.add(i);
            }
        }

        return result;
    }

    public Set<String> dameArticulosRepetidos(){
        Set<String> result = new TreeSet<>();
        for (Articulo i : articulos) {
            if (i.getCantidad()>1) {
                result.add(i.getNombre());
            }
        }
        return result;
    }

    public Map<String, ArrayList<Articulo>> proveedorProducto() {
        Map<String, ArrayList<Articulo>> res = new TreeMap<String, ArrayList<Articulo>>();

        for (Proveedor i : proveedores) {
            res.put(i.getNombre(), i.todosArticuloVendidos());
        }
        return res;
    }

    public List<String> dameProveedores() {
        // del que más provee al que menos y si es igual por alfabeto

        Map<String, ArrayList<Articulo>> aux = proveedorProducto();
        Map<String, Integer> res = new TreeMap<String, Integer>();

        ArrayList<Integer> cantidad = new ArrayList<Integer>();

        // Obtenemos mapa ordenando alfabeticamente Nombre proveedores, productos
        for (Map.Entry<String, ArrayList <Articulo>> entry : aux.entrySet() ) {
            int count = 0;
            for (Articulo i : entry.getValue()) {
                count += i.getCantidad();
            }
            cantidad.add(count);
            res.put(entry.getKey(), count);
        }

        Collections.sort(cantidad);
        Collections.reverse(cantidad);

        List<String> result = new LinkedList<String>();
        for (Integer j : cantidad) {
            for (Map.Entry<String, Integer> entry2 : res.entrySet()) {
                if (j.equals(entry2.getValue()) && !result.contains(entry2.getKey() + " " + entry2.getValue())) {
                    result.add(entry2.getKey() + " " + entry2.getValue());
                }
            }
        }

        return result;
    }




}
