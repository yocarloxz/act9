import java.util.regex.Pattern;

public class ValidadorConcurrencia extends Thread {
    private String contraseña;

    public ValidadorConcurrencia(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public void run() {
        // Expresión regular para validar la contraseña
        String regex = "^(?=.*[A-Z].*[A-Z])(?=.*[a-z].*[a-z].*[a-z])(?=.*[0-9])(?=.*[@#$%^&+=]).{8,}$";
        Pattern pattern = Pattern.compile(regex);
        boolean esValida = pattern.matcher(contraseña).matches();

        if (esValida) {
            System.out.println("La contraseña \"" + contraseña + "\" es válida.");
        } else {
            System.out.println("La contraseña \"" + contraseña + "\" no es válida.");
        }
    }
}
