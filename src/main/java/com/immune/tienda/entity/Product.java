package com.immune.tienda.entity;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "products", schema = "tienda" )
public class Product {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ID;
    private String name;
    private Integer price;
	@Column(name = "LM")
	private String LM;
	//Getters y Setters para cada campo de producto:
    public Integer getID() {
		return ID;
	}

	public void setId(Integer ID) {
		this.ID = ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getLM() {
		return LM;
	}

	public void setLM() {
		//Recoge la fecha y la hora actual.
		DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		this.LM = dtf3.format(LocalDateTime.now());
	}
}