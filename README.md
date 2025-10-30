# CS121 Project 9
Bank on it Part 1

# Algorithm

* Goal(this week):
  * Build HasMenu, CheckingAccount, SavingsAccount, abstract User, and Customer.  

## Interface
* HasMenu
  * String menu() ; print options, return prompt text
  * void start() ; loop until user chooses Exit/Quit



## CheckingAccount
* State: balance: double (default 0.0)
* Public:
  * CheckingAccount() ; CheckingAccount(double start)
  * double getBalance() ; void setBalance(double)
  * String getBalanceString() ; "$%.2f"
  * void checkBalance() ; print balance
  * void makeDeposit() ; balance += amount
  * void makeWithdrawal() ; ask amount and balance -= amount, else say "Insufficient funds"
* String menu() ; 
  Account menu
  0) quit
  1) check balance
  2) deposit
  3) withdraw
* void start() ; read choice; 0=quit, 1..3 call above

Helper: private double getDouble(String prompt) ; read double or return 0.0

## SavingsAccount (extends CheckingAccount)
State: interestRate: double

* Public:
  * void setInterestRate(double r)
  * double getInterestRate()`
  * void calcInterest() ; setBalance(getBalance() + getBalance()*interestRate)`

## 4) User (abstract, implements HasMenu)
* State: userName: String, PIN: String

* Public:
  * boolean login() ; ask for userName & PIN; return login(u,p)
  * boolean login(String u, String p) ; compare to fields
  * getters/setters for userName, PIN
  * abstract String getReport()

## 5) Customer (extends User)
* State: checking: CheckingAccount, savings: SavingsAccount

* Constructors:
  * Default ; userName="Alice", PIN="0000", zeroed accounts
  * Param ; set given name/PIN

* Menu (menu()):
Customer Menu
0) Exit
1) Manage Checking
2) Manage Savings
3) Change PIN

* Start (start()):
1) Run login() ; if false ; print "Login failed" and return
2) Loop on menu:
   - 1 ; checking.start()
   - 2 ; savings.start()
   - 3 ; prompt new PIN → setPIN(newPin)
   - 0 ; exit

Report (getReport()):  
"Customer: <name>\nChecking: " + checking.getBalanceString() + "\nSavings: " + savings.getBalanceString()
