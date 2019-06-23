package accountService;


import org.springframework.transaction.annotation.Isolation;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import accountDao.AccountDao;
//类上的通知注解遍布整个类,如果要修改注解中的某个属性,可以在单个方法前单独写注解
@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=false)
public class AccountServiceImpl implements AccountService {

	private AccountDao ad;
	
	@Override
	@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=false)
	public void transfer(Integer from, Integer to, Double money) {
				ad.decreaseMoney(from, money);
				//int i = 1/0;
				ad.increaseMoney(to, money);
	}

	public void setAd(AccountDao ad) {
		this.ad = ad;
	}
}
