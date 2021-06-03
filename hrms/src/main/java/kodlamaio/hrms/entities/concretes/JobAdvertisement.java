package kodlamaio.hrms.entities.concretes;

import java.sql.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="job_advertisements")
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertisement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	
	@Column(name="description")
	private String jobDescription;
	
	@Column(name="min_salary")
	private double minSalary;
	
	@Column(name="max_salary")
	private double maxSalary;
	
	@Column(name="number_of_position")
	private int numberOfPosition;

	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Column(name="publish_date")
	private Date publishDate;
	

	@Column(name="deadline")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date deadline;
	
	@Column(name="is_active")
	private boolean isActive;
	
	@ManyToOne()
	@JoinColumn(name ="user_id")
	private User user;
	
	
	@ManyToOne()
	@JoinColumn(name="job_id")
	private Job job;
	
	@ManyToOne()
	@JoinColumn(name="city_id")
	private City city;
}
