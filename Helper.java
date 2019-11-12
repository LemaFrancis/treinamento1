final class Helper {

    Helper() {
    }

    /**
     * Método para tornar maiúscula a primeira letra de qualquer palavra
     *
     * @param word
     * @return String
     */
    String ucFirst(String word) {
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }
}
