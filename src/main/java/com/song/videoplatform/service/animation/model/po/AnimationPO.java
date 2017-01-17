package com.song.videoplatform.service.animation.model.po;

import java.sql.Timestamp;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * <p>
 * Title: videoplatform_[animation]_[PO层]
 * </p>
 * <p>
 * Description: [animation对象PO层]
 * </p>
 * 
 * @author SO
 * @version $Revision$ 2017年1月17日
 * @author (lastest modification by $Author$)
 * @since 20100901
 */
@Entity
@Table(name = "tb_animation")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class AnimationPO {

	private Integer id;

	private String series;

	private String designation;

	private String company;

	private Double size;

	private String format;

	private Timestamp addtime;

	private byte[] image;

	public AnimationPO() {
	}

	public AnimationPO(Integer id, String series, String designation, String company, Double size, String format,
			Timestamp addtime, byte[] image) {
		this.id = id;
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
	public Timestamp getAddtime() {
		return addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	@Basic(fetch = FetchType.LAZY)
	@Column(name = "image")
	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

}
