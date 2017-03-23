package com.ksimeo.givorost.impl.dao.stubs;

import com.ksimeo.givorost.api.dao.OrderDAO;
import com.ksimeo.givorost.core.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ksimeo. Created on 26.01.2017 at 16:45 for "web-store-market" project.
 * @version 1.0
 * @since 1.0
 */
//@Repository
public class OrderDaoStub implements OrderDAO {

    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Integer saveOrUpdate(OrderDTO order) {

        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = "INSERT INTO orders (name, tel, email, product_name, amount, create_date, read_date) " +
                "VALUES (':name', ':tel', ':email', ':product_name', ':amount', 'create_date', 'read_date')";
        namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(order), keyHolder);
        return null;
    }

    @Override
    public OrderDTO findOne(int id) {

        Map<String, Object> params = new HashMap<>();
        params.put("id", id);

        String sql = "SELECT * FROM orders WHERE id=:id";

        OrderDTO result = null;

        try {
            result = namedParameterJdbcTemplate
                    .queryForObject(sql, params, new OrderMapper());
        } catch (EmptyResultDataAccessException e) {
            // do nothing, return null
        }
        return result;
    }


    @Override
    public List<OrderDTO> findSeveral(int from, int to) {
        Map<String, Object> params = new HashMap<>();
        params.put("from", from);
        params.put("to", to);

        String sql = "SELECT * FROM orders LIMIT from, to";

        List<OrderDTO> result = null;

        try {
            result = namedParameterJdbcTemplate
                    .query(sql, params, new OrderMapper());
        } catch (EmptyResultDataAccessException e) {
            // do nothing, return null
        }
        return result;
    }

    @Override
    public List<OrderDTO> findAll() {

        String sql = "SELECT * FROM orders";
        List<OrderDTO> res = namedParameterJdbcTemplate.query(sql, new OrderMapper());
        return res;
    }

    @Override
    public void dropOne(int id) {

        String sql = "DELETE FROM orders WHERE id =: id";
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource("id", id));
    }

    @Override
    public void dropAll() {

        String sql = "DELETE * FROM orders";
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource("", ""));
    }

    @Override
    public int getCount() {
        return 0;
    }

    private SqlParameterSource getSqlParameterByModel(OrderDTO order) {

        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", order.getId());
        paramSource.addValue("tel", order.getTel());
        paramSource.addValue("email", order.getEmail());
        paramSource.addValue("product_name", order.getProdName());
        paramSource.addValue("amount", order.getAmount());
        paramSource.addValue("create_date", order.getCreateDate());
        paramSource.addValue("read_date", order.getReadDate());

        return paramSource;
    }

    private static final class OrderMapper implements RowMapper<OrderDTO> {

        @Override
        public OrderDTO mapRow(ResultSet rs, int i) throws SQLException {
            OrderDTO toSend = new OrderDTO();
            toSend.setId(rs.getInt("id"));
            toSend.setName(rs.getString("name"));
            toSend.setEmail(rs.getString("email"));
            toSend.setProdName(rs.getString("product_name"));
            toSend.setAmount(rs.getInt("amount"));
            toSend.setCreateDate(rs.getDate("create_date").toString());
            toSend.setReadDate(rs.getDate("read_date").toString());
            return toSend;
        }
    }
}
