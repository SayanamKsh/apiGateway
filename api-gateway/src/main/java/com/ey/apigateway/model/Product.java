package com.ey.apigateway.model;


public class Product {

	    private Long id;
	    
	    private String name;
	    private String description;
	    
	    private Long actualPrice;
	    private Long discountPercent;
	    
	    private Long discountedPrice;
	    
	    
	    public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDesc() {
			return description;
		}
		public void setDesc(String description) {
			this.description = description;
		}
		public Long getActualPrice() {
			return actualPrice;
		}
		public void setActualPrice(Long actualPrice) {
			this.actualPrice = actualPrice;
		}
		public Long getDiscountPercent() {
			return discountPercent;
		}
		public void setDiscountPercent(Long discountPercent) {
			this.discountPercent = discountPercent;
		}
		public Long getDiscountedPrice() {
			return discountedPrice;
		}
		public void setDiscountedPrice(Long discountedPrice) {
			this.discountedPrice = discountedPrice;
		}
		public Product() {
			super();
		}
		
		public Product(Long id, String name, String description, Long actualPrice, Long discountedPrice,
				Long discountPercent) {
			super();
			this.id = id;
			this.name = name;
			this.description = description;
			this.actualPrice = actualPrice;
			this.discountedPrice = discountedPrice;
			this.discountPercent = discountPercent;
		}
		@Override
		public String toString() {
			return "Product [id=" + id + ", name=" + name + ", description=" + description + ", actualPrice=" + actualPrice
					+ ", discountedPrice=" + discountedPrice + ", discountPercent=" + discountPercent + "]";
		}

		
	    
	    
	    
	    
	    
	    
}
