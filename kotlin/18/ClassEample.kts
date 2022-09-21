// 자료형
// -> Int, Byte, Short, Long ... ETC ..
// -> Class도 Type이 될 수 있다! (함수의 인자, 인수.. 클래스 생성자 인자)
class Bank {

    /**
     * 저금 기능
     */
    fun save(account: Account, money: Int) {
        if (money >= 0) account.balance += money
        else println("마이너스 금액은 예금할 수 없습니다.")
    }

    /**
     * 출금 기능
     */
    fun withdraw(account: Account, money: Int) {
        if (account.checkBalanace() >= money) account.balance -= money
        else println("잔액이 부족합니다.")
    }
}

class Account constructor(
    val initialBalance: Int = 0 // 계좌를 만듦과 동시에 입금할 금액
) {
    var balance: Int = 0 // 입금 금액을 클래스 내로 저장

    init {
        this.balance = initialBalance
    }
    /*
        잔액 확인 기능
    */
    fun checkBalanace(): Int {
        return this.balance
    }

}

val account: Account = Account(1000)
val bank = Bank()
println(account.checkBalanace())
bank.save(account, 1000)
println(account.checkBalanace())
bank.withdraw(account, 2000)
println(account.checkBalanace())
bank.withdraw(account, 1000) // 잔액 부족
bank.save(account, -1000) // 마이너스는 예금 불가능
val account_1 = Account(10000)
bank.save(account_1, 1000)
println(account_1.checkBalanace())
