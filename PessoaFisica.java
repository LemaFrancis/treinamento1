import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class PessoaFisica extends Pessoa {

    private String cpf;
    private String sexo;
    private Cargo cargo;
    private List<Perfil> perfil;

    PessoaFisica(String nome, String cpf, Date dataNascimento, String sexo, String cargo, List<Perfil> perfis) {
        super(nome, dataNascimento);
        this.cpf = cpf;
        this.sexo = sexo;
        this.cargo = new Cargo(cargo);
        this.perfil = perfis;
    }

    public String getCpf() {
        return this.cpf;
    }

    @Override
    public void setNome(String razaoSocial) {
        this.nome = razaoSocial;
    }

    @Override
    public String toString() {
        return "Nome= '" + nome + '\'' +
                "\nCPF= '" + cpf + '\'' +
                "\nData de Nascimento= '" + dataNascimento + '\'' +
                "\nSexo= '" + sexo + '\'' +
                "\nCargo= '" + cargo + '\'' +
                "\nPerfil= '" + perfil + '\'';
    }

}
