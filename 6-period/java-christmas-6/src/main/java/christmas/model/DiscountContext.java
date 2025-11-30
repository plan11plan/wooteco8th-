package christmas.model;

import java.time.LocalDate;
import java.util.List;

public record DiscountContext(LocalDate visitDate, List<Menu> menus, int totalAmount) {
}
