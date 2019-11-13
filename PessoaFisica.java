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

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public void setNome(String razaoSocial) {
        this.nome = razaoSocial;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    String getCpf() {
        return this.cpf;
    }

    @Override
    public String toString() {
        return "nome='" + nome + '\'' +
                "\ncpf='" + cpf + '\'' +
                "\ndataNascimento='" + dataNascimento +
                "\nsexo='" + sexo + '\'' +
                "\ncargo=" + cargo +
                "\nperfil=" + perfil + '\'';
    }
}
