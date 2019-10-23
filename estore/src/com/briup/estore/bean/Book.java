package com.briup.estore.bean;
import java.io.Serializable;
/**
 * 
 * @ClassName: Book	书籍类
 *
 */
public class Book implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private Double price;
	private String witer;
	private String press;
	int page;
	String intro;
	
	public Book(){
		
	}
	
	public Book(Long id, String name, Double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}


	public Book(Long id, String name, Double price, String witer, String press, int page, String intro) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.witer = witer;
		this.press = press;
		this.page = page;
		this.intro = intro;
	}

	public String getWiter() {
		return witer;
	}

	public void setWiter(String witer) {
		this.witer = witer;
	}

	public String getPress() {
		return press;
	}

	public void setPress(String press) {
		this.press = press;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

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
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
}
