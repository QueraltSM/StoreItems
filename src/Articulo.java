public class Articulo implements Comparable<Articulo> {
    private String nombre;
    private int cantidad;
    private double precioUnidad;

    public Articulo(String nombre, int cantidad, double precioUnidad ) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precioUnidad = precioUnidad;
    }

    public String getNombre(){
        return nombre;
    }

    public int getCantidad(){
        return cantidad;
    }

    public double getPrecioUnidad(){
        return precioUnidad;
    }
    public int vende(int num){
        if (num>=0 && num<=cantidad && (cantidad-num)>=0) {
            cantidad -= num;
        }
        return cantidad;
    }

    public String toString(){
        return nombre;
    }

    public int compareTo(Articulo a){
        if (a.getNombre().compareTo(getNombre())<0) {
            return 1;
        } else if (a.getNombre().compareTo(getNombre())==0) {
            return 0;
        }
        return -1;
    }

}
