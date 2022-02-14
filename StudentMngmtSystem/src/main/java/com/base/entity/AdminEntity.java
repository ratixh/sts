package com.base.entity;

import javax.persistence.*;


@Entity
@Table(name = "admin")
	public class AdminEntity {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int adminId;
		@Column
		private String adminLogin;
		@Column
		private String adminPassword;
		public int getAdminId() {
			return adminId;
		}
		public void setAdminId(int adminId) {
			this.adminId = adminId;
		}
		public String getAdminLogin() {
			return adminLogin;
		}
		public void setAdminLogin(String adminLogin) {
			this.adminLogin = adminLogin;
		}
		public String getAdminPassword() {
			return adminPassword;
		}
		public void setAdminPassword(String adminPassword) {
			this.adminPassword = adminPassword;
		}
		public AdminEntity() {
			super();
			// TODO Auto-generated constructor stub
		}
		public AdminEntity(int adminId, String adminLogin, String adminPassword) {
			super();
			this.adminId = adminId;
			this.adminLogin = adminLogin;
			this.adminPassword = adminPassword;
		}
		@Override
		public String toString() {
			return "AdminEntity [adminId=" + adminId + ", adminLogin=" + adminLogin + ", adminPassword=" + adminPassword
					+ "]";
		}
		
	
}

