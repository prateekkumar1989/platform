package db;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "profile", uniqueConstraints = { @UniqueConstraint(name = "u_profile_name", columnNames = { "name" }) })
public class DbProfile implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String job;
	
	public DbProfile() {
	}

	public DbProfile(String name, String job) {
		this.name = name;
		this.job = job;
	}

	@Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "id", nullable = false)
    public String getId() {
        return id;
    }
	
	public void setId(String id) {
        this.id = id;
    }
	
	@Column(name = "name", nullable = false, length = 250)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "job", nullable = false, length = 250)
	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@Override
	public String toString() {
		return "DbProfile [id=" + id + ", name=" + name + ", job=" + job + "]";
	}

}
