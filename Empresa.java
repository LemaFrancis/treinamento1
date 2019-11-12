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
    public Boolean inserirUsuario(Usuario usuario) {
        return this.listaUsuario.add(usuario);
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
     * Método para remover um usuario da empresa
     *
     * @param cpf
     * @return boolean
     */
    public Boolean removerUsuario(String cpf) {
        for (Usuario user : listaUsuario) {
            if (user.pf.getCpf().equals(cpf)) {
                return this.listaUsuario.remove(user);
            }
        }
        return false;
    }

    public void editarUsuario() {

    }

    //========= CARGO ==========//

    /**
     * Método para inserir um novo cargo na lista de cargos.
     *
     * @param cargo
     * @return boolean
     */
    public Boolean inserirCargo(Cargo cargo) {
        return this.listaCargo.add(cargo);
    }

    /**
     * Método para obter a lista de Cargos
     *
     * @return listaCargo
     */
    public List<Cargo> getListaCargo() {
        return this.listaCargo;
    }

    /**
     * Método para remover cargo da lista de cargos
     *
     * @param id
     * @return boolean
     */
    public Boolean removerCargo(int id) {
        Cargo cargo = this.listaCargo.get(id - 1);
        return this.listaCargo.remove(cargo);
    }

    //========= PERFIL ==========//

    /**
     * Método para inserir um novo usuario na lista de perfis.
     *
     * @param perfil
     */
    public Boolean inserirPerfil(Perfil perfil) {
        return this.listaPerfil.add(perfil);
    }

    /**
     * Método para obter a lista de perfis de usuario
     *
     * @return listaPerfil
     */
    public List<Perfil> getListaPerfil() {
        return this.listaPerfil;
    }

    /**
     * Método para remover um perfil de usuário do sistema
     *
     * @param id
     */
    public Boolean removerPerfil(int id) {
        Perfil perfil = this.listaPerfil.get(id);
        return this.listaPerfil.remove(perfil);
    }

    public void editarPerfil() {

    }

}
