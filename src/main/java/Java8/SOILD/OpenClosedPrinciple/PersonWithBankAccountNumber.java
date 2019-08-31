package Java8.SOILD.OpenClosedPrinciple;

public class PersonWithBankAccountNumber extends Person {
    private String bankAccountNumber;

    public PersonWithBankAccountNumber(String name, String email, String bankAccountNumber) {
        super(name, email);
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    @Override
    public String toString() {
        return "PersonWithBankAccountNumber{" +
                "bankAccountNumber='" + bankAccountNumber + '\'' +
                '}';
    }
}
