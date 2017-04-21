package books;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class BookCrudBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<Book> list;
	private Book item = new Book();
	private Book beforeEditItem = null;
	private boolean edit;
	private boolean isbnField, titleField, priceField = false;
	
    @PostConstruct
    public void init() {
        list = new ArrayList<Book>();
    }
    
    public void add() {
    	isbnField = false;
    	titleField = false;
    	priceField = false;
    	if(item.getIsbn().trim().equals("")) {
    		isbnField = true;
    	} else {
    		isbnField = false;
    	}
    	
    	if(item.getTitle().trim().equals("")) {
    		titleField = true;
    	} else {
    		titleField = false;
    	}
    	
    	if(!(item.getPrice()>0)) {
    		priceField = true;
    	} else {
    		priceField = false;
    	}
    	
    	if(!(isbnField||titleField||priceField)) {
            list.add(item);
            item = new Book();
    	}
    }

    public boolean isIsbnField() {
		return isbnField;
	}

	public boolean isTitleField() {
		return titleField;
	}

	public boolean isPriceField() {
		return priceField;
	}

	public void resetAdd() {
    	item = new Book();
    	isbnField = false;
    	titleField = false;
    	priceField = false;
    }

    public void edit(Book item) {
    	beforeEditItem = item.clone();
        this.item = item;
        edit = true;
    }

    public void cancelEdit() {
    	this.item.restore(beforeEditItem);
        this.item = new Book();
        edit = false;
    	isbnField = false;
    	titleField = false;
    	priceField = false;
    }

    public void saveEdit() {
    	isbnField = false;
    	titleField = false;
    	priceField = false;
    	if(item.getIsbn().trim().equals("")) {
    		isbnField = true;
    	} else {
    		isbnField = false;
    	}
    	
    	if(item.getTitle().trim().equals("")) {
    		titleField = true;
    	} else {
    		titleField = false;
    	}
    	
    	if(!(item.getPrice()>0)) {
    		priceField = true;
    	} else {
    		priceField = false;
    	}
    	
    	if(!(isbnField||titleField||priceField)) {
            this.item = new Book();
            edit = false;
    	} else {
        	this.item.restore(beforeEditItem);
    	}

    }

    public void delete(Book item) throws IOException {
        list.remove(item);
    }

    public List<Book> getList() {
        return list;
    }

    public Book getItem() {
        return this.item;
    }

    public boolean isEdit() {
        return this.edit;
    }
}
