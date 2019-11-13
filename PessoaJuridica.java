class PessoaJuridica extends Pessoa {

    private String cnpj;
    private String email;

    PessoaJuridica(String razaoSocial, String cnpj, String dataAbertura, String email) {
        super(razaoSocial, dataAbertura);
        this.cnpj = cnpj;
        this.email = email;
    }


    @Override
    public String toString() {
        return "nome='" + nome + '\'' +
                "\ncnpj='" + cnpj + '\'' +
                "\ndataNascimento='" + dataNascimento + '\'' +
                "\nemail='" + email + '\'';
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }
}
