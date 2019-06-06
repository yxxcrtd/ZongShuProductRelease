package cn.digitalpublishing.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Resource Object
 */
@SuppressWarnings("serial")
public class Resource extends BaseDomain {
	
	/** 资源Id */
	private int resourceId;
	
	/** 资源分类ID */
	private int categoryId;

	/** 资源名称 */
	private String resourceName;

	/** 资源作者 */
	private String resourceAuthor;

	/** 资源出版时间 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date resourcePublishDate;

	/** 资源ISBN */
	private String resourceISBN;

	/** 资源出版社 */
	private Double resourcePrice;

	/** 资源出版社 */
	private String resourcePublisher;

	/** 资源版次 */
	private String resourceEdition;

	/** 资源页数 */
	private int resourcePage;

	/** 资源装帧 */
	private String resourceFrame;

	/** 资源开本 */
	private String resourceFormat;

	/** 资源印张 */
	private int resourceSheet;

	/** 资源附件 */
	private String resourceFile;
	
	/** 资源创建时间 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date resourceCreateTime;

	public Resource() {
		// 
	}

	public int getResourceId() {
		return resourceId;
	}

	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getResourceAuthor() {
		return resourceAuthor;
	}

	public void setResourceAuthor(String resourceAuthor) {
		this.resourceAuthor = resourceAuthor;
	}

	public Date getResourcePublishDate() {
		return resourcePublishDate;
	}

	public void setResourcePublishDate(Date resourcePublishDate) {
		this.resourcePublishDate = resourcePublishDate;
	}

	public String getResourceISBN() {
		return resourceISBN;
	}

	public void setResourceISBN(String resourceISBN) {
		this.resourceISBN = resourceISBN;
	}

	public Double getResourcePrice() {
		return resourcePrice;
	}

	public void setResourcePrice(Double resourcePrice) {
		this.resourcePrice = resourcePrice;
	}

	public String getResourcePublisher() {
		return resourcePublisher;
	}

	public void setResourcePublisher(String resourcePublisher) {
		this.resourcePublisher = resourcePublisher;
	}

	public String getResourceEdition() {
		return resourceEdition;
	}

	public void setResourceEdition(String resourceEdition) {
		this.resourceEdition = resourceEdition;
	}

	public int getResourcePage() {
		return resourcePage;
	}

	public void setResourcePage(int resourcePage) {
		this.resourcePage = resourcePage;
	}

	public String getResourceFrame() {
		return resourceFrame;
	}

	public void setResourceFrame(String resourceFrame) {
		this.resourceFrame = resourceFrame;
	}

	public String getResourceFormat() {
		return resourceFormat;
	}

	public void setResourceFormat(String resourceFormat) {
		this.resourceFormat = resourceFormat;
	}

	public int getResourceSheet() {
		return resourceSheet;
	}

	public void setResourceSheet(int resourceSheet) {
		this.resourceSheet = resourceSheet;
	}

	public String getResourceFile() {
		return resourceFile;
	}

	public void setResourceFile(String resourceFile) {
		this.resourceFile = resourceFile;
	}

	public Date getResourceCreateTime() {
		return resourceCreateTime;
	}

	public void setResourceCreateTime(Date resourceCreateTime) {
		this.resourceCreateTime = resourceCreateTime;
	}

}
