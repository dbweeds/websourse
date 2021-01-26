package domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductVO {

	private int num;
	
	private String category;
	private String name;
	private String content;
	private String psize;
	private String color;
	
	private int amount;
	private int price;
	
	private Date uploadDate;
}
