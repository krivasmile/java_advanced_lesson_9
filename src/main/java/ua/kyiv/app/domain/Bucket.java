package ua.kyiv.app.domain;

import java.sql.Date;

public class Bucket {
	private int id;
	private int userId;
	private int productId;
	private Date purchaseDate;
	
	public Bucket(int id, int userId, int productId, Date purcaseDate) {
		this.id = id;
		this.userId = userId;
		this.productId = productId;
		this.purchaseDate = purcaseDate;
	}

	public Bucket(int userId, int productId, Date purcaseDate) {
		this.userId = userId;
		this.productId = productId;
		this.purchaseDate = purcaseDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public Date getPurcaseDate() {
		return purchaseDate;
	}

	public void setPurcaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + productId;
		result = prime * result + ((purchaseDate == null) ? 0 : purchaseDate.hashCode());
		result = prime * result + userId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bucket other = (Bucket) obj;
		if (id != other.id)
			return false;
		if (productId != other.productId)
			return false;
		if (purchaseDate == null) {
			if (other.purchaseDate != null)
				return false;
		} else if (!purchaseDate.equals(other.purchaseDate))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bucket [id=" + id + ", userId=" + userId + ", productId=" + productId + ", purcaseDate=" + purchaseDate
				+ "]";
	}
}
