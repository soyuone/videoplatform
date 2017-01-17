package com.song.videoplatform.service.actress.model.po;

import java.sql.Date;
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
 * Title: videoplatform_[actress]_[PO层]
 * </p>
 * <p>
 * Description: [actress对象PO层]
 * </p>
 * 
 * @author SO
 * @version $Revision$ 2017年1月17日
 * @author (lastest modification by $Author$)
 * @since 20100901
 */
@Entity
@Table(name = "tb_actress")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ActressPO {

	private Integer id;

	private String name;

	private Date birth;

	private Integer age;

	private Timestamp addtime;

	private byte[] image;

	public ActressPO() {
	}

	public ActressPO(Integer id, String name, Date birth, Integer age, Timestamp addtime, byte[] image) {
		this.id = id;
		this.name = name;
		this.birth = birth;
		this.age = age;
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

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "birth")
	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	@Column(name = "age")
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
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
