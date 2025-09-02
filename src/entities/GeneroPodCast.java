package entities;

public enum GeneroPodCast implements Genero {
    HUMOR("Humor"),
    NOTICIAS("Noticias"),
    CULTURA("Cultura"),
    ESPORTES("Esportes");

    private String descricao;

    GeneroPodCast(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static GeneroPodCast valueOfDescricao(String texto) {
        for (GeneroPodCast genero : values()) {
            if (genero.descricao.equalsIgnoreCase(texto)) {
                return genero;
            }
        }
        return null;
    }
}
