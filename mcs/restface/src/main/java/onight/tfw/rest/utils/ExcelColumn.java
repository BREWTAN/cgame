package onight.tfw.rest.utils;

import java.io.Serializable;

import lombok.Data;

import org.jdom.Element;

@Data
public class ExcelColumn implements Serializable,Cloneable{
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private ExcelAlign align;
	private int width;
	
	public ExcelColumn(Element columnElement){
		
		this.id = columnElement.getAttributeValue("id");
		if(this.id == null){
			throw new NullPointerException("id不能为空");
		}
//		this.id = this.id.toUpperCase();
		this.name = columnElement.getAttributeValue("name");
		if(this.name == null){
			throw new NullPointerException("name不能为空");
		}
		String tmp = columnElement.getAttributeValue("align");
		if(tmp == null){
			this.align = ExcelAlign.left;
		}else{
			this.align = ExcelAlign.valueOf(tmp);
		}
		tmp = columnElement.getAttributeValue("width");
		if(tmp == null){
			this.width = 20;
		}else{
			this.width = Integer.parseInt(tmp);
		}
	}

	public ExcelColumn clone(){
		return this.clone();
	}
	public enum ExcelAlign {
		left,center,right
	}
}
