package pe.estebancoder.solutions.eshop.oauth.model;



import java.io.Serializable;

public class Role implements Serializable {

	private Long id;

	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private static final long serialVersionUID = 4467531611801172710L;

}
