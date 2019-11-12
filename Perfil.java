import java.util.ArrayList;
import java.util.List;

class Perfil {

    private String tipoPerfil;

    Perfil(String perfil) {
        this.tipoPerfil = perfil;
    }

    public void setTipoPerfil(String perfil) {
        this.tipoPerfil = perfil;
    }

    @Override
    public String toString() {
        return tipoPerfil + "\n";
    }

}