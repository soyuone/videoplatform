package com.song.videoplatform.service.infantry.model.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <p>
 * Title: videoplatform_[infantry]_[PO层]
 * </p>
 * <p>
 * Description: [infantry表PO层]
 * </p>
 * 
 * @author SO
 * @version $Revision$ 2016年10月23日
 * @author (lastest modification by $Author$)
 * @since 20100901
 */
@Entity
@Table(name = "tb_infantry")
public class InfantryPO {

	private Integer id;

	private String actress;

	private String series;

	private String designation;

	private String company;

	private Double size;

	private String format;

	private Date addtime;

	private String image;

	public InfantryPO() {
	}

	public InfantryPO(Integer id, String actress, String series, String designation, String company, Double size,
			String format, Date addtime, String image) {
		this.id = id;
		this.actress = actress;
		this.series = series;
		this.designation = designation;
		this.company = company;
		this.size = size;
		this.format = format;
		this.addtime = addtime;
		this.image = image;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "actress")
	public String getActress() {
		return actress;
	}

	public void setActress(String actress) {
		this.actress = actress;
	}

	@Column(name = "series")
	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	@Column(name = "designation")
	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Column(name = "company")
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Column(name = "size")
	public Double getSize() {
		return size;
	}

	public void setSize(Double size) {
		this.size = size;
	}

	@Column(name = "format")
	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	@Column(name = "addtime")
	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	@Column(name = "image")
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
