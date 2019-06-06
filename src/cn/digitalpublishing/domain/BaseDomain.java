package cn.digitalpublishing.domain;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Base Domain
 */
@SuppressWarnings("serial")
public class BaseDomain implements Serializable {

	/* (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
	/**
	 * Category
	 */
	private Category category;

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
