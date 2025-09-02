package entities;

public class Admin extends Usuario{

    public Admin(String nome, String email, String senha) {
        super(nome, email, senha);
        nome = "admin";
        senha = "admin";
    }

}
