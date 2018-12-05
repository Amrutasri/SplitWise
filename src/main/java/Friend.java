import java.util.Objects;

public class Friend {

    private String name;
    private Money money;

    Friend(String name, Money money) {
        this.name = name;
        this.money = money;
    }

    String getName() {
        return name;
    }

    Money getMoney() {
        return money;
    }

    @Override
    public boolean equals(Object object) {
        return object.getClass() == getClass();
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
