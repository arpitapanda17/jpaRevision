package com.arpita.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@AttributeOverrides({
	@AttributeOverride(
		name="name",
		column=@Column(name="guardian_name")
		),
	@AttributeOverride(
			name="email",
			column=@Column(name="guardian_email")
		),
	@AttributeOverride(
			name="mobile",
			column=@Column(name="guardian_mobile")
		)
})
public class Guardian {
	private String name;
	private String email;
	private String mobile;
	public Guardian() {
		super();
	}
	public Guardian(String name, String email, String mobile) {
		super();
		this.name = name;
		this.email = email;
		this.mobile = mobile;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
