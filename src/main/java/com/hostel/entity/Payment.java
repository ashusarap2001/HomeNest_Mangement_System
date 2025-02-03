package com.hostel.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Payment")
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String candidate_name;
	private double amound;
	private double paying_amount;
	private double remaning_amount;
	private String date;
	private String status;
	private int uniqueid;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCandidate_name() {
		return candidate_name;
	}

	public void setCandidate_name(String candidate_name) {
		this.candidate_name = candidate_name;
	}

	public double getAmound() {
		return amound;
	}

	public void setAmound(double amound) {
		this.amound = amound;
	}

	public double getPaying_amount() {
		return paying_amount;
	}

	public void setPaying_amount(double paying_amount) {
		this.paying_amount = paying_amount;
	}

	public double getRemaning_amount() {
		return remaning_amount;
	}

	public void setRemaning_amount(double remaning_amount) {
		this.remaning_amount = remaning_amount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getUniqueid() {
		return uniqueid;
	}

	public void setUniqueid(int uniqueid) {
		this.uniqueid = uniqueid;
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", candidate_name=" + candidate_name + ", amound=" + amound + ", paying_amount="
				+ paying_amount + ", remaning_amount=" + remaning_amount + ", date=" + date + ", status=" + status
				+ ", uniqueid=" + uniqueid + "]";
	}

	public Payment(long id, String candidate_name, double amound, double paying_amount, double remaning_amount,
			String date, String status, int uniqueid) {
		super();
		this.id = id;
		this.candidate_name = candidate_name;
		this.amound = amound;
		this.paying_amount = paying_amount;
		this.remaning_amount = remaning_amount;
		this.date = date;
		this.status = status;
		this.uniqueid = uniqueid;
	}

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

}
