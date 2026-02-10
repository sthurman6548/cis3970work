
package transactions;


/**
 * A {@code Transaction} object represents a banking transaction.
 * It uses int for the account numbers of deposit and withdrawal accounts, 
 * double for the amount, and a TransactionType for what banking transaction is being called.
 * 
 * Assignment: labW04
 * @author Seth Thurman
 * @version 1.0
 * 
 */
public class Transaction {
  int depositAccNum;
  int withdrawalAccNum; 
  double amount;
  TransactionType type;
  
  /**
 * Instantiates new Transaction
 * @param deposit
 * @param withdraw
 * @param amount
 * @param type
 * @return instantiated Transaction
 */
  public Transaction(int deposit, int withdraw, double amount, TransactionType type) {
    this.depositAccNum = deposit;
    this.withdrawalAccNum = withdraw;
    this.amount = amount;
    this.type = type;
  }

  /**
   * sets the depositAccNum to value of parameter
   * @param acc value to assign to depostiAccNum
   */
  public void setDepositAccNum(int acc) {
    this.depositAccNum = acc;
  }

  /**
   * Retrieves the deposit account number
   * @return depositAccNum
   */
  public int getDepositAccNum() {
    return this.depositAccNum;
  }

  /**
   * sets the withdrawalAccNum to value of parameter
   * @param num value to assign to withdrawalAccNum
   */
  public void setWithdrawalAccNum(int num) {
    this.withdrawalAccNum = num;
  }

  /**
   * Retrieves the withdrawal account number
   * @return withdrawalAccNum which is withdrawal account number
   */
  public int getWithdrawalAccNum() {
    return this.withdrawalAccNum;
  }

  /**
   * sets the amount to value of parameter
   * @param amount value to assign to amount
   */
  public void setAmount(double amount) {
    this.amount = amount;
  }
  
  /**
   * Retrieves the amount of money moved
   * @return amount the amount that is moved around
   */ 
  public double getAmount() {
    return this.amount;
  }
  
  /**
   * sets the TransactionType type to value of parameter
   * @param t value to assign to type
   */
  public void setType(TransactionType t) {
    this.type = t;
  }

  /**
   * Retrieves the TransactionType type
   * @return type which is the TransactionType
   */
  public TransactionType getType() {

    return this.type;
  }

  /**
   *  Returns a string of the Transaction info formatted in record-style 
   * @return String record-style formatted string 
   */
  @Override
  public String toString() {
    return String.format("Transaction={depositAccNum='%d', withdrawalAccNum='%d', amount='%d', type='%s'}",
                  this.depositAccNum, this.withdrawalAccNum, this.amount, this.type.toString());
  }

  /**
   * Returns boolean based on equality of two objects
   * @param obj used to compare equality to current Transaction object
   * @return boolean that determines if obj parameter is equal to this
   */
  @Override
  public boolean equals(Object obj) {
     if (this == obj) {
      return true;
    }

    if (obj == null || this.getClass() != obj.getClass()) { return false; }   
    Transaction t = (Transaction) obj;
    
    return (t.depositAccNum == this.depositAccNum && t.withdrawalAccNum == this.withdrawalAccNum 
    && t.amount == this.amount && t.type == this.type);
  }

  /**
   * returns hashCode of Transaction object
   * @return result value of hash computation
   */
  @Override
  public int hashCode() {
    int result = 31;

    result = 17 * result + depositAccNum;
    result = 17 * result + withdrawalAccNum;
    result = 17 * result + Double.hashCode(amount);
    result = 17 * result + (type != null ? type.hashCode() : 0);

    return result;
  }

}





