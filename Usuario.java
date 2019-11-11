import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Usuario {

    private String nome;
    private String cpf;
    private String dataNascimento;
    private String sexo;
    private Cargo cargo;
    private List perfil;

    Usuario(String nome, String cpf, String dataNascimento, String sexo, String cargo) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.cargo = new Cargo(cargo);
        this.perfil = new ArrayList();
    }

    @Override
    public String toString() {
        return "Nome: " + nome +
                "\nCPF: " + cpf +
                "\nData: " + dataNascimento +
                "\nSexo: " + sexo;
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

    public String getCpf(){
        return this.cpf;
    }

}
