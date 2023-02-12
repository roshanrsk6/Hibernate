package my.training.stockpricereaderservice.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;


@Entity
@Table(name = "USER_DETAILS")
public class Userdetails {
	@Id
	//@EmbeddedId
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "USER_ID")
	private int userid;
	
	@Column(name = "USER_NAME")
	private String userName;
	
	@Temporal(TemporalType.DATE)
	private Date joinedDate;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "street",column = @Column(name="HOME_STREET")),
		@AttributeOverride(name = "city",column = @Column(name="HOME_CITY")),
		@AttributeOverride(name = "state",column = @Column(name="HOME_STATE")),
		@AttributeOverride(name = "pincode",column = @Column(name="HOME_PINCODE"))
		
	})
	private Address homeAddress;


	@ElementCollection(fetch = FetchType.LAZY)
	@JoinTable(name = "USER_ADDRESS",joinColumns = @JoinColumn(name="USERID"))
	 @GenericGenerator(name="increment", strategy = "increment")
	@CollectionId(columns = { @Column(name = "ADDRESS_ID") }, generator = "increment", type = @Type(type = "long"))
	private Collection<Address> listOfAddress=new ArrayList<>();
	
	
	@Lob
	private String description;
	
	
	
	
	public Collection<Address> getListOfAddress() {
		return listOfAddress;
	}
	public void setListOfAddress(Collection<Address> listOfAddress) {
		this.listOfAddress = listOfAddress;
	}
	public Date getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}
	
	
	
	public Address getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	

}
