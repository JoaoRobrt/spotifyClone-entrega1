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

    public static GeneroAudioBook valueOfDescricao(String texto) {
        for (GeneroAudioBook genero : values()) {
            if (genero.descricao.equalsIgnoreCase(texto)) {
                return genero;
            }
        }
        return null;
    }
}
