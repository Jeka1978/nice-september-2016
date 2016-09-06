package builder;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.ToString;
import lombok.Value;

/**
 * Created by Jeka on 06/09/2016.
 */
@ToString
public class Client {
    @NonNull
    private final String name;
    private final int bonus;
    private final int debt;

    private Client(String name, int bonus, int debt) {
        this.name = name;
        this.bonus = bonus;
        this.debt = debt;
    }

    public Client addBonus(int delta) {
        return new Client(name, bonus + delta, debt);
    }


    public static class Builder{
        @NonNull
        private  String name;
        private  int bonus;
        private  int debt;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder bonus(int bonus) {
            this.bonus = bonus;
            return this;
        }

        public Builder debt(int debt) {
            this.debt = debt;
            return this;
        }

        public Client build() {
            validate();
            return new Client(name, bonus, debt);
        }

        private void validate() {
            if (name == null) {
                throw new IllegalStateException("name can't be null");
            }
        }
    }






}
