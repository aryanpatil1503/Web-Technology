package bankexamp;

import javax.ejb.Local;

@Local
public interface BankTransactLocal {

	int deposit(int amount);

	int withdraw(int amount);

}
