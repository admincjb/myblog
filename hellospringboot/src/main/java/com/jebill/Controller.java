package com.jebill;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
//	@Autowired
//	private MySQLProperties mySQLProperties;
//	
//	@Value("${mysql.jdbcDriverName}")
//	private String jdbcDriverName;
//	
//	@Value("${mysql.jdbcDriverUrl}")
//	private String jdbcDriverUrl;
//	
//	@Value("${mysql.jdbcDriverUser}")
//	private String jdbcDriverUser;
//	
//	@Value("${mysql.jdbcDriverPassword}")
//	private String jdbcDriverPassword;
//	
//	@RequestMapping("/hello")
//	public String hello() {
//		return "spring boot 测试";
//	}
//	
//	@RequestMapping("/getDB")
//	public String dbInfo() {
//		return "数据库连接信息:"
//				+ "数据库驱动类[" + jdbcDriverName + "]<br/>"
//				+ "连接字符串[" + jdbcDriverUrl + "]<br/>"
//				+ "数据库用户名[" + jdbcDriverUser + "]<br/>"
//				+ "数据库密码[" + jdbcDriverPassword + "]<br/>";
//	}
//	
//	@RequestMapping("/getDBConf")
//	public String dbInfoByConf() {
//		return "数据库连接信息:"
//				+ "数据库驱动类[" + mySQLProperties.getJdbcName() + "]<br/>"
//				+ "连接字符串[" + mySQLProperties.getJdbcUrl() + "]<br/>"
//				+ "数据库用户名[" + mySQLProperties.getJdbcUser() + "]<br/>"
//				+ "数据库密码[" + mySQLProperties.getJdbcPassword() + "]<br/>";
//	}
	
}
