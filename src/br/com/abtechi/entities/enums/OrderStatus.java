package br.com.abtechi.entities.enums;

public enum OrderStatus {
	
	PENDENTING_PAYMENT("1"),
	PROCESSING("2"),
	SHIPPED("3"),
	DELIVERED("4");
	
	private String descricao;
	
	OrderStatus(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
}
