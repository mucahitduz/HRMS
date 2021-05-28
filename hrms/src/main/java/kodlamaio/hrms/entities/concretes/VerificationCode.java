package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "verificationcode")
public class VerificationCode {

	@Id
	@GeneratedValue
	@Column(name ="id")
	private int id;
	
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "verification_code")
	private String verificationCode;
	
	@Column(name = "is_verified")
	private boolean isVerified;
	
	@Column(name = "verification_date", columnDefinition = "Date default CURRENT_DATE")
	private LocalDate verifiedAt = LocalDate.now();
	
	public VerificationCode(int userId, String verificationCode, boolean isVerified, LocalDate verifiedAt) {
		super ();
		this.userId = userId;
		this.verificationCode = verificationCode;
		this.isVerified = isVerified;
		this.verifiedAt = verifiedAt;
	}
	
}
