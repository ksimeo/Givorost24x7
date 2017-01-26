package com.ksimeo.givorost.admin.config;

//@Configuration
//public class SpringDBConfig {
//
//    @Autowired
//    DataSource dataSource;
//
//	/*@Bean
//	public JdbcTemplate getJdbcTemplate() {
//		return new JdbcTemplate(dataSource);
//	}*/
//
//    @Bean
//    public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
//        return new NamedParameterJdbcTemplate(dataSource);
//    }
//
//    @Bean
//    public DataSource getDataSource() {
//        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
//        EmbeddedDatabase db = builder.setName("testdb").setType(EmbeddedDatabaseType.HSQL)
//                .addScript("db/sql/create-db.sql").addScript("db/sql/insert-data.sql").build();
//        return db;
//    }
//
//    @PostConstruct
//    public void startDBManager() {
//
//        // hsqldb
//        // DatabaseManagerSwing.main(new String[] { "--url",
//        // "jdbc:hsqldb:mem:testdb", "--user", "sa", "--password", "" });
//
//    }
//
//}