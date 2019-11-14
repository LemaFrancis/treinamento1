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
        //se a lista de usuário pessoa física é vazia, então insere
        if (this.listaUsuario.isEmpty()) {
            return this.listaUsuario.add(usuario);
        } else {
            //se usuário não existir no sistema, então insere
            if (!verificarUnicidadeUsuario(usuario)) {
                return this.listaUsuario.add(usuario);
            }
            return false;
        }
    }

    /**
     * Metodo para verificar se usuário é unico no sistema
     *
     * @param usuario
     * @return boolean
     */
    public Boolean verificarUnicidadeUsuario(Usuario usuario) {
        //verifica se o usuário é uma pessoa física ou jurídica
        if (usuario.getPf() != null) {
            for (Usuario u : this.listaUsuario) {
                if (u.getPf().getCpf().equals(usuario.getPf().getCpf())) {
                    return true;
                }
            }
        } else {
            for (Usuario u : this.listaUsuario) {
                if (u.getPj().getCnpj().equals(usuario.getPj().getCnpj())) {
                    return true;
                }
            }
        }
        //caso não existe usuário no sistema, retorna false
        return false;
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
    public Boolean inserirCargo(Cargo cargo) {
        //caso lista seja vazio, inserir cargo
        if (this.listaCargo.isEmpty()) {
            System.out.println("é vazia");
            insertAndSortCargo(cargo);
        } else {
            //verifica se o cargo é único cadastrado no sistema
            if (verificarUnicidadeCargo(cargo)) {
                System.out.println("Verificada");
                this.listaCargo.add(cargo);
                insertAndSortCargo(cargo);
            }
        }
        return false;
    }

    public void insertAndSortCargo(Cargo cargo) {
        this.listaCargo.add(cargo);
        //ordena a lista de cargos
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

    public Boolean verificarUnicidadeCargo(Cargo cargo) {
        for (Cargo c : listaCargo) {
            if (!c.getNomeCargo().equals(cargo.getNomeCargo())) {
                System.out.println("é TRUEEEE");
                return true;
            }
        }
        return false;
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
