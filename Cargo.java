class Cargo {

    private String nomeCargo;

    Cargo(String cargo) {
        this.nomeCargo = cargo;
    }

    public void setCargo(String cargo) {
        this.nomeCargo = cargo;
    }

    public String getNomeCargo() {
        return this.nomeCargo;
    }

    @Override
    public String toString() {
        return nomeCargo;
    }

}
