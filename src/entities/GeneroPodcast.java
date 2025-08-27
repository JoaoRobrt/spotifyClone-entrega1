package entities;

public enum GeneroPodcast implements Genero {
    HUMOR("Humor"),
    NOTICIAS("Notícias"),
    CULTURA("Cultura"),
    ESPORTES("Esportes");

    private String descricao;

    GeneroPodcast(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
