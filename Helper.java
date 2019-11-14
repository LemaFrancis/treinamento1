import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

final class Helper {

    /**
     * Método para tornar maiúscula a primeira letra de qualquer palavra
     *
     * @param word
     * @return String
     */
    static String ucFirst(String word) {
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }

    /**
     * Método para "limpar"(espaço) tela
     */
    static void clearScreen() {
        for (int i = 0; i < 100; i++) {
            System.out.println("");
        }
    }

    static Date formatarData(String data) {
        if (Validator.validarData(data)) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            try {
                return simpleDateFormat.parse(data);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
