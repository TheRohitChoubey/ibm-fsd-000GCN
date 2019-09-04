package cd_type_webapp.dao;

import java.util.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("special_edition_cd")
public class SpecialEditionCD extends LocalCd {
	
	public SpecialEditionCD(String fn, String ln) {
		super(fn, ln);
	}
}