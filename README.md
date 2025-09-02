# 🎵 Mini Spotify em Java

Um simples clone do Spotify desenvolvido em **Java** para ser executado via **linha de comando (CLI)**.  
Este projeto acadêmico demonstra conceitos fundamentais de **Programação Orientada a Objetos (POO)**, como **encapsulamento, herança, polimorfismo** e **tratamento de exceções**.

---

## 📌 Status do Projeto
✔️ Concluído

---

## ✨ Funcionalidades

### 🔑 Autenticação
- Login e Cadastro de usuários.

### 👤 Perfis de Acesso
- **Usuário Comum**: pode criar e gerenciar suas playlists.  
- **Administrador**: possui acesso especial ao catálogo central de mídias.

### 🛠️ Painel do Administrador
- Adicionar e remover mídias do catálogo.  
- Visualizar todos os usuários cadastrados no sistema.

### 🎧 Funcionalidades do Usuário
- Criar, remover e visualizar playlists personalizadas.  
- Adicionar e remover mídias do catálogo em suas playlists.

### 🎼 Catálogo de Mídias
- Suporte para **Músicas, Podcasts e Audiobooks**.  
- Cada tipo possui seus **próprios gêneros**.

### 🏗️ Estrutura OO Robusta
- Organização em **camadas**: `model`, `service`, `exception`.  
- Uso de **exceções customizadas** para controle seguro e claro do fluxo de erros.

---

## 💻 Tecnologias Utilizadas
- **Java 17+** (Java puro, sem frameworks externos).

---

## 🚀 Como Executar o Projeto

### ✅ Pré-requisitos
- **JDK (Java Development Kit)** instalado e configurado.  
Verifique com:



```bash
▶️ Passos

Clone o repositório (ou copie a pasta do projeto):

# git clone https://github.com/seu-usuario/mini-spotify-java.git


Navegue até a pasta raiz do projeto:

cd caminho/para/seu/projeto


Compile o código-fonte:
O comando abaixo compila os arquivos .java da pasta src e gera os .class em out.

javac -d out src/com/minispotify/ui/Main.java


Execute a aplicação:

java -cp out com.minispotify.ui.Main


📌 O menu interativo do Mini Spotify será exibido no seu terminal.

/
|-- /src
|   |-- /com/minispotify
|       |-- /exception   # Exceções customizadas (ex: RecursoNaoEncontradoException)
|       |-- /model       # Classes de domínio (Usuario, Admin, Midia, Artista, Playlist, Enums...)
|       |-- /service     # Lógica de negócio (Sistema, Catalogo...)
|       |--main          # Interface do usuário (Main - CLI)
|
`-- README.md


java -version
