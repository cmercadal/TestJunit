package cl.camila.model;

public class Cuenta {
    private String usuario;
    private Integer saldo;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Integer getSaldo() {
        return saldo;
    }

    public Cuenta(String usuario, Integer saldo) {
        this.usuario = usuario;
        this.saldo = saldo;
    }

    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }


    public float agregarSaldo(float saldoInicial, float saldoAgregado) {
        if (saldoInicial > 0 && saldoAgregado > 0) {
            return saldoInicial + saldoAgregado;
        } else {
            System.out.println("Valores deben ser mayores a cero");
            return 0;
        }
    }
}
