package jan.prado.controller.api.dto;

import java.util.Objects;

public class UsuarioDTO {

    private String email;
    private String nome;
    public String senha;

    public UsuarioDTO() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioDTO that = (UsuarioDTO) o;
        return Objects.equals(email, that.email) && Objects.equals(nome, that.nome) && Objects.equals(senha, that.senha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, nome, senha);
    }

    @Override
    public String toString() {
        return "UsuarioDTO{" +
                "email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }

    public static class Builder{
        public String email;
        public String nome;
        public String senha;

        public Builder (String email,String nome, String senha){
            this.email = email;
            this.nome = nome;
            this.senha = senha;
        }

        public UsuarioDTO build(){
            return new UsuarioDTO(this);
        }
    }
    private UsuarioDTO(Builder builder){
        email = builder.email;
        nome = builder.nome;
        senha = builder.nome;
    }
}
