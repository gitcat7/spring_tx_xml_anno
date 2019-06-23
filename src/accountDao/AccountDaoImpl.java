package accountDao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {


	@Override
	public void increaseMoney(Integer id,Double money) {
		getJdbcTemplate().update("update person set money=money+? where id=?", money,id);
	}

	@Override
	public void decreaseMoney(Integer id,Double money) {
		getJdbcTemplate().update("update person set money=money-? where id=?", money,id);
	}

}
