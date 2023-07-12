package com.chatApp.dto;
//dto-data tranfer object
public class userdto {
        private static String userid;
        private char[] password;
        public userdto(String userid,char[] password)
        {
                this.userid=userid;
                this.password=password;
        }
		public static String getUserid() {
			return userid;
		}
		public void setUserid(String userid) {
			this.userid = userid;
		}
		public char[] getPassword() {
			return password;
		}
		public void setPassword(char[] password) {
			this.password = password;
		}
}
