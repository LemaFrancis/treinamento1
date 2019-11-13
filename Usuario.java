import java.util.ArrayList;
import java.util.List;

class Usuario {

    private PessoaFisica pf;
    private PessoaJuridica pj;

    Usuario(PessoaFisica pessoaFisica) {
        this.pf = pessoaFisica;
    }

    Usuario(PessoaJuridica pessoaJuridica) {
        this.pj = pessoaJuridica;
    }

    public PessoaFisica getPf() {
        return pf;
    }

    public PessoaJuridica getPj() {
        return pj;
    }
}
