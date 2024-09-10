package letcode;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class TablePage {
    private final ElementsCollection prices = $$x("//div[@class='table-container'][1]//tbody//tr//td[2]");
    private final SelenideElement totalPrice = $x("//table[@id='shopping']/tfoot[1]/td[2]/b[1]");
    private final SelenideElement markRaj = $x("(//td[text()='Raj']/following-sibling::td)[2]/input");

    public TablePage addAllPricesAndAssertWithTotalPrice() {
        List<SelenideElement> priceList = prices.stream().toList();
        int countPrice = 0;
        for (SelenideElement price : priceList) {
            countPrice += Integer.parseInt(price.text());
        }
        int totalPriceInt = Integer.parseInt(totalPrice.text());
        Assertions.assertEquals(countPrice, totalPriceInt);
        return this;
    }

    public TablePage markRajAsPresent() {
        markRaj.click();
        return this;
    }

    public TablePage checkIfSortWorksCorrectly() {
        int rowSize = 6;
        ArrayList<TableData> list = new ArrayList<>();
        for (int i = 2; i < rowSize; i++) {
            final SelenideElement fat = $x("//table[@class='mat-sort table is-bordered is-striped is-narrow is-hoverable is-fullwidth']/tr["+ i +"]/td[3]");
            final SelenideElement desert = $x("//table[@class='mat-sort table is-bordered is-striped is-narrow is-hoverable is-fullwidth']/tr["+ i +"]/td[1]");
            int fatValue = Integer.parseInt(fat.text());
            list.add(new TableData(fatValue, desert.getText()));
        }
        System.out.println("before sorting" + list);
        Collections.sort(list);
        System.out.println("after sorting" + list);
        list.forEach(i -> {
            System.out.println("Fat: " + i.fat + " Desert: " + i.desert);
        });
        return this;
    }
}

class TableData implements Comparable<TableData> {
    Integer fat;
    String desert;

    public TableData(Integer fat, String desert) {
        this.fat = fat;
        this.desert = desert;
    }

    @Override
    public int compareTo(TableData data) {
        if (this.fat < data.fat) {
            return -1;
        } else
            return 0;
    }

    @Override
    public String toString() {
        return "TableData{" +
                "desert=" + desert +
                ", fat=" + fat +
                '}';
    }
}
