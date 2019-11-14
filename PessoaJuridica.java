import java.util.Date;
import java.util.List;

class PessoaJuridica extends Pessoa {

    private String cnpj;
    private String email;
    private Cargo cargo;
    private List<Perfil> perfil;

    PessoaJuridica(String razaoSocial, String cnpj, Date dataAbertura, String email) {
        super(razaoSocial, dataAbertura);
        this.cnpj = cnpj;
        this.email = email;
    }

    public String getCnpj() {
        return cnpj;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "\nnome='" + nome + '\'' +
                "\ncnpj='" + cnpj + '\'' +
                "\ndataNascimento='" + dataNascimento + '\'' +
                "\nemail='" + email + '\'';
    }

}
