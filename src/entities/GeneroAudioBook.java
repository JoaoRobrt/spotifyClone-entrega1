package entities;

public enum GeneroAudioBook implements Genero {
    FICCAO("Ficção"),
    ROMANCE("Romance"),
    AVENTURA("Aventura"),
    DRAMA("Drama");

    private final String descricao;

    GeneroAudioBook(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
