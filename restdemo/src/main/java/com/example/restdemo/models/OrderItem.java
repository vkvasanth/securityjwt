package com.example.restdemo.models;





import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class OrderItem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
		private int itemid;
	@ManyToOne
		private Product product;
		private int quantity;
		@ManyToOne
		@JoinColumn(name="order_orderid")
		@JsonIgnore
		private OrderDetails order;
		public OrderItem() {
			
		}
		public OrderItem( Product product, int quantity, OrderDetails order) {
			super();
			
			this.product = product;
			this.quantity = quantity;
			this.order = order;
		}
		
		public int getItemid() {
			return itemid;
		}
		public void setItemid(int itemid) {
			this.itemid = itemid;
		}
		public Product getProduct() {
			return product;
		}
		public void setProduct(Product product) {
			this.product = product;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public OrderDetails getOrder() {
			return order;
		}
		public void setOrder(OrderDetails order) {
			this.order = order;
		}
		@Override
		public String toString() {
			return "OrderItem [itemid=" + itemid + ", product=" + product + ", quantity=" + quantity + ", order="
					+ order + "]";
		}
		

}
