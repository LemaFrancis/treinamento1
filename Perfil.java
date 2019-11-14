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

    public String getPerfil(){
        return this.tipoPerfil;
    }

    @Override
    public String toString() {
        return tipoPerfil;
    }

}