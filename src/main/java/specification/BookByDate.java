package specification;

import entity.Book;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Calendar;

public class BookByDate extends AbstractSpecification<Book>{
    private Calendar addDate1;
    private Calendar addDate2;

    public BookByDate(Calendar addDate1, Calendar addDate2) {
        this.addDate1 = addDate1;
        this.addDate2 = addDate2;
    }

    public Predicate toPredicate(Root<Book> bookRoot, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.between(bookRoot.<Calendar>get("addDate"),addDate1,addDate2);
    }
}
