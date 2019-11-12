import java.util.ArrayList;
import java.util.List;

class PessoaFisica extends Pessoa {

    private String cpf;
    private String sexo;
    private Cargo cargo;
    private List perfil;

    PessoaFisica(String nome, String cpf, String dataNascimento, String sexo, String cargo) {
        super(nome, dataNascimento);
        this.cpf = cpf;
        this.sexo = sexo;
        this.cargo = new Cargo(cargo);
        this.perfil = new ArrayList();
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCpf() {
        return this.cpf;
    }

    @Override
    public String toString() {
        return "nome='" + nome + '\'' +
                "dataNascimento='" + dataNascimento +
                "cpf='" + cpf + '\'' +
                ", sexo='" + sexo + '\'' +
                ", cargo=" + cargo +
                ", perfil=" + perfil + '\'';
    }
}
