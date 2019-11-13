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

    String getCpf() {
        return this.cpf;
    }

    @Override
    public void setNome(String razaoSocial) {
        this.nome = razaoSocial;
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
