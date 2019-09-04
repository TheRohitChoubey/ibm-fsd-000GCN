package cd_type_webapp.dao;

import java.util.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("international_cd")
public class InternationalCD extends LocalCd {

	public InternationalCD(String fn, String ln ) {
		super(fn, ln);
	}

	
}