package com.ksimeo.givorost.impl.dao.stubs;

/**
 * @author Ksimeo. Created on 16.01.2017 at 19:36 for "web-store-market" project.
 * @version 1.0
 * @since 1.0
 */
//@Repository
public class UserDaoStub
//        implements UserDAO

{


//    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
//
//    @Autowired
//    public void setNamedParameterJdbcTemplate(
//            NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
//        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
//    }
//
//    @Override
//    public User findOne(int id) {
//        Map<String, Object> params = new HashMap<>();
//        params.put("id", id);
//
//        String sql = "SELECT * FROM users WHERE id=:id";
//
//        User result = null;
//        try {
//            result = namedParameterJdbcTemplate
//                    .queryForObject(sql, params, new UserMapper());
//        } catch (EmptyResultDataAccessException e) {
//            // do nothing, return null
//        }
//
//        return result;
//
//    }
//
//    @Override
//    public User findOne(String login, String password) {
//        return null;
//    }
//
//    @Override
//    public List<User> findAll() {
//        String sql = "SELECT * FROM users";
//        List<User> result = namedParameterJdbcTemplate.query(sql, new UserMapper());
//        return result;
//    }
//
//    public void save(User usr) {
//        KeyHolder keyHolder = new GeneratedKeyHolder();
//
//        String sql = "INSERT INTO USERS(NAME, EMAIL, ADDRESS, PASSWORD, NEWSLETTER, FRAMEWORK, SEX, NUMBER, COUNTRY, SKILL) "
//                + "VALUES ( :name, :email, :address, :password, :newsletter, :framework, :sex, :number, :country, :skill)";
//
//        namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(user), keyHolder);
//        usr.setId(keyHolder.getKey().intValue());
//    }
//
//    public void update(User usr) {
//
//    }
}
