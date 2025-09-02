package entities;

public enum GeneroMusica implements Genero {
    ROCK("Rock"),
    POP("Pop"),
    MPB("MPB"),
    JAZZ("Jazz"),
    CLASSIC("Classic");

    private final String descricao;

    GeneroMusica(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String getDescricao() {
        return descricao;
    }

    public static GeneroMusica valueOfDescricao(String texto) {
        for (GeneroMusica genero : values()) {
            if (genero.descricao.equalsIgnoreCase(texto)) {
                return genero;
            }
        }
        return null;
    }
}
