package HW_10;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class Product {

    private String type;
    private float price;
    private LocalDate addingDate;

    public static class Type {
        public static final String BOOK = "Book", TOY = "Toy";
    }
}
