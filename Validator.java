import javax.swing.text.StyledEditorKit;
import java.util.Calendar;
import java.util.Date;

class Validator {

    public static Boolean validarNomeUsuario(String nome) {
        return (nome.isEmpty());
    }

    public static void validarCpf(String cpf) {

    }

    public static void validarSexo(Character sexo) {

    }

    public static boolean validarData(String data) {
        int dia = 0, mes = 0, ano = 0;
        String[] novaData = data.split("/");

        try {
            dia = Integer.parseInt(novaData[0]);
            mes = Integer.parseInt(novaData[1]);
            ano = Integer.parseInt(novaData[2]);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return (dia > 1 && dia < 31) &&
                (mes > 1 && mes < 12) &&
                (novaData[2].length() == 4 && (ano > 1900 && ano < Calendar.getInstance().get(Calendar.YEAR) + 1));
    }

    public static void validarCargo() {

    }

    public static void validarPerfil() {

    }

    public static void validarUsuario() {

    }
}
