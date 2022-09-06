import java.util.Date;

public class Voo {
	
	private  int id_voo;
	private String Destino;
	private Date data_voo;
	private String companhia;
	private String aeroporto;
	private String portao_de_embarque;
	
	public int getId_voo() {
		return id_voo;
	}
	public void setId_voo(int id_voo) {
		this.id_voo = id_voo;
	}
	public String getDestino() {
		return Destino;
	}
	public void setDestino(String destino) {
		Destino = destino;
	}
	public Date getData_voo() {
		return data_voo;
	}
	public void setData_voo(Date data_voo) {
		this.data_voo = data_voo;
	}
	public String getCompanhia() {
		return companhia;
	}
	public void setCompanhia(String companhia) {
		this.companhia = companhia;
	}
	public String getAeroporto() {
		return aeroporto;
	}
	public void setAeroporto(String aeroporto) {
		this.aeroporto = aeroporto;
	}
	public String getPortao_de_embarque() {
		return portao_de_embarque;
	}
	public void setPortao_de_embarque(String portao_de_embarque) {
		this.portao_de_embarque = portao_de_embarque;
	}
	
	

}
