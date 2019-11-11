class Cargo {

    private String nomeCargo;

    Cargo(String cargo) {
        this.nomeCargo = cargo;
    }

    @Override
    public String toString() {
        return nomeCargo;
    }

    public void setCargo(String cargo) {
        this.nomeCargo = cargo;
    }

    public String getNomeCargo() {
        return this.nomeCargo;
    }
}
