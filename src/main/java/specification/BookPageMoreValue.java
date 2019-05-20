package specification;

import entity.Book;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class BookPageMoreValue extends AbstractSpecification<Book>{
    private int page;

    public BookPageMoreValue(int page) {
        this.page = page;
    }

    public Predicate toPredicate(Root<Book> bookRoot, CriteriaBuilder criteriaBuilder)
    {
        return criteriaBuilder.ge(bookRoot.<Integer>get("pageCount"),page);
    }

}
