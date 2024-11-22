package br.uam.rabbitmq.entities;

/**
 *
 * @author Joao Rodolfo
 */
public class Usuario {
    private int id;
    private String nome;
    private String sobreNome;

    public Usuario() {
        
    }
    
    public Usuario(int id, String nome, String sobreNome) {
        this.id = id;
        this.nome = nome;
        this.sobreNome = sobreNome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", sobreNome=" + sobreNome + "]";
	}
    
    
    
}
