package cn.itcast.crm.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.crm.domain.Customer;
import cn.itcast.crm.service.ICustomerService;

@Transactional
public class CustomerService implements ICustomerService {
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Customer> findAll() {
		String sql = "select * from t_customer";
		List<Customer> list = this.jdbcTemplate.query(sql, new RowMapper<Customer>() {

			@Override
			public Customer mapRow(ResultSet rw, int num) throws SQLException {
				Customer customer = new Customer();
				customer.setId(rw.getInt("id"));
				customer.setName(rw.getString("name"));
				customer.setStation(rw.getString("station"));
				customer.setTelephone(rw.getString("telephone"));
				customer.setAddress(rw.getString("address"));
				customer.setDecidedzone_id(rw.getString("decidedzone_id"));

				return customer;
			}
		});

		return list;
	}

}
