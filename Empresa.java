import java.util.ArrayList;
import java.util.List;

class Empresa {

    private List<Usuario> listaUsuario;
    private List<Cargo> listaCargo;
    private List<Perfil> listaPerfil;

    /**
     * Método construtor que inicializa os atributos listas como vazias
     */
    Empresa() {
        this.listaCargo = new ArrayList<>();
        this.listaUsuario = new ArrayList<>();
        this.listaPerfil = new ArrayList<>();
    }

    //========= USUÁRIO ==========//

    /**
     * Método para inserir um novo usuario na lista de usuarios.
     *
     * @param usuario
     */
    public void inserirUsuario(Usuario usuario) {
        this.listaUsuario.add(usuario);
    }

    /**
     * Método para obter a lista de usuários;
     *
     * @return usuario
     */
    public List<Usuario> getListaUsuario() {
        return listaUsuario;
    }

    /**
     * Método para obter a lista de Cargos
     *
     * @return listaCargo
     */
    public List<Cargo> getListaCargo() {
        return listaCargo;
    }

    /**
     * Método para obter a lista de perfis de usuario
     *
     * @return listaPerfil
     */
    public List<Perfil> getListaPerfil() {
        return listaPerfil;
    }


    //========= CARGO ==========//

    /**
     * Método para inserir um novo cargo na lista de cargos.
     *
     * @param cargo
     */
    public Boolean inserirCargo(Cargo cargo) {
        return this.listaCargo.add(cargo);
    }


    //========= PERFIL ==========//

    /**
     * Método para inserir um novo usuario na lista de perfis.
     *
     * @param perfil
     */
    public void inserirPerfil(Perfil perfil) {
        this.listaPerfil.add(perfil);
    }

    /**
     * Método para remover um usuario da empresa
     *
     * @param cpf
     */
    public void removerUsuario(String cpf) {
        boolean flag = false;
        for (Usuario user : listaUsuario) {
            System.out.println("Percorrendo Usuarios: " + user);
            if (user.getCpf().equals(cpf)) {
                this.listaUsuario.remove(user);
                System.out.println("Usuário removido com sucesso");
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("Usuário NÃO REMOVIDO");
        }
    }

    /**
     * Método para remover um cargo da empresa
     *
     * @param cargo
     */
    public void removerPerfil(Cargo cargo) {
        this.listaCargo.remove(cargo);
    }

    /**
     * Método para remover um perfil da empresa
     *
     * @param perfil
     */
    public void removerUsuario(Perfil perfil) {
        this.listaPerfil.remove(perfil);
    }

}
