public abstract class Pessoa {

    String nome;
    String dataNascimento;

    Pessoa(String nome, String dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

//    public abstract String getNome();

    public abstract void setNome(String nome);

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

}
