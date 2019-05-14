package br.com.pignus.pignusproject.entities;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class Download{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nomePrograma;
	private String link;
	@ManyToMany(mappedBy="softwaresSetor")
	private List<Setor> setores = new ArrayList<>();
	@ManyToOne
	private Funcoes funcaoDownload;

 
	public String getNomePrograma() {
		return nomePrograma;
	}

	public String setNomePrograma(String nomePrograma) {
		return this.nomePrograma = nomePrograma;
	}

	public String getLink() {
		return link;
	}

	public String setLink(String link) {
		return this.link = link;
	}

	public List<Setor> getSetores() {
		return setores;
	}

	public void setSetores(List<Setor> setores) {
		this.setores = setores;
	}
	
	@Override
	public String toString() {
		return nomePrograma+"\n"+funcaoDownload+"\n" +link;
	}



}
