import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        if (this.listaUsuario.isEmpty()) {
            return this.listaUsuario.add(usuario);
        } else {
            //verifica se o usuário é uma pessoa física
            if (usuario.getPf() != null) {
                //se a lista de usuário pessoa física é vazia, então já adiciona
                for (Usuario u : this.listaUsuario) {
                    if (!u.getPf().getCpf().equals(usuario.getPf().getCpf())) {
                        System.out.println("TEM CPF:  U: " + u);
                        return this.listaUsuario.add(usuario);
                    }
                    System.out.println("Usuário já existe no sistema");
                }
            } else {
                for (Usuario u : this.listaUsuario) {
                    if (!u.getPj().getCnpj().equals(usuario.getPj().getCnpj())) {
                        return this.listaUsuario.add(usuario);
                    }
                    System.out.println("Cnpj já cadastrado no sistema");
                }
            }
            return false;
        }
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
            if (user.getPf().getCpf().equals(cpf)) {
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
    public void inserirCargo(Cargo cargo) {
        this.listaCargo.add(cargo);
        this.listaCargo = this.listaCargo.stream().sorted
                ((c, c2) -> c.getNomeCargo().compareTo(c2.getNomeCargo())).collect(Collectors.toList());
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
     * @param position
     * @return boolean
     */
    public Boolean removerCargo(int position) {
        Cargo cargo = this.listaCargo.get(position - 1);
        return this.listaCargo.remove(cargo);
    }

    public void ordenarCargo() {

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
     * @param position
     */
    public Boolean removerPerfil(int position) {
        Perfil perfil = this.listaPerfil.get(position - 1);
        return this.listaPerfil.remove(perfil);
    }

    public void editarPerfil() {

    }

}
