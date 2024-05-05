import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        //Permite que el usuario escriba
        Scanner scanner = new Scanner(System.in);

        String palabraSecreta = "jugar";
        int intentosMaximos = 3;
        int intentos = 0;
        boolean palabraAdivinada = false;

        char[] letrasAdivinadas = new char[palabraSecreta.length()];

        for (int i = 0; i < letrasAdivinadas.length; i++) {
            letrasAdivinadas[i] = '_';
        }

        while(!palabraAdivinada && intentos < intentosMaximos){
            System.out.println("Palabra a adivinar: " + String.valueOf(letrasAdivinadas) + " (" + palabraSecreta.length() + " letras)");

            System.out.println("Introduce una letra, por favor");
            char letra = Character.toLowerCase(scanner.next().charAt(0));

            boolean letraCorrecta = false;

            for (int i = 0; i < palabraSecreta.length(); i++) {
                if(palabraSecreta.charAt(i) == letra){
                    letrasAdivinadas[i] = letra;
                    letraCorrecta = true;
                }
            }

            if(!letraCorrecta){
                intentos++;
                System.out.println("Letra incorrecta! Te quedan " + (intentosMaximos - intentos) + " intentos.");
            }

            if(String.valueOf(letrasAdivinadas).equals(palabraSecreta)){
                palabraAdivinada = true;
                System.out.println("¡Felicidades! Has adividado la palabra secreta: " + palabraSecreta);
            }
        }

        if(!palabraAdivinada){
            System.out.println("Que pena! te has quedado sin intentos! GAME OVER");
        }

        scanner.close();

    }
}
