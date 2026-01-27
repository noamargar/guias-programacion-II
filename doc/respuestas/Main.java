class Punto {
    double x; // coordenada X
    double y; // coordenada Y

    // Método que calcula la distancia al origen (0,0)
    double calculaDistanciaAOrigen() {
        return Math.sqrt(x * x + y * y);
    }
}

public class Main {
    public static void main(String[] args) {
        // Crear un objeto de tipo Punto
        Punto p = new Punto();

        // Asignar valores a las coordenadas
        p.x = 3;
        p.y = 4;

        // Calcular distancia al origen usando el método de la clase
        double distancia = p.calculaDistanciaAOrigen();

        // Mostrar resultado
        System.out.println("Distancia al origen: " + distancia);
    }
}
