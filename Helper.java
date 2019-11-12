import java.io.IOException;

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

}
